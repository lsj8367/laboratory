plugins {
    kotlin("jvm") version "1.8.20"
    kotlin("plugin.spring") version "1.8.0"
    kotlin("plugin.jpa") version "1.8.0"
    kotlin("plugin.noarg") version "1.8.0"
}

group = "com.github.lsj8367"
version = "17"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.slack.api:bolt:1.29.2")
    implementation("com.slack.api:bolt-servlet:1.29.2")
}

tasks.test {
    useJUnitPlatform()
}
