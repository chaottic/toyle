# Toyle
Toyle is an independent programming language created for the JVM. The goal of Toyle is to be a learning experience, provide less boilerplate and enforce better practises compared to Java.

See "Examples.md" for Examples.

### Applying to your project
Clone the repository and then execute
``gradle gradle-plugin:publishToMavenLocal``

and then
``gradle intellij-plugin:runIde``

within the debug IDE create a new kts gradle project and add
```kotlin
pluginManagement {
    repositories { 
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}
```
to the project's ``settings.gradle.kts``

afterwards add
```kotlin
plugins {
    id("toyle") version "1.0-SNAPSHOT"
}
```
to the project's ``build.gradle.kts``

you will then need to create a source directory ``src/main/toyle``