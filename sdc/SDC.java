package sdc;

import java.util.StringTokenizer;
import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;
//Elliott ADDI – Jeremy HOARAU
public class SDC {

	private Factory factory;
	private Stack<Value> stack;
	private ArrayList<Variable> variables;
	private Stack<Condition> conditions;
	private boolean conditionState;

	public SDC() {
		this.factory = new Factory();
		this.stack = new Stack<Value>();
		this.variables = new ArrayList<Variable>();
		this.conditions = new Stack<Condition>();
		this.conditionState = true;
	}

	public void executeLine(String line) throws Exception {
		// main method:

		// parse the line to execute
		// tokens are separated by a space
		StringTokenizer st = new StringTokenizer(line);

		while (st.hasMoreTokens()) {

			// read the next token
			String token = st.nextToken();

			// try every registered symbol
			boolean found = false;

			if (this.conditionState || token.equals("if") || token.equals("else") || token.equals("endif")) {

				for (Symbol s : this.factory.registered()) {
					if (s.parse(token)) {
						found = true;
						@SuppressWarnings("unchecked")
						Stack<Value> oldStack = (Stack<Value>) stack.clone();
						try {

							// --->
							if (s instanceof Variable) {
								((Variable) s).execute(this.stack, this.variables);
								break;
							}
							if (token.startsWith("$")) {
								((Retrieve) s).execute(this.stack, this.variables);
								break;
							}
							if (token.equals("if") || token.equals("else") || token.equals("endif")) {
								this.conditionState = ((Condition) s).executeIF(this.stack, this.conditions);
								break;
							}
							// <---

							s.execute(this.stack);
						} catch (EmptyStackException e) {
							// we might have read some symbols from the stack
							// roll back
							this.stack = oldStack;
							throw new StackException("Empty stack --- aborting last operations");
						} catch (IncompatibleTypeException e) {
							// we might have read some symbols from the stack
							// roll back
							this.stack = oldStack;
							throw new IncompatibleTypeException(
									"Illegal operations: values must have the same type --- aborting last operations");
						} catch (UnknownVariableException e) {
							// we might have read some symbols from the stack
							// roll back
							this.stack = oldStack;
							throw new UnknownVariableException(
									"Illegal operation: unknown variable --- aborting last operation");
						} catch (ReservedWordException e) {
							// we might have read some symbols from the stack
							// roll back
							this.stack = oldStack;
							this.stack.pop();
							throw new ReservedWordException("Illegal operation: \" " + token
									+ "\" is a reserved word --- aborting last operation");
						}
						break;
					}
					// continue to the next symbol
				}

				if (!found) {
					throw new SymbolNotFoundException("the token " + token + " has not been recognized. Abort");
				}

			}

		}

	}

	public String getLastResult() {
		try {
			Value v = this.stack.peek();
			return v.toString();
		} catch (EmptyStackException e) {
			return "";
		}
	}

}
