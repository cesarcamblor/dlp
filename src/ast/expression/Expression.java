/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.expression;

import ast.AST;
import ast.type.Type;


public interface Expression extends AST {
    public void setType(Type type);

    public Type getType();

    public void setModificable(boolean modificable);

    public boolean isModificable();
}
