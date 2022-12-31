package com.chaottic.toyle.file

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class ToyleNewFileAction : CreateFileFromTemplateAction("", "", ToyleFileType.type.icon) {
	override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
		builder.apply {
			setTitle("New Toyle File")
			addKind("Toyle", ToyleFileType.type.icon, "Toyle")
		}
	}

	override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?) = "Toyle"
}