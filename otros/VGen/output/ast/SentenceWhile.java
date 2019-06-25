/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	SentenceWhile:sentence -> condition:expression  trueCon:sentence*

public class SentenceWhile extends AbstractSentence {

	public SentenceWhile(Expression condition, List<Sentence> trueCon) {
		this.condition = condition;
		this.trueCon = trueCon;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, trueCon);
	}

	@SuppressWarnings("unchecked")
	public SentenceWhile(Object condition, Object trueCon) {
		this.condition = (Expression) ((condition instanceof ParserRuleContext) ? getAST(condition) : condition);
		this.trueCon = (List<Sentence>) trueCon;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, trueCon);
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

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Sentence> trueCon;

	public String toString() {
       return "{condition:" + getCondition() + ", trueCon:" + getTrueCon() + "}";
   }
}
