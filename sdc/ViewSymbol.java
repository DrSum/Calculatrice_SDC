package sdc;

import java.util.Stack;
//Elliott ADDI – Jeremy HOARAU
public class ViewSymbol implements Symbol {

	public boolean parse(String s) {
		return s.equals("view");
	}

	public void execute(Stack<Value> s) throws ShutdownException, ReservedWordException {
		if (!s.isEmpty() && s.peek() instanceof Variable) {
			throw new ReservedWordException();
		}
		
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.size() - i + " ----> " + s.get(i));
		}
	}

}
