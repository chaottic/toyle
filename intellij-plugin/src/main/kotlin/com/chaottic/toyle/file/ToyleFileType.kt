package com.chaottic.toyle.file

import com.chaottic.toyle.ToyleLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

class ToyleFileType : LanguageFileType(ToyleLanguage.language) {
	private val icon = IconLoader.getIcon("toyle.svg", ToyleFileType::class.java)

	override fun getName() = "Toyle"

	override fun getDescription() = "Toyle"

	override fun getDefaultExtension() = "toyle"

	override fun getIcon() = icon

	companion object {
		val type = ToyleFileType()
	}
}