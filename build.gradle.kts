plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("pmd")
}

group = "com.gremlinengine"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// UTILITY
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.hibernate.validator:hibernate-validator")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// SECURITY
//	implementation ("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.security:spring-security-config")
//	implementation("org.springframework.security:spring-security-core")
//	implementation("org.springframework.security:spring-security-oauth2-client")
//	implementation("org.springframework.security:spring-security-oauth2-resource-server")
//	implementation("org.springframework.security:spring-security-oauth2-jose")

	// DATA STORAGE
	// Temporarily using H2 for testing purposes
	runtimeOnly("com.h2database:h2")

	// DOCUMENTATION
	implementation("net.sourceforge.plantuml:plantuml:8059")

	// TESTING
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

pmd {
	toolVersion = "7.7.0"
	isConsoleOutput = true
	ruleSets = listOf(
		"category/java/bestpractices.xml",
		"category/java/codestyle.xml",
		"category/java/errorprone.xml",
		"category/java/design.xml",
		"category/java/performance.xml",
		"category/java/documentation.xml"
	)
	/* Custom ruleset
	ruleSetFiles = files("config/pmd/ruleset.xml") // Point to your custom ruleset
    ruleSets = emptyList() // Clear default rule sets to avoid duplication
	 */
}

tasks.withType<Pmd> {
	reports {
		html.required.set(true)
		xml.required.set(false)
	}
	ignoreFailures = false
}
