Program Gauss;

Var upperBound, i, total  : Integer;

Begin
    In("Upper bound? ", upperBound);
    i := 1;
    total := 0;
    While i <= upperBound Do
    Begin
        total := total + i;
        i := i + 1
    End;
    Out("Total = ", total)
End.