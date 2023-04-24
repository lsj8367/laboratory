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
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}
