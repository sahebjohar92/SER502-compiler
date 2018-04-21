grammar Race;
program:'race' body* 'finish';

body : variableDeclaration ';'|statement;
variableDeclaration : type varDeclarators ;
varDeclarators: varDeclarator (',' varDeclarator)*;
varDeclarator: varDecalaratorId ('=' varInit)?;
varDecalaratorId : IDENTIFIER ('[' ']')*;
varInit:expression;
statement: IF ifExpression statement* (ELSE ifExpression statement*) (ELSE statement*)? ENDIF  | expressionBody';'| SEMI
   |FOR '(' forControl ')' statement* ENDFOR ;
ifExpression : '(' expression ')' ;

forControl:forInit? ';' expressionBody? ';'forUpdate=expressionBody?;
forInit:expressionBody;//variableDeclaration|
expressionBody : expression (',' expression)* ;
primary : variableDeclaration|IDENTIFIER;

expression : primary| expression postfix=('++' | '--')
    | prefix=('+'|'-'|'++'|'--') expression
    | prefix=('~'|'!') expression
    | expression bop=('*'|'/'|'%') expression
    | expression bop=('+'|'-') expression
    | expression ('<' '<' | '>' '>' '>' | '>' '>') expression
    | expression bop=('<=' | '>=' | '>' | '<') expression
    | expression bop='INSTANCEOF' basicType
    | expression bop=('==' | '!=') expression
    | expression bop='&' expression
    | expression bop='^' expression
    | expression bop='|' expression
    | expression bop='&&' expression
    | expression bop='||' expression
    | expression bop='?' expression ':' expression
    | <assoc=right> expression
      bop=('=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '>>=' | '>>>=' | '<<=' | '%=')
      expression;


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
Digits : [0-9] ([0-9]* [0-9])?;
AlphaNumeric: Letter| [0-9];

WS:[ \t\r\n]+ -> skip;
COMMENT:'/' .? '*/' -> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
Letter:[a-zA-Z];
