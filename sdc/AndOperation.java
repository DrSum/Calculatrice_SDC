package sdc;
//Elliott ADDI � Jeremy HOARAU
public class AndOperation extends BinaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("&");
	}

	@Override
	public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
		return v1.and(v2);
	}

}
