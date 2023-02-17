package com.chaottic.toyle.compile

import org.gradle.api.provider.Provider

class DefaultToyleToolchainService : ToyleToolchainService {

	override fun compilerFor(spec: ToyleToolchainSpec): Provider<ToyleCompiler<ToyleCompileSpec>> {
		TODO("Not yet implemented")
	}
}