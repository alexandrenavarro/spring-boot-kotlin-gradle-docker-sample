import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//import pl.allegro.tech.build.axion.release.domain.TagNameSerializationConfig
//import pl.allegro.tech.build.axion.release.domain.NextVersionConfig

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	id("com.google.cloud.tools.jib") version "2.7.0"
	//id("pl.allegro.tech.build.axion-release") version "1.12.0"
	//id("eu.davidea.grabver") version "2.0.2"
	//id("com.karmanno.plugins.semver") version "1.15"
	//id("com.github.mazzeb.auto-version") version "0.3.0"
	//id("io.alcide.gradle-semantic-build-versioning") version "4.2.1"
	id("de.epitschke.gradle-file-versioning") version "1.0.0"
}
//
//autoversion {
//	versionFile="version.json"
//}

//version = scmVersion.version

group = "com.github.alexandrenavarro"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

jib.to.image = "schumnana/spring-boot-kotlin-gradle-docker-sample"

repositories {
	mavenCentral()
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
