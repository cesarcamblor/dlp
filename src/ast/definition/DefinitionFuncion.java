/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.definition;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

import ast.sentence.Sentence;
import ast.type.Type;

//	DefinitionFuncion:definitions -> name:String  type:type  param:definitions*  definitions:definitions*  body:sentence*

public class DefinitionFuncion extends AbstractDefinitions {

	private String name;
	private Type type;
	private List<DefinitionVariable> param;
	private List<DefinitionVariable> definitions;
	private List<Sentence> body;
	private int localSize;
	private int paramSize;
	
	public DefinitionFuncion(String name, Type type, List<DefinitionVariable> param, List<DefinitionVariable> definitions, List<Sentence> body) {
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
		this.param = (List<DefinitionVariable>) param;
		this.definitions = (List<DefinitionVariable>) definitions;
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

	public List<DefinitionVariable> getParam() {
		return param;
	}
	public void setParam(List<DefinitionVariable> param) {
		this.param = param;
	}

	public List<DefinitionVariable> getDefinitions() {
		return definitions;
	}
	public void setDefinitions(List<DefinitionVariable> definitions) {
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

	public String toString() {
       return "{name:" + getName() + ", type:" + getType() + ", param:" + getParam() + ", definitions:" + getDefinitions() + ", body:" + getBody() + "}";
   }

	public int getParametersSize() {
		return paramSize;
	}
	
	public int getLocalVarsSize() {
		return localSize;
	}
	
	public void setParametersSize(int i) {
		paramSize = i;
		
	}

	public void setLocalVarsSize(int i) {
		localSize = i;
		
	}

	@Override
	public boolean isFuncion() {
		return true;
	}


}
