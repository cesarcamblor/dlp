/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	SentenceFunctionCall:sentence -> name:String  param:expression*

public class SentenceFunctionCall extends AbstractSentence {

	public SentenceFunctionCall(String name, List<Expression> param) {
		this.name = name;
		this.param = param;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(param);
	}

	@SuppressWarnings("unchecked")
	public SentenceFunctionCall(Object name, Object param) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.param = (List<Expression>) param;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, param);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getParam() {
		return param;
	}
	public void setParam(List<Expression> param) {
		this.param = param;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Expression> param;

	public String toString() {
       return "{name:" + getName() + ", param:" + getParam() + "}";
   }
}
