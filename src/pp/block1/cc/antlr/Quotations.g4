lexer grammar Quotations;

SENTENCE :  QUOTATION (ALPHABET | QUOTATION QUOTATION)* QUOTATION;

fragment ALPHABET : (ALPHANUM | PUNCTUATION | SPACE);
fragment ALPHANUM : ('a'..'z' | 'A'..'Z' | '0'..'9');
fragment SPACE : (' ' | '\r' | '\n' | '\t');
fragment PUNCTUATION : (',' | '.' | '?' | '!' | '\'');
fragment QUOTATION : '"';
