/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.type;

import ast.AbstractAST;
import ast.definition.DefinitionVariable;

public abstract class AbstractType extends AbstractAST implements Type {

	public boolean isSimple() {
		return isReal() || isInt() || isChar();
	}
	
	public boolean isNumeric() {
		return isReal() || isInt();
	}
	
	public boolean isReal() {
		return getKind().equals("real");
	}
	
	public boolean isInt() {
		return getKind().equals("int");
	}
	
	public boolean isChar() {
		return getKind().equals("char");
	}
	
	public boolean isArray() {
		return getKind().equals("array");
	}
	
	public boolean isStruct() {
		return getKind().equals("struct");
	}
	
	public boolean isVoidType() {
		return getKind().equals("void");
	}
	
	@Override
	public boolean equals(Type type) {
		return this.getKind().equals(type.getKind());
	}
	
	public boolean equivalenciaEstructural(Type right) {
		TypeStruct l = (TypeStruct) this;
		TypeStruct r = (TypeStruct) right;
		
		for (DefinitionVariable dv : l.getDefinicion().getBody()) {
			if(r.searchField(dv.getName()) == null || !dv.getType().equals(r.searchField(dv.getName()).getType()))
					return false;
		}
		
		return true;
		
	}
}
