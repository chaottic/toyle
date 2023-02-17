package com.chaottic.toyle.compile

import org.gradle.api.provider.Provider

interface ToyleToolchainService {

	fun compilerFor(spec: ToyleToolchainSpec): Provider<ToyleCompiler<ToyleCompileSpec>>
}