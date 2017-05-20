grammar CC3Attr;

import CC3Vocab;

@members {
    }

expr returns [ pp.block3.cc.antlr.Type val ]
     : t0=expr POWER t1=expr
       {$val = ($t0.val != Type.BOOL && $t1.val == Type.NUM) ? $t0.val : Type.ERR;}
     | t0=expr PLUS t1=expr
       { $val = ($t0.val == $t1.val) ? $t0.val : Type.ERR;}
     | t0 = expr EQUAL t1 = expr
       { $val = ($t0.val == $t1.val) ? Type.BOOL : Type.ERR;}
     | LPAR t=expr RPAR
       { $val = $t.val; }
     | BOOL
        { $val = Type.BOOL;}
     | STR
        { $val = Type.STR; }
     | NUM
       { $val = Type.NUM; }

     ;
