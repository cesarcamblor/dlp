/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import visitor.*;

import org.antlr.v4.runtime.*;

import ast.definition.DefinitionStruct;
import ast.definition.DefinitionVariable;

//	TypeStruct:type -> name:String

public class TypeStruct extends AbstractType {

	private String name;
	private DefinitionStruct definition;
	
	public TypeStruct(String name) {
		this.name = name;
	}

	public TypeStruct(Object name) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	public String toString() {
       return "{name:" + getName() + "}";
   }

	public DefinitionStruct getDefinicion() {
		return definition;
	}

	public void setDefinicion(DefinitionStruct definition) {
		this.definition = definition;
	}
	
	public String getKind() {
		return "struct";
	}
	
	public DefinitionVariable searchField(String name) {
		for (DefinitionVariable dv : definition.getBody()) {
			if(dv.getName().equals(name))
				return dv;
		}
		return null;
	}

	@Override
	public int getSize() {
		int size = 0;
		for (DefinitionVariable df : definition.getBody()) 
			size += df.getType().getSize();
		return size;
	}

	@Override
	public String getSuffix() {
		throw new UnsupportedOperationException("No implementado aun. TypeStruct Suffix");
	}

	@Override
	public String getMaplName() {
		return name;
	}
	

	
	
}
