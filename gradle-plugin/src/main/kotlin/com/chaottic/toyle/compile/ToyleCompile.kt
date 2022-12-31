package com.chaottic.toyle.compile

import org.gradle.api.internal.tasks.compile.HasCompileOptions
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.compile.AbstractCompile
import org.gradle.api.tasks.compile.CompileOptions

@CacheableTask
open class ToyleCompile : AbstractCompile(), HasCompileOptions {
	private val options = project.objects.newInstance(CompileOptions::class.java)

	override fun getOptions(): CompileOptions = options
}