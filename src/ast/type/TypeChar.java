/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import visitor.*;

//	TypeChar:type -> 

public class TypeChar extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{TypeChar}";
   }
	
	public String getKind() {
		return "char";
	}


	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public String getSuffix() {
		return "b";
	}


	@Override
	public String getMaplName() {
		return "char";
	}
}
