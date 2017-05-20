lexer grammar CalcVocab;

TIMES  : '*';
PLUS   : '+';
MINUS  : '-';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;

// ignore whitespace
WS : [ \t\n\r] -> skip;
