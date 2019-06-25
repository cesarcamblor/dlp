/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.expression;

import visitor.*;

import org.antlr.v4.runtime.*;

//	ExpressionCharCte:expression -> value:String

public class ExpressionCharCte extends AbstractExpression {
	
	private char value;
	
	public ExpressionCharCte(String value) {
		if (value.equals("'\\n'")) {
			this.value = '\n';
		}
		else {
			this.value = value.charAt(1);
			
		}
	}

	public ExpressionCharCte(Object value) {
		this((value instanceof Token) ? ((Token)value).getText() : (String) value);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	public String toString() {
       return "{value:" + getValue() + "}";
   }
}
