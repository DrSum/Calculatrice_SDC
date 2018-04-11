package sdc;

import java.util.ArrayList;
import java.util.Stack;
//Elliott ADDI – Jeremy HOARAU
public class Retrieve implements Symbol {

	private Variable var;

	public void execute(Stack<Value> s, ArrayList<Variable> vars) throws UnknownVariableException {
		boolean found = false;
		for (Variable v : vars) {
			if (v.getName().equals(var.getName())) {
				found = true;
				s.push(((Variable) v).getValue());
				break;
			}
		}

		if (!found) {
			throw new UnknownVariableException();
		}
	}

	@Override
	public boolean parse(String s) {
		if (s.startsWith("$")) {
			this.var = new Variable(s.substring(1).toLowerCase(), null);
			return true;
		}
		return false;
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException, UnknownVariableException {
		// TODO Auto-generated method stub
	}

}
