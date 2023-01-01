# toyle
Programming language for the Java Virtual Machine.


### Syntax Example
The syntax designed with ligatures in mind.
```java
package net.example.Example
        
import net.example.special.SpecialObject
        
// Outside of a class is global.        

// The "const" keyword can only be used for primitives, and inferred is the preferred type declaration.
const a = 0        
const b = 0
const c = 0
const johnDoe = "John Doe"

// Mutable variables with type declaration.
var x: byte = 0
var y: byte = 0
var z: byte = 0
        
// Declaring a void function.
func helloWorld() {
    // Reasigning the above global variables.
    x = 0xFF
    y = 0xFF
    z = 0xFF
        
    print("Hello World")
}

// Inferred return type.
func add(x: int, y: int) -> x + y
        
// Without inferred.
func add(x: int, y: int) -> int {
    return x + y    
}

class MyObject inherit SpecialObject {
    
    // Override a function. Don't need to specify the "func" keyword.
    override helloWorld() {
        explode()
    }
    
    private func explode() {
        // ...
    }
}

// Access blocks are an alternative way to prevent the overuse of "private".

private const a = 0
private const b = 0
private const c = 0

// This the above can be shortened to:
private {
    const a = 0    
    const b = 0
    const c = 0
}
```

### Toying with
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