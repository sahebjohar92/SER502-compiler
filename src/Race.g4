statement: IF ifExpression statement* (ELSE ifExpression statement*) (ELSE statement*)? ENDIF  | expressionBody';'| SEMI
   |FOR '(' forControl ')' statement* ENDFOR ;
ifExpression : '(' expression ')' ;
WS:[ \t\r\n]+ -> skip;
COMMENT:'/' .? '*/' -> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;

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
