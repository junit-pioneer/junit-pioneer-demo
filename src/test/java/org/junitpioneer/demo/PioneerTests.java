package org.junitpioneer.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.DefaultLocale;
import org.junitpioneer.jupiter.params.IntRangeSource;

class PioneerTests {

	@Test
	@DefaultLocale(language = "en", country = "EN")
	void pioneerTest() {
		assertEquals(Locale.getDefault(), new Locale("en", "EN"));
	}

	@ParameterizedTest
	@IntRangeSource(from = 0, to = 10)
	void validDigit(int digit) {
		assertTrue(0 <= digit && digit < 10);
	}

}
