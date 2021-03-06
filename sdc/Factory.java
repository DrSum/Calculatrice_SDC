package sdc;

import java.util.ArrayList;
//Elliott ADDI � Jeremy HOARAU
public class Factory {

	private ArrayList<String> list;

	public Factory() {
		this.list = new ArrayList<String>();

		// add all types or operation here
		this.list.add("IntegerValue");
		this.list.add("RationalValue");
		this.list.add("BooleanValue");
		
		this.list.add("QuitSymbol");
		this.list.add("ClearSymbol");
		this.list.add("ViewSymbol");

		this.list.add("AbsOperation");
		this.list.add("NotOperation");

		this.list.add("AddOperation");
		this.list.add("SubOperation");
		this.list.add("DivOperation");
		this.list.add("MulOperation");

		this.list.add("AndOperation");
		this.list.add("OrOperation");

		this.list.add("InfOperation");
		this.list.add("SupOperation");
		this.list.add("EquOperation");
		
		this.list.add("Condition");
		
		this.list.add("Variable");
		this.list.add("Retrieve");
	}

	public Symbol[] registered() throws InternalError {
		ArrayList<Symbol> s = new ArrayList<Symbol>();

		for (String objectName : this.list) {
			objectName = "sdc." + objectName;
			s.add(this.createInstance(objectName));
		}

		return s.toArray(new Symbol[this.list.size()]);
	}

	private Symbol createInstance(String className) throws InternalError {
		try {
			Class cl = Class.forName(className);
			java.lang.reflect.Constructor co = cl.getConstructor();
			return (Symbol) co.newInstance();
		} catch (Exception e) {
			throw new InternalError();
		}
	}

}
