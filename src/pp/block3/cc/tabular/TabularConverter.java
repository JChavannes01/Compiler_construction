package pp.block3.cc.tabular;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TabularConverter extends TabularBaseListener {
    private StringBuilder table;
    private boolean errorFound;

    public void init(String filePath) {
        this.table = new StringBuilder();
        this.errorFound = false;
        MyErrorListener errorListener = new MyErrorListener();
        Lexer lexer = null;
        try {
            lexer = new TabularLexer(CharStreams.fromFileName(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        TabularParser parser = new TabularParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.start();
        new ParseTreeWalker().walk(this, tree);
        if (!errorFound) {
            writeFile(filePath);
        } else {
            System.err.println("Error in file " + filePath.substring(24) + ", HTML file will not be generated.");
            System.err.println("errors = " + errorListener.getErrors());
        }
    }

    private void writeFile(String filePath) {
        try(PrintWriter out = new PrintWriter(filePath + ".html")){
            out.print(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void visitErrorNode(ErrorNode node) {
        this.errorFound = true;
    }

    @Override
    public void enterStart(TabularParser.StartContext ctx) {
        table.append("<html>\n" +
                     "<body>\n" +
                     "<table border=\"1\">\n");
    }

    @Override
    public void exitStart(TabularParser.StartContext ctx) {
        table.append("</table>\n" +
                     "</body>\n" +
                     "</html>");
    }

    @Override
    public void enterTablerow(TabularParser.TablerowContext ctx) {
        table.append("<tr>\n");
    }

    @Override
    public void exitTablerow(TabularParser.TablerowContext ctx) {
        table.append("</tr>\n");
    }

    @Override
    public void enterTableentry(TabularParser.TableentryContext ctx) {
        table.append("\t<td>" +
                     ctx.getText() +
                     "</td>\n");
    }

    public static void main(String[] args) {
        TabularConverter tc = new TabularConverter();
        tc.init("src/pp/block3/cc/tabular/tabular-1.tex");
//        tc.init("src/pp/block3/cc/tabular/tabular-2.tex");
//        tc.init("src/pp/block3/cc/tabular/tabular-3.tex");
//        tc.init("src/pp/block3/cc/tabular/tabular-4.tex");
//        tc.init("src/pp/block3/cc/tabular/tabular-5.tex");
    }
}
