package com.chaottic.toyle.highlighter

import com.chaottic.toyle.parser.ToyleTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class ToyleSyntaxHighlighter : SyntaxHighlighterBase() {

	override fun getHighlightingLexer() = ToyleFlexAdapter()

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
		if (tokenType!! == ToyleTypes.LINE_COMMENT) {
			return lineComment
		}
		if (tokenType!! == ToyleTypes.PACKAGE) {
			return keyWord
		}

		return empty
	}

	private companion object {
		val empty = arrayOf<TextAttributesKey>()
		val lineComment = arrayOf(TextAttributesKey.createTextAttributesKey("TOYLE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT))
		val keyWord = arrayOf(TextAttributesKey.createTextAttributesKey("TOYLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD))
	}
}