package sdc;
//Elliott ADDI – Jeremy HOARAU
public class IntegerValue extends Value {

	private int value;

	public IntegerValue() {
		this(0);
	}

	public IntegerValue(int value) {
		this.value = value;
	}

	public boolean parse(String s) {
		try {
			this.value = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "" + this.value;
	}

	public Value add(Value v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value + this.value);
	}

	public Value multiply(Value v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value * this.value);
	}

	public Value divide(Value v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value / this.value);
	}

	public Value substract(Value v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value - this.value);
	}

	public Value abs() {
		if (this.value < 0) {
			return new IntegerValue(-1 * this.value);
		} else {
			return new IntegerValue(this.value);
		}
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
	public Value not() throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}

	@Override
	public Value isInferiorTo(Value v) throws IncompatibleTypeException {
		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}
		BooleanValue b = new BooleanValue(this.value < ((IntegerValue) v).value);
		return b;
	}

	@Override
	public Value isSuperiorTo(Value v) throws IncompatibleTypeException {
		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}
		return new BooleanValue(this.value > ((IntegerValue) v).value);
	}

}
