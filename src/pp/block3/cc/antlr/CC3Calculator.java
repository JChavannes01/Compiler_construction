package pp.block3.cc.antlr;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.block2.cc.ll.If;

public class CC3Calculator extends CC3BaseListener {
	/** Map storing the getValue attribute for all parse tree nodes. */
	private ParseTreeProperty<Type> vals;
	private boolean foundError;

	/** Initialises the calculator before using it to walk a tree. */
	public void init() {
		this.vals = new ParseTreeProperty<>();
	}

	@Override
	public void exitParT(CC3Parser.ParTContext ctx) {
		set(ctx, getValue(ctx.t()));
	}

	@Override
	public void exitEqualT(CC3Parser.EqualTContext ctx) {
		if (getValue(ctx.t(0)) == getValue(ctx.t(1))) {
			set(ctx, Type.BOOL);
		} else {
			set(ctx, Type.ERR);
		}
	}

	@Override
	public void exitPlusT(CC3Parser.PlusTContext ctx) {
		if (getValue(ctx.t(0)) == getValue(ctx.t(1))) {
			set(ctx, getValue(ctx.t(0)));
		} else {
			set(ctx, Type.ERR);
		}
	}

	@Override
	public void exitPowT(CC3Parser.PowTContext ctx) {
		Type t1 = getValue(ctx.t(0));
		Type t2 = getValue(ctx.t(1));

		if (t1 != Type.BOOL && t2 == Type.NUM) {
			set(ctx, t1);
		} else {
			set(ctx, Type.ERR);
		}
	}

	@Override
	public void exitBoolT(CC3Parser.BoolTContext ctx) {
		set(ctx, Type.BOOL);
	}

	@Override
	public void exitNumT(CC3Parser.NumTContext ctx) {
		set(ctx, Type.NUM);
	}

	@Override
	public void exitStrT(CC3Parser.StrTContext ctx) {
		set(ctx, Type.STR);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		foundError = true;
	}

	/** Sets the getValue attribute of a given node. */
	private void set(ParseTree node, Type val) {
		this.vals.put(node, val);
	}

	/** Retrieves the getValue attribute of a given node. */
	public Type getValue (ParseTree node) {
		return this.vals.get(node);
	}
}
