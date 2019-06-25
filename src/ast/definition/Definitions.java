/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.definition;

import ast.AST;

public interface Definitions extends AST {
	String getWhere();
	boolean isLocal();
	boolean isParameter();
	boolean isGlobal();
	boolean isFuncion();
	boolean isStruct();
	boolean isVariable();
	
	
}
