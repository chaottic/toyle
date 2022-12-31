package com.chaottic.toyle.parser

import com.chaottic.toyle.ToyleLanguage
import com.intellij.psi.tree.IElementType

class ToyleElementType(debugName: String) : IElementType(debugName, ToyleLanguage.language)