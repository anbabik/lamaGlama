import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
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
    testImplementation("com.codeborne:selenide:6.11.2")
    testImplementation ("io.rest-assured:rest-assured:5.2.0")
    testImplementation ("io.rest-assured:kotlin-extensions:5.2.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
// Allure
    implementation ("io.qameta.allure:allure-junit5:${allureVersion}")
    implementation ("io.qameta.allure:allure-assertj:${allureVersion}")
    implementation ("io.qameta.allure:allure-rest-assured:${allureVersion}")
    implementation ("io.qameta.allure:allure-java-commons:${allureVersion}")
    implementation ("io.qameta.allure:allure-selenide:${allureVersion}")

    testImplementation ("org.aspectj:aspectjweaver:1.9.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}