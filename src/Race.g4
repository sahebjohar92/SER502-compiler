forControl:forInit? ';' expressionBody? ';'forUpdate=expressionBody?;
forInit:expressionBody;//variableDeclaration|
expressionBody : expression (',' expression)* ;
primary : variableDeclaration|IDENTIFIER;

type: basicType;
basicType: BOOLEAN| CHAR| INT| FLOAT;

BOOLEAN: 'boolean';
CHAR: 'char';
ELSE: 'else';
FLOAT: 'float';
FOR: 'for';
IF: 'if';
INT: 'int';
SEMI: ';';
ENDFOR:'endfor';
ENDIF:'endif';

IDENTIFIER: (Letter|Digits) AlphaNumeric*;