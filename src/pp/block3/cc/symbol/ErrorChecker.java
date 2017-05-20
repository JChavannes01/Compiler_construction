package pp.block3.cc.symbol;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ErrorChecker extends DeclUseBaseListener {
    private SymbolTable table;
    private List<String> errors;

    public List<String> checkErrors (String filePath) {
        this.errors = new ArrayList<>();
        this.table = new MySymbolTable();
        Lexer lexer = null;
        try {
            lexer = new DeclUseLexer(CharStreams.fromFileName(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeclUseParser parser = new DeclUseParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();
        new ParseTreeWalker().walk(this, tree);
        System.out.println("errors in " + filePath.substring(24) + " = " + errors);
        return errors;
    }

    @Override
    public void enterProgram(DeclUseParser.ProgramContext ctx) {
        table.openScope();
    }

    @Override
    public void exitProgram(DeclUseParser.ProgramContext ctx) {
        table.closeScope();
    }

    @Override
    public void enterSeriesUnit(DeclUseParser.SeriesUnitContext ctx) {
        table.openScope();
    }

    @Override
    public void exitSeriesUnit(DeclUseParser.SeriesUnitContext ctx) {
        table.closeScope();
    }

    @Override
    public void enterDeclUnit(DeclUseParser.DeclUnitContext ctx) {
        String variable = ctx.getText().substring(2);
        Token tk = ctx.getStart();
        if (!table.add(variable)) {
            errors.add("Error at: " + tk.getLine() + ":"+ tk.getCharPositionInLine()+ ", variable '" + variable + "' is already declared in this scope.");
        }
    }

    @Override
    public void enterUseUnit(DeclUseParser.UseUnitContext ctx) {
        String variable = ctx.getText().substring(2);
        Token tk = ctx.getStart();
        if (!table.contains(variable)) {
            errors.add("Error at line " + tk.getLine() + ":"+ tk.getCharPositionInLine()+ ", variable '" + variable + "' is used out of scope.");
        }
    }

    public static void main(String[] args) {
        ErrorChecker ec = new ErrorChecker();
        ec.checkErrors("src/pp/block3/cc/symbol/prog1");
        ec.checkErrors("src/pp/block3/cc/symbol/prog2");
        ec.checkErrors("src/pp/block3/cc/symbol/prog3");
        ec.checkErrors("src/pp/block3/cc/symbol/prog4");
        ec.checkErrors("src/pp/block3/cc/symbol/prog5");
    }
}
