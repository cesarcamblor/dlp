/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast.sentence;

import ast.AST;
import ast.definition.DefinitionFuncion;

public interface Sentence extends AST {
	
	DefinitionFuncion funcionDondeEstaDefinida();
	void setFuncionDondeEstaDefinida(DefinitionFuncion funcionDondeEstaDefinid);
}
