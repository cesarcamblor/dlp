/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import visitor.*;

//	TypeReal:type -> 

public class TypeReal extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{TypeReal}";
	}

	public String getKind() {
		return "real";
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getSuffix() {
		return "f";
	}

	@Override
	public String getMaplName() {
		return "float";
	}
}
