/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import java.io.*;

import ast.*;
import java.util.*;

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *      ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    /**
     * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
     * (línea y columna) de cada nodo.
     *
     * @param sourceFile El fichero del cual se ha obtenido el AST
     * @param raiz       El AST creado a partir de sourceFile
     * @param filename   Nombre del fichero HMTL a crear con la traza del AST
     */

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        toHtml(sourceFile, raiz, filename, 4);
    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    // tabWidth deberían ser los espacios correspondientes a un tabulador en eclipse.
    // Normalmente no sería necesario especificarlo. Usar mejor los dos métodos anteriores.

    public static void toHtml(String sourceFile, AST raiz, String filename, int tabWidth) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"));
            generateHeader(writer);
            writer.println("[ASTPrinter] -------------------------------- line:col  line:col");
            if (raiz != null) {
                ASTPrinter tracer = new ASTPrinter(writer, loadLines(sourceFile, tabWidth));
                raiz.accept(tracer, new Integer(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[ASTPrinter] --------------------------------");
            generateFooter(writer);
            writer.close();
            System.out.println(ls + "ASTPrinter: Fichero '" + filename
                    + ".html' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "ASTPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static void generateHeader(PrintWriter writer) {
        writer.println("<html>\r\n"
            + "<head>\r\n"
            + "<meta charset=\"utf-8\" />\r\n"
            + "<style type=\"text/css\">\r\n"
            + ".value { font-weight: bold; }\r\n"
            + ".dots { color: #bebdbd; }\r\n"
            + ".type { color: #BBBBBB; }\r\n"
            + ".pos { color: #CCCCCC; }\r\n"
            + ".sourceText { color: #BBBBBB; }\r\n"
            + ".posText {\r\n" + "	color: #BBBBBB;\r\n"
            + "	text-decoration: underline; font-weight: bold;\r\n"
            + "}\r\n"
            + ".null {\r\n"
            + "	color: #FF0000;\r\n"
            + "	font-weight: bold;\r\n"
            + "	font-style: italic;\r\n" + "}\r\n"
            + "</style>\r\n" + "</head>\r\n" + "\r\n"
            + "<body><pre>");
    }

    private static void generateFooter(PrintWriter writer) {
        writer.println("</pre>\r\n" + "</body>\r\n" + "</html>");
    }

    private ASTPrinter(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
    }

    // ----------------------------------------------
	//	class Program { List<Definitions> definitions; }
	public Object visit(Program node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", node, false);

		visit(indent + 1, "definitions", "List<Definitions>",node.getDefinitions());
		return null;
	}

	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DefinitionVariable", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class DefinitionStruct { String name;  List<Sentence> body; }
	public Object visit(DefinitionStruct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DefinitionStruct", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "body", "List<Sentence>",node.getBody());
		return null;
	}

	//	class DefinitionFuncion { String name;  Type type;  List<Definitions> param;  List<Definitions> definitions;  List<Sentence> body; }
	public Object visit(DefinitionFuncion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DefinitionFuncion", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		visit(indent + 1, "param", "List<Definitions>",node.getParam());
		visit(indent + 1, "definitions", "List<Definitions>",node.getDefinitions());
		visit(indent + 1, "body", "List<Sentence>",node.getBody());
		return null;
	}

	//	class SentencePrint { Expression expr;  String accion; }
	public Object visit(SentencePrint node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentencePrint", node, false);

		visit(indent + 1, "expr", "Expression",node.getExpr());
		print(indent + 1, "accion", "String", node.getAccion());
		return null;
	}

	//	class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentenceRead", node, false);

		visit(indent + 1, "expression", "Expression",node.getExpression());
		return null;
	}

	//	class SentenceAssignment { Expression left;  Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentenceAssignment", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class SentenceIf { Expression condition;  List<Sentence> trueCon;  List<Sentence> falseCon; }
	public Object visit(SentenceIf node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentenceIf", node, false);

		visit(indent + 1, "condition", "Expression",node.getCondition());
		visit(indent + 1, "trueCon", "List<Sentence>",node.getTrueCon());
		visit(indent + 1, "falseCon", "List<Sentence>",node.getFalseCon());
		return null;
	}

	//	class SentenceWhile { Expression condition;  List<Sentence> trueCon; }
	public Object visit(SentenceWhile node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentenceWhile", node, false);

		visit(indent + 1, "condition", "Expression",node.getCondition());
		visit(indent + 1, "trueCon", "List<Sentence>",node.getTrueCon());
		return null;
	}

	//	class SentenceFunctionCall { String name;  List<Expression> param; }
	public Object visit(SentenceFunctionCall node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentenceFunctionCall", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "param", "List<Expression>",node.getParam());
		return null;
	}

	//	class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "SentenceReturn", node, false);

		visit(indent + 1, "expression", "Expression",node.getExpression());
		return null;
	}

	//	class ExpressionIntCte { String value; }
	public Object visit(ExpressionIntCte node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "ExpressionIntCte", node, "value", node.getValue());
		return null;
	}

	//	class ExpressionRealCte { String value; }
	public Object visit(ExpressionRealCte node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "ExpressionRealCte", node, "value", node.getValue());
		return null;
	}

	//	class ExpressionCharCte { String value; }
	public Object visit(ExpressionCharCte node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "ExpressionCharCte", node, "value", node.getValue());
		return null;
	}

	//	class ExpressionVariable { String value; }
	public Object visit(ExpressionVariable node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "ExpressionVariable", node, "value", node.getValue());
		return null;
	}

	//	class ExpressionArithmetic { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionArithmetic", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "op", "String", node.getOp());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpressionComparision { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionComparision node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionComparision", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "op", "String", node.getOp());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpressionOperator { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionOperator node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionOperator", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "op", "String", node.getOp());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpressionNegative { Expression expression; }
	public Object visit(ExpressionNegative node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionNegative", node, false);

		visit(indent + 1, "expression", "Expression",node.getExpression());
		return null;
	}

	//	class ExpressionMinus { Expression expression; }
	public Object visit(ExpressionMinus node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionMinus", node, false);

		visit(indent + 1, "expression", "Expression",node.getExpression());
		return null;
	}

	//	class ExpressionCast { Type castTo;  Expression castFrom; }
	public Object visit(ExpressionCast node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionCast", node, false);

		visit(indent + 1, "castTo", "Type",node.getCastTo());
		visit(indent + 1, "castFrom", "Expression",node.getCastFrom());
		return null;
	}

	//	class ExpressionElements { Expression left;  String right; }
	public Object visit(ExpressionElements node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionElements", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "right", "String", node.getRight());
		return null;
	}

	//	class ExpressionArray { Expression left;  Expression right; }
	public Object visit(ExpressionArray node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionArray", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpressionFunctionCall { String name;  List<Expression> param; }
	public Object visit(ExpressionFunctionCall node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpressionFunctionCall", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "param", "List<Expression>",node.getParam());
		return null;
	}

	//	class TypeArray { List<String> dimension;  Type type; }
	public Object visit(TypeArray node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TypeArray", node, false);

		print(indent + 1, "dimension", "List<String>", node.getDimension());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "TypeStruct", node, "name", node.getName());
		return null;
	}

	//	class TypeInt {  }
	public Object visit(TypeInt node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TypeInt", node, true);

		return null;
	}

	//	class TypeChar {  }
	public Object visit(TypeChar node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TypeChar", node, true);

		return null;
	}

	//	class TypeReal {  }
	public Object visit(TypeReal node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TypeReal", node, true);

		return null;
	}


	// -----------------------------------------------------------------
	// Métodos invocados desde los métodos visit -----------------------

	private void printName(int indent, String name, AST node, boolean empty) {
		String text = ls + tabula(indent) + name + " &rarr;  ";
		text = String.format("%1$-" + 93 + "s", text);
		if (empty)
			text = text.replace(name, valueTag(name));
		writer.print(text + getPosition(node));
	}

	private void print(int indent, String name, String type, Object value) {
		write(indent, formatValue(value) + "  " + typeTag(type));
	}

	private void print(int indent, String attName, String type, List<? extends Object> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (Object child : children)
				write(indent + 1, formatValue(child));
		else
			writer.print(" " + valueTag(null));
	}

	// Versión compacta de una linea para nodos que solo tienen un atributo String
	private void printCompact(int indent, String nodeName, AST node, String attName, Object value) {
		String fullName = nodeName + '.' + attName;
		String text = ls + tabula(indent) + '\"' + value + "\"  " + fullName;
		text = String.format("%1$-" + 88 + "s", text);
		// text = text.replace(value.toString(), valueTag(value));
		text = text.replace(fullName, typeTag(fullName));
		writer.print(text + getPosition(node));
	}

	private void visit(int indent, String attName, String type, List<? extends AST> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (AST child : children)
				child.accept(this, indent + 1);
		else
			writer.print(" " + valueTag(null));
	}

	private void visit(int indent, String attName, String type, AST child) {
		if (child != null)
			child.accept(this, new Integer(indent));
		else
			write(indent, valueTag(null) + "  " + attName + ':' + typeTag(type));
	}

	// -----------------------------------------------------------------
	// Métodos auxiliares privados -------------------------------------

	private void write(int indent, String text) {
		writer.print(ls + tabula(indent) + text);
	}

	private static String tabula(int count) {
		StringBuffer cadena = new StringBuffer("<span class=\"dots\">");
		for (int i = 0; i < count; i++)
			cadena.append(i % 2 == 0 && i > 0 ? "|  " : ".  ");
		return cadena.toString() + "</span>";
	}

	private String typeTag(String type) {
		if (type.equals("String"))
			return "";
		return "<span class=\"type\">" + type.replace("<", "&lt;").replace(">", "&gt;") + "</span>";
	}

	private String valueTag(Object value) {
		if (value == null)
			return "<span class=\"null\">null</span>";
		return "<span class=\"value\">" + value + "</span>";
	}

	private String formatValue(Object value) {
		String text = valueTag(value);
		if (value instanceof String)
			text = "\"" + text + '"';
		return text;
	}


	// -----------------------------------------------------------------
	// Métodos para mostrar las Posiciones -----------------------------

	private String getPosition(AST node) {
		String text = node.getStart() + "  " + node.getEnd();
		text = "<span class=\"pos\">" + String.format("%1$-" + 13 + "s", text) + "</span>";
		text = text.replace("null", "<span class=\"null\">null</span>");
		String sourceText = findSourceText(node);
		if (sourceText != null)
			text += sourceText;
		return text;
	}

	private String findSourceText(AST node) {
		if (sourceLines == null)
			return null;

		Position start = node.getStart();
		Position end = node.getEnd();
		if (start == null || end == null)
			return null;

		String afterText, text, beforeText;
		if (start.getLine() == end.getLine()) {
			String line = sourceLines.get(start.getLine() - 1);
			afterText = line.substring(0, start.getColumn() - 1);
			text = line.substring(start.getColumn() - 1, end.getColumn());
			beforeText = line.substring(end.getColumn());
		} else {
			String firstLine = sourceLines.get(start.getLine() - 1);
			String lastLine = sourceLines.get(end.getLine() - 1);

			afterText = firstLine.substring(0, start.getColumn() - 1);

			text = firstLine.substring(start.getColumn() - 1);
			text += "</span><span class=\"sourceText\">" + " ... " + "</span><span class=\"posText\">";
			text += lastLine.substring(0, end.getColumn()).replaceAll("^\\s+", "");

			beforeText = lastLine.substring(end.getColumn());
		}
		return "<span class=\"sourceText\">" + afterText.replaceAll("^\\s+", "")
				+ "</span><span class=\"posText\">" + text
				+ "</span><span class=\"sourceText\">" + beforeText + "</span>";
	}

	private static List<String> loadLines(String sourceFile, int tabWidth) {
		if (sourceFile == null)
			return null;
		try {
			String spaces = new String(new char[tabWidth]).replace("\0", " ");

			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			while ((line = br.readLine()) != null) {
			//	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
				lines.add(line);
            }
			br.close();
			return lines;
		} catch (FileNotFoundException e) {
			System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		} catch (IOException e) {
			System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		}
	}


	private List<String> sourceLines;
	private static String ls = System.getProperty("line.separator");
	private PrintWriter writer;
}
