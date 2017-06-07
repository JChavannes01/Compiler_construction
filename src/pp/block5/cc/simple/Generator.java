package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.iloc.Simulator;
import pp.iloc.model.*;

/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<Op> {
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
	/** The representation of the boolean value <code>true</code>. */
	public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

	/** The base register. */
	private Reg arp = new Reg("r_arp");
	/** The outcome of the checker phase. */
	private Result checkResult;
	/** Association of statement nodes to labels. */
	private ParseTreeProperty<Label> labels;
	/** The program being built. */
	private Program prog;
	/** Register count, used to generate fresh registers. */
	private int regCount;
	/** Association of expression and target nodes to registers. */
	private ParseTreeProperty<Reg> regs;

	/** Generates ILOC code for a given parse tree,
	 * given a pre-computed checker result.
	 */
	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		tree.accept(this);
		return this.prog;
	}

	// Override the visitor methods


	@Override
	public Op visitProgram(SimplePascalParser.ProgramContext ctx) {
		return visit(ctx.body());
	}

	@Override
	public Op visitBody(SimplePascalParser.BodyContext ctx) {
		return visit(ctx.block());
	}

	@Override
	public Op visitBlock(SimplePascalParser.BlockContext ctx) {
		Op result = visit(ctx.stat(0));
		for (int i = 1; i < ctx.stat().size(); i++) {
			visit(ctx.stat(i));
		}
		return result;
	}

	// Statements
	@Override
	public Op visitAssStat(SimplePascalParser.AssStatContext ctx) {
		Op result = visit(ctx.expr());

		Reg expr_reg = reg(ctx.expr());
		Num target_offset = offset(ctx.target());

		emit(OpCode.storeAI, expr_reg, arp, target_offset);
		return result;
	}

	@Override
	public Op visitIfStat(SimplePascalParser.IfStatContext ctx) {
		Op result = visit(ctx.expr());
		Label then_label = createLabel(ctx, "then");
		Label endif_label = createLabel(ctx, "endif");
		setReg(ctx, reg(ctx.expr()));

		if (ctx.ELSE() == null) {
			emit(OpCode.cbr, reg(ctx.expr()), then_label, endif_label);
			visit(ctx.stat(0)).setLabel(then_label);
		} else {
			Label else_label = createLabel(ctx, "else");
			emit(OpCode.cbr, reg(ctx.expr()), then_label, else_label);
			visit(ctx.stat(0)).setLabel(then_label);
			emit(OpCode.jumpI, endif_label);
			visit(ctx.stat(1)).setLabel(else_label);
		}
		emit(endif_label, OpCode.nop);
		return result;
	}

	@Override
	public Op visitWhileStat(SimplePascalParser.WhileStatContext ctx) {
		Label whilestart_label = createLabel(ctx, "while_start");
		Label whileblock_label = createLabel(ctx, "while_block");
		Label whileend_label = createLabel(ctx, "while_end");

		Op result = visit(ctx.expr());
		result.setLabel(whilestart_label);
		setReg(ctx, reg(ctx.expr()));

		emit(OpCode.cbr, reg(ctx.expr()), whileblock_label, whileend_label);
		visit(ctx.stat()).setLabel(whileblock_label);

		emit(OpCode.jumpI, whilestart_label);
		emit(whileend_label, OpCode.nop);
		return result;
	}

	@Override
	public Op visitInStat(SimplePascalParser.InStatContext ctx) {
		Reg target_reg = reg(ctx.target());
		Op result = emit(OpCode.in, new Str("In? "), target_reg);
		Num instat_offset = offset(ctx.target());
		emit(OpCode.storeAI, target_reg, arp, instat_offset);
		return result;
	}

	@Override
	public Op visitOutStat(SimplePascalParser.OutStatContext ctx) {
		Op result = visit(ctx.expr());
		emit(OpCode.out, new Str(ctx.STR().getText().replace("\"", "")), reg(ctx.expr()));
		return result;
	}

	// Expressions
	@Override
	public Op visitNumExpr(SimplePascalParser.NumExprContext ctx) {
		Num num = new Num(Integer.parseInt(ctx.NUM().getText()));
		return emit(OpCode.loadI, num, reg(ctx));
	}

	@Override
	public Op visitPrfExpr(SimplePascalParser.PrfExprContext ctx) {
		Op result = visit(ctx.expr());
		Reg expr = reg(ctx);
		Reg subexpr = reg(ctx.expr());

		if (ctx.prfOp().MINUS() != null) {
			emit(OpCode.rsubI, subexpr, new Num(0), expr);
		} else {
			emit(OpCode.xorI, subexpr, TRUE_VALUE, expr);
		}
		return result;
	}

	@Override
	public Op visitMultExpr(SimplePascalParser.MultExprContext ctx) {
		Op result = visit(ctx.expr(0));
		visit(ctx.expr(1));

		Reg expr1 = reg(ctx.expr(0));
		Reg expr2 = reg(ctx.expr(1));
		Reg expr = reg(ctx);

		if (ctx.multOp().STAR() != null) {
			emit(OpCode.mult, expr1, expr2, expr);
		} else {
			emit(OpCode.div, expr1, expr2, expr);
		}
		return result;
	}

	@Override
	public Op visitPlusExpr(SimplePascalParser.PlusExprContext ctx) {
		Op result = visit(ctx.expr(0));
		visit(ctx.expr(1));

		Reg expr1 = reg(ctx.expr(0));
		Reg expr2 = reg(ctx.expr(1));
		Reg expr = reg(ctx);

		if (ctx.plusOp().PLUS() != null) {
			emit(OpCode.add, expr1, expr2, expr);
		} else {
			emit(OpCode.sub, expr1, expr2, expr);
		}
		return result;
	}

	@Override
	public Op visitCompExpr(SimplePascalParser.CompExprContext ctx) {
		Op result = visit(ctx.expr(0));
		visit(ctx.expr(1));

		Reg expr1 = reg(ctx.expr(0));
		Reg expr2 = reg(ctx.expr(1));
		Reg expr = reg(ctx);

		if (ctx.compOp().LE() != null) {
			emit(OpCode.cmp_LE, expr1, expr2, expr);
		} else if (ctx.compOp().LT() != null) {
			emit(OpCode.cmp_LT, expr1, expr2, expr);
		} else if (ctx.compOp().GE() != null) {
			emit(OpCode.cmp_GE, expr1, expr2, expr);
		} else if (ctx.compOp().GT() != null) {
			emit(OpCode.cmp_GT, expr1, expr2, expr);
		} else if (ctx.compOp().EQ() != null) {
			emit(OpCode.cmp_EQ, expr1, expr2, expr);
		} else {
			emit(OpCode.cmp_NE, expr1, expr2, expr);
		}
		return result;
	}

	@Override
	public Op visitBoolExpr(SimplePascalParser.BoolExprContext ctx) {
		Op result = visit(ctx.expr(0));
		visit(ctx.expr(1));

		Reg expr1 = reg(ctx.expr(0));
		Reg expr2 = reg(ctx.expr(1));
		Reg expr = reg(ctx);

		if (ctx.boolOp().AND() != null) {
			emit(OpCode.and, expr1, expr2, expr);
		} else {
			emit(OpCode.or, expr1, expr2, expr);
		}
		return result;
	}

	@Override
	public Op visitParExpr(SimplePascalParser.ParExprContext ctx) {
		setReg(ctx, reg(ctx.expr()));
		return visit(ctx.expr());
	}

	@Override
	public Op visitIdExpr(SimplePascalParser.IdExprContext ctx) {
		return emit(OpCode.loadAI, arp, offset(ctx), reg(ctx));
	}

	@Override
	public Op visitTrueExpr(SimplePascalParser.TrueExprContext ctx) {
		return emit(OpCode.loadI, TRUE_VALUE, reg(ctx));
	}

	@Override
	public Op visitFalseExpr(SimplePascalParser.FalseExprContext ctx) {
		return emit(OpCode.loadI, FALSE_VALUE, reg(ctx));
	}




	/** Constructs an operation from the parameters
	 * and adds it to the program under construction. */
	private Op emit(Label label, OpCode opCode, Operand... args) {
		Op result = new Op(label, opCode, args);
		this.prog.addInstr(result);
		return result;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		return emit((Label) null, opCode, args);
	}

	/** 
	 * Looks up the label for a given parse tree node,
	 * creating it if none has been created before.
	 * The label is actually constructed from the entry node
	 * in the flow graph, as stored in the checker result.
	 */
	private Label label(ParserRuleContext node) {
		Label result = this.labels.get(node);
		if (result == null) {
			ParserRuleContext entry = this.checkResult.getEntry(node);
			result = createLabel(entry, "n");
			this.labels.put(node, result);
		}
		return result;
	}

	/** Creates a label for a given parse tree node and prefix. */
	private Label createLabel(ParserRuleContext node, String prefix) {
		Token token = node.getStart();
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		String result = prefix + "_" + line + "_" + column;
		return new Label(result);
	}

	/** Retrieves the offset of a variable node from the checker result,
	 * wrapped in a {@link Num} operand. */
	private Num offset(ParseTree node) {
		return new Num(this.checkResult.getOffset(node));
	}

	/** Returns a register for a given parse tree node,
	 * creating a fresh register if there is none for that node. */
	private Reg reg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			result = new Reg("r_" + this.regCount);
			this.regs.put(node, result);
			this.regCount++;
		}
		return result;
	}

	/** Assigns a register to a given parse tree node. */
	private void setReg(ParseTree node, Reg reg) {
		this.regs.put(node, reg);
	}
}
