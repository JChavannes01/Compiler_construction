package pp.slides.cc5;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import pp.slides.cc5.CalcParser.DivContext;
import pp.slides.cc5.CalcParser.MainContext;
import pp.slides.cc5.CalcParser.MinusContext;
import pp.slides.cc5.CalcParser.MultContext;
import pp.slides.cc5.CalcParser.NumContext;
import pp.slides.cc5.CalcParser.PlusContext;

public class VisitorCalc extends CalcBaseVisitor<Integer> {
	@Override
	public Integer visitDiv(DivContext ctx) {
		return visit(ctx.expr(0)) / visit(ctx.expr(1));
	}

	@Override
	public Integer visitMinus(MinusContext ctx) {
		return visit(ctx.expr(0)) - visit(ctx.expr(1));
	}

	@Override
	public Integer visitMult(MultContext ctx) {
		return visit(ctx.expr(0)) * visit(ctx.expr(1));
	}

	@Override
	public Integer visitNum(NumContext ctx) {
		return Integer.parseInt(ctx.getText());
	}

	@Override
	public Integer visitMain(MainContext ctx) {
		return visit(ctx.expr());
	}

	@Override
	public Integer visitPlus(PlusContext ctx) {
		return visit(ctx.expr(0)) + visit(ctx.expr(1));
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

	private static VisitorCalc calc = new VisitorCalc();

	public static int calculate(ParseTree tree) {
		return calc.visit(tree);
	}

	public static void main(String[] args) {
		int result = calculate(parse(args[0]));
		System.out.printf("%s = %d%n", args[0], result);
	}
}
