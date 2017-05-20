/**
 * 
 */
package pp.block2.cc;

/**
 * Terminal symbol in a grammar rule.
 * @author Arend Rensink
 */
public class Term implements Symbol {
	private final String name;

	private final int tokenType;

	/** Creates a terminal with a given (Antlr) token type. */
	public Term(int tokenType, String name) {
		this.name = name;
		this.tokenType = tokenType;
	}

	/** Creates a terminal (without token type). */
	public Term(String name) {
		this(0, name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	/** Returns the (Antlr) token type of this terminal. */
	public int getTokenType() {
		return this.tokenType;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Term)) {
			return false;
		}
		Term other = (Term) obj;
		boolean result = this.name.equals(other.name);
		assert !result || this.tokenType == other.tokenType;
		return result;
	}
}
