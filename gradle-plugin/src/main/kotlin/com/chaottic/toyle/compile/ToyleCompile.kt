package com.chaottic.toyle.compile

import org.gradle.api.file.FileCollection
import org.gradle.api.file.ProjectLayout
import org.gradle.api.internal.tasks.compile.HasCompileOptions
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.*
import org.gradle.api.tasks.compile.AbstractCompile
import org.gradle.api.tasks.compile.CompileOptions
import org.gradle.work.Incremental
import org.gradle.work.InputChanges
import javax.inject.Inject

@CacheableTask
open class ToyleCompile : AbstractCompile(), HasCompileOptions {
	@Input
	private val compileOptions = project.objects.newInstance(CompileOptions::class.java)

	private val stableSources = project.files(::getSource)

	private val defaultSpec
		get() = DefaultToyleCompileSpecFactory(compileOptions).create()

	@get:Inject
	open val projectLayout: ProjectLayout
		get() {
			throw UnsupportedOperationException()
		}

	@get:Inject
	open val moduleDetector: ToyleModuleDetector
		get() {
			throw UnsupportedOperationException()
		}

	@get:Inject
	open val toolchainService: ToyleToolchainService
		get() {
			throw UnsupportedOperationException()
		}

	private val spec: DefaultToyleCompileSpec
		get() = defaultSpec.apply {
			val moduleDetector = moduleDetector
			destinationDir = destinationDirectory.asFile.get()
			workingDir = projectLayout.projectDirectory.asFile
			tempDir = temporaryDir
		}

	private val explicitToolchainSpec: ToyleToolchainSpec
		get() {
			TODO()
		}

	private val compilerTool: Provider<ToyleCompiler<ToyleCompileSpec>>
		get() {
			return toolchainService.compilerFor(explicitToolchainSpec)
		}

	private val toolchainCompiler: ToyleCompiler<ToyleCompileSpec>
		get() {
			return object : ToyleCompiler<ToyleCompileSpec> {

				override fun execute(spec: ToyleCompileSpec?): WorkResult {
					return compilerTool.get().execute(spec)
				}
			}
		}

	private val compiler
		get() = toolchainCompiler

	@TaskAction
	fun compile(inputChanges: InputChanges) {
		compileSpec(spec.apply { sourceFiles = stableSources }, compiler)
	}

	private fun compileSpec(spec: ToyleCompileSpec, compiler: ToyleCompiler<ToyleCompileSpec>): WorkResult {
		val result = compiler.execute(spec)
		didWork = result.didWork
		return result
	}

	@CompileClasspath
	@Incremental
	override fun getClasspath(): FileCollection? {
		return super.getClasspath()
	}

	override fun getOptions(): CompileOptions = compileOptions
}