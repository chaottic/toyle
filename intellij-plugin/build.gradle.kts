plugins {
	id("org.jetbrains.intellij") version "1.11.0"
}

intellij {
	version.set("2022.3.1")

	plugins.set(listOf("com.intellij.java"))
}

sourceSets.main.get().java.srcDir("src/main/gen")