package sdc;

import java.util.Stack;
//Elliott ADDI – Jeremy HOARAU
public abstract class UnaryOperation implements Symbol {

	private boolean ifStatement;

	public abstract Value compute(Value v) throws IncompatibleTypeException;

	public void execute(Stack<Value> s) throws IncompatibleTypeException {
		Value v = s.pop();

		s.push(this.compute(v));
	}

	public boolean parse(String s) {
		this.ifStatement = s.equals("if");
		return this.ifStatement;
	}

}
