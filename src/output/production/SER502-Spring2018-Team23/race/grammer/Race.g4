grammar Race;


program
	: 'race' body 'finish'
	;

body
	:
	| statement+
	;
	
statement
	: (funcStmt|ifExpressn|whileExpressn|forExpressn|disp|expression|func|returnStmt)
	;

expression
	: 'float' IDENTIFIER (EQUALSto num_expressn)?              # assignmentInteger
	| 'boolean' IDENTIFIER (EQUALSto bool_expressn)?         # assignmentBoolean
	| IDENTIFIER EQUALSto num_expressn                       # assignmentInteger
	| IDENTIFIER EQUALSto bool_expressn                      # assignmentBoolean
	| IDENTIFIER op=(INCR|DECR)                     # assignmentIncrementOrDecrement
    | IDENTIFIER op=(ADD|SUB|MUL|DIV) EQUAL num_expressn  # assignmentShortHand
    ;

bool_expressn
    : bool_expressn op=(ISEquals|NotEquals) bool_expressn # expressionBoolean
    | bool_expressn op=(AND|OR) bool_expressn                # expressionBooleanConnector
    | comp_expressn                                            # expressionBooleanComparison
    | func                                                    # expressionBooleanFunctionCall
    | '(' bool_expressn ')'                                       # expressionBooleanParentheses
    | (NOT)? BOOLEAN                                                   # expressionBooleanOnly
    | (NOT)? IDENTIFIER                                                # expressionBooleanIdentifierOnly
    ;
comp_expressn
    : num_expressn op=(GREATER|LESSER|MORE_or_EQU|LESS_or_EQU|ISEquals|NotEquals) num_expressn  # expressionNumberComparison
    ;

num_expressn
    : num_expressn op=(MUL|DIV) num_expressn              # expressionNumberMultiplyDivide
    | num_expressn op=(ADD|SUB) num_expressn                   # expressionNumberPlusMinus
    | '(' num_expressn ')'                                             # expressionNumberParentheses
    | func                                                         # expressionNumberFunctionCall
    | SUB? DIGITS                                                         # expressionNumberOnly
    | SUB? IDENTIFIER                                                     # expressionNumberIdentifierOnly
    ;

cond_expressn
    : '(' bool_expressn ')'
    ;

inputParams
    : '()'
    | '(' IDENTIFIER (',' IDENTIFIER)* ')'
    ;

inputArgs
    : '()'
    | '(' bool_id_Dig (',' bool_id_Dig)* ')'
    ;

funcStmt
    : 'function' IDENTIFIER inputParams '{' body '}'
    ;

func
    : IDENTIFIER inputArgs
    ;

returnStmt
    : 'return' (bool_id_Dig|num_expressn|bool_expressn|func)
    ;

ifExpressn
    : 'if' cond_expressn '{' body '}' (elseIfExpressn)* (elseExpressn)?
    ;

elseIfExpressn
    : 'else if' cond_expressn '{' body '}'
    ;

elseExpressn
    : 'else' '{' body '}'
    ;

whileExpressn
    : 'while' cond_expressn '{' body '}'
    ;

forExpressn
    : 'for' '(' expression ';' comp_expressn ';' expression ')' '{' body '}'
    ;

disp
    : 'WRITE' '(' (DIGITS|BOOLEAN|IDENTIFIER|num_expressn|bool_expressn|func) ')'
    ;

bool_id_Dig
    : (IDENTIFIER|BOOLEAN|DIGITS)
    ;

// accepts numbers from 0-9 and more than that.
DIGITS
	: [1-9] [0-9]*
	| '0'
	;

// Takes Boolean value as True or false.
BOOLEAN
	: 'T'
	| 'F'
	;

ADD               : '+';
SUB              : '-';
MUL           : '*';
DIV             : '/';

INCR          : '++';
DECR        : '--';

AND                : '&&';
OR                 : '||';
NOT                : '~';
LESSER          : '<';
GREATER       : '>';
LESS_or_EQU    : '<=';
MORE_or_EQU : '>=';
NotEquals          : '!=';
ISEquals        : '==';

// Accepts lower case and upper case letters.
IDENTIFIER
	: [a-zA-Z_] [a-zA-Z_0-9]*
	;

EQUALSto  : '>>';
EQUAL   : '=';
WS      : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines
Comment : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip;
