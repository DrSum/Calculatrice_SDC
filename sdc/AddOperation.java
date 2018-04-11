package sdc;
//Elliott ADDI – Jeremy HOARAU
public class AddOperation extends BinaryOperation {

	public boolean parse(String s) {
		return s.equals("+");
	}

	public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
		return v1.add(v2);
	}

}
