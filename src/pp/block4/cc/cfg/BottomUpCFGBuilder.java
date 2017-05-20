package pp.block4.cc.cfg;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;
import pp.block4.cc.cfg.FragmentParser.ContStatContext;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
    /** The CFG being built. */
    private Graph graph;
    private ParseTreeProperty<Node> entrances;
    private ParseTreeProperty<Node> exits;

    /** Builds the CFG for a program contained in a given file. */
    public Graph build(File file) {
        Graph result = null;
        ErrorListener listener = new ErrorListener();
        entrances = new ParseTreeProperty<>();
        exits = new ParseTreeProperty<>();
        try {
            CharStream chars = CharStreams.fromPath(file.toPath());
            Lexer lexer = new FragmentLexer(chars);
            lexer.removeErrorListeners();
            lexer.addErrorListener(listener);
            TokenStream tokens = new CommonTokenStream(lexer);
            FragmentParser parser = new FragmentParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(listener);
            ParseTree tree = parser.program();
            if (listener.hasErrors()) {
                System.out.printf("Parse errors in %s:%n", file.getPath());
                for (String error : listener.getErrors()) {
                    System.err.println(error);
                }
            } else {
                result = build(tree);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /** Builds the CFG for a program given as an ANTLR parse tree. */
    public Graph build(ParseTree tree) {
        this.graph = new Graph();
        new ParseTreeWalker().walk(this, tree);
        try {
            graph.writeDOT("src/pp/block4/cc/cfg/BottomUpCFG.dot", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

    @Override
    public void exitProgram(FragmentParser.ProgramContext ctx) {
        Node node = new Node(0);
        for (FragmentParser.StatContext stmnt : ctx.stat()) {
            node.addEdge(entrances.get(stmnt));
            node = exits.get(stmnt);
        }
    }

    @Override
    public void exitDecl(FragmentParser.DeclContext ctx) {
        Node node = addNode(ctx, ctx.getText());
        entrances.put(ctx, node);
        exits.put(ctx, node);
    }

    @Override
    public void exitAssignStat(FragmentParser.AssignStatContext ctx) {
        Node node = addNode(ctx, ctx.getText());
        entrances.put(ctx, node);
        exits.put(ctx, node);
    }

    @Override
    public void exitIfStat(FragmentParser.IfStatContext ctx) {
        Node entrance = addNode(ctx, ctx.getText());
        Node exit = addNode(ctx, ctx.getText() + "_EXIT");
        entrances.put(ctx, entrance);
        exits.put(ctx, exit);

        entrance.addEdge(entrances.get(ctx.stat(0)));
        exits.get(ctx.stat(0)).addEdge(exit);

        if (ctx.stat(1) == null) {
            entrance.addEdge(exit);
        } else {
            entrance.addEdge(entrances.get(ctx.stat(1)));
            exits.get(ctx.stat(1)).addEdge(exit);
        }
    }

    @Override
    public void exitWhileStat(FragmentParser.WhileStatContext ctx) {
        Node entrance = addNode(ctx, ctx.getText());
        Node exit = addNode(ctx, ctx.getText() + "_EXIT");
        entrances.put(ctx, entrance);
        exits.put(ctx, exit);

        entrance.addEdge(entrances.get(ctx.stat()));
        entrance.addEdge(exit);
        exits.get(ctx.stat()).addEdge(entrance);
    }

    @Override
    public void exitBlockStat(FragmentParser.BlockStatContext ctx) {
        Node entrance = addNode(ctx, ctx.getText());
        Node exit = addNode(ctx, ctx.getText() + "_EXIT");
        entrances.put(ctx, entrance);
        exits.put(ctx, exit);

        Node node = entrance;
        for (FragmentParser.StatContext stmnt :ctx.stat()) {
            node.addEdge(entrances.get(stmnt));
            node = exits.get(stmnt);
        }
        node.addEdge(exit);
    }

    @Override
    public void exitPrintStat(FragmentParser.PrintStatContext ctx) {
        Node node = addNode(ctx, ctx.getText());
        entrances.put(ctx, node);
        exits.put(ctx, node);
    }

    @Override
    public void enterBreakStat(BreakStatContext ctx) {
        throw new IllegalArgumentException("Break not supported");
    }

    @Override
    public void enterContStat(ContStatContext ctx) {
        throw new IllegalArgumentException("Continue not supported");
    }

    /** Adds a node to he CGF, based on a given parse tree node.
     * Gives the CFG node a meaningful ID, consisting of line number and
     * a further indicator.
     */
    private Node addNode(ParserRuleContext node, String text) {
        return this.graph.addNode(node.getStart().getLine() + ": " + text);
    }

    /** Main method to build and print the CFG of a simple Java program. */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [filename]+");
            return;
        }
        BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
        for (String filename : args) {
            File file = new File(filename);
            System.out.println(filename);
            System.out.println(builder.build(file));
        }
    }
}
