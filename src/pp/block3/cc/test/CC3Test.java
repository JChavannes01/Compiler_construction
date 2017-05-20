package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.*;
import pp.block3.cc.antlr.CC3AttrParser.ExprContext;

import static org.junit.Assert.assertEquals;

public class CC3Test {
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final CC3Calculator calc = new CC3Calculator();

	@Test
	public void test() {
		// PLUS OPERATOR
		test(Type.BOOL, "false + true");
		test(Type.NUM, "2 + 3");
		test(Type.NUM, "(2+2) + (3+3)");
		test(Type.STR, "hello + world");

		test(Type.ERR, "hello + 3");
		test(Type.ERR, "hello + true");
		test(Type.ERR, "true + 3");

		// EQUAL OPERATOR
		test(Type.BOOL, "hello = world");
		test(Type.BOOL, "2 = 3");
		test(Type.BOOL, "true = false");

		test(Type.ERR, "hello = true");
		test(Type.ERR, "hello = 3");
		test(Type.ERR, "3 = true");

		// POWER OPERATOR
		test(Type.NUM, "2 ^ 3");
		test(Type.STR, "hello ^ 3");

		test(Type.ERR, "true ^ false");
		test(Type.ERR, "hello ^ true");
		test(Type.ERR, "hello ^ world");
		test(Type.ERR, "3 ^ true");


	}

	private void test(Type expected, String expr) {
		assertEquals(expected, parseCC3Attr(expr).val);
		ParseTree tree = parseCalc(expr);
		this.calc.init();
		this.walker.walk(this.calc, tree);
		assertEquals(expected, this.calc.getValue(tree));
	}

	private ParseTree parseCalc(String text) {
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CC3Lexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CC3Parser parser = new CC3Parser(tokens);
		return parser.t();
	}

	private ExprContext parseCC3Attr(String text) {
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CC3AttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CC3AttrParser parser = new CC3AttrParser(tokens);
		return parser.expr();
	}
}
