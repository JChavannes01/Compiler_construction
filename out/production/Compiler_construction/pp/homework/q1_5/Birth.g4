grammar Birth;

//@header{package pp.homework.q1_5;}

/** Branch of a family tree */
branch : enter* beget+ ;
/** Figures may enter with unknown parenthood. */
enter : ENTER sex ID (COMMA ID)* ;
/** Figures may be born from mother and father. */
beget : ID COMMA ID BEGET sex ID (COMMA ID)* #childBeget
      | LEFT branch RIGHT #branchBeget
      ;
/** Persons are always male or female. */
sex : MALE | FEMALE ;

COMMA  :  ',';
LEFT   :  '[';
RIGHT  :  ']';

BEGET  :  'beget';
ENTER  :  'enter';
FEMALE :  'female';
MALE   :  'male';

ID : [A-Z][a-z]*;

WS : [ \t\n\r]+ -> skip;
