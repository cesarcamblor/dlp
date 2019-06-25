package visitor;

import ast.*;
import ast.definition.*;
import ast.expression.*;
import ast.sentence.*;
import ast.type.*;


public class PrintVisitor extends DefaultVisitor {

	// class Program { List<Definitions> definitions; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);
		if (node.getDefinitions() != null)
			for (Definitions child : node.getDefinitions())
				child.accept(this, "normal");
		System.out.println();
		return null;
	}

	// class DefinitionVariable { String name; Type type; }
	public Object visit(DefinitionVariable node, Object param) {

		// super.visit(node, param);

		if (node.getType() != null) {
			if (("normal").equals(param))
				System.out.print("var " + node.getName() + ":");
			else
				System.out.print(node.getName() + ":");
			node.getType().accept(this, param);
			if (("normal").equals(param) || ("struct").equals(param))
				System.out.println(";");
			
		}

		return null;
	}

	// class DefinitionStruct { String name; List<Sentence> body; }
	public Object visit(DefinitionStruct node, Object param) {

		// super.visit(node, param);

		if (node.getBody() != null) {
			System.out.println("struct " + node.getName() + "{");
			for (Definitions child : node.getBody()) {
				child.accept(this, "struct");
			}
			System.out.println("};");
		}

		return null;
	}

	// class DefinitionFuncion { String name; Type type; List<Definitions>
	// param; List<Definitions> definitions; List<Sentence> body; }
	public Object visit(DefinitionFuncion node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getName() + "(");
		if (node.getParam() != null)
			
			if (node.getParam().size() > 0) {
				node.getParam().get(0).accept(this, "param");
				for(int i=1; i<node.getParam().size();i++) {
					System.out.print(",");
					node.getParam().get(i).accept(this, "param");
				}
			}
		System.out.print(")");

		if (node.getType() != null) {
			System.out.print(":");
			node.getType().accept(this, param);
		}
		System.out.println("{");
		if (node.getDefinitions() != null)
			for (Definitions child : node.getDefinitions())
				child.accept(this, param);

		if (node.getBody() != null)
			for (Sentence child : node.getBody())
				child.accept(this, param);
		System.out.println("}");
		return null;
	}

	// class SentencePrint { Expression expr; String accion; }
	public Object visit(SentencePrint node, Object param) {

		// super.visit(node, param);
		if(node.getAccion().equals(""))
			System.out.print("print ");
		else if(node.getAccion().equals("\n"))
			System.out.print("println ");
		else
			System.out.print("printsp ");
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {

		// super.visit(node, param);
		System.out.print("read ");
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class SentenceAssignment { Expression left; Expression right; }
	public Object visit(SentenceAssignment node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print("=");
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		System.out.println(";");

		return null;
	}

	// class SentenceIf { Expression condition; List<Sentence> trueCon;
	// List<Sentence> falseCon; }
	public Object visit(SentenceIf node, Object param) {

		// super.visit(node, param);
		System.out.print("if(");
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		System.out.print(")");
		
		System.out.println("{");
		if (node.getTrueCon() != null)
			for (Sentence child : node.getTrueCon())
				child.accept(this, param);
		System.out.println("}");
		
		if (node.getFalseCon() != null) {
			System.out.println("else {");
			for (Sentence child : node.getFalseCon())
				child.accept(this, param);
			System.out.println("}");
		}
		
		return null;
	}

	// class SentenceWhile { Expression condition; List<Sentence> trueCon; }
	public Object visit(SentenceWhile node, Object param) {

		// super.visit(node, param);
		System.out.print("while(");
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		System.out.print(")");
		
		System.out.println("{");
		if (node.getTrueCon() != null)
			for (Sentence child : node.getTrueCon())
				child.accept(this, param);
		System.out.println("}");
		return null;
	}

	// class SentenceFunctionCall { String name; List<Expression> param; }
	public Object visit(SentenceFunctionCall node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getName() + "(");
		if (node.getParam() != null)
			for (Expression child : node.getParam())
				child.accept(this, param);
		System.out.println(");");
		return null;
	}

	// class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {

		// super.visit(node, param);
		System.out.print("return ");
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class ExpressionIntCte { String value; }
	public Object visit(ExpressionIntCte node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	// class ExpressionRealCte { String value; }
	public Object visit(ExpressionRealCte node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	// class ExpressionCharCte { String value; }
	public Object visit(ExpressionCharCte node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	// class ExpressionVariable { String value; }
	public Object visit(ExpressionVariable node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	// class ExpressionArithmetic { Expression left; String op; Expression
	// right; }
	public Object visit(ExpressionArithmetic node, Object param) {

		// super.visit(node, param);
		System.out.print("(");
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		
		System.out.print(node.getOp());
		
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		System.out.print(")");
		return null;
	}

	// class ExpressionComparision { Expression left; String op; Expression
	// right; }
	public Object visit(ExpressionComparision node, Object param) {

		// super.visit(node, param);
		System.out.print("(");
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		
		System.out.print(node.getOp());
		
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		System.out.print(")");
		return null;
	}

	// class ExpressionOperator { Expression left; String op; Expression right;
	// }
	public Object visit(ExpressionOperator node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		
		System.out.print(node.getOp());
		
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	// class ExpressionNegative { Expression expression; }
	public Object visit(ExpressionNegative node, Object param) {

		// super.visit(node, param);
		System.out.print("!(");
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		System.out.print(")");
		return null;
	}

	// class ExpressionMinus { Expression expression; }
	public Object visit(ExpressionMinus node, Object param) {

		// super.visit(node, param);
		System.out.print("-(");
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		System.out.print(")");
		return null;
	}

	// class ExpressionCast { Type castTo; Expression castFrom; }
	public Object visit(ExpressionCast node, Object param) {

		// super.visit(node, param);
		System.out.print("cast<");
		if (node.getCastTo() != null)
			node.getCastTo().accept(this, param);
		System.out.print(">(");
		if (node.getCastFrom() != null)
			node.getCastFrom().accept(this, param);
		System.out.print(")");

		return null;
	}

	// class ExpressionElements { Expression left; String right; }
	public Object visit(ExpressionElements node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print("." + node.getRight());
		return null;
	}

	// class ExpressionArray { Expression left; Expression right; }
	public Object visit(ExpressionArray node, Object param) {

		// super.visit(node, param);
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		
		System.out.print('[');
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		System.out.print(']');
		return null;
	}

	// class ExpressionFunctionCall { String name; List<Expression> param; }
	public Object visit(ExpressionFunctionCall node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getName() + "(");
		if (node.getParam() != null) {
			int cont = 0;
			for (Expression child : node.getParam()) {
				cont++;
				if (cont > 1)
					System.out.print(",");
				child.accept(this, param);

			}
		}
		System.out.print(")");
		return null;
	}

	// class TypeArray { String dimension; Type type; }
	public Object visit(TypeArray node, Object param) {

		// super.visit(node, param);
		System.out.print("[" + node.getDimension() + "]");
		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	// class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		System.out.print(node.getName());
		return null;
	}

	// class TypeInt { }
	public Object visit(TypeInt node, Object param) {
		System.out.print("int");
		return null;
	}

	// class TypeChar { }
	public Object visit(TypeChar node, Object param) {
		System.out.print("char");
		return null;
	}

	// class TypeReal { }
	public Object visit(TypeReal node, Object param) {
		System.out.print("float");
		return null;
	}
}
