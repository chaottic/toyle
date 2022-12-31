// This is a generated file. Not intended for manual editing.
package com.chaottic.toyle.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface ToyleTypes {

  IElementType PROPERTY = new ToyleElementType("PROPERTY");

  IElementType COMMENT = new ToyleTokenType("COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new ToylePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
