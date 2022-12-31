package com.chaottic.toyle.parser

import com.chaottic.toyle.ToyleLanguage
import com.intellij.psi.tree.IElementType

class ToyleTokenType(debugName: String) : IElementType(debugName, ToyleLanguage.language)