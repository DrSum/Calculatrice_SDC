package sdc;

import java.util.Stack;
//Elliott ADDI – Jeremy HOARAU
public abstract class Value implements Symbol {

	public void execute(Stack<Value> s) {
		s.push(this);
	}

	public abstract Value multiply(Value v) throws IncompatibleTypeException;

	public abstract Value divide(Value v) throws IncompatibleTypeException;

	public abstract Value add(Value v) throws IncompatibleTypeException;

	public abstract Value substract(Value v) throws IncompatibleTypeException;

	public abstract Value and(Value v) throws IncompatibleTypeException;

	public abstract Value or(Value v) throws IncompatibleTypeException;

	public abstract Value isInferiorTo(Value v) throws IncompatibleTypeException;

	public abstract Value isSuperiorTo(Value v) throws IncompatibleTypeException;

	public abstract Value not() throws IncompatibleTypeException;

	public abstract Value abs() throws IncompatibleTypeException;

}
