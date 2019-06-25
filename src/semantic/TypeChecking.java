package semantic;

import ast.AST;
import ast.Position;
import ast.definition.DefinitionFuncion;
import ast.definition.DefinitionVariable;
import ast.definition.Definitions;
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
import ast.type.TypeArray;
import ast.type.TypeChar;
import ast.type.TypeInt;
import ast.type.TypeReal;
import ast.type.TypeStruct;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

	//	class DefinitionFuncion { String name;  Type type;  List<Definitions> param;  List<Definitions> definitions;  List<Sentence> body; }
	public Object visit(DefinitionFuncion node, Object param) {
	//	super.visit(node,param);
		
		boolean condicion;
		if (node.getType() != null) {
			condicion = node.getType().isVoidType() || node.getType().isSimple();
			predicado(condicion, "Retorno de tipo no simple", node);
			node.getType().accept(this, param);
		}
		if (node.getParam() != null)
			for (DefinitionVariable child : node.getParam()) {
				condicion = child.getType().isSimple();
				predicado(condicion, "Los parametros deben ser de tipos primitivos", node);
				child.accept(this, param);
			}

		if (node.getDefinitions() != null)
			for (Definitions child : node.getDefinitions())
				child.accept(this, param);

		if (node.getBody() != null)
			for (Sentence child : node.getBody()) {
				child.setFuncionDondeEstaDefinida(node);
				child.accept(this, param);
			}

		return null;

	}

	//	class SentencePrint { Expression expr;  String accion; }
	public Object visit(SentencePrint node, Object param) {
		super.visit(node, param);
		
		TypeArray ta = null;
		if(node.getExpr() != null && node.getExpr().getType()!=null && node.getExpr().getType().isArray()) 
			ta = (TypeArray) node.getExpr().getType();
		boolean c = node.getExpr() == null || node.getExpr().getType() == null 
				|| node.getExpr().getType().isArray() && ta.getType().isChar();
		boolean condicion =  node.getExpr() == null || node.getExpr().getType() == null 
				|| node.getExpr().getType().isSimple() || c;
		predicado(condicion, "Ha de ser de tipo simple o un array de caracteres", node);

		return null;
	}

	//	class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		super.visit(node, param);

		boolean condicion = node.getExpression().getType() == null || node.getExpression().getType().isSimple();
		predicado(condicion, "Ha de ser de tipo simple", node);
		
		condicion = node.getExpression().isModificable();
		predicado(condicion, "Ha de ser modificable", node);

		return null;
	}

	//	class SentenceAssignment { Expression left;  Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
		super.visit(node, param);

		boolean condicion = node.getLeft().isModificable();
		predicado(condicion, "Left ha de ser modificable", node);

		if(node.getLeft().getType()!=null && node.getRight().getType()!=null 
				&& node.getLeft().getType().isArray() && node.getRight().getType().isArray()) {
			TypeArray ta1 = (TypeArray) node.getLeft().getType();
			TypeArray ta2 = (TypeArray) node.getRight().getType();
			condicion = ta1.getType().isChar() && ta2.getType().isChar();
			predicado(condicion, "En la asignacion de array, los arrays han de ser de tipo char");
			
			int dimensionLeft = Integer.parseInt(ta1.getDimension());
			int dimensionRight = Integer.parseInt(ta2.getDimension());
			condicion = dimensionLeft <= dimensionRight;
			predicado(condicion, "En la asignacion de array, la expresion de la izquierda ha "
					+ "de tener una dimension <= que la expresion de la derecha");
			
		}
		else if(node.getLeft().getType()!=null && node.getRight().getType()!=null) {
			condicion = node.getLeft().getType().isSimple();
			predicado(condicion, "Left ha de ser de tipo simple", node);
			
			condicion = node.getLeft().getType().equals(node.getRight().getType());
			predicado(condicion, "Left y Right han de ser del mismo tipo", node);
		}
		
		return null;
	}

	//	class SentenceIf { Expression condition;  List<Sentence> trueCon;  List<Sentence> falseCon; }
	public Object visit(SentenceIf node, Object param) {
	//	super.visit(node, param);
		boolean condicion;

		node.getCondition().accept(this, param);
		condicion = node.getCondition().getType() == null || node.getCondition().getType().isInt();
		predicado(condicion, "La condicion ha de ser de tipo entero", node);
		


		for (Sentence child : node.getTrueCon()) {
			child.setFuncionDondeEstaDefinida(node.funcionDondeEstaDefinida());
			child.accept(this, param);
		}

		for (Sentence child : node.getFalseCon()) {
			child.setFuncionDondeEstaDefinida(node.funcionDondeEstaDefinida());
			child.accept(this, param);
		}

		return null;
	}

	//	class SentenceWhile { Expression condition;  List<Sentence> trueCon; }
	public Object visit(SentenceWhile node, Object param) {
		//super.visit(node, param);
		boolean condicion;
		node.getCondition().accept(this, param);
		condicion = node.getCondition().getType() == null || node.getCondition().getType().isInt();
		predicado(condicion, "La condicion ha de ser de tipo entero", node);
		

		for (Sentence child : node.getTrueCon()) {
			child.setFuncionDondeEstaDefinida(node.funcionDondeEstaDefinida());
			child.accept(this, param);
		}
		
		
		return null;
	}
	
	//	class SentenceFunctionCall { String name;  List<Expression> param; }
	public Object visit(SentenceFunctionCall node, Object param) {
		super.visit(node, param);

		boolean condicion = node.getParam().size() == node.getDefinicion().getParam().size();
		predicado(condicion, "Numero de parametros incorrecto", node);
		
		if(condicion) {
			for(int i=0; i<node.getParam().size(); i++) {
				condicion = node.getParam().get(i).getType().equals(node.getDefinicion().getParam().get(i).getType());
				predicado(condicion, "Los parametros no coinciden", node);
			}
		}

		return null;
	}

	//	class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		super.visit(node, param);
		
		DefinitionFuncion df = node.funcionDondeEstaDefinida();
		boolean condicion;
		
		if(df.getType().isVoidType()) {
			condicion = node.getExpression() == null;
			predicado(condicion, "Funcion de tipo void no puede devolver expresion", node);
		}
		else if (!df.getType().isVoidType() && node.getExpression() == null)
			predicado(node.getExpression() != null, "La funcion ha de tener un valor de retorno", node);
		else if (!df.getType().isVoidType() && node.getExpression().getType() != null){
			condicion = df.getType().equals(node.getExpression().getType());
			predicado(condicion, "Los tipos de retorno han de ser iguales", node);
		}
		
		return null;
	}

	//	class ExpressionIntCte { String value; }
	public Object visit(ExpressionIntCte node, Object param) {
		node.setType(new TypeInt());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionRealCte { String value; }
	public Object visit(ExpressionRealCte node, Object param) {
		node.setType(new TypeReal());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionCharCte { String value; }
	public Object visit(ExpressionCharCte node, Object param) {
		node.setType(new TypeChar());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionVariable { String value; }
	public Object visit(ExpressionVariable node, Object param) {
		node.setType(node.getDefinicion().getType());
		node.setModificable(true);
		return null;
	}

	//	class ExpressionArithmetic { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		super.visit(node, param);
		
		boolean condicion = node.getLeft().getType() == null || node.getRight().getType() == null 
				|| node.getLeft().getType().isNumeric() && node.getRight().getType().isNumeric();
		predicado(condicion, "Deben de ser de tipo int o real", node);
		
		condicion = node.getLeft().getType() == null || node.getRight().getType() == null 
				|| node.getLeft().getType().equals(node.getRight().getType());
		predicado(condicion, "Deben ser del mismo tipo", node);
		
		node.setType(node.getLeft().getType());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionComparision { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionComparision node, Object param) {
		super.visit(node, param);
		
		boolean condicion = node.getLeft().getType() == null || node.getRight().getType() == null 
				|| node.getLeft().getType().isNumeric() && node.getRight().getType().isNumeric();
		predicado(condicion, "Deben de ser de tipo numerico", node);
		
		condicion = node.getLeft().getType() == null || node.getRight().getType() == null 
				||  node.getLeft().getType().equals(node.getRight().getType());
		predicado(condicion, "Deben ser del mismo tipo", node);
		
		node.setType(new TypeInt());
		node.setModificable(false);
		return null;
	}
	


	//	class ExpressionOperator { Expression left;  String op;  Expression right; }
	public Object visit(ExpressionOperator node, Object param) {
		super.visit(node, param);
		
		boolean condicion = (node.getLeft().getType() == null || node.getRight().getType() == null) 
				|| (node.getLeft().getType().isInt() && node.getRight().getType().isInt());
		predicado(condicion, "Tienen que ser de tipo entero", node);
	
		node.setType(new TypeInt());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionNegative { Expression expression; }
	public Object visit(ExpressionNegative node, Object param) {
		super.visit(node, param);
		
		boolean condicion = node.getExpression().getType()==null || node.getExpression().getType().isInt();
		predicado(condicion, "Deben de ser de tipo entero", node);
		
		node.setType(new TypeInt());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionMinus { Expression expression; }
	public Object visit(ExpressionMinus node, Object param) {
		super.visit(node, param);
		
		boolean condicion =  node.getExpression().getType() == null || node.getExpression().getType().isNumeric();
		predicado(condicion, "Tiene que ser de tipo int o real", node);
		
		node.setType(node.getExpression().getType());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionCast { Type castTo;  Expression castFrom; }
	public Object visit(ExpressionCast node, Object param) {
		super.visit(node, param);
		
		boolean condicion = (node.getCastFrom().getType() == null) || (node.getCastFrom().getType().isSimple() && node.getCastTo().isSimple());
		predicado(condicion, "Los tipos del cast han de ser de tipo simple", node);

		condicion = node.getCastFrom().getType() == null || !node.getCastTo().equals(node.getCastFrom().getType());
		predicado(condicion, "Los tipos del cast han de ser distintos", node);
		
		node.setType(node.getCastTo());
		node.setModificable(false);
		return null;
	}

	//	class ExpressionElements { Expression left;  String right; }
	public Object visit(ExpressionElements node, Object param) {
		super.visit(node, param);
		
		boolean condicion = node.getLeft().getType() == null || node.getLeft().getType().isStruct();
		predicado(condicion, "Ha de ser de tipo struct" , node);
		
		if(condicion && node.getLeft().getType() != null) {
			TypeStruct ts = (TypeStruct) node.getLeft().getType();
			DefinitionVariable d = ts.searchField(node.getRight());
			
			condicion = d != null;
			predicado(condicion, "El campo no esta definido", node);
			if(condicion)
				node.setType(d.getType());
		}
		node.setModificable(true);
		
		return null;
	}

	//	class ExpressionArray { Expression left;  Expression right; }
	public Object visit(ExpressionArray node, Object param) {
		super.visit(node, param);
		
		boolean condicion = node.getLeft().getType() == null || node.getLeft().getType().isArray();
		predicado(condicion, "Ha de ser de tipo Array" , node);
		
		condicion = node.getRight().getType() == null || node.getRight().getType().isInt();
		predicado(condicion, "El indice ha de ser tipo int", node);
		
		if(node.getLeft().getType() != null && node.getLeft().getType().isArray()) {
			TypeArray ta = (TypeArray) node.getLeft().getType();
			node.setType(ta.getType());
		}
		
		node.setModificable(true);
		return null;
	}

	//	class ExpressionFunctionCall { String name;  List<Expression> param; }
	public Object visit(ExpressionFunctionCall node, Object param) {
		super.visit(node, param);
		
		boolean condicion = node.getParam().size() == node.getDefinicion().getParam().size();
		predicado(condicion, "Numero de parametros incorrecto", node);
		
		if(condicion) {
			for(int i=0; i<node.getParam().size(); i++) {
				condicion = node.getParam().get(i).getType() == null || 
						node.getParam().get(i).getType().equals(node.getDefinicion().getParam().get(i).getType());
				predicado(condicion, "Los parametros no coinciden", node);
			}
		}
	
		condicion = !node.getDefinicion().getType().isVoidType();
		predicado(condicion, "Ha de tener valor de retorno", node);
		
		if(condicion)	
			node.setType(node.getDefinicion().getType());
		node.setModificable(false);
		return null;
	}


    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo pimitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo pimitivo", expr);
     *      3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condicion     Debe cumplirse para que no se produzca un error
     * @param mensajeError  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
     */
    private void predicado(boolean condicion, String mensajeError, Position posicionError) {
        if (!condicion)
            errorManager.notify("Comprobación de tipos", mensajeError, posicionError);
    }

    private void predicado(boolean condicion, String mensajeError, AST node) {
        predicado(condicion, mensajeError, node.getStart());
    }

    private void predicado(boolean condicion, String mensajeError) {
        predicado(condicion, mensajeError, (Position) null);
    }


    private ErrorManager errorManager;
}
