package sdc;
//Elliott ADDI – Jeremy HOARAU
public class RationalValue extends Value {

	private int n;
	private int d;

	public RationalValue() {
	}

	public RationalValue(int numerateur, int denominateur) {
		this.n = numerateur;
		this.d = denominateur;
	}

	@Override
	public boolean parse(String s) {
		try {
			this.n = Integer.parseInt(s.split("#")[0]);
			this.d = Integer.parseInt(s.split("#")[1]);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public String toString() {
		int gcm = gcm(this.n, this.d);
		return (this.n / gcm) + "#" + (this.d / gcm);
	}

	@Override
	public Value multiply(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationalValue)) {
			throw new IncompatibleTypeException();
		}

		return new RationalValue(((RationalValue) v).n * this.n, ((RationalValue) v).d * this.d);
	}

	@Override
	public Value divide(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationalValue)) {
			throw new IncompatibleTypeException();
		}
		return new RationalValue(((RationalValue) v).n * this.d, ((RationalValue) v).d * this.n);
	}

	@Override
	public Value add(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationalValue)) {
			throw new IncompatibleTypeException();
		}

		return new RationalValue(this.n * ((RationalValue) v).d + ((RationalValue) v).n,
				((RationalValue) v).d * this.d);
	}

	@Override
	public Value substract(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationalValue)) {
			throw new IncompatibleTypeException();
		}

		int newD = this.d * ((RationalValue) v).d;
		int newN = ((RationalValue) v).n * this.d - this.n * ((RationalValue) v).d;
		return new RationalValue(newN, newD);
	}

	@Override
	public Value abs() {
		if (this.n < 0 && this.d > 0) {
			return new RationalValue(-1 * this.n, this.d);
		} else if (this.n > 0 && this.d < 0) {
			return new RationalValue(-1 * this.n, this.d);
		}
		return this;
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
		if (!(v instanceof RationalValue)) {
			throw new IncompatibleTypeException();
		}

		return new BooleanValue(this.n * ((RationalValue) v).d < ((RationalValue) v).n * this.d);
	}

	@Override
	public Value isSuperiorTo(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationalValue)) {
			throw new IncompatibleTypeException();
		}

		return new BooleanValue(this.n * ((RationalValue) v).d > ((RationalValue) v).n * this.d);
	}

	public int gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b);
	}
}
