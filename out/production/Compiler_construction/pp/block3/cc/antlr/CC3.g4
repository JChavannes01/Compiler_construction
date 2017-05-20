grammar CC3;

import CC3Vocab;

t   : t POWER t # powT
    | t PLUS t  # plusT
    | t EQUAL t # equalT
    | LPAR t RPAR #parT
    | NUM # numT
    | BOOL # boolT
    | STR # strT
    ;

