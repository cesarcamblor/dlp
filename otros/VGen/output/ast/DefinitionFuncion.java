/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	DefinitionFuncion:definitions -> name:String  type:type  param:definitions*  definitions:definitions*  body:sentence*

public class DefinitionFuncion extends AbstractDefinitions {

	public DefinitionFuncion(String name, Type type, List<Definitions> param, List<Definitions> definitions, List<Sentence> body) {
		this.name = name;
		this.type = type;
		this.param = param;
		this.definitions = definitions;
		this.body = body;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type, param, definitions, body);
	}

	@SuppressWarnings("unchecked")
	public DefinitionFuncion(Object name, Object type, Object param, Object definitions, Object body) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);
		this.param = (List<Definitions>) param;
		this.definitions = (List<Definitions>) definitions;
		this.body = (List<Sentence>) body;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, type, param, definitions, body);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public List<Definitions> getParam() {
		return param;
	}
	public void setParam(List<Definitions> param) {
		this.param = param;
	}

	public List<Definitions> getDefinitions() {
		return definitions;
	}
	public void setDefinitions(List<Definitions> definitions) {
		this.definitions = definitions;
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
	private Type type;
	private List<Definitions> param;
	private List<Definitions> definitions;
	private List<Sentence> body;

	public String toString() {
       return "{name:" + getName() + ", type:" + getType() + ", param:" + getParam() + ", definitions:" + getDefinitions() + ", body:" + getBody() + "}";
   }
}
