/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.sentence;

import ast.AbstractAST;
import ast.definition.DefinitionFuncion;

public abstract class AbstractSentence extends AbstractAST implements Sentence {
	private DefinitionFuncion funcionDondeEstaDefinida;

	public DefinitionFuncion funcionDondeEstaDefinida() {
		return funcionDondeEstaDefinida;
	}

	public void setFuncionDondeEstaDefinida(DefinitionFuncion funcionDondeEstaDefinida) {
		this.funcionDondeEstaDefinida = funcionDondeEstaDefinida;
	}
}
