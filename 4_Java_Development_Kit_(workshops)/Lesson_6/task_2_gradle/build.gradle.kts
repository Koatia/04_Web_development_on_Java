plugins {
    id("java")
}

group = "ru.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.guava:guava:33.3.0-jre")
}

tasks.test {
    useJUnitPlatform()
}