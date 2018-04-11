package test_sdc;

import junit.framework.*;
import sdc.*;
//Elliott ADDI – Jeremy HOARAU
public class TestRational extends TestCase {

	SDC sdc;

	public void setUp() {
		this.sdc = new SDC();
	}

	public void testRationalCreation() {
		try {
			String[] test = { "6#1", "-12#1", "1#2", "0#1" };

			for (String expectedRes : test) {
				this.sdc.executeLine(expectedRes);
				assertEquals(expectedRes, this.sdc.getLastResult());
			}
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testRationalCreationFail() {
		String[] test = { "12.0#2", "-12#a", "1a#2" };

		try {
			for (String expectedRes : test) {
				try {
					this.sdc.executeLine(expectedRes);
					assertEquals(false, true);
				} catch (SymbolNotFoundException e) {
					assertEquals(true, true);
				}
			}
		} catch (Exception e) {
			assertEquals(false, true);
		}
	}

	public void testMultiply() {

		try {
			this.sdc.executeLine("12#2 2#2 *");
			String expectedRes = "6#1";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("1#1 *");
			expectedRes = "6#1";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}

	}

	public void testMultiplyFail() {
		try {
			this.sdc.executeLine("12#2 2 *");
			assertEquals(false, true);
		} catch (IncompatibleTypeException e) {
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testDivide() {
		try {
			this.sdc.executeLine("1#2 3#4 /");
			String expectedRes = "2#3";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-2#3 /");
			expectedRes = "-1#1";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testSubstract() {
		try {
			this.sdc.executeLine("12#2 2#4 -");
			String expectedRes = "11#2";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-15#8 -");
			expectedRes = "59#8";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testEquals() {
		try {
			this.sdc.executeLine("1#1 12#12 =");
			String expectedRes = "true";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("12#12 12#2 =");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testInferior() {
		try {
			this.sdc.executeLine("12#2 13#2 <");
			String expectedRes = "true";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("2#1 12#133 <");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("12#12 12#12 <  ");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testSuperior() {
		try {
			this.sdc.executeLine("12#2 13#2 >");
			String expectedRes = "false";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("2#1 12#133 >");
			expectedRes = "true";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("12#12 12#12 >");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

}