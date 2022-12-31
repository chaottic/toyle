package com.chaottic.toyle.highlighter

import com.intellij.lexer.FlexAdapter
import java.io.Reader

class ToyleFlexAdapter : FlexAdapter(ToyleFlexLexer(Reader.nullReader()))