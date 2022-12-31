plugins {
	`java-gradle-plugin`
	`maven-publish`
}

gradlePlugin {
	plugins {
		create("toyle") {
			id = "toyle"
			implementationClass = "com.chaottic.toyle.ToylePlugin"
		}
	}
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "com.chaottic"
			artifactId = "toyle"
			version = "1.0-SNAPSHOT"
			from(components["kotlin"])
		}
	}
}