/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.Program;
import ast.definition.DefinitionFuncion;
import ast.definition.DefinitionStruct;
import ast.definition.DefinitionVariable;
import ast.expression.ExpressionArithmetic;
import ast.expression.ExpressionArray;
import ast.expression.ExpressionCast;
import ast.expression.ExpressionCharCte;
import ast.expression.ExpressionComparision;
import ast.expression.ExpressionElements;
import ast.expression.ExpressionFunctionCall;
import ast.expression.ExpressionIntCte;
import ast.expression.ExpressionMinus;
import ast.expression.ExpressionNegative;
import ast.expression.ExpressionOperator;
import ast.expression.ExpressionRealCte;
import ast.expression.ExpressionVariable;
import ast.sentence.SentenceAssignment;
import ast.sentence.SentenceFunctionCall;
import ast.sentence.SentenceIf;
import ast.sentence.SentencePrint;
import ast.sentence.SentenceRead;
import ast.sentence.SentenceReturn;
import ast.sentence.SentenceWhile;
import ast.type.TypeArray;
import ast.type.TypeChar;
import ast.type.TypeInt;
import ast.type.TypeReal;
import ast.type.TypeStruct;
import ast.type.TypeVoid;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(DefinitionVariable node, Object param);
	public Object visit(DefinitionStruct node, Object param);
	public Object visit(DefinitionFuncion node, Object param);
	public Object visit(SentencePrint node, Object param);
	public Object visit(SentenceRead node, Object param);
	public Object visit(SentenceAssignment node, Object param);
	public Object visit(SentenceIf node, Object param);
	public Object visit(SentenceWhile node, Object param);
	public Object visit(SentenceFunctionCall node, Object param);
	public Object visit(SentenceReturn node, Object param);
	public Object visit(ExpressionIntCte node, Object param);
	public Object visit(ExpressionRealCte node, Object param);
	public Object visit(ExpressionCharCte node, Object param);
	public Object visit(ExpressionVariable node, Object param);
	public Object visit(ExpressionArithmetic node, Object param);
	public Object visit(ExpressionComparision node, Object param);
	public Object visit(ExpressionOperator node, Object param);
	public Object visit(ExpressionNegative node, Object param);
	public Object visit(ExpressionMinus node, Object param);
	public Object visit(ExpressionCast node, Object param);
	public Object visit(ExpressionElements node, Object param);
	public Object visit(ExpressionArray node, Object param);
	public Object visit(ExpressionFunctionCall node, Object param);

	
	public Object visit(TypeArray node, Object param);
	public Object visit(TypeStruct node, Object param);
	public Object visit(TypeInt node, Object param);
	public Object visit(TypeChar node, Object param);
	public Object visit(TypeReal node, Object param);
	public Object visit(TypeVoid node, Object param);

	
	

}
