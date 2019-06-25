package ast.type;

import visitor.Visitor;

public class TypeVoid extends AbstractType{

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{TypeVoid}";
   }
	
	public String getKind() {
		return "void";
	}


	@Override
	public int getSize() {
		throw new UnsupportedOperationException("Nunca se ha de poder realizar esta operacion. VoidType size");
	}


	@Override
	public String getSuffix() {
		throw new UnsupportedOperationException("Nunca se ha de poder realizar esta operacion. VoidType get Suffix");
	}
	
	@Override
	public String getMaplName() {
		throw new UnsupportedOperationException("Nunca se ha de poder realizar esta operacion. VoidType get Mapl Name");
	}

}
