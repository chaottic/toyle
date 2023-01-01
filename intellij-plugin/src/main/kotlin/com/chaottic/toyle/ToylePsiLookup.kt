package com.chaottic.toyle

import com.chaottic.toyle.file.ToyleFileType
import com.chaottic.toyle.parser.ToyleProperty
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

object ToylePsiLookup {

	fun properties(project: Project, key: String): List<ToyleProperty> {
		val list: MutableList<ToyleProperty> = arrayListOf()

		FileTypeIndex.getFiles(ToyleFileType.type, GlobalSearchScope.allScope(project)).forEach {
			PsiManager.getInstance(project).findFile(it)?.apply {
				PsiTreeUtil.getChildrenOfType(this, ToyleProperty::class.java)?.filter { property -> key == ToylePsiUtil.getKey(property) }?.forEach(list::add)
			}
		}

		return list
	}
}