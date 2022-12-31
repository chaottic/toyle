package com.chaottic.toyle

import com.intellij.lang.Language

class ToyleLanguage : Language(name) {

	companion object {
		const val name = "toyle"

		val language = ToyleLanguage()
	}
}