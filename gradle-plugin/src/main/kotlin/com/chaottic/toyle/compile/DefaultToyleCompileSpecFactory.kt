package com.chaottic.toyle.compile

class DefaultToyleCompileSpecFactory : AbstractToyleCompileSpecFactory<DefaultToyleCompileSpec>() {
	override fun create() = DefaultToyleCompileSpec()
}