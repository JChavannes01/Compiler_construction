grammar CalcAttr;

import CalcVocab;

@members {
    private int getValue(String text) {
        return Integer.parseInt(text);
    }
}

expr returns [ int val ]
     : e0=expr TIMES e1=expr
       { $val = $e0.val * $e1.val; }
     | e0=expr PLUS e1=expr
       { $val = $e0.val + $e1.val; }
     |  e0=expr MINUS e1=expr
       {System.out.println("[CalcAttr.g4] Evaluating MINUS expression");}
       { $val = $e0.val - $e1.val; }
     | LPAR e=expr RPAR
       { $val = $e.val; }
     | { System.out.println("[CalcAttr.g4] Evaluating NEGATIVE NUMBER"); }
       MINUS NUMBER
       { $val = (-1) * getValue($NUMBER.text); }
       { System.out.println("[CalcAttr.g4] Evaluating NEGATIVE NUMBER"); }
     | { System.out.println("[CalcAttr.g4] Evaluating NUMBER"); }
       NUMBER
       { $val = getValue($NUMBER.text); }

     ;
