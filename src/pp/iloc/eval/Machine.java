package pp.iloc.eval;

import java.util.HashMap;
import java.util.Map;

import pp.iloc.model.Num;
import pp.iloc.model.Reg;

/**
 * Virtual machine for ILOC program evaluation.
 * @author Arend Rensink
 */
public class Machine {
	/** Size of an integer values (in bytes). */
	public static final int INT_SIZE = 4;
	/** Default size of a char value (in bytes).
	 * The actual size used in a particular Machine instance
	 * can be set using {@link #setCharSize(int)}
	 */
	public static final int DEFAULT_CHAR_SIZE = 1;
	/** Size of an integer values (in bits). */
	public static final int BYTE_SIZE = 8;
	/** Name of the allocation pointer register.
	 * This is initialised to start at address 0.
	 */
	public static final String ARP = "r_arp";
	/** The allocation pointer register (see {@link #ARP}). */
	public static final Reg ARP_REG = new Reg(ARP);
	/** Name of the stack pointer register.
	 * This is initialised to start at the top of memory. 
	 */
	public static final String SP = "sp";
	/** The stack pointer register (see {@link #SP}). */
	public static final Reg SP_REG = new Reg(SP);

	/** The actual size of a char value in this machine.
	 * Typically, either 1 (as per {@link #DEFAULT_CHAR_SIZE})
	 * or 4 (the same as {@link #INT_SIZE}).
	 * This affects the implementation of {@link #loadC} and
	 * {@link #storeC}.
	 */
	private int charSize;
	/** Mapping from register names to register numbers. */
	private final Map<String, Integer> registers;
	/** Mapping from symbolic constants to actual values. */
	private final Map<Num, Integer> symbMap;
	/** Memory of the machine. */
	private final Memory memory;
	/** Counter of reserved memory cells. */
	private int reserved;
	/** Program counter. */
	private int pc;

	/** Constructs a new, initially empty machine 
	 * with default-sized memory. */
	public Machine() {
		this.symbMap = new HashMap<>();
		this.memory = new Memory();
		this.registers = new HashMap<>();
		this.charSize = DEFAULT_CHAR_SIZE;
		clear();
	}

	/** Reinitialises the machine memory to a certain size (in bytes).
	 * This also resets the stack pointer (to the top of the memory).
	 * @param size
	 */
	public void setSize(int size) {
		this.memory.setSize(size);
		setReg(SP_REG, size);
	}

	/** Sets the size used to store a char value. 
	 * @param charSize the number of bytes used to store a char
	 * value; between 1 and 4 (inclusive)
	 */
	public void setCharSize(int charSize) {
		if (charSize < 1 || charSize > 4) {
			throw new IllegalArgumentException("Illegal character size: "
					+ charSize);
		}
		this.charSize = charSize;
	}

	/** Returns the size used to store a char value.
	 * This is equal to {@link #DEFAULT_CHAR_SIZE} unless
	 * changed by a call to {@link #setCharSize} */
	public int getCharSize() {
		return this.charSize;
	}

	/** Reserves a memory segment of given length.
	 * @param length (in bytes) of the segment to be reserved
	 * @return the base address of the allocated block
	 * @see #alloc(String, int)
	 */
	public int alloc(int length) {
		int result = this.reserved;
		for (int i = 0; i < length; i++) {
			this.memory.set(result + i, (byte) 0);
		}
		this.reserved += length;
		return result;
	}

	/** Reserves a memory segment of a given length (in bytes),
	 * assigns the base address to a symbolic constant,
	 * and returns the base address.
	 * The reserved memory is guaranteed to be unshared and
	 * initialized to 0.
	 * @param cst the name for the start address of the allocated memory
	 * @param length length (in bytes) of the segment to be reserved
	 * @return the allocated start address
	 * @throws IllegalArgumentException if the symbolic name is known
	 */
	public int alloc(String cst, int length) {
		if (this.symbMap.get(new Num(cst)) != null) {
			throw new IllegalArgumentException("Duplicate symbolic name '"
					+ cst + "'");
		}
		int result = alloc(length);
		setNum(cst, result);
		return result;
	}

	/** Initializes a memory segment of a length sufficient to
	 * accommodate a given list of initial values,
	 * assigns the start address to a symbolic name,
	 * and returns the start address.
	 * The reserved memory is guaranteed to be unshared.
	 * @param cst the name for the start address of the allocated memory
	 * @param vals the initial values 
	 * @return the allocated start address
	 * @throws IllegalArgumentException if the symbolic name is known
	 */
	public int init(String cst, int... vals) {
		if (this.symbMap.get(new Num(cst)) != null) {
			throw new IllegalArgumentException("Duplicate symbolic name '"
					+ cst + "'");
		}
		int result = alloc(vals.length * INT_SIZE);
		setNum(cst, result);
		for (int i = 0; i < vals.length; i++) {
			store(vals[i], result + INT_SIZE * i);
		}
		return result;
	}

