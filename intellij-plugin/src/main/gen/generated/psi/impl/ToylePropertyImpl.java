// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.chaottic.toyle.parser.ToyleTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.chaottic.toyle.parser.*;
import com.chaottic.toyle.ToylePsiUtil;

public class ToylePropertyImpl extends ASTWrapperPsiElement implements ToyleProperty {

  public ToylePropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ToyleVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ToyleVisitor) accept((ToyleVisitor)visitor);
    else super.accept(visitor);
  }

}
