lexer grammar id6;

ID : ALPHABET ALPHANUM ALPHANUM ALPHANUM ALPHANUM ALPHANUM;

fragment DIGIT : ('0'..'9');
fragment ALPHABET : ('a'..'z' | 'A'..'Z');
fragment ALPHANUM : DIGIT | ALPHABET;
