package com.chaottic.toyle.parser

import com.chaottic.toyle.ToyleLanguage
import com.chaottic.toyle.file.ToyleFile
import com.chaottic.toyle.highlighter.ToyleFlexAdapter
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class ToyleParserDefinition : ParserDefinition {

	override fun createLexer(project: Project?) = ToyleFlexAdapter()

	override fun createParser(project: Project?) = ToyleParser()

	override fun getFileNodeType() = fileElementType

	override fun getCommentTokens() = tokenSet

	override fun getStringLiteralElements() = TokenSet.EMPTY

	override fun createElement(node: ASTNode?) = ToyleTypes.Factory.createElement(node)

	override fun createFile(viewProvider: FileViewProvider) = ToyleFile(viewProvider)

	companion object {
		val fileElementType = IFileElementType(ToyleLanguage.language)

		val tokenSet = TokenSet.create(ToyleTypes.LINE_COMMENT)
	}
}