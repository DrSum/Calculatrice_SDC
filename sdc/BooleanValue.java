package sdc;
//Elliott ADDI – Jeremy HOARAU
public class BooleanValue extends Value {

	private boolean b;

	public BooleanValue() {
		this.b = false;
	}

	public BooleanValue(boolean b) {
		this.b = b;
	}

	@Override
	public boolean parse(String s) {
		if (s.equals("true") || s.equals("false")) {
			this.b = Boolean.parseBoolean(s);
			return true;
		}
		return false;
	}

	public String toString() {
		return Boolean.toString(this.b);
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
		if (!(v instanceof BooleanValue)) {
			throw new IncompatibleTypeException();
		}
		return new BooleanValue(Boolean.logicalAnd(this.b, ((BooleanValue) v).b));
	}

	@Override
	public Value or(Value v) throws IncompatibleTypeException {
		if (!(v instanceof BooleanValue)) {
			throw new IncompatibleTypeException();
		}
		return new BooleanValue(Boolean.logicalOr(this.b, ((BooleanValue) v).b));
	}

	@Override
	public Value not() throws IncompatibleTypeException {
		return new BooleanValue(!this.b);
	}

	@Override
	public Value abs() throws IncompatibleTypeException {
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

}
