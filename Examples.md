# Examples
This file contains mock-ups. These are always prone to change.

Toyle files don't need to end lines with ";" and must have a package.
```java
package org.example.Example
```

Imports are the same as Java
```java
package org.example.Example

import org.example.HelloWorld
import org.example.foo.Bar
```

Functions are declared with the "routine" keyword. All functions, classes, enums and as such are public by default.
```java
package org.example.Example

routine main(args: string[]) {
}
```

Access can either be declared with the keywords "private" or "protected", along with being used as "blocks"
```java
package org.example.Example

routine main(args: string[]) {
    add(0, 0)
}

private routine add(x: int, y: int) -> int {
    return x + y
}
```
```java
package org.example.Example

routine main(args: string[]) {
    add(0, 0)
}

private {
    
    rountine add(x: int, y: int) -> int {
        return x + y
    }
}
```
Functions can be inferred
```java
package org.example.Example

routine main(args: string[]) {
}

routine add(x: int, y: int) -> x + y
```

Exception handling 
```java
package org.example.Example;

routine main(args: string[]) {
    divide(100, 0).catch
    divide(100, 0).silence
}

routine divide(x: int, y: int) -> int throws ArithmeticException {
    return x / y
}
```
Exceptions must be propagated
```java
package org.example.Example

routine main(args: string[]) {
    before().catch
}

routine before() throws RuntimeExeception {
    after()
}

routine after() throws RuntimeException {
    // ...
}
```
The "const" keyword can only be used for primitive data types.
```java
package org.example.Example

const foo = 0
const bar = 1
```

Getters and Setters
```java
package org.example.Example

routine main(args: string[]) {
}

class ExampleClass {
    var number: int {
        get; set
    }
}
```