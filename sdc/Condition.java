package sdc;
//Elliott ADDI – Jeremy HOARAU
import java.util.Stack;

public class Condition implements Symbol {

	private boolean value;
	private String ifValue;

	@Override
	public boolean parse(String s) {
		if (s.equals("if") || s.equals("else") || s.equals("endif")) {
			this.ifValue = s;
			return true;
		}
		return false;
	}

	public boolean executeIF(Stack<Value> s, Stack<Condition> c) throws ReservedWordException {		
		if (!s.isEmpty() && s.peek() instanceof Variable) {
			throw new ReservedWordException();
		}
		
		if (this.ifValue.equals("else")) {
			Condition previousIf = c.peek();
			previousIf.value = !previousIf.value;
			return previousIf.value;
		}

		if (this.ifValue.equals("endif")) {
			c.pop();
			return true;
		}

		Value v = s.peek();
		this.value = ((BooleanValue) v).toString().equals("true");
		c.push(this);
		s.pop();
		return this.value;
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException, UnknownVariableException {
		// TODO Auto-generated method stub

	}

}
