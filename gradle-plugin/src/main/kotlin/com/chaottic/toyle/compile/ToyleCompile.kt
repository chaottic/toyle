package com.chaottic.toyle.compile

import org.gradle.api.internal.tasks.compile.HasCompileOptions
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.*
import org.gradle.api.tasks.compile.AbstractCompile
import org.gradle.api.tasks.compile.CompileOptions
import org.gradle.work.InputChanges

@CacheableTask
open class ToyleCompile : AbstractCompile(), HasCompileOptions {
	@Input
	private val options = project.objects.newInstance(CompileOptions::class.java)

	@TaskAction
	fun compile(inputChanges: InputChanges) {
		val spec = createSpec()
		fullCompile(spec)
	}

	private fun fullCompile(spec: DefaultToyleCompileSpec) {
		val compiler = createCompiler()
		compileSpec(spec, compiler)
	}

	private fun compileSpec(spec: ToyleCompileSpec, compiler: ToyleCompiler<ToyleCompileSpec>): WorkResult {
		val result = compiler.execute(spec)
		didWork = result.didWork
		return result
	}

	private fun createCompiler(): ToyleCompiler<ToyleCompileSpec> {
		val compiler = createToolchainCompiler<DefaultToyleCompileSpec>()

		return DefaultToyleCompiler()
	}
	
	private fun <T : ToyleCompileSpec> createToolchainCompiler(): ToyleCompiler<T> {
		return object : ToyleCompiler<T> {

			override fun execute(spec: T): WorkResult {
				val compiler = getCompilerTool<T>().get()

				return compiler.execute(spec)
			}
		}
	}

	private fun <T : ToyleCompileSpec> getCompilerTool(): Provider<ToyleCompiler<T>> {
		TODO("")
	}

	private fun createSpec(): DefaultToyleCompileSpec {
		val spec = createBaseSpec()

		return spec
	}

	private fun createBaseSpec(): DefaultToyleCompileSpec {
		return DefaultToyleCompileSpecFactory().create()
	}

	override fun getOptions(): CompileOptions = options
}