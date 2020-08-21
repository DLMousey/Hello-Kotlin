import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.4.0"
    id("application")
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "me.mousey"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "me.mousey.ApplicationKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test-junit"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
            mergeServiceFiles()
            manifest {
                attributes(mapOf("Main-Class" to "me.mousey.ApplicationKt"))
            }
    }
}