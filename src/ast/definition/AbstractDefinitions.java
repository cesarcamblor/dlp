/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.definition;

import ast.AbstractAST;

public abstract class AbstractDefinitions extends AbstractAST implements Definitions {

	private String where;
	
	public String getWhere() {
		if(where==null)
			return "notdefined";
		return where;
	}
	
	public void setWhere(String where) {
		this.where = where;
	}
	
	public boolean isGlobal() {
		return getWhere().equals("global");
	}
	
	public boolean isParameter() {
		return getWhere().equals("parameter");
	}
	
	public boolean isLocal() {
		return getWhere().equals("local");
	}
	
	public boolean isFuncion() {
		return false;
	}
	
	public boolean isStruct() {
		return false;
	}

	public boolean isVariable() {
		return false;
	}
}
