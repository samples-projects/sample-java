package sample.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorTest {

	@Test
	public void testGetEnv() {
		/** 供試体 */
		Calculator calculator = new Calculator();
		String actual = calculator.getEnv();
		assertEquals(actual, "SampleEnv");
	}
}
