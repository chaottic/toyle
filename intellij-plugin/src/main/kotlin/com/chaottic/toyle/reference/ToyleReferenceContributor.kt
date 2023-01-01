package com.chaottic.toyle.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class ToyleReferenceContributor : PsiReferenceContributor() {

	override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
		registrar.registerReferenceProvider(PlatformPatterns.psiElement(), object : PsiReferenceProvider() {

			override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {

				return PsiReference.EMPTY_ARRAY
			}
		})
	}
}