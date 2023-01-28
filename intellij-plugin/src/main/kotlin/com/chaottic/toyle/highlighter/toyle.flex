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
ANY_WORD=\ [^ \r\n]+

%state WAITING_VALUE
%state WAITING_IDENTIFIER
%state WAITING_CLASS_SCOPE
%state WAITING_FUNCTION_SCOPE
%state WAITING_GLOBAL_NAME

%%

<YYINITIAL> {
      {END_OF_LINE_COMMENT}  { yybegin(YYINITIAL); return ToyleTypes.LINE_COMMENT; }
      "package" { yybegin(WAITING_IDENTIFIER); return ToyleTypes.PACKAGE;  }
      "import" { yybegin(WAITING_IDENTIFIER); return ToyleTypes.IMPORT;  }
      "class" { yybegin(WAITING_IDENTIFIER); return ToyleTypes.CLASS; }
      "inherit" { yybegin(WAITING_IDENTIFIER); return ToyleTypes.INHERIT; }
      "const" { yybegin(WAITING_GLOBAL_NAME); return ToyleTypes.CONST; }
      "var" { yybegin(WAITING_GLOBAL_NAME); return ToyleTypes.VAR; }
      "val" { yybegin(WAITING_GLOBAL_NAME); return ToyleTypes.LET; }
      [.*0-9]+ { yybegin(YYINITIAL); return ToyleTypes.NUMBER; }
      \"([^\r\n]*)\" { yybegin(YYINITIAL); return ToyleTypes.STRING_LITERAL; }
      "{" { yybegin(WAITING_SCOPE); return ToyleTypes.OPEN_SCOPE; }
}
<WAITING_IDENTIFIER> {ANY_WORD} {  yybegin(YYINITIAL); return ToyleTypes.IDENTIFIER; }
<WAITING_CLASS_SCOPE> {
      "}" {  yybegin(YYINITIAL); return ToyleTypes.CLOSE_SCOPE; }
      "override" {  yybegin(WAITING_SCOPE); return ToyleTypes.OVERRIDE; }
}
<WAITING_GLOBAL_NAME> {ANY_WORD} {  yybegin(YYINITIAL); return ToyleTypes.GLOBAL_NAME; }

[^]                                                         { return TokenType.BAD_CHARACTER; }