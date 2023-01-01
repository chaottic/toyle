package com.chaottic.toyle.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class ToyleReference(element: PsiElement, range: TextRange) : PsiReferenceBase<PsiElement>(element, range), PsiPolyVariantReference {

	override fun resolve(): PsiElement? {
		TODO("Not yet implemented")
	}

	override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
		TODO("Not yet implemented")
	}
}