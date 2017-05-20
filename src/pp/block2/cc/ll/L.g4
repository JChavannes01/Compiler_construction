lexer grammar L;

A : 'a';
B : 'b';
C : 'c';

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : (~(' ' | '\t' | '\n' | '\r'))+;
