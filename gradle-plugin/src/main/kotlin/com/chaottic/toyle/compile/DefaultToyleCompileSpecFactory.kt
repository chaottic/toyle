package com.chaottic.toyle.compile

import org.gradle.api.tasks.compile.CompileOptions

class DefaultToyleCompileSpecFactory(compileOptions: CompileOptions) : AbstractToyleCompileSpecFactory<DefaultToyleCompileSpec>() {
	override fun create() = DefaultToyleCompileSpec()
}