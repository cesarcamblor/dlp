/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	SentencePrint:sentence -> expr:expression  accion:String

public class SentencePrint extends AbstractSentence {

	public SentencePrint(Expression expr, String accion) {
		this.expr = expr;
		this.accion = accion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public SentencePrint(Object expr, Object accion) {
		this.expr = (Expression) ((expr instanceof ParserRuleContext) ? getAST(expr) : expr);
		this.accion = (accion instanceof Token) ? ((Token)accion).getText() : (String) accion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr, accion);
	}

	public Expression getExpr() {
		return expr;
	}
	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expr;
	private String accion;

	public String toString() {
       return "{expr:" + getExpr() + ", accion:" + getAccion() + "}";
   }
}
