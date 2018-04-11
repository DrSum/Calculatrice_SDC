package test_sdc;

import junit.framework.*;
import sdc.*;


// Elliott ADDI – Jeremy HOARAU
public class TestCondition extends TestCase {

	SDC sdc;

	public void setUp() {
		this.sdc = new SDC();
	}

	public void testCreationCondition() {
		try {
			this.sdc.executeLine("true if 1 else 2 endif");
			assertEquals("1", this.sdc.getLastResult());

			this.sdc.executeLine("false if 1 else 2 endif");
			assertEquals("2", this.sdc.getLastResult());
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testCreationConditionFail() {
		try {
			this.sdc.executeLine("0 if 1 else 2 endif");
			fail("expected exception was not occured.");
		} catch (Exception e) {
		}
	}

	public void testConditionImbrique() {
		try {
			this.sdc.executeLine("true if 1 1 = if 1 else 2 endif else 3 endif");
			assertEquals("1", this.sdc.getLastResult());
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}
}
