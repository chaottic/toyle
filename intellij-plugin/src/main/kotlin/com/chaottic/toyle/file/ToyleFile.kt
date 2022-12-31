package com.chaottic.toyle.file

import com.chaottic.toyle.ToyleLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class ToyleFile(provider: FileViewProvider) : PsiFileBase(provider, ToyleLanguage.language) {

	override fun getFileType() = ToyleFileType.type
}