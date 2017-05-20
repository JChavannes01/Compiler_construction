grammar Tree;

//@header{package pp.homework.q1_4;}

top : node ;

node
  : NUM                                 # numNode
  | LPAR node LEFT NUM  RPAR            # leftNode
  | LPAR NUM RIGHT node RPAR            # rightNode
  | LPAR node LEFT NUM RIGHT node RPAR  # binNode
  ; 
  
LPAR  : '(';
RPAR  : ')';
LEFT  : '<';
RIGHT : '>';

NUM : [0-9]+;

WS : [ \t\r\n]+ -> skip;
