grammar Grammar;

import Lexicon;

@parser::header {
	import ast.*;
	import ast.definition.*;
	import ast.expression.*;
	import ast.type.*;
	import ast.sentence.*;
}
start returns[Program ast]
:
	definiciones 
	{ $ast = new Program($definiciones.list); }
; 

definiciones returns [List<Definitions> list = new ArrayList<Definitions>()]
:
	(definicion { $list.add($definicion.ast); })*
;

definicion returns[Definitions ast]
:
	definicionVariable 
	{ $ast = $definicionVariable.ast; }
	
	| definicionStruct 
	{ $ast = $definicionStruct.ast; }
	
	| definicionFuncion 
	{ $ast = $definicionFuncion.ast; }
;

definicionVariable returns[Definitions ast]
:
	'var' IDENT ':' t=tipo ';' 
	{ $ast = new DefinitionVariable($IDENT, $t.ast, "global"); }
;

definicionStruct returns [Definitions ast]
:
	'struct' IDENT '{' b=bodyStruct '};' 
	{ $ast = new DefinitionStruct($IDENT, $b.list); }
;

bodyStruct returns [List<Definitions> list = new ArrayList<Definitions>()]
:
	(i=IDENT ':' t=tipo ';' { $list.add(new DefinitionVariable($i, $t.ast,"struct")); })*
;

definicionFuncion returns[Definitions ast]
:
	i1=IDENT '(' p1=param ')''{'  d1=definicionInsideFunction s1=sentencias '}'
	{ $ast = new DefinitionFuncion($i1, new TypeVoid(), $p1.list, $d1.list, $s1.list); }
	
	| i2=IDENT '(' p2=param ')'':' t2=tipo '{' d2=definicionInsideFunction s2=sentencias '}'
	{ $ast = new DefinitionFuncion($i2, $t2.ast, $p2.list, $d2.list, $s2.list); }
;

definicionInsideFunction returns[List<Definitions> list = new ArrayList<Definitions>()]
:
	(d=definicionVariableLocal {$list.add($d.ast);})*
;

definicionVariableLocal returns[Definitions ast]
:
	'var' IDENT ':' t=tipo ';' 
	{ $ast = new DefinitionVariable($IDENT, $t.ast, "local"); }
;

param returns[List<Definitions> list = new ArrayList<Definitions>()]
:
	(i1=IDENT ':' t1=tipo  { $list.add(new DefinitionVariable($i1, $t1.ast, "parameter")); } 
	(',' i2=IDENT ':' t2=tipo { $list.add(new DefinitionVariable($i2, $t2.ast, "parameter")); })*)?
;

sentencia returns[Sentence ast]
:
	
	'println' (ex=expr)? ';'
	{ $ast = new SentencePrint($ex.ctx == null ? null : $ex.ast, "\n"); }
	
	| 'printsp' ex=expr ';' 
	{ $ast = new SentencePrint($ex.ast, " "); }
	
	| 'print' ex=expr ';' 
	{ $ast = new SentencePrint($ex.ast, ""); } 
	
	| 'read' ex=expr ';' 
	{ $ast = new SentenceRead($ex.ast); }
	
	| left=expr '=' right=expr ';' 
	{ $ast = new SentenceAssignment($left.ast, $right.ast); }
	
	| 'if' '(' condition=expr ')' '{' cierto=sentencias '}' ('else' '{' falso=sentencias '}')? 
	{ $ast = new SentenceIf($condition.ast, $cierto.list, $falso.ctx == null ? new ArrayList<>() : $falso.list); }
	
	| 'while' '(' condition=expr ')' '{' cierto=sentencias '}'
	{ $ast = new SentenceWhile($condition.ast,$cierto.list); }
	
	| 'return' (ret=expr)? ';'
	{ $ast = new SentenceReturn($ret.ctx == null ? null : $ret.ast); }
	
	| IDENT '(' r=paramExpr ')' ';'
	{ $ast = new SentenceFunctionCall($IDENT, $r.list); }

;

sentencias returns[List<Sentence> list = new ArrayList<Sentence>()]
:
	(sentencia { $list.add($sentencia.ast); })*
;

expr returns[Expression ast]
:
	INT_CONSTANT 
	{ $ast = new ExpressionIntCte($INT_CONSTANT); }
	
	| REAL_CONSTANT 
	{ $ast = new ExpressionRealCte($REAL_CONSTANT); }
	
	| CHAR_CONSTANT 
	{ $ast = new ExpressionCharCte($CHAR_CONSTANT); }
	
	| IDENT
	{ $ast = new ExpressionVariable($IDENT); }
	
	| left=expr '.' IDENT 
	{ $ast = new ExpressionElements($left.ast, $IDENT); }

	| left=expr '[' right=expr ']' 
	{ $ast = new ExpressionArray($left.ast, $right.ast); }

	| '!' right=expr 
	{ $ast = new ExpressionNegative($right.ast); }
	
	| '-' right=expr
	{ $ast = new ExpressionMinus($right.ast); }
	
	| left=expr op=('*' | '/') right=expr 
	{ $ast = new ExpressionArithmetic($left.ast, $op, $right.ast);}
	
	| left=expr op=('+' | '-') right=expr 
	{ $ast = new ExpressionArithmetic($left.ast, $op, $right.ast); }
	
		| left=expr op=('==' | '!=' | '>=' | '<=' | '<' | '>') right=expr 
	{ $ast = new ExpressionComparision($left.ast, $op, $right.ast); }
	
	| left=expr op=('&&' | '||') right=expr 
	{ $ast = new ExpressionOperator($left.ast, $op, $right.ast); }
	
	| '(' expr ')' 
	{ $ast = $expr.ast; }

	| 'cast<' l=tipo '>' '(' right=expr ')'
	{ $ast = new ExpressionCast($l.ast, $right.ast); }
	
	| IDENT '(' rig=paramExpr ')' 
	{ $ast = new ExpressionFunctionCall($IDENT, $rig.list); }
;

paramExpr returns[List<Expression> list = new ArrayList<Expression>()]
:
	(l=expr {$list.add($l.ast);}(',' r=expr { $list.add($r.ast); })*)?
;


tipo returns[Type ast]
:
	i0=IDENT 
	{ $ast = new TypeStruct($i0); }
	
	| '[' d=INT_CONSTANT ']' t2=tipo 
	{ $ast = new TypeArray($d, $t2.ast); }
	
	| t3=tipoSimple 
	{ $ast = $t3.ast; }
;

tipoSimple returns[Type ast]
:
	'float' 
	{ $ast = new TypeReal(); }
	
	| 'int' 
	{ $ast = new TypeInt(); }
	
	| 'char' 
	{ $ast = new TypeChar(); }
;
