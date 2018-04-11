package test_sdc;

import junit.framework.TestCase;
import sdc.*;
//Elliott ADDI – Jeremy HOARAU
public class TestInteger extends TestCase {

	SDC sdc;

	public void setUp() {
		this.sdc = new SDC();
	}

	public void testIntegerCreation() {
		try {
			this.sdc.executeLine("12");
			String expectedRes = "12";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-23");
			expectedRes = "-23";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testAdd() {
		try {
			this.sdc.executeLine("12 2 +");
			String expectedRes = "14";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-2 +");
			expectedRes = "12";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}

	}

	public void testMultiply() {
		try {
			this.sdc.executeLine("12 2 *");
			String expectedRes = "24";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-2 *");
			expectedRes = "-48";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testDivide() {
		try {
			this.sdc.executeLine("12 2 /");
			String expectedRes = "6";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-2 /");
			expectedRes = "-3";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testSubstract() {
		try {
			this.sdc.executeLine("12 2 -");
			String expectedRes = "10";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("-15 -");
			expectedRes = "25";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testEquals() {
		try {
			this.sdc.executeLine("12 12 =");
			String expectedRes = "true";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("12 2 =");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testInferior() {
		try {
			this.sdc.executeLine("12 2 <");
			String expectedRes = "false";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("2 12 <");
			expectedRes = "true";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("12 12 <  ");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	public void testSuperior() {
		try {
			this.sdc.executeLine("12 2 >");
			String expectedRes = "true";
			String res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("2 12 >");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);

			this.sdc.executeLine("12 12 >");
			expectedRes = "false";
			res = this.sdc.getLastResult();
			assertEquals(expectedRes, res);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}
}