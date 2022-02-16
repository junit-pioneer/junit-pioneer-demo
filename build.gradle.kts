plugins {
	java
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	mavenLocal()
	mavenCentral()
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
	testImplementation("org.junit-pioneer:junit-pioneer:1.7.0")

	// This dependency is needed to use JSON sources from the package
	// `org.junitpioneer.jupiter.json` for parameterized tests.
	// Pioneer doesn't pull it in by default and instead:
	//   (a) just works if you already use it
	//   (b) otherwise requires you to add it explicitly
	//         (1) either as a test dependency
	//         (2) or as a capability
	// The following line models case (1):

	// testImplementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")

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
