grammar DeclUse;

program : '(' series ')' ;
series  : unit* ;
unit    : decl            # declUnit
        | use             # useUnit
        | '(' series ')'  # seriesUnit
        ;
decl    : 'D:' ID ;
use     : 'U:' ID ;

ID : [a-zA-Z]+;
WS : [ \t\n\r]+ -> skip;
