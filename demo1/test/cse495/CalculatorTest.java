package cse495;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	public void testAdd() {
		// 4 = 2 + 2
		assertEquals(4, calculator.add(2, 2), 0);
		// 0 = 0 + 0
		assertEquals(0, calculator.add(0, 0), 0);
		// INFINITY = INFINITY + 2
		assertEquals(Float.POSITIVE_INFINITY, calculator.add(Float.POSITIVE_INFINITY, 2), 0);
		// NaN = NaN + 0
		assertEquals(Float.NaN, calculator.add(Float.NaN, 2), 0);
	}

	@Test
	public void testSubtract() {
		// -2 = 2 - 4
		assertEquals(-2, calculator.subtract(2, 4), 0);
		// 0 = 0 - 0
		assertEquals(0, calculator.subtract(0, 0), 0);
		// -INFINITY = -INFINITY - 2
		assertEquals(Float.NEGATIVE_INFINITY, calculator.subtract(Float.NEGATIVE_INFINITY, 2), 0);
		// NaN = NaN + 0
		assertEquals(Float.NaN, calculator.subtract(Float.NaN, 2), 0);
	}

	@Test
	public void testDivide() {
		// -2 = -2 / 4
		assertEquals(-0.5, calculator.divide(-2, 4), 0);
		// 0 = 2 / 0
		assertEquals(Float.POSITIVE_INFINITY, calculator.divide(2, 0), 0);
		// NaN = 0 / 0
		assertEquals(Float.NaN, calculator.divide(0, 0), 0);
		// -INFINITY = -INFINITY / 2
		assertEquals(Float.NEGATIVE_INFINITY, calculator.divide(Float.NEGATIVE_INFINITY, 2), 0);
		// NaN = NaN + 0
		assertEquals(Float.NaN, calculator.divide(Float.NaN, 0), 0);
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

}
