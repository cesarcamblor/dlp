/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import ast.AST;

public interface Type extends AST {
	boolean isSimple();
	boolean isArray();
	boolean isChar();
	boolean isInt();
	boolean isStruct();
	boolean isReal();
	boolean equals(Type type);
	boolean isNumeric();
	boolean isVoidType();
	String getKind();
	int getSize();
	String getSuffix();
	String getMaplName();
	boolean equivalenciaEstructural(Type right);
	
}
