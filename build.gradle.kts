plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.kotest:kotest-runner-junit5:5.0.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    wrapper {
        gradleVersion = "7.3"
    }
}
