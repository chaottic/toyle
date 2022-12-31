package com.chaottic.toyle

import com.chaottic.toyle.compile.ToyleCompile
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension

class ToylePlugin : Plugin<Project> {

	override fun apply(target: Project) {
		target.pluginManager.apply(JavaPlugin::class.java)

		target.extensions.getByType(JavaPluginExtension::class.java).sourceSets.all {
			target.objects.sourceDirectorySet("toyle", "Toyle").apply {
				srcDir("src/${it.name}/toyle")
				filter.include("**/*.toyle")

				it.allSource.source(this)

				it.extensions.add("toyle", this)
			}
		}

		target.extensions.create("toyle", ToyleExtension::class.java)

		target.tasks.create("compileToyle", ToyleCompile::class.java)
	}
}