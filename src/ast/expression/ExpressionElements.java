/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.expression;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import visitor.Visitor;

//	ExpressionElements:expression -> left:expression  right:String

public class ExpressionElements extends AbstractExpression {

	private Expression left;
	private String right;
	
	public ExpressionElements(Expression left, String right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left);
	}

	public ExpressionElements(Object left, Object right) {
		this.left = (Expression) ((left instanceof ParserRuleContext) ? getAST(left) : left);
		this.right = (right instanceof Token) ? ((Token)right).getText() : (String) right;

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

	public String getRight() {
		return right;
	}
	public void setRight(String right) {
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
