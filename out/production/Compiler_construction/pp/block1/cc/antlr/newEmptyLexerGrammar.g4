lexer grammar newEmptyLexerGrammar;

CITATION :  QUOTATION (ALPHABET | QUOTATION QUOTATION)* QUOTATION;

ALPHABET : (ALPHANUM | PUNCTUATION | SPACE);
ALPHANUM : ('a'..'z' | 'A'..'Z' | '0'..'9');
SPACE : (' ' | '\r' | '\n' | '\t');
PUNCTUATION : (',' | '.' | '?' | '!' | '\'');
QUOTATION : '"';
