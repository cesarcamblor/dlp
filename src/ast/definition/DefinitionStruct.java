/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.definition;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	DefinitionStruct:definitions -> name:String  body:definitions*

public class DefinitionStruct extends AbstractDefinitions {

	private String name;
	private List<DefinitionVariable> body;
	
	public DefinitionStruct(String name, List<DefinitionVariable> body) {
		this.name = name;
		this.body = body;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(body);
	}

	@SuppressWarnings("unchecked")
	public DefinitionStruct(Object name, Object body) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.body = (List<DefinitionVariable>) body;

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

	public List<DefinitionVariable> getBody() {
		return body;
	}
	public void setBody(List<DefinitionVariable> body) {
		this.body = body;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	public String toString() {
       return "{name:" + getName() + ", body:" + getBody() + "}";
   }
	
	public boolean isStruct() {
		return true;
	}

}
