package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.*;
import pp.block2.cc.ParseException;

public class ArithmeticCalculator extends ArithmeticBaseListener{
	/** Map from Antlr tree nodes to ASTs. */
	private ParseTreeProperty<Double> values;
	/** Number of error nodes. */
	private boolean foundError;
	private double finalValue;

	public void calculate(String text) {
		this.values = new ParseTreeProperty<>();
		this.foundError = false;
		Lexer lexer = new ArithmeticLexer(CharStreams.fromString(text));
		ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.start();
		new ParseTreeWalker().walk(this, tree);
		if (!foundError) {
			System.out.println(text + " = " + finalValue);
		} else {
			System.err.println("Actual token did not match expected token in: " + text);
		}
	}
	@Override
	public void exitAddExpr(ArithmeticParser.AddExprContext ctx) {
		if (foundError) return;
		double left = getValue(ctx.getChild(0));
		double right = getValue(ctx.getChild(2));
		double result = left + right;
		setValue(ctx, result);
	}

	@Override
	public void exitMulExpr(ArithmeticParser.MulExprContext ctx) {
		if (foundError) return;
		double left = getValue(ctx.getChild(0));
		double right = getValue(ctx.getChild(2));
		double result = left * right;
		setValue(ctx, result);
	}

	@Override
	public void exitSubExpr(ArithmeticParser.SubExprContext ctx) {
		if (foundError) return;
		double left = getValue(ctx.getChild(0));
		double right = getValue(ctx.getChild(2));
		double result = left - right;
		setValue(ctx, result);
	}

	@Override
	public void exitPowExpr(ArithmeticParser.PowExprContext ctx) {
		if (foundError) return;
		double left = getValue(ctx.getChild(0));
		double right = getValue(ctx.getChild(2));
		double result = Math.pow(left, right);
		setValue(ctx, result);
	}

	@Override
	public void exitNumExpr(ArithmeticParser.NumExprContext ctx) {
		if (foundError) return;
		TerminalNode child0 = (TerminalNode) ctx.getChild(0);
		double result = Double.parseDouble(child0.getSymbol().getText());
		setValue(ctx, result);
	}

	@Override
	public void exitStart(ArithmeticParser.StartContext ctx) {
		if (foundError) return;
		finalValue =  getValue(ctx.getChild(0));
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}

	private void setValue(ParseTree node, double i) {
		this.values.put(node, i);
	}

	private double getValue(ParseTree node) {
		return this.values.get(node);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		this.foundError = true;
	}

	public static void main(String[] args) {
		ArithmeticCalculator counter = new ArithmeticCalculator();
		counter.calculate("3**2");
		counter.calculate("5--3*2+1^4");
		counter.calculate("1+2");
		counter.calculate("3*4+7^54");
		counter.calculate("-8^45-123*-42^2");
		counter.calculate("69*420^2-1337+3");
	}
}
