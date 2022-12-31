package com.chaottic.toyle.file

import com.chaottic.toyle.ToyleLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

class ToyleFileType : LanguageFileType(ToyleLanguage.language) {
	override fun getName() = "Toyle"

	override fun getDescription() = ""

	override fun getDefaultExtension() = "toyle"

	override fun getIcon() = IconLoader.getIcon("toyle.svg", ToyleFileType::class.java)

	companion object {
		val type = ToyleFileType()
	}
}