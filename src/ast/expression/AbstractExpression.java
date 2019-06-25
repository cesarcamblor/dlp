/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.expression;

import ast.AbstractAST;
import ast.type.Type;

public abstract class AbstractExpression extends AbstractAST implements Expression {
    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }

    public boolean isModificable() {
        return modificable;
    }

    private Type type;
    private boolean modificable;
}
