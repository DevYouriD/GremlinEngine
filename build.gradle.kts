
// Major versions
val javaVersion = JavaVersion.VERSION_21

// Quality plugin versions
val pmdVersion = "7.7.0"
val checkstyleVersion = "10.20.1"
val jacocoVersion = "0.8.12"

// Dependency versions
val springBootStarterWebVersion = "3.3.5"
val springBootStarterJpaVersion = "3.3.5"
val springdocOpenapiStarterWebmvcUiVersion = "2.6.0"
val hibernateValidatorVersion = "8.0.1.Final"
val springBootDevtoolsVersion = "3.3.5"
val lombokVersion = "1.18.36"
val h2Version = "2.3.232"
val plantUmlVersion = "8059"
val springBootStarterTestVersion = "3.3.5"
val junitPlatformLauncherVersion = "1.11.3"

plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	id("pmd")
	id("checkstyle")
	id("jacoco")
}

group = "com.gremlinengine"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(javaVersion.toString())
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
	implementation("org.springframework.boot:spring-boot-starter-web:$springBootStarterWebVersion")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootStarterJpaVersion")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocOpenapiStarterWebmvcUiVersion")
	implementation("org.hibernate.validator:hibernate-validator:$hibernateValidatorVersion")
	developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootDevtoolsVersion")
	compileOnly("org.projectlombok:lombok:$lombokVersion")
	annotationProcessor("org.projectlombok:lombok:$lombokVersion")

	// SECURITY
	implementation ("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-config")
	implementation("org.springframework.security:spring-security-core")
	implementation("org.springframework.security:spring-security-oauth2-client")
	implementation("org.springframework.security:spring-security-oauth2-resource-server")
	implementation("org.springframework.security:spring-security-oauth2-jose")

	// DATA STORAGE
	// Temporarily using H2 for testing purposes
	runtimeOnly("com.h2database:h2:$h2Version")

	// DOCUMENTATION
	implementation("net.sourceforge.plantuml:plantuml:$plantUmlVersion")

	// TESTING
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootStarterTestVersion")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:$junitPlatformLauncherVersion")
}

// Plugin configuration

pmd {
	toolVersion = pmdVersion
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

checkstyle {
	toolVersion = checkstyleVersion
}

jacoco {
	toolVersion = jacocoVersion
}

// Task configuration

tasks.withType<Pmd> {
	reports {
		html.required.set(true)
		xml.required.set(false)
	}
	ignoreFailures = false
}

tasks.withType<Checkstyle> {
	configFile = file("config/checkstyle/sun_checks.xml")
	reports {
		html.required.set(true)
		xml.required.set(false)
	}
	ignoreFailures = false
}

tasks.jacocoTestReport {
	dependsOn(tasks.withType<Test>())
	reports {
		html.required.set(true)
		xml.required.set(false)
	}

	doLast {
		// Print report browser link to console
		val reportFile = file("${layout.buildDirectory.get().asFile}/reports/jacoco/test/html/index.html")
		val fileUrl = reportFile.toURI().toString().removePrefix("file:")
		println("View report at: file:///$fileUrl")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}