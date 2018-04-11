package sdc;
//Elliott ADDI – Jeremy HOARAU
public class AbsOperation extends UnaryOperation {

	public boolean parse(String s) {
		return s.equals("||");
	}

	public Value compute(Value v) throws IncompatibleTypeException {
		return v.abs();
	}

}
