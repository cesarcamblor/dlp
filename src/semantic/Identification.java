package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.AST;
import ast.Position;
import ast.definition.DefinitionFuncion;
import ast.definition.DefinitionStruct;
import ast.definition.DefinitionVariable;
import ast.expression.ExpressionFunctionCall;
import ast.expression.ExpressionVariable;
import ast.sentence.SentenceFunctionCall;
import ast.type.TypeStruct;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class Identification extends DefaultVisitor {

	private ContextMap<String, DefinitionVariable> variables = new ContextMap<String, DefinitionVariable>();
	private Map<String, DefinitionFuncion> funciones = new HashMap<String, DefinitionFuncion>();
	private Map<String, DefinitionStruct> structs = new HashMap<String, DefinitionStruct>();
	
	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}
	
	public Object visit(DefinitionFuncion node, Object param) {
		predicado(funciones.get(node.getName()) == null, "Funcion " + node.getName() + " ya definida", node);
		funciones.put(node.getName(), node);
		variables.set();
		super.visit(node, param);
		variables.reset();
		return null;
	}
	
	//	class SentenceFunctionCall { String name;  List<Expression> param; }
	public Object visit(SentenceFunctionCall node, Object param) {
		super.visit(node, param);
		DefinitionFuncion definicion = funciones.get(node.getName());
		predicado(definicion != null, "Funcion " + node.getName() + " no definida", node);
		node.setDefinicion(definicion);
		return null;
	}
	
	//	class ExpressionFunctionCall { String name;  List<Expression> param; }
	public Object visit(ExpressionFunctionCall node, Object param) {
		super.visit(node, param);
		DefinitionFuncion definicion = funciones.get(node.getName());
		predicado(definicion != null, "Funcion " + node.getName() + " no definida", node);
		node.setDefinicion(definicion);
		return null;
	}
	
	//	class DefinitionStruct { String name;  List<Sentence> body; }
	public Object visit(DefinitionStruct node, Object param) {
		predicado(structs.get(node.getName()) == null, "Struct " + node.getName() + " ya definida", node);
		structs.put(node.getName(), node);
		variables.set();
		super.visit(node, param);
		variables.reset();
		return null;
	}
	
	//	class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		super.visit(node, param);
		DefinitionStruct definicion = structs.get(node.getName());
		predicado(definicion != null, "Struct " + node.getName() + " no definido", node);
		node.setDefinicion(definicion);
		return null;
	}
	
	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		super.visit(node, param);
		predicado(variables.getFromTop(node.getName()) == null, "Variable " + node.getName() + " ya definida", node);
		variables.put(node.getName(), node);
		return null;
	}
	
	//	class ExpressionVariable { String value; }
	public Object visit(ExpressionVariable node, Object param) {
		super.visit(node, param);
		DefinitionVariable definicion = variables.getFromAny(node.getValue());
		predicado(definicion != null, "Variable " + node.getValue() + " no definida", node);
		node.setDefinicion(definicion);
		return null;
	}
	
	/*
	 * Poner aquí los visit necesarios. Si se ha usado VGen, solo hay que
	 * copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
	 */

	// public Object visit(Programa prog, Object param) {
	// ...
	// }



	/**
	 * predicado. Método auxiliar para implementar los predicados. Borrar si no
	 * se quiere usar.
	 *
	 * Ejemplos de uso (suponiendo que existe un método "esPrimitivo"):
	 *
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * pimitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
	 * expresión debe ser de un tipo pimitivo", expr); 3.
	 * predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * primitivo");
	 *
	 * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del
	 * fichero fuente donde estaba el nodo (y así poder dar información más
	 * detallada de la posición del error). Si se usa VGen, dicho método habrá
	 * sido generado en todos los nodos del AST. No es obligatorio llamar a
	 * getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto
	 * dicha posición. Si no se quiere imprimir la posición del fichero, se
	 * puede omitir el tercer argumento (ejemplo 3).
	 *
	 * @param condicion
	 *            Debe cumplirse para que no se produzca un error
	 * @param mensajeError
	 *            Se imprime si no se cumple la condición
	 * @param posicionError
	 *            Fila y columna del fichero donde se ha producido el error.
	 */
	private void predicado(boolean condicion, String mensajeError,
			Position posicionError) {
		if (!condicion)
			errorManager.notify("Fase Identificacion", mensajeError,
					posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private ErrorManager errorManager;
}
