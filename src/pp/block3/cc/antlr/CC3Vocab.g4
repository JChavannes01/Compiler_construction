lexer grammar CC3Vocab;

POWER  : '^';
PLUS   : '+';
EQUAL  : '=';
LPAR   : '(';
RPAR   : ')';

NUM    : ('0'..'9')+;
BOOL   : 'true' | 'false';
STR    : ('a'..'z')+;


// ignore whitespace
WS : [ \t\n\r] -> skip;