	/** Declares a register with a given name, and sets its value to 0. */
	public void declare(String reg) {
		setReg(reg, 0);
	}

	/** Sets the value of a register with a given name to a given number. */
	public void setReg(String reg, int val) {
		this.registers.put(reg, val);
	}

	/** Sets the value of a given register to a given number. */
	public void setReg(Reg reg, int val) {
		this.registers.put(reg.getName(), val);
	}

	/** Returns the current value in a register with a given name.
	 * @throws IllegalArgumentException if no such register exists */
	public int getReg(String name) {
		Integer result = this.registers.get(name);
		if (result == null) {
			throw new IllegalArgumentException("Unknown register '" + name
					+ "'");
		}
		return result;
	}

	/** Returns the current value in a given register. */
	public int getReg(Reg reg) {
		return getReg(reg.getName());
	}

	/** Sets the value of a given named symbolic constant.
	 * @param name symbolic name, without '@'-prefix
	 * @throws IllegalArgumentException if the name is already declared
	 */
	public void setNum(String name, int val) {
		Num symbol = new Num(name);
		Integer oldVal = this.symbMap.put(symbol, val);
		if (oldVal != null) {
			throw new IllegalArgumentException("Duplicate symbol '" + symbol
					+ "': values " + oldVal + " and " + val);
		}
	}

	/** Returns the value of a given symbolic numeric value.
	 * @return the corresponding value, or <code>null</code> if
	 * the symbol is not defined.
	 */
	public Integer getNum(Num symb) {
		return this.symbMap.get(symb);
	}

	/** Convenience method to returns the value of a given symbolic constant.
	 * @param name symbolic name without '@'-prefix
	 * @throws IllegalArgumentException if the name is not declared 
	 * @see #getNum(Num)
	 */
	public Integer getNum(String name) {
		return getNum(new Num(name));
	}

	/** Returns the integer value starting at a given memory location.
	 * The value is computed from the four successive bytes starting
	 * at that location (most significant first).
	 */
	public int load(int loc) {
		return load(loc, INT_SIZE);
	}

	/** Returns the char value at a given memory location.
	 * This consists of a number of successive bytes determined
	 * by #getCharSize().
	 */
	public int loadC(int loc) {
		return 0xFF & load(loc, getCharSize());
	}

	/** Returns the integer value starting at a given memory location,
	 * consisting of 1 through 4 consecutive bytes.
	 * The value is computed from the successive bytes starting
	 * at that location (most significant first).
	 */
	private int load(int loc, int size) {
		int result = 0;
		for (int i = 0; i < size; i++) {
			result <<= BYTE_SIZE;
			result += 0xFF & this.memory.get(loc + i);
		}
		return result;
	}

	/** Stores an integer value in memory, starting at a given location.
	 * The value is stored at the four successive bytes starting
	 * at that location (most significant first).
	 */
	public void store(int val, int loc) {
		store(val, loc, INT_SIZE);
	}

	/** Stores a character in memory,
	 * at a given location.
	 * The number of bytes used is determined by {@link #getCharSize()}.
	 */
	public void storeC(int val, int loc) {
		store((char) val, loc, getCharSize());
	}

	/** Stores an integer value in memory, starting at a given location.
	 * The value is stored at the 1-4 successive bytes starting
	 * at that location (most significant first).
	 */
	private void store(int val, int loc, int len) {
		for (int i = len - 1; i >= 0; i--) {
			this.memory.set(loc + i, (byte) val);
			val >>= BYTE_SIZE;
		}
	}

	/** Returns the current program counter value. */
	public int getPC() {
		return this.pc;
	}

	/** Increases the current program counter value. */
	public void incPC() {
		this.pc++;
	}

	/** sets the program counter to a given line number. */
	public void setPC(int line) {
		if (line < 0) {
			throw new IllegalArgumentException("Trying to jump to line " + line);
		}
		this.pc = line;
	}

	/** Clears the registers, constants, memory and PC. */
	public void clear() {
		this.registers.clear();
		this.symbMap.clear();
		this.memory.clear();
		this.pc = 0;
		setReg(ARP_REG, 0);
		setReg(SP_REG, this.memory.size());
	}

	@Override
	public String toString() {
		return String.format("Registers: %s%nConstants: %s%nMemory: %s%n",
				this.registers, this.symbMap, this.memory);
	}
}
