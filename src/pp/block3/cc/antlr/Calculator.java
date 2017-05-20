package pp.block3.cc.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import pp.block3.cc.antlr.CalcParser.NumberContext;
import pp.block3.cc.antlr.CalcParser.ParContext;
import pp.block3.cc.antlr.CalcParser.PlusContext;
import pp.block3.cc.antlr.CalcParser.TimesContext;

public class Calculator extends CalcBaseListener {
	/** Map storing the getValue attribute for all parse tree nodes. */
	private ParseTreeProperty<Integer> vals;

	/** Initialises the calculator before using it to walk a tree. */
	public void init() {
		this.vals = new ParseTreeProperty<>();
	}

	@Override
	public void exitPar(ParContext ctx) {
		set(ctx, val(ctx.expr()));
	}

	@Override
	public void exitMinus(CalcParser.MinusContext ctx) {
		set(ctx, val(ctx.expr(0)) - val(ctx.expr(1)));
	}

	@Override
	public void exitNegNumber(CalcParser.NegNumberContext ctx) {
		set(ctx, Integer.parseInt(ctx.getText()));
		System.out.println("[Calculator.java] Found negative number *" + ctx.getText());
	}

	@Override
	public void exitNumber(NumberContext ctx) {
		set(ctx, Integer.parseInt(ctx.NUMBER().getText()));
	}

	@Override
	public void exitTimes(TimesContext ctx) {
		set(ctx, val(ctx.expr(0)) * val(ctx.expr(1)));
	}

	@Override
	public void exitPlus(PlusContext ctx) {
		set(ctx, val(ctx.expr(0)) + val(ctx.expr(1)));
	}

	/** Sets the getValue attribute of a given node. */
	private void set(ParseTree node, int val) {
		this.vals.put(node, val);
	}

	/** Retrieves the getValue attribute of a given node. */
	public int val(ParseTree node) {
		return this.vals.get(node);
	}
}
