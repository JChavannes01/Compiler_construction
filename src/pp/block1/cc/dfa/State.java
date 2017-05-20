package pp.block1.cc.dfa;

import java.util.Map;
import java.util.TreeMap;

/**
 * State of a DFA.
 */
public class State {
	/** State number */
	private final int nr;

	/** Flag indicating if this state is accepting. */
	private final boolean accepting;

	/** Mapping to next states. */
	private final Map<Character, State> next;

	/**
	 * Constructs a new, possibly accepting state with a given number. The
	 * number is meant to identify the state, but there is no check for
	 * uniqueness.
	 */
	public State(int nr, boolean accepting) {
		this.next = new TreeMap<>();
		this.nr = nr;
		this.accepting = accepting;
	}

	/** Returns the state number. */
	public int getNumber() {
		return this.nr;
	}

	/** Indicates if the state is accepting. */
	public boolean isAccepting() {
		return this.accepting;
	}

	/**
	 * Adds an outgoing transition to a next state. This overrides any previous
	 * transition for that character.
	 */
	public void addNext(Character c, State next) {
		this.next.put(c, next);
	}

	/** Indicates if there is a next state for a given character. */
	public boolean hasNext(Character c) {
		return getNext(c) != null;
	}

	/**
	 * Returns the (possibly <code>null</code>) next state for a given
	 * character.
	 */
	public State getNext(Character c) {
		return this.next.get(c);
	}

	@Override
	public String toString() {
		String trans = "";
		for (Map.Entry<Character, State> out : this.next.entrySet()) {
			if (!trans.isEmpty()) {
				trans += ", ";
			}
			trans += "--" + out.getKey() + "-> " + out.getValue().getNumber();
		}
		return String.format("State %d (%s) with outgoing transitions %s",
				this.nr, this.accepting ? "accepting" : "not accepting", trans);
	}

	static final public State ID6_DFA;
	static {
		ID6_DFA = new State(0, false);
		State id61 = new State(1, false);
		State id62 = new State(2, false);
		State id63 = new State(3, false);
		State id64 = new State(4, false);
		State id65 = new State(5, false);
		State id66 = new State(6, true);
		State[] states = { ID6_DFA, id61, id62, id63, id64, id65, id66 };
		for (char c = 'a'; c < 'z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = 'A'; c < 'Z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = '0'; c < '9'; c++) {
			for (int s = 1; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
	}

	static final public State LALA_DFA;
	static {
		// Create and initiate all states
		LALA_DFA = new State(0, false);
		State lala1 = new State(1, false);
		State lala2 = new State(2, true);
		State lala3 = new State(3, true);
		State lala4 = new State(4, false);
		State lala5 = new State(5, true);
		State lala6 = new State(6, true);
		State lala7 = new State(7, false);
		State lala8 = new State(8, false);
		State lala9 = new State(9, false);
		State lala10 = new State(10, false);
		State lala11 = new State(11, true);
		State lala12 = new State(12, true);

		// Add transitions
		LALA_DFA.addNext('L', lala1);
		lala1.addNext('a', lala2);
		lala2.addNext('a', lala2);
		lala2.addNext(' ', lala3);
		lala2.addNext('L', lala4);
		lala3.addNext(' ', lala3);
		lala3.addNext('L', lala4);
		lala4.addNext('a', lala5);
		lala5.addNext('a', lala5);
		lala5.addNext(' ', lala6);
		lala5.addNext('L', lala7);
		lala6.addNext(' ', lala6);
		lala6.addNext('L', lala7);
		lala7.addNext('a', lala8);
		lala8.addNext('a', lala8);
		lala8.addNext(' ', lala9);
		lala8.addNext('L', lala10);
		lala9.addNext(' ', lala9);
		lala9.addNext('L', lala10);
		lala10.addNext('i', lala11);
		lala11.addNext(' ', lala12);
		lala12.addNext(' ', lala12);
	}
}
