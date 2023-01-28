// This is a generated file. Not intended for manual editing.
package com.chaottic.toyle.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface ToyleTypes {

  IElementType CLASS = new ToyleElementType("CLASS");
  IElementType PROPERTY = new ToyleElementType("PROPERTY");

  IElementType CLOSE_SCOPE = new ToyleTokenType("CLOSE_SCOPE");
  IElementType CONST = new ToyleTokenType("CONST");
  IElementType GLOBAL_NAME = new ToyleTokenType("GLOBAL_NAME");
  IElementType IDENTIFIER = new ToyleTokenType("IDENTIFIER");
  IElementType IMPORT = new ToyleTokenType("IMPORT");
  IElementType INHERIT = new ToyleTokenType("INHERIT");
  IElementType LET = new ToyleTokenType("LET");
  IElementType LINE_COMMENT = new ToyleTokenType("LINE_COMMENT");
  IElementType NUMBER = new ToyleTokenType("NUMBER");
  IElementType OPEN_SCOPE = new ToyleTokenType("OPEN_SCOPE");
  IElementType OVERRIDE = new ToyleTokenType("OVERRIDE");
  IElementType PACKAGE = new ToyleTokenType("PACKAGE");
  IElementType STRING_LITERAL = new ToyleTokenType("STRING_LITERAL");
  IElementType VAR = new ToyleTokenType("VAR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CLASS) {
        return new ToyleClassImpl(node);
      }
      else if (type == PROPERTY) {
        return new ToylePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
