package sdc;

import java.util.Stack;
//Elliott ADDI – Jeremy HOARAU
public class QuitSymbol implements Symbol {

	public boolean parse(String s) {
		return s.equals("quit");
	}

	public void execute(Stack<Value> s) throws ShutdownException, ReservedWordException {
		if (!s.isEmpty() && s.peek() instanceof Variable) {
			throw new ReservedWordException();
		}
		
		throw new ShutdownException();
	}

}