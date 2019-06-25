lexer grammar Lexicon
	;

INT_CONSTANT: [0-9]+;
REAL_CONSTANT: [0-9]+ '.' [0-9]+;
IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
CHAR_CONSTANT: '\''[a-zA-Z0-9_:-@{-} ] '\''
	| '\'\\n\'' | '\''[!-/]'\'';
LINE_COMMENT:		'//' .*? '\n'	-> skip;
MULTILINE_COMMENT:	'/*' .*? '*/'	-> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
