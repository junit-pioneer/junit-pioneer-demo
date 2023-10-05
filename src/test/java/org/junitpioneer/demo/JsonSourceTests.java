package org.junitpioneer.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonSource;
import org.junitpioneer.jupiter.json.Property;

class JsonSourceTests {

	@ParameterizedTest
	@JsonSource("[ { name: 'Luke', height: 172 }, { name: 'Yoda', height: 66 } ]")
	void jsonTest(@Property("name") String name, @Property("height") int height) {
		if (name.equals("Luke"))
			assertEquals(172, height);
		else if (name.equals("Yoda"))
			assertEquals(66, height);
		else
			fail();
	}

}
