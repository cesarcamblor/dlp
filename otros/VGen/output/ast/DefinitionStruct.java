/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	DefinitionStruct:definitions -> name:String  body:sentence*

public class DefinitionStruct extends AbstractDefinitions {

	public DefinitionStruct(String name, List<Sentence> body) {
		this.name = name;
		this.body = body;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(body);
	}

	@SuppressWarnings("unchecked")
	public DefinitionStruct(Object name, Object body) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.body = (List<Sentence>) body;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, body);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Sentence> getBody() {
		return body;
	}
	public void setBody(List<Sentence> body) {
		this.body = body;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Sentence> body;

	public String toString() {
       return "{name:" + getName() + ", body:" + getBody() + "}";
   }
}
