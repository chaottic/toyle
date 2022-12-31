package com.chaottic.toyle.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class ToyleSyntaxHighlighter : SyntaxHighlighterBase() {

	override fun getHighlightingLexer() = ToyleFlexAdapter()

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {

		return empty
	}

	private companion object {
		val empty = arrayOf<TextAttributesKey>()
	}
}