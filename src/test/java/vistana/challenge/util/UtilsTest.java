package vistana.challenge.util;

import static org.junit.Assert.assertTrue;

public class UtilsTest {
	
	public void testGetRndomNumberInRange() {
		int start = 1;
		int end = 6;
		int num = Utils.getRndomNumberInRange(start, end);
		assertTrue(num >= start && num <= end);
	}

}
