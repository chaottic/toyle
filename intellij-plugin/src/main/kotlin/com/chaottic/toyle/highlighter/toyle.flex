package com.chaottic.toyle.highlighter;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.chaottic.toyle.parser.ToyleTypes;

%%

%class ToyleFlexLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("//")[^\r\n]*
IDENTIFIER=\ [^ \r\n]+

%state WAITING_VALUE
%state WAITING_IDENTIFIER

%%

<YYINITIAL> {END_OF_LINE_COMMENT}  { yybegin(YYINITIAL); return ToyleTypes.LINE_COMMENT; }
<YYINITIAL> "package" { yybegin(WAITING_IDENTIFIER); return ToyleTypes.PACKAGE;  }
<WAITING_IDENTIFIER> {IDENTIFIER} {  yybegin(YYINITIAL); return ToyleTypes.IDENTIFIER; }

[^]                                                         { return TokenType.BAD_CHARACTER; }