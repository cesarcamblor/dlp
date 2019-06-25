/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import visitor.*;

//	TypeInt:type -> 

public class TypeInt extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	public String toString() {
       return "{TypeInt}";
   }
	
	public String getKind() {
		return "int";
	}

	@Override
	public int getSize() {
		return 2;
	}

	@Override
	public String getSuffix() {
		return "i";
	}
	
	@Override
	public String getMaplName() {
		return "int";
	}
}
