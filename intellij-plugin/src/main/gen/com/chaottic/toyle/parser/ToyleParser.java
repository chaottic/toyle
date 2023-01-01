// This is a generated file. Not intended for manual editing.
package com.chaottic.toyle.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.chaottic.toyle.parser.ToyleTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ToyleParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // PACKAGE IDENTIFIER (IMPORT IDENTIFIER)* LINE_COMMENT*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    if (!nextTokenIs(b, PACKAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PACKAGE, IDENTIFIER);
    r = r && file_2(b, l + 1);
    r = r && file_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IMPORT IDENTIFIER)*
  private static boolean file_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_2", c)) break;
    }
    return true;
  }

  // IMPORT IDENTIFIER
  private static boolean file_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_COMMENT*
  private static boolean file_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_COMMENT)) break;
      if (!empty_element_parsed_guard_(b, "file_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LINE_COMMENT*
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_COMMENT)) break;
      if (!empty_element_parsed_guard_(b, "property", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

}
