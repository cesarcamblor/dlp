/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	ExpressionCast:expression -> castTo:type  castFrom:expression

public class ExpressionCast extends AbstractExpression {

	public ExpressionCast(Type castTo, Expression castFrom) {
		this.castTo = castTo;
		this.castFrom = castFrom;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(castTo, castFrom);
	}

	public ExpressionCast(Object castTo, Object castFrom) {
		this.castTo = (Type) ((castTo instanceof ParserRuleContext) ? getAST(castTo) : castTo);
		this.castFrom = (Expression) ((castFrom instanceof ParserRuleContext) ? getAST(castFrom) : castFrom);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(castTo, castFrom);
	}

	public Type getCastTo() {
		return castTo;
	}
	public void setCastTo(Type castTo) {
		this.castTo = castTo;
	}

	public Expression getCastFrom() {
		return castFrom;
	}
	public void setCastFrom(Expression castFrom) {
		this.castFrom = castFrom;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Type castTo;
	private Expression castFrom;

	public String toString() {
       return "{castTo:" + getCastTo() + ", castFrom:" + getCastFrom() + "}";
   }
}
