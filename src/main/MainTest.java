package main;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;

import ast.AST;
import ast.Program;
import codegeneration.CodeGeneration;
import parser.GrammarLexer;
import parser.GrammarParser;
import semantic.SemanticAnalisys;
import visitor.ASTPrinter;
import visitor.PrintVisitor;
 
/**
 * Clase que inicia el compilador e invoca a todas sus fases.
 *
 * Normalmente, no es necesario modificar este fichero. En su lugar, modificar
 * los ficheros de cada fase (que son llamados desde aquí):
 * - Para Análisis Léxico: 'Lexico.g4'.
 * - Para Análisis Sintáctico: 'Grammar.g4'.
 * - Para Análisis Semántico: 'Identification.java' y 'TypeChecking.java'.
 * - Para Generación de Código: 'MemoryAllocation.java' y 'CodeSelection.java'.
 *
 * @author Raúl Izquierdo
 *
 */
public class MainTest {
	private static final boolean printVisitor = false;
	public static final String path = "files/";
	public static final String[] files = 
		{
				"ejemplo.txt", 
				"Hipoteca.txt", 
				"empty.txt", 
				
				"IdentificacionEstructuras.txt", 
				"IdentificacionFunciones.txt", 
				"IdentificacionVariables.txt",
				"IdentificacionProg1.txt",
				"IdentificacionProg2.txt",
				
				"Tipos.txt", 
				
				"MemoryAllocation.txt",
				
				"GeneracionCodigoV1.txt",
				"GeneracionCodigoV2.txt",
				"GeneracionCodigoV3.txt",
				"GeneracionCodigoV4.txt",
				"GeneracionCodigoV5.txt",
				
				"GeneracionCodigoFin.txt"
		};

    public static void main(String[] args) throws Exception {
    	for (String f : files) {
    		System.out.println("-----Inicio " + f + " -----\n");
    		ErrorManager errorManager = new ErrorManager();
        	AST ast = compile(path + f, errorManager); // Poner args[0] en vez de "programa" en la versión final
        	if (errorManager.errorsCount() == 0)
            	System.out.println("El programa " + f + " se ha compilado correctamente.");
        	ASTPrinter.toHtml(path + f, ast, "AST"); // Utilidad generada por VGen (opcional)
        	System.out.println("\n-----Fin " + f + " -----\n");
		}
    }
    

    /**
     * Método que coordina todas las fases del compilador
     */
    public static AST compile(String sourceName, ErrorManager errorManager) throws Exception {

        // 1. Fases de Análisis Léxico y Sintáctico
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(sourceName));
        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
       
        // Las dos siguientes líneas son opcionales. Realizan una detección más precisa
        // (y lenta) de si la entrada se puede reconocer de más de una manera.
        parser.addErrorListener(new DiagnosticErrorListener()); // Notificar entradas ambiguas
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        AST ast = null;
        // IMPORTANTE: Cuando se genere el AST, INTERCAMBIAR las dos líneas siguientes:
        //parser.start();
        ast = parser.start().ast; 
        
        if (parser.getNumberOfSyntaxErrors() > 0) {
            errorManager.notify("Sintactico", "La entrada no pertenece al lenguaje.");
            return null;
        }
        
        if(printVisitor)
        	new PrintVisitor().visit((Program) ast, null);
        
        if (ast == null) // Si el AST no se ha implementado aún
            return null;

        // 2. Fase de Análisis Semántico
        SemanticAnalisys analyzer = new SemanticAnalisys(errorManager);
        analyzer.analize(ast);
        if (errorManager.errorsCount() > 0)
            return ast;

        // 3. Fase de Generación de Código
        File sourceFile = new File(sourceName);
        Writer out = new FileWriter(new File(sourceFile.getParent(), "output.txt"));

        CodeGeneration generator = new CodeGeneration();
        generator.generate(sourceFile.getName(), ast, out);
        out.close();

        return ast;
    }
}
