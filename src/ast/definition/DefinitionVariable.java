/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.definition;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import ast.type.Type;
import visitor.Visitor;

//	DefinitionVariable:definitions -> name:String  type:type

public class DefinitionVariable extends AbstractDefinitions {

	private String name;
	private Type type;
	private int address;
	
	public DefinitionVariable(String name, Type type, String where) {
		this.name = name;
		this.type = type;
		super.setWhere(where);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public DefinitionVariable(Object name, Object type, Object where) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);
		super.setWhere((String) where);
       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, type);
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

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
	
	public String toString() {
       return "{name:" + getName() + ", type:" + getType() + "}";
   }
	
	public boolean isVariable() {
		return true;
	}
    
}
