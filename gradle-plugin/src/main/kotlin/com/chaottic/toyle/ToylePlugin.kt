package com.chaottic.toyle

import com.chaottic.toyle.compile.ToyleCompile
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension

class ToylePlugin : Plugin<Project> {

	override fun apply(target: Project) {
		target.pluginManager.apply(JavaPlugin::class.java)

		val compileTask = target.tasks.create("compileToyle", ToyleCompile::class.java)

		val extensions = target.extensions

		extensions.getByType(JavaPluginExtension::class.java).sourceSets.all {
			val sourceDirectorySet = target.objects.sourceDirectorySet("toyle", "Toyle")

			sourceDirectorySet.srcDir("src/${it.name}/toyle")
			sourceDirectorySet.filter.include("**/*.toyle")

			it.extensions.add("toyle", sourceDirectorySet)
			it.allSource.srcDirs(sourceDirectorySet)
			it.allSource.source(sourceDirectorySet)
			it.java.source(sourceDirectorySet)
			it.compiledBy(compileTask)
		}
		extensions.create("toyle", ToyleExtension::class.java)
	}
}