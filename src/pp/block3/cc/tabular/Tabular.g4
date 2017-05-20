grammar Tabular;

start : COMMENT? BEGINTABLE tablerow+ ENDTABLE;
tablerow : tableentry? (AND tableentry?)* ENDROW;
tableentry : TABLEENTRY;

TABLEENTRY : ALPHANUM+;
BEGINTABLE : '\\begin{tabular}' ALLIGNMENT [ ]* NEWLINE;
ENDTABLE : '\\end{tabular}' [ ]* NEWLINE*;

COMMENT : '%' (ALPHANUM | '.')* NEWLINE+;
AND : '&';
ENDROW : '\\\\' NEWLINE;
ALPHANUM : [a-zA-Z0-9 ];
fragment NEWLINE : '\r'? '\n';
fragment ALLIGNMENT : '{' [lcr]+ '}';