plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
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
