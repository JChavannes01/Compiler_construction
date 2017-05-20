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
import pp.block4.cc.cfg.FragmentParser.DeclContext;
import pp.block4.cc.cfg.FragmentParser.IfStatContext;
import pp.block4.cc.cfg.FragmentParser.PrintStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
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
			ProgramContext tree = parser.program();
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
    public Graph build(ProgramContext tree) {
        this.graph = new Graph();
        new ParseTreeWalker().walk(this, tree);
        try {
            graph.writeDOT("src/pp/block4/cc/cfg/TopDownCFG.dot", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

    @Override
    public void enterProgram(ProgramContext ctx) {
        Node node = new Node(0);
        for (FragmentParser.StatContext stmnt : ctx.stat()) {
            Node childEntry = addNode(stmnt, stmnt.getText());
            Node childExit = addNode(stmnt, stmnt.getText() + "_EXIT");
            entrances.put(stmnt, childEntry);
            exits.put(stmnt, childExit);

            node.addEdge(childEntry);
            node = childExit;
        }
    }

    @Override
    public void enterDecl(DeclContext ctx) {
        entrances.get(ctx).addEdge(exits.get(ctx));
    }

    @Override
    public void enterAssignStat(FragmentParser.AssignStatContext ctx) {
	    entrances.get(ctx).addEdge(exits.get(ctx));

    }

    @Override
    public void enterIfStat(IfStatContext ctx) {
        Node entrance = entrances.get(ctx);
        Node exit = exits.get(ctx);
        FragmentParser.StatContext ifContext = ctx.stat(0);
        FragmentParser.StatContext elseContext = ctx.stat(1);

        Node childIfEntry = addNode(ifContext, ifContext.getText());
        Node childIfExit = addNode(ifContext, ifContext.getText() + "_EXIT");
        entrances.put(ifContext, childIfEntry);
        exits.put(ifContext, childIfExit);

        entrance.addEdge(childIfEntry);
        childIfExit.addEdge(exit);

        if (elseContext != null) {
            Node childElseEntry = addNode(elseContext, elseContext.getText());
            Node childElseExit = addNode(elseContext, elseContext.getText() + "_EXIT");
            entrances.put(elseContext, childElseEntry);
            exits.put(elseContext, childElseExit);

            entrance.addEdge(childElseEntry);
            childElseExit.addEdge(exit);
        }
    }

    @Override
    public void enterWhileStat(FragmentParser.WhileStatContext ctx) {
        Node entrance = entrances.get(ctx);
        Node exit = exits.get(ctx);

        Node childEntry = addNode(ctx.stat(), ctx.stat().getText());
        Node childExit = addNode(ctx.stat(), ctx.stat().getText() + "_EXIT");
        entrances.put(ctx.stat(), childEntry);
        exits.put(ctx.stat(), childExit);

        entrance.addEdge(childEntry);
        entrance.addEdge(exit);
        childExit.addEdge(entrance);
    }

    @Override
    public void enterBlockStat(FragmentParser.BlockStatContext ctx) {
        Node entrance = entrances.get(ctx);
        Node exit = exits.get(ctx);

        Node node = entrance;
        for (FragmentParser.StatContext stmnt : ctx.stat()) {
            Node childEntry = addNode(stmnt, stmnt.getText());
            Node childExit = addNode(stmnt, stmnt.getText() + "_EXIT");
            entrances.put(stmnt, childEntry);
            exits.put(stmnt, childExit);

            node.addEdge(childEntry);
            node = childExit;
        }
        node.addEdge(exit);
    }

    @Override
    public void enterPrintStat(PrintStatContext ctx) {
	    entrances.get(ctx).addEdge(exits.get(ctx));
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
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
