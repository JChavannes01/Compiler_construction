package pp.iloc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import pp.iloc.eval.Machine;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpClaz;
import pp.iloc.model.OpCode;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

/**
 * ILOC program simulator
 * @author Arend Rensink
 */
public class Simulator {
	/** Representation of <code>true</code>. */
	public static final int TRUE = -1;
	/** Representation of <code>false</code>. */
	public static final int FALSE = 0;
	/** Flag controlling debug mode. */
	public static boolean DEBUG = false;

	static public void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: filename.iloc");
			return;
		}
		try {
			Program prog = Assembler.instance().assemble(new File(args[0]));
			new Simulator(prog).run();
		} catch (FormatException | IOException exc) {
			exc.printStackTrace();
		}
	}

	/** The simulated program. */
	private final Program prg;
	/** The virtual machine on which the program is run. */
	private final Machine vm;
	/** Flag signifying that the input is from stdin. */
	private boolean stdIn;
	/** The reader used for the in-operations. */
	private Scanner in;
	/** The print writer used for the out-operations. */
	private PrintStream out;

	/** Constructs a simulator for a given program and VM. */
	public Simulator(Program program, Machine vm) {
		assert program != null;
		assert vm != null;
		this.prg = program;
		this.vm = vm;
		this.out = System.out;
		this.in = new Scanner(System.in);
		this.stdIn = true;
	}

	/** Constructs a simulator for a given program and a fresh VM. */
	public Simulator(Program program) {
		this(program, new Machine());
	}

	/** Returns the program wrapped in this simulator. */
	public Program getProgram() {
		return this.prg;
	}

	/** Returns the Virtual Machine wrapped in this simulator. */
	public Machine getVM() {
		return this.vm;
	}

	/** Changes the input stream for the {@link OpCode#in}-operations. */
	public void setIn(InputStream in) {
		this.in = new Scanner(in);
		this.stdIn = false;
	}

	/** Changes the output stream for the {@link OpCode#out}-operations. */
	public void setOut(OutputStream out) {
		this.out = new PrintStream(out);
	}

	/** Runs the program. */
	public void run() {
		while (this.vm.getPC() < this.prg.size()) {
			step();
		}
	}

	/** Executes one operation of the program. */
	public void step() {
		Op o = this.prg.getOpAt(this.vm.getPC());
		OPContext c = new OPContext(o);
		Machine vm = this.vm;
		if (DEBUG) {
			System.out.printf("Op %d: %s%n", vm.getPC(), o);
			System.out.println(vm);
		}
		switch (o.getOpCode()) {
		case nop:
			// do nothing
			break;
		case add:
			c.setReg(2, c.reg(0) + c.reg(1));
			break;
		case sub:
			c.setReg(2, c.reg(0) - c.reg(1));
			break;
		case mult:
			c.setReg(2, c.reg(0) * c.reg(1));
			break;
		case div:
			c.setReg(2, c.reg(0) / c.reg(1));
			break;
		case addI:
			c.setReg(2, c.reg(0) + c.num(1));
			break;
		case subI:
			c.setReg(2, c.reg(0) - c.num(1));
			break;
		case rsubI:
			c.setReg(2, c.num(1) - c.reg(0));
			break;
		case multI:
			c.setReg(2, c.reg(0) * c.num(1));
			break;
		case divI:
			c.setReg(2, c.reg(0) / c.num(1));
			break;
		case rdivI:
			c.setReg(2, c.num(1) / c.reg(0));
			break;
		case lshift:
			c.setReg(2, c.num(0) << c.reg(1));
			break;
		case lshiftI:
			c.setReg(2, c.num(0) << c.num(1));
			break;
		case rshift:
			c.setReg(2, c.num(0) >>> c.reg(1));
			break;
		case rshiftI:
			c.setReg(2, c.num(0) >>> c.num(1));
			break;
		case and:
			c.setReg(2, -1 * c.reg(0) * c.reg(1));
			break;
		case andI:
			c.setReg(2, -1 * c.reg(0) * c.num(1));
			break;
		case or:
			c.setReg(2, Math.max(-1, c.reg(0) + c.reg(1)));
			break;
		case orI:
			c.setReg(2, Math.max(-1, c.reg(0) + c.num(1)));
			break;
		case xor:
			c.setReg(2, Math.max(-1, c.reg(0) ^ c.reg(1)));
			break;
		case xorI:
			c.setReg(2, Math.max(-1, c.reg(0) ^ c.num(1)));
			break;
		case load:
			c.setReg(1, vm.load(c.reg(0)));
			break;
		case loadI:
			c.setReg(1, c.num(0));
			break;
		case loadAI:
			c.setReg(2, vm.load(c.reg(0) + c.num(1)));
			break;
		case loadAO:
			c.setReg(2, vm.load(c.reg(0) + c.reg(1)));
			break;
		case store:
			vm.store(c.reg(0), c.reg(1));
			break;
		case storeAI:
			vm.store(c.reg(0), c.reg(1) + c.num(2));
			break;
		case storeAO:
			vm.store(c.reg(0), c.reg(1) + c.reg(2));
			break;
		case cload:
			c.setReg(1, vm.loadC(c.reg(0)));
			break;
		case cloadAI:
			c.setReg(2, vm.loadC(c.reg(0) + c.num(1)));
			break;
		case cloadAO:
			c.setReg(2, vm.loadC(c.reg(0) + c.reg(1)));
			break;
		case cstore:
			vm.storeC(c.reg(0), c.reg(1));
			break;
		case cstoreAI:
			vm.storeC(c.reg(0), c.reg(1) + c.num(2));
			break;
		case cstoreAO:
			vm.storeC(c.reg(0), c.reg(1) + c.reg(2));
			break;
		case i2i:
			c.setReg(1, c.reg(0));
			break;
		case i2c:
			c.setReg(1, (byte) c.reg(0));
			break;
		case c2i:
			c.setReg(1, (byte) c.reg(0));
			break;
		case c2c:
			c.setReg(1, (byte) c.reg(0));
			break;
		case cmp_LT:
			c.setReg(2, c.reg(0) < c.reg(1));
			break;
		case cmp_LE:
			c.setReg(2, c.reg(0) <= c.reg(1));
			break;
		case cmp_EQ:
			c.setReg(2, c.reg(0) == c.reg(1));
			break;
		case cmp_GE:
			c.setReg(2, c.reg(0) >= c.reg(1));
			break;
		case cmp_GT:
			c.setReg(2, c.reg(0) > c.reg(1));
			break;
		case cmp_NE:
			c.setReg(2, c.reg(0) != c.reg(1));
			break;
		case cbr:
			if (c.reg(0) == 0) {
				this.vm.setPC(c.label(2));
			} else {
				this.vm.setPC(c.label(1));
			}
			break;
		case jumpI:
			this.vm.setPC(c.label(0));
			break;
		case jump:
			this.vm.setPC(c.reg(0));
			break;
		case tbl:
			// do nothing
			break;
		case push:
			push(c.reg(0));
			break;
		case pop:
			c.setReg(0, pop());
			break;
		case cpush:
			pushC(c.reg(0));
			break;
		case cpop:
			c.setReg(0, popC());
			break;
		case in:
			String message = o.str(0).getText();
			if (this.stdIn) {
				this.out.print(message);
			}
			String in = this.in.nextLine();
			int val = Integer.MAX_VALUE;
			do {
				try {
					val = Integer.parseInt(in);
				} catch (NumberFormatException e) {
					// try again
					if (this.stdIn) {
						this.out.printf("Input '%s' should be a number%n", in);
						this.out.print(message);
						in = this.in.nextLine();
					} else {
						throw new IllegalArgumentException(String.format(
								"Input '%s' should be a number%n", in));
					}
				}
			} while (val == Integer.MAX_VALUE);
			c.setReg(1, val);
			break;
		case out:
			this.out.print(o.str(0).getText());
			this.out.println(c.reg(1));
			break;
		case cin:
			message = o.str(0).getText();
			if (this.stdIn) {
				this.out.print(message);
			}
			in = this.in.nextLine();
			pushString(in);
			break;
		case cout:
			this.out.print(o.str(0).getText());
			this.out.println(popString());
			break;
		case comment:
			// do nothing
			break;
		default:
			System.err.printf(
					"Error at line %d: Operation %s not yet implemented%n",
					o.getLine(), o.getOpCode());
			this.vm.incPC();
			return;
		}
		if (o.getClaz() != OpClaz.CONTROL) {
			this.vm.incPC();
		}
	}

	/** Pushes a 4-byte integer onto the stack. */
	private void push(int val) {
		int sp = this.vm.getReg(Machine.SP) - 4;
		this.vm.setReg(Machine.SP, sp);
		this.vm.store(val, sp);
	}

	/** Pushes a character onto the stack. */
	private void pushC(int val) {
		int sp = this.vm.getReg(Machine.SP) - this.vm.getCharSize();
		this.vm.setReg(Machine.SP, sp);
		this.vm.storeC(val, sp);
	}

	/** Pushes a string onto the stack.
	 * The string is represented by an integer length followed
	 * by the chars of the string, with first char on top .
	 */
	private void pushString(String text) {
		for (int i = text.length() - 1; i >= 0; i--) {
			pushC(text.charAt(i));
		}
		push(text.length());
	}

	/** Pops a 4-byte integer from the stack. */
	private int pop() {
		int sp = this.vm.getReg(Machine.SP);
		int result = this.vm.load(sp);
		this.vm.setReg(Machine.SP, sp + 4);
		return result;
	}

	/** Pops a character from the stack. */
	private int popC() {
		int sp = this.vm.getReg(Machine.SP);
		int result = this.vm.loadC(sp);
		this.vm.setReg(Machine.SP, sp + this.vm.getCharSize());
		return result;
	}

	/** Pops a string from the stack.
	 * The string should be represented by an integer length followed
	 * by the chars of the string, with first char on top.
	 * This method coerces all values to (Java) chars,
	 * so if {@link Machine#setCharSize(int)} has been set to 4 then
	 * all more significant bytes are lost
	 */
	private String popString() {
		StringBuilder result = new StringBuilder();
		int len = pop();
		for (int i = 0; i < len; i++) {
			result.append((char) popC());
		}
		return result.toString();
	}

	/** Operation context.
	 * This is a helper class for easy access to the underlying VM,
	 * given a particular operation.
	 */
	private class OPContext {
		private final Op op;

		OPContext(Op o) {
			this.op = o;
		}

		/** Sets a register of the processor to a given boolean value.
		 * The boolean is converted to {@link #TRUE} of {@link #FALSE}.
		 * @param regIx operand index of the register to be set
		 * @param val the boolean value
		 */
		public void setReg(int regIx, boolean val) {
			getVM().setReg(this.op.reg(regIx), val ? TRUE : FALSE);
		}

		/** Sets a register of the VM to a given integer value.
		 * @param regIx operand index of the register to be set
		 * @param val the value
		 */
		public void setReg(int regIx, int val) {
			getVM().setReg(this.op.reg(regIx), val);
		}

		/** Returns the value of a register of the VM.
		 * @param regIx operand index of the register to be returned
		 */
		public int reg(int regIx) {
			return getVM().getReg(this.op.reg(regIx));
		}

		/** Returns the value assigned to a numeric constant.
		 * @param numIx operand index of the num to be returned
		 */
		public int num(int numIx) {
			Num num = this.op.num(numIx);
			switch (num.getKind()) {
			case LAB:
				Label label = num.getLabel();
				int line = getProgram().getLine(label);
				if (line < 0) {
					System.err.println("Label '" + label
							+ "' does not occur in program");
				}
				return line;
			case LIT:
				return num.getValue();
			case SYMB:
				Integer result = getVM().getNum(num);
				if (result == null) {
					result = getProgram().getSymb(num);
					if (result == null) {
						System.err.println("Symbolic constant '"
								+ num.getName()
								+ "' not initialised in VM or program");
					}
				}
				return result;
			default:
				assert false;
				return 0;
			}
		}

		/** Returns the instruction number associated with a given label. */
		public int label(int ix) {
			return getProgram().getLine(this.op.label(ix));
		}
	}
}
