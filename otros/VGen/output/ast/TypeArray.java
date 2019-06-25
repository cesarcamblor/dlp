/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	TypeArray:type -> dimension:String*  type:type

public class TypeArray extends AbstractType {

	public TypeArray(List<String> dimension, Type type) {
		this.dimension = dimension;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	@SuppressWarnings("unchecked")
	public TypeArray(Object dimension, Object type) {
		this.dimension = tokensToStrings(dimension);
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(dimension, type);
	}

	public List<String> getDimension() {
		return dimension;
	}
	public void setDimension(List<String> dimension) {
		this.dimension = dimension;
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


	@SuppressWarnings("unchecked")
	static private List<String> tokensToStrings(Object objectList) {
		if (objectList == null)
			return null;
		List<String> strings = new ArrayList<String>();
		for (Object o : (List<Object>) objectList)
			strings.add((o instanceof Token) ? ((Token) o).getText() : (String) o);
		return strings;
	}


	private List<String> dimension;
	private Type type;

	public String toString() {
       return "{dimension:" + getDimension() + ", type:" + getType() + "}";
   }
}
