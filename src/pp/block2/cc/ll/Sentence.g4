lexer grammar Sentence;

NOUN : 'students' | 'compilers' ;
VERB : 'love' ;
ADJECTIVE : 'all' | 'smart' | 'undergraduate' ;
ENDMARK : '.' ;

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : [a-zA-Z]+;
