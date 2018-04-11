package sdc;
//Elliott ADDI – Jeremy HOARAU
import java.util.Stack;

public class ClearSymbol implements Symbol {

	public boolean parse(String s) {
		return s.equals("clear");
	}

	public void execute(Stack<Value> s) throws ShutdownException, ReservedWordException {
		if (!s.isEmpty() && s.peek() instanceof Variable) {
			throw new ReservedWordException();
		}
		
		s.clear();
	}

}