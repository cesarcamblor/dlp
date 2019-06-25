package codegeneration;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import ast.Program;
import ast.definition.DefinitionFuncion;
import ast.definition.DefinitionStruct;
import ast.definition.DefinitionVariable;
import ast.definition.Definitions;
import ast.expression.Expression;
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
import ast.sentence.Sentence;
import ast.sentence.SentenceAssignment;
import ast.sentence.SentenceFunctionCall;
import ast.sentence.SentenceIf;
import ast.sentence.SentencePrint;
import ast.sentence.SentenceRead;
import ast.sentence.SentenceReturn;
import ast.sentence.SentenceWhile;
import ast.type.Type;
import ast.type.TypeArray;
import ast.type.TypeStruct;
import visitor.DefaultVisitor;

public class CodeSelection extends DefaultVisitor {

	private Map<String, String> instruccion = new HashMap<String, String>();
	private int numEtiqueta = 0;
	enum CodeFunction {
	    ADDRESS, VALUE
	}
	
    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
        
        instruccion.put("+", "add");
        instruccion.put("-", "sub");
        instruccion.put("*", "mul");
        instruccion.put("/", "div");
        instruccion.put("==", "eq");
        instruccion.put("!=", "ne");
        instruccion.put(">=", "ge");
        instruccion.put("<=", "le");
        instruccion.put("<", "lt");
        instruccion.put(">", "gt");
        instruccion.put("&&", "and");
        instruccion.put("||", "or");
        instruccion.put("!", "not");
      
    }

//	class Program { List<Definitions> definitions; }
	public Object visit(Program node, Object param) {
		out("#source \"" + sourceFile + "\"");
		for (Definitions def : node.getDefinitions()) {
			if(def.isVariable() || def.isStruct())
				def.accept(this, param);
		}
		out("call main");
        out("halt");
        
        for (Definitions def : node.getDefinitions()) {
			if(def.isFuncion())
				def.accept(this, param);
        }
		return null;
	}

	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		out("#GLOBAL " + node.getName() + ":" + node.getType().getMaplName());
		return null;
	}

	//	class DefinitionStruct { String name;  List<Definitions> body; }
	public Object visit(DefinitionStruct node, Object param) {
		out("#type " + node.getName() + ": {");
		for (DefinitionVariable def : node.getBody()) {
			out(def.getName() + ":" + def.getType().getMaplName());
		}
		out("}");
		return null;
	}

	//	class DefinitionFuncion { String name;  Type type;  List<Definitions> param;  List<Definitions> definitions;  List<Sentence> body; }
	public Object visit(DefinitionFuncion node, Object param) {
		out("#func " + node.getName());
		out(node.getName() + ":");
		for (DefinitionVariable dv : node.getParam()) 
			out("#param " + dv.getName() + ":" + dv.getType().getMaplName());
		if(node.getType().isVoidType())
			out("#ret void");
		else
			out("#ret " + node.getType().getMaplName());
		for ( DefinitionVariable dv  : node.getDefinitions()) {
			out("#local " + dv.getName()+":"+dv.getType().getMaplName());
		}
		if (node.getLocalVarsSize() > 0) {
			out("enter " + node.getLocalVarsSize());
		}
		visitChildren(node.getBody(), param);
		if (node.getType().isVoidType()) {
			out("ret 0, " + node.getLocalVarsSize() + "," + node.getParametersSize());
		}

		return null;
	}

	//	class SentencePrint { Expression expr;  String accion; }
	public Object visit(SentencePrint node, Object param) {
		
		if(node.getExpr()==null) {
			out("pushb 10");
        	out("outb");
		}
		else if(node.getExpr().getType().isArray()) {
			out("#LINE " + node.getStart().getLine());
			TypeArray ta = (TypeArray) node.getExpr().getType();
			for(int i=0;i<Integer.parseInt(ta.getDimension());i++){
				ExpressionArray eaL = new ExpressionArray(node.getExpr(), new ExpressionIntCte(i+""));
				eaL.accept(this, CodeFunction.VALUE);
				out("outb");
			}
		}
		else {
			out("#LINE " + node.getStart().getLine());
			node.getExpr().accept(this, CodeFunction.VALUE);
			out("out", node.getExpr().getType());
			if(node.getAccion().equals("\n")) {
				out("pushb 10");
				out("outb");
        	
			}
			else if(node.getAccion().equals(" ")) {
				out("pushb 32");
				out("outb");
			}
		}
		return null;
	}

	//	class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		out("#LINE " + node.getStart().getLine());
		node.getExpression().accept(this, CodeFunction.ADDRESS);
		out("in", node.getExpression().getType());
		out("store", node.getExpression().getType());
		return null;
	}

	//	class SentenceAssignment { Expression left;  Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
        out("#LINE " + node.getStart().getLine());
		if(node.getLeft().getType().isArray() && node.getRight().getType().isArray()) {
			TypeArray ta1 = (TypeArray) node.getLeft().getType();
			int dimensionLeft = Integer.parseInt(ta1.getDimension());
			for(int i=0; i<dimensionLeft;i++) {
				ExpressionArray eaL = new ExpressionArray(node.getLeft(), new ExpressionIntCte(i+""));
				eaL.accept(this, CodeFunction.ADDRESS);
				ExpressionArray eaR = new ExpressionArray(node.getRight(), new ExpressionIntCte(i+""));
				eaR.accept(this, CodeFunction.VALUE);
				out("storeb");
			}
		}
		else {
			node.getLeft().accept(this, CodeFunction.ADDRESS);
        	node.getRight().accept(this, CodeFunction.VALUE);
        	out("store", node.getLeft().getType());
        
		}
		return null;
	}
	

	//	class SentenceIf { Expression condition;  List<Sentence> trueCon;  List<Sentence> falseCon; }
	public Object visit(SentenceIf node, Object param) {
		out("#LINE " + node.getStart().getLine());
		String etElse = generarEtiqueta();
		String fin = generarEtiqueta();
		
		node.getCondition().accept(this, CodeFunction.VALUE);
		out("jz " + etElse);
		
		boolean retIf = false;
		for (Sentence child : node.getTrueCon()) {
			Object retorno = child.accept(this, param);
			retIf = "RET".equals(retorno);
		}
		
		if (!retIf)
			out("jmp " + fin);
		out(etElse + ":");
		
		boolean retElse = false;
		for (Sentence child : node.getFalseCon()) {
			Object retorno = child.accept(this, param);
			retElse = "RET".equals(retorno);
		}
		
		if (!retIf)
			out(fin + ":");

		if (retIf && retElse) 
			return "RET";
		return null;
	}

	//	class SentenceWhile { Expression condition;  List<Sentence> trueCon; }
	public Object visit(SentenceWhile node, Object param) {
		out("#LINE " + node.getStart().getLine());

		String inicioWhile = generarEtiqueta();
		String finWhile = generarEtiqueta();
		
		out(inicioWhile + ":");
		node.getCondition().accept(this, CodeFunction.VALUE);
		out("jz " + finWhile);

		boolean retWhile = false;
		for (Sentence child : node.getTrueCon()) {
			Object retorno = child.accept(this, param);
			retWhile = "RET".equals(retorno);
		}
		
		if(!retWhile) 
			out("jmp " + inicioWhile);
	
	
		out(finWhile + ":");
		if(retWhile)
			return "RET";
		return null;
	}
	


	//	class SentenceFunctionCall { String name;  List<Expression> param; }
	public Object visit(SentenceFunctionCall node, Object param) {
		out("#LINE " + node.getStart().getLine());
		if (node.getParam() != null)
			for (Expression child : node.getParam())
				child.accept(this, CodeFunction.VALUE);

		out("call " + node.getName());
		
		if(!node.getDefinicion().getType().isVoidType())
			out("pop", node.getDefinicion().getType());
		return null;
	}

	//	class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, CodeFunction.VALUE);

		int localS = node.funcionDondeEstaDefinida().getLocalVarsSize();
		int paramS = node.funcionDondeEstaDefinida().getParametersSize();
		int retS = 0;
		if(!node.funcionDondeEstaDefinida().getType().isVoidType())
			retS = node.funcionDondeEstaDefinida().getType().getSize();
		//ret retorno, local, param
		out("ret " + retS + "," + localS + ',' + paramS);
		return "RET";
	}

	//	class ExpressionIntCte { char value; }
	public Object visit(ExpressionIntCte node, Object param) {
		int charValue = Integer.parseInt(node.getValue());
        out("push " + charValue);
        return null;
	}

	//	class ExpressionRealCte { String value; }
	public Object visit(ExpressionRealCte node, Object param) {
        out("pushf " + node.getValue());
        return null;
	}

	//	class ExpressionCharCte { String value; }
	public Object visit(ExpressionCharCte node, Object param) {
		out("pushb " +  (int) node.getValue());
		return null;
	}

	//	class ExpressionVariable { String value; }
	public Object visit(ExpressionVariable node, Object param) {
		if(param == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
		} 
		else if(param == CodeFunction.ADDRESS && node.getDefinicion().isGlobal())
			out("pusha " + node.getDefinicion().getAddress());
		else if(param == CodeFunction.ADDRESS && node.getDefinicion().isLocal()) {
			out("pusha bp");
			out("push " + node.getDefinicion().getAddress());
			out("add");
		}
		else if(param == CodeFunction.ADDRESS && node.getDefinicion().isParameter()) {
			out("pusha bp");
			out("push " + node.getDefinicion().getAddress());
			out("add");
		}
		return null;
	}

	//	class ExpressionArithmetic { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionArithmetic node, Object param) {
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruccion.get(node.getOp()), node.getLeft().getType());
        return null;
	}

	//	class ExpressionComparision { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionComparision node, Object param) {
		node.getLeft().accept(this, CodeFunction.VALUE);
		node.getRight().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOp()), node.getLeft().getType());
		return null;
	}

	//	class ExpressionOperator { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionOperator node, Object param) {
		node.getLeft().accept(this, CodeFunction.VALUE);
		node.getRight().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOp()));
		return null;
	}

	//	class ExpressionNegative { Expression expression; }
	public Object visit(ExpressionNegative node, Object param) {
		node.getExpression().accept(this, CodeFunction.VALUE);
		out(instruccion.get("!"));
		return null;
	}
	


	//	class ExpressionMinus { Expression expression; }
	public Object visit(ExpressionMinus node, Object param) {
		node.getExpression().accept(this, CodeFunction.VALUE);
		out("push -1");
		out(instruccion.get("*"), node.getType());
		return null;
	}

	//	class ExpressionCast { Type castTo;  Expression castFrom; }
	public Object visit(ExpressionCast node, Object param) {
		node.getCastFrom().accept(this, param);
		String conversion = node.getCastFrom().getType().getSuffix() + "2" + node.getCastTo().getSuffix();
		if(conversion.equals("b2f")) {
			out("b2i");
			out("i2f");
		}
		else if(conversion.equals("f2b")) {
			out("f2i");
			out("i2b");
		}
		else 
			out(conversion);
		return null;
	}

	//	class ExpressionElements { Expression left;  String right; }
	public Object visit(ExpressionElements node, Object param) {
		if(param==CodeFunction.ADDRESS) {
			node.getLeft().accept(this, CodeFunction.ADDRESS);
			TypeStruct ts = (TypeStruct) node.getLeft().getType();
			out("push " + ts.searchField(node.getRight()).getAddress());
			out("add");		
		}
		else if(param == CodeFunction.VALUE) {
			node.getLeft().accept(this, CodeFunction.ADDRESS);
			TypeStruct ts = (TypeStruct) node.getLeft().getType();
			out("push " + ts.searchField(node.getRight()).getAddress());
			out("add");
			out("load",ts.searchField(node.getRight()).getType());
		}
		return null;
	}

	//	class ExpressionArray { Expression left;  Expression right; }
	public Object visit(ExpressionArray node, Object param) {
		
		TypeArray ta = (TypeArray)node.getLeft().getType();
		
		if(param == CodeFunction.ADDRESS) {
			node.getLeft().accept(this, CodeFunction.ADDRESS);
			node.getRight().accept(this, CodeFunction.VALUE);
			out("push " + ta.getType().getSize());
			out("mul");
			out("add");
		}
		else if(param == CodeFunction.VALUE) {
			node.getLeft().accept(this, CodeFunction.ADDRESS);
			node.getRight().accept(this, CodeFunction.VALUE);
			out("push " + ta.getType().getSize());
			out("mul");
			out("add");
			out("load", ta.getType());
		}
		return null;
	}

	//	class ExpressionFunctionCall { String name;  List<Expression> param; }
	public Object visit(ExpressionFunctionCall node, Object param) {
		if (node.getParam() != null)
			for (Expression child : node.getParam())
				child.accept(this, CodeFunction.VALUE);

		out("call " + node.getName());

		return null;
	}

    // Método auxiliar
    private void out(String instruccion, Type tipo) {
        out(instruccion + tipo.getSuffix());
    }
    
    // Método auxiliar recomendado (opcional) -------------
    private void out(String instruction) {
        writer.println(instruction);
    }
    
    private String generarEtiqueta() {
    	String str = "etiqueta" + numEtiqueta;
		numEtiqueta++;
		return str;
    }

    private PrintWriter writer;
    private String sourceFile;
}
