package pp.block4.cc.iloc;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.iloc.Simulator;
import pp.iloc.model.*;

/** Compiler from Calc.g4 to ILOC. */
public class CalcCompiler extends CalcBaseListener {
	/** Program under construction. */
	private Program prog;
	// Attribute maps and other fields
	private int register_count;
	private ParseTreeProperty<Reg> register_names;

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.complete();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
		this.prog = new Program();
		this.register_count = 0;
		this.register_names = new ParseTreeProperty<>();

		new ParseTreeWalker().walk(this, tree);
		System.out.println(prog.prettyPrint());
		return prog;
	}

	@Override
	public void exitComplete(CalcParser.CompleteContext ctx) {
		Reg reg = register_names.get(ctx.expr());
		Str str = new Str("Outcome: ");
		emit(OpCode.out, str, reg);
	}

	@Override
	public void exitTimes(CalcParser.TimesContext ctx) {
		Reg reg = new Reg("r_" + register_count);
		Reg reg1 = register_names.get(ctx.expr(0));
		Reg reg2 = register_names.get(ctx.expr(1));

		emit(OpCode.mult, reg1, reg2, reg);
		register_names.put(ctx, reg);
		register_count++;
	}

	@Override
	public void exitMinus(CalcParser.MinusContext ctx) {
		Reg reg = new Reg("r_" + register_count);
		Reg reg1 = register_names.get(ctx.expr());
		Num num = new Num(0);

		emit(OpCode.rsubI, reg1, num, reg);
		register_names.put(ctx, reg);
		register_count++;
	}

	@Override
	public void exitPlus(CalcParser.PlusContext ctx) {
		Reg reg = new Reg("r_" + register_count);
		Reg reg1 = register_names.get(ctx.expr(0));
		Reg reg2 = register_names.get(ctx.expr(1));

		emit(OpCode.add, reg1, reg2, reg);
		register_names.put(ctx, reg);
		register_count++;
	}

	@Override
	public void exitPar(CalcParser.ParContext ctx) {
		Reg child = register_names.get(ctx.expr());
		register_names.put(ctx, child);
	}

	@Override
	public void exitNumber(CalcParser.NumberContext ctx) {
		Reg reg = new Reg("r_" + register_count);

		int val = Integer.parseInt(ctx.NUMBER().getText());
		System.out.println("val = " + val);
		Num num = new Num(val);

		emit(OpCode.loadI, num, reg);
		register_names.put(ctx, reg);
		register_count++;
	}

	/** Constructs an operation from the parameters
	 * and adds it to the program under construction. */
	private void emit(OpCode opCode, Operand... args) {
		this.prog.addInstr(new Op(opCode, args));
	}

	/** Calls the compiler, and simulates and prints the compiled program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [expr]+");
			return;
		}
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : args) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}
}
