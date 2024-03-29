plugins {
	java
}

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
	testImplementation("org.junit-pioneer:junit-pioneer:2.1.0")

	// This dependency is needed to use JSON sources from the package
	// `org.junitpioneer.jupiter.json` for parameterized tests.
	// Pioneer doesn't pull it in by default and instead:
	//   (a) just works if you already use it
	//   (b) otherwise requires you to add it explicitly
	//         (1) either as a test dependency
	//         (2) or as a capability

	// The following line models case (b1):
	// testImplementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

	// But this configuration models case (b2) instead:
	testRuntimeOnly("org.junit-pioneer:junit-pioneer") {
		capabilities {
			requireCapability("org.junit-pioneer:junit-pioneer-jackson")
		}
	}
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}
