/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	TypeArray:type -> dimension:String*  type:type

public class TypeArray extends AbstractType {

	private String dimension;
	private Type type;
	
	public TypeArray(String dimension, Type type) {
		this.dimension = dimension;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el
		// fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public TypeArray(Object dimension, Object type) {
		this.dimension = (dimension instanceof Token)
				? ((Token) dimension).getText()
				: (String) dimension;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type)
				: type);

		// Lo siguiente se puede borrar si no se quiere la posicion en el
		// fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(dimension, type);
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
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

	@SuppressWarnings({ "unchecked", "unused" })
	static private List<String> tokensToStrings(Object objectList) {
		if (objectList == null)
			return null;
		List<String> strings = new ArrayList<String>();
		for (Object o : (List<Object>) objectList)
			strings.add(
					(o instanceof Token) ? ((Token) o).getText() : (String) o);
		return strings;
	}

	public String toString() {
		return "{dimension:" + getDimension() + ", type:" + getType() + "}";
	}
	
	public String getKind() {
		return "array";
	}

	@Override
	public int getSize() {
		int dim= Integer.parseInt(dimension);
		return dim * type.getSize();
	}

	@Override
	public String getSuffix() {
		throw new UnsupportedOperationException("No implementado aun. TypeArray Suffix");
	}

	@Override
	public String getMaplName() {
		return getDimension() +"*" +  type.getMaplName();
	}
}
