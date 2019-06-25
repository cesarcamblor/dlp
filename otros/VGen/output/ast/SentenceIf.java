/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	SentenceIf:sentence -> condition:expression  trueCon:sentence*  falseCon:sentence*

public class SentenceIf extends AbstractSentence {

	public SentenceIf(Expression condition, List<Sentence> trueCon, List<Sentence> falseCon) {
		this.condition = condition;
		this.trueCon = trueCon;
		this.falseCon = falseCon;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, trueCon, falseCon);
	}

	@SuppressWarnings("unchecked")
	public SentenceIf(Object condition, Object trueCon, Object falseCon) {
		this.condition = (Expression) ((condition instanceof ParserRuleContext) ? getAST(condition) : condition);
		this.trueCon = (List<Sentence>) trueCon;
		this.falseCon = (List<Sentence>) falseCon;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, trueCon, falseCon);
	}

	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public List<Sentence> getTrueCon() {
		return trueCon;
	}
	public void setTrueCon(List<Sentence> trueCon) {
		this.trueCon = trueCon;
	}

	public List<Sentence> getFalseCon() {
		return falseCon;
	}
	public void setFalseCon(List<Sentence> falseCon) {
		this.falseCon = falseCon;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Sentence> trueCon;
	private List<Sentence> falseCon;

	public String toString() {
       return "{condition:" + getCondition() + ", trueCon:" + getTrueCon() + ", falseCon:" + getFalseCon() + "}";
   }
}
