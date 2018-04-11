package sdc;
//Elliott ADDI – Jeremy HOARAU
public class InfOperation extends BinaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("<");
	}

	@Override
	public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
		return v2.isInferiorTo(v1);
	}
}
