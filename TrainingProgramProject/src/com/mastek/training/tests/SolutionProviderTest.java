package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testGetMaxNumberValidParams() {
		assertEquals(10,SolutionProvider.getMaxNumber(10, 2), "invalid Max Number Returned");
	}
	@Test
	void testGetMaxNumberEqualParams() {
		assertEquals(9,SolutionProvider.getMaxNumber(9, 9), "invalid Max Number Returned");
	}
	@Test
	void testGetMaxNumberNegativeValueParams() {
		assertEquals(-2,SolutionProvider.getMaxNumber(-110, -2), "invalid Max Number Returned");
	}
	@Test
	void testGetMaxNumberMaxLimitsForIntParams() {
		assertEquals(99999999,SolutionProvider.getMaxNumber(99999999, 2), "invalid Max Number Returned");
	}
	@Test
	void testDivideNumber() {
		assertEquals("3,2" ,SolutionProvider.divideNumber(11, 3), "invalid Divide Number Returned");
	}
	@Test
	void testkilosToMiles() {
		assertEquals(6.875,SolutionProvider.kilosToMiles(11), "invalid Mileage Returned");
	}
	@Test
	void testarea() {
		assertEquals("121.0 and 132.0",SolutionProvider.area(11,11,12), "invalid Area Returned");
	}
}