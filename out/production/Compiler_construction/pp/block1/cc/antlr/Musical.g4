lexer grammar Musical;
SONG : (LA | LA LA | LA LA LA LI);
fragment LA : 'La' 'a'* SPACE*;
fragment LI : 'Li' SPACE*;
fragment SPACE : ' ';