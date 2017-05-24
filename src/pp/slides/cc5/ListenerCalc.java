package pp.slides.cc5;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.slides.cc5.CalcParser.DivContext;
import pp.slides.cc5.CalcParser.MainContext;
import pp.slides.cc5.CalcParser.MinusContext;
import pp.slides.cc5.CalcParser.MultContext;
import pp.slides.cc5.CalcParser.NumContext;
import pp.slides.cc5.CalcParser.PlusContext;

public class ListenerCalc extends CalcBaseListener {
	private ParseTreeProperty<Integer> vals;

	private void init() {
		this.vals = new ParseTreeProperty<>();
	}

	private int val(ParseTree tree) {
		return this.vals.get(tree);
	}

	@Override
	public void exitMain(MainContext ctx) {
		this.vals.put(ctx, val(ctx.expr()));
	}

	@Override
	public void exitDiv(DivContext ctx) {
		this.vals.put(ctx, val(ctx.expr(0)) / val(ctx.expr(1)));
	}

	@Override
	public void exitMinus(MinusContext ctx) {
		this.vals.put(ctx, val(ctx.expr(0)) - val(ctx.expr(1)));
	}

	@Override
	public void exitMult(MultContext ctx) {
		this.vals.put(ctx, val(ctx.expr(0)) * val(ctx.expr(1)));
	}

	@Override
	public void exitNum(NumContext ctx) {
		this.vals.put(ctx, Integer.parseInt(ctx.getText()));
	}

	@Override
	public void exitPlus(PlusContext ctx) {
		this.vals.put(ctx, val(ctx.expr(0)) + val(ctx.expr(1)));
	}

	public static ParseTree parse(String text) {
		// Convert the input text to a character stream
		CharStream stream = CharStreams.fromString(text);
		// Build a lexer on top of the character stream
		Lexer lexer = new CalcLexer(stream);
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		CalcParser parser = new CalcParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.expr();
		// Print the (formatted) parse tree
		// System.out.println(tree.toStringTree(parser));
		return tree;
	}

	private static ListenerCalc calc = new ListenerCalc();

	public static int calculate(ParseTree tree) {
		calc.init();
		new ParseTreeWalker().walk(calc, tree);
		return calc.val(tree);
	}

	public static void main(String[] args) {
		int result = calculate(parse(args[0]));
		System.out.printf("%s = %d%n", args[0], result);
	}
}
