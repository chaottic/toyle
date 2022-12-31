import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "com.chaottic"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation(kotlin("test"))
    }

    tasks {
        test {
            useJUnitPlatform()
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "17"
        }
    }
}