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
  // IDENTIFIER (INHERIT IDENTIFIER)? (OPEN_SCOPE (OVERRIDE)* CLOSE_SCOPE)?
  public static boolean class_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_$")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && class_1(b, l + 1);
    r = r && class_2(b, l + 1);
    exit_section_(b, m, CLASS, r);
    return r;
  }

  // (INHERIT IDENTIFIER)?
  private static boolean class_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_1")) return false;
    class_1_0(b, l + 1);
    return true;
  }

  // INHERIT IDENTIFIER
  private static boolean class_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INHERIT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OPEN_SCOPE (OVERRIDE)* CLOSE_SCOPE)?
  private static boolean class_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_2")) return false;
    class_2_0(b, l + 1);
    return true;
  }

  // OPEN_SCOPE (OVERRIDE)* CLOSE_SCOPE
  private static boolean class_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_SCOPE);
    r = r && class_2_0_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_SCOPE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OVERRIDE)*
  private static boolean class_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, OVERRIDE)) break;
      if (!empty_element_parsed_guard_(b, "class_2_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PACKAGE IDENTIFIER (IMPORT IDENTIFIER)* class* (CONST|VAR GLOBAL_NAME)* LINE_COMMENT*
  // NUMBER
  // STRING_LITERAL
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    if (!nextTokenIs(b, PACKAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PACKAGE, IDENTIFIER);
    r = r && file_2(b, l + 1);
    r = r && file_3(b, l + 1);
    r = r && file_4(b, l + 1);
    r = r && file_5(b, l + 1);
    r = r && consumeTokens(b, 0, NUMBER, STRING_LITERAL);
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

  // class*
  private static boolean file_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_3", c)) break;
    }
    return true;
  }

  // (CONST|VAR GLOBAL_NAME)*
  private static boolean file_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_4", c)) break;
    }
    return true;
  }

  // CONST|VAR GLOBAL_NAME
  private static boolean file_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONST);
    if (!r) r = parseTokens(b, 0, VAR, GLOBAL_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_COMMENT*
  private static boolean file_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_COMMENT)) break;
      if (!empty_element_parsed_guard_(b, "file_5", c)) break;
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
