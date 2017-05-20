grammar Fragment;

program: stat+ EOF;

stat: type ID (ASSIGN expr)? SEMI         #decl
    | target ASSIGN expr SEMI             #assignStat
    | IF LPAR expr RPAR stat (ELSE stat)? #ifStat 
    | WHILE LPAR expr RPAR stat           #whileStat 
    | LCURLY stat* RCURLY                 #blockStat
    | PRINT LPAR STRING (COMMA ID)* RPAR SEMI #printStat
    | BREAK SEMI                          #breakStat
    | CONTINUE SEMI                       #contStat
    ;

target
    : ID              #idTarget
    | ID LSQ expr RSQ #arrayTarget
    ;

expr: expr DOT ID                   #fieldExpr
    | NOT expr                      #notExpr
    | expr (PLUS | MINUS) expr      #addExpr
    | expr BIT_AND expr             #bitAndExpr
    | expr BIT_OR expr              #bitOrExpr
    | expr AND expr                 #andExpr
    | expr OR  expr                 #orExpr
    | expr (LT | GT | EQ | NE) expr #compExpr
    | LPAR expr RPAR                #parExpr
    | (NUM | TRUE | FALSE)          #constExpr
    | IN LPAR RPAR                  #inExpr
    | ID LSQ expr RSQ               #arrayExpr
    | ID                            #idExpr
    ;

type: INT | BOOL;

DOT: '.';
SEMI: ';';
COMMA: ',';
LSQ: '[';
RSQ: ']';
ASSIGN: '=';
NOT: '!';
OR: '||';
AND: '&&';
BIT_OR: '|';
BIT_AND: '&';
PLUS: '+';
MINUS: '-';
LT: '<';
GT: '>';
EQ: '==';
NE: '!=';
LCURLY: '{';
RCURLY: '}';
LPAR: '(';
RPAR: ')';

IN: 'in';
PRINT: 'printf';
BOOL: 'boolean';
INT: 'int';
WHILE: 'while';
IF: 'if';
ELSE: 'else';
TRUE: 'true';
FALSE: 'false';
BREAK: 'break';
CONTINUE: 'continue';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT+;
STRING: '"' (~["\\] | '\\'.)* '"';

WS: [ \t\r\n]+ -> skip;
