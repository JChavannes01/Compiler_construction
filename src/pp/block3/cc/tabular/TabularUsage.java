package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class TabularUsage {
    public static void main(String[] args) {
        parse("src/pp/block3/cc/tabular/tabular-1.tex");
        parse("src/pp/block3/cc/tabular/tabular-2.tex");
        parse("src/pp/block3/cc/tabular/tabular-3.tex");
        parse("src/pp/block3/cc/tabular/tabular-4.tex");
        parse("src/pp/block3/cc/tabular/tabular-5.tex");
    }

    public static void parse(String text) {
        // Convert the input text to a character stream
        CharStream stream = null;
        try {
            stream = CharStreams.fromFileName(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new TabularLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        TabularParser parser = new TabularParser(tokens);
        ParseTree tree = parser.start();
        System.out.println(tree.toStringTree(parser));
    }
}