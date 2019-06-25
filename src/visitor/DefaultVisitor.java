/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import java.util.List;

import ast.AST;
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

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Definitions> definitions; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDefinitions(), param);
		return null;
	}

	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class DefinitionStruct { String name;  List<Sentence> body; }
	public Object visit(DefinitionStruct node, Object param) {
		visitChildren(node.getBody(), param);
		return null;
	}

	//	class DefinitionFuncion { String name;  Type type;  List<Definitions> param;  List<Definitions> definitions;  List<Sentence> body; }
	public Object visit(DefinitionFuncion node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		visitChildren(node.getParam(), param);
		visitChildren(node.getDefinitions(), param);
		visitChildren(node.getBody(), param);
		return null;
	}

	//	class SentencePrint { Expression expr;  String accion; }
	public Object visit(SentencePrint node, Object param) {
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class SentenceAssignment { Expression left;  Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class SentenceIf { Expression condition;  List<Sentence> trueCon;  List<Sentence> falseCon; }
	public Object visit(SentenceIf node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getTrueCon(), param);
		visitChildren(node.getFalseCon(), param);
		return null;
	}

	//	class SentenceWhile { Expression condition;  List<Sentence> trueCon; }
	public Object visit(SentenceWhile node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getTrueCon(), param);
		return null;
	}

	//	class SentenceFunctionCall { String name;  List<Expression> param; }
	public Object visit(SentenceFunctionCall node, Object param) {
		visitChildren(node.getParam(), param);
		return null;
	}

	//	class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}


	//	class ExpressionIntCte { String value; }
	public Object visit(ExpressionIntCte node, Object param) {
		return null;
	}

	//	class ExpressionRealCte { String value; }
	public Object visit(ExpressionRealCte node, Object param) {
		return null;
	}

	//	class ExpressionCharCte { String value; }
	public Object visit(ExpressionCharCte node, Object param) {
		return null;
	}

	//	class ExpressionVariable { String value; }
	public Object visit(ExpressionVariable node, Object param) {
		return null;
	}

	//	class ExpressionArithmetic { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpressionComparision { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionComparision node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpressionOperator { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionOperator node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpressionNegative { Expression expression; }
	public Object visit(ExpressionNegative node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ExpressionMinus { Expression expression; }
	public Object visit(ExpressionMinus node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ExpressionCast { Type castTo;  Expression castFrom; }
	public Object visit(ExpressionCast node, Object param) {
		if (node.getCastTo() != null)
			node.getCastTo().accept(this, param);
		if (node.getCastFrom() != null)
			node.getCastFrom().accept(this, param);
		return null;
	}

	//	class ExpressionElements { Expression left;  String right; }
	public Object visit(ExpressionElements node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		return null;
	}

	//	class ExpressionArray { Expression left;  Expression right; }
	public Object visit(ExpressionArray node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpressionFunctionCall { String name;  List<Expression> param; }
	public Object visit(ExpressionFunctionCall node, Object param) {
		visitChildren(node.getParam(), param);
		return null;
	}

	//	class TypeArray { List<String> dimension;  Type type; }
	public Object visit(TypeArray node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		return null;
	}

	//	class TypeInt {  }
	public Object visit(TypeInt node, Object param) {
		return null;
	}

	//	class TypeChar {  }
	public Object visit(TypeChar node, Object param) {
		return null;
	}

	//	class TypeReal {  }
	public Object visit(TypeReal node, Object param) {
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }

	@Override
	public Object visit(TypeVoid node, Object param) {
		
		return null;
	}






}
