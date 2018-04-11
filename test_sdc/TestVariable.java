package test_sdc;

import junit.framework.*;
import sdc.*;


//Elliott ADDI – Jeremy HOARAU
public class TestVariable extends TestCase {

	SDC sdc;

	public void setUp() {
		this.sdc = new SDC();
	}

	public void testVariableCreation() {
		try {
			this.sdc.executeLine("1 => x");
			this.sdc.executeLine("1 $x =");
			assertEquals("true", this.sdc.getLastResult());

			this.sdc.executeLine("1#2 => x");
			this.sdc.executeLine("1#2 $x =");
			assertEquals("true", this.sdc.getLastResult());
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testVariableIncompatibleTypeException() throws Exception {
		this.sdc.executeLine("1#2 => x");
		try {
			this.sdc.executeLine("1 $x =");
			fail("expected exception was not occured.");
		} catch (IncompatibleTypeException e) {
			// do nothing, exception has been caught
		}
	}

	public void testRetrieveUnknownVariable() {
		try {
			this.sdc.executeLine("$z");
			fail("expected exception was not occured.");
		} catch (Exception e) {
			// do nothing, exception has been caught
		}
	}

	public void testVariableCreationFail() {
		try {
			this.sdc.executeLine("1 x");
			fail("expected exception was not occured.");
		} catch (Exception e) {
			// do nothing, exception has been caught
		}
	}

	public void testVariableCreationFailReservedWord() {
		try {
			this.sdc.executeLine("1 => view");
			this.sdc.executeLine("1 => if");
			fail("expected exception was not occured.");
		} catch (Exception e) {
			// do nothing, exception has been caught
		}
	}
}
