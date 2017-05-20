grammar Calc;

import CalcVocab;

expr : expr TIMES expr # times
     | expr PLUS expr  # plus
     | expr MINUS expr # minus
     | LPAR expr RPAR  # par
     | MINUS NUMBER    # negNumber
     | NUMBER          # number
     ;
