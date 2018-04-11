package sdc;

import java.util.ArrayList;
import java.util.Stack;
//Elliott ADDI – Jeremy HOARAU
public class Variable extends Value {

	private String name;
	private Value value;
	private boolean affectationMode;

	public void execute(Stack<Value> s, ArrayList<Variable> vars)
			throws SymbolNotFoundException, ReservedWordException {
		if (this.affectationMode) {
			s.push(this);
			return;
		}
		
		Value val = s.pop();
		
		for (Variable v : vars) {
			if (v.name.equals(this.name)) {
				vars.remove(v);
				break;
			}
		}

		vars.add(new Variable(this.name, s.pop()));
	}

	public Variable() {
		this.affectationMode = false;
	}

	public Variable(String name, Value value) {
		this.name = name;
		this.value = value;
		this.affectationMode = false;
	}

	public boolean parse(String s) {

		if (s.equals("=>")) {
			this.affectationMode = true;
			return true;
		}

		if (s.matches("[a-zA-Z_]\\w*")) {
			this.name = s.toLowerCase();
			return true;
		}

		return false;
	}

	public String toString() {
		return "" + this.value;
	}

	@Override
	public Value multiply(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value divide(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value add(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value substract(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value and(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value or(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value isInferiorTo(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value isSuperiorTo(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value not() throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value abs() throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	public String getName() {
		return this.name;
	}

	public Value getValue() {
		return this.value;
	}

}