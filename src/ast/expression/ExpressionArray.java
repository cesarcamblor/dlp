/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.expression;

import visitor.*;

import org.antlr.v4.runtime.*;

//	ExpressionArray:expression -> left:expression  right:expression

public class ExpressionArray extends AbstractExpression {
	
	private Expression left;
	private Expression right;
	
	public ExpressionArray(Expression left, Expression right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public ExpressionArray(Object left, Object right) {
		this.left = (Expression) ((left instanceof ParserRuleContext) ? getAST(left) : left);
		this.right = (Expression) ((right instanceof ParserRuleContext) ? getAST(right) : right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Expression getLeft() {
		return left;
	}
	public void setLeft(Expression left) {
		this.left = left;
	}

	public Expression getRight() {
		return right;
	}
	public void setRight(Expression right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	public String toString() {
       return "{left:" + getLeft() + ", right:" + getRight() + "}";
   }
}
