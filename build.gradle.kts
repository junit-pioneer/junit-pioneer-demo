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
    testImplementation("org.junit-pioneer:junit-pioneer:1.5.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
