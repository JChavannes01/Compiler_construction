grammar Calc;

@header{package pp.slides.cc5;}

main : expr EOF;

expr : expr '*' expr #mult
     | expr '/' expr #div
     | expr '+' expr #plus
     | expr '-' expr #minus
     | NUMBER        #num
     ;

NUMBER : [0-9]+;

// ignore whitespace
WS : [ \t\n\r] -> skip;

