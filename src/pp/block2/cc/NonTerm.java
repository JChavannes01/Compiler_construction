package pp.block2.cc;

/** 
 * Non-terminal symbol in a grammar.
 * @author Arend Rensink
 */
public class NonTerm implements Symbol {
	private final String name;

	/** Constructs a non-terminal with a given name. */
	public NonTerm(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
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
		} else if (!(obj instanceof NonTerm)) {
			return false;
		}
		NonTerm other = (NonTerm) obj;
		return this.name.equals(other.name);
	}
}
