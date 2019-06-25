package codegeneration;

import ast.Program;
import ast.definition.DefinitionFuncion;
import ast.definition.DefinitionStruct;
import ast.definition.DefinitionVariable;
import ast.definition.Definitions;
import ast.sentence.Sentence;
import visitor.DefaultVisitor;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    private int global;
    private int strcut;
    private int parameter;
    private int local;
	
	public Object visit(Program node, Object param) {
		global = 0;
		if (node.getDefinitions() != null)
			for (Definitions child : node.getDefinitions()) 
				child.accept(this, "global");
		return null;
	}

	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		if (node.getType() != null) {
			node.getType().accept(this, param);
			if(param!=null && param.equals("global")) {
				node.setAddress(global);
				global += node.getType().getSize();
			}
		}
		return null;
	}

	//	class DefinitionStruct { String name;  List<Definitions> body; }
	public Object visit(DefinitionStruct node, Object param) {
		strcut = 0;	
		if (node.getBody() != null) {
			for (DefinitionVariable child : node.getBody()) {
				child.setAddress(strcut);
				strcut += child.getType().getSize();
				child.accept(this, null);
			}
		}

		return null;
	}

	//	class DefinitionFuncion { String name;  Type type;  List<Definitions> param;  List<Definitions> definitions;  List<Sentence> body; }
	public Object visit(DefinitionFuncion node, Object param) {
		parameter = 4;
		local = 0;
		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getParam() != null) {
			for(int i=node.getParam().size()-1;i>=0; i--) {
				node.getParam().get(i).accept(this, null);
				node.getParam().get(i).setAddress(parameter);
				parameter += node.getParam().get(i).getType().getSize();
			}
		}
		if (node.getDefinitions() != null) {
			for (DefinitionVariable child : node.getDefinitions()) {
				child.accept(this, null);
				local -= child.getType().getSize();
				child.setAddress(local);
			}
		}

		if (node.getBody() != null)
			for (Sentence child : node.getBody())
				child.accept(this, param);
		
		node.setLocalVarsSize(-local);
		node.setParametersSize(parameter - 4);
		
		return null;
	}

}
