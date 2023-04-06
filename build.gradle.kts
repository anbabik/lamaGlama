import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val allureVersion by extra { "2.20.0" }
val restAssuredVersion by extra { "2.19.0" }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
// https://mavenlibs.com/maven/dependency/com.codeborne/selenide
    implementation("com.codeborne:selenide:6.12.2")
    implementation ("io.rest-assured:rest-assured:5.2.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
// Allure
    testImplementation ("org.aspectj:aspectjweaver:1.9.5")
    implementation ("io.qameta.allure:allure-junit5:${allureVersion}")
    // implementation ("io.qameta.allure:allure-commandline:${allureVersion}")
    implementation ("io.qameta.allure:allure-assertj:${allureVersion}")
    implementation ("io.qameta.allure:allure-rest-assured:${allureVersion}")
    implementation ("io.qameta.allure:allure-java-commons:${allureVersion}")
    implementation ("io.qameta.allure:allure-selenide:${allureVersion}")
}

tasks.test {

    useJUnitPlatform()
    testLogging {
        events("PASSED", "STARTED", "FAILED", "SKIPPED")
    }

}



tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}