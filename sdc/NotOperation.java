package sdc;
//Elliott ADDI – Jeremy HOARAU
public class NotOperation extends UnaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("~");
	}

	@Override
	public Value compute(Value v1) throws IncompatibleTypeException {
		return v1.not();
	}

}
