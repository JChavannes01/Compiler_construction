grammar Arithmetic;

//start symbol to remove eof error.
start :expr;

expr : <assoc=right> expr '^' expr #powExpr
     | expr '*' expr # mulExpr
     | expr '-' expr # subExpr
     | expr '+' expr # addExpr
     | NUMBER # numExpr
     ;

NUMBER : '-' DIGIT+ | DIGIT+ ;

fragment DIGIT : '0'..'9';

//// ignore whitespace
//WS : [ \t\n\r] -> skip;
//
//// everything else is a typo
//TYPO : [a-zA-Z]+;
