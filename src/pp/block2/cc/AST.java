package pp.block2.cc;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

/**
 * Abstract Syntax Tree.
 * The tree consists of a root symbol and children.
 * If the root symbol is a terminal, there cannot be any children.
 * @author Arend Rensink
 */
public class AST {
	private final Symbol symbol;

	private final String text;

	private final Token token;

	private final List<AST> children;

	/** Constructs an AST with a non-terminal as root.
	 * Children should be added later.
	 */
	public AST(NonTerm symbol) {
		this.symbol = symbol;
		this.text = symbol.getName();
		this.token = null;
		this.children = new ArrayList<>();
	}

	/** 
	 * Constructs an AST with a terminal as root and a given token instance.
	 * The token types have to coincide. 
	 */
	public AST(Term symbol, Token token) {
		assert symbol.getTokenType() == token.getType();
		this.symbol = symbol;
		this.text = token.getText();
		this.token = token;
		this.children = null;
	}

	/** Tests if the root of this AST is a terminal
	 * (meaning that the AST can have no children). 
	 */
	public boolean isTerminal() {
		return getSymbol() instanceof Term;
	}

	/** Returns the (terminal or non-terminal) symbol at the root. */
	public Symbol getSymbol() {
		return this.symbol;
	}

	/** Returns the text of this node.
	 * This is either the nonterminal's name, or the terminal's token text.
	 */
	public String getText() {
		return this.text;
	}

	/** Returns the token in this node.
	 * @return <code>null</code> if this node is a non-terminal;
	 * the terminal token otherwise.
	 */
	public Token getToken() {
		return this.token;
	}

	/** Adds a child node to this root.
	 * This is only allowed if the root is a non-terminal node.
	 */
	public void addChild(AST child) {
		assert !isTerminal();
		if (child != null) {
			this.children.add(child);
		}
	}

	/** Returns the list of children of this node.
	 * @return the list of children, or <code>null</code> if this
	 * is a terminal node.
	 */
	public List<AST> getChildren() {
		return this.children;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		toString(s, null, "");
		return s.toString();
	}

	/** Auxiliary method to build a string representation of this tree. */
	private void toString(StringBuilder s, String prefix1, String prefix2) {
		if (prefix1 != null) {
			s.append(prefix1);
			s.append(" +--");
		}
		if (isTerminal()) {
			s.append(getSymbol());
			s.append("='");
			s.append(getText());
			s.append("'\n");
		} else {
			s.append(getText());
			s.append('\n');
			prefix1 = prefix1 == null ? prefix2 : prefix1 + prefix2;
			AST prevChild = null;
			for (AST child : getChildren()) {
				if (prevChild != null) {
					prevChild.toString(s, prefix1, " |  ");
				}
				prevChild = child;
			}
			if (prevChild != null) {
				prevChild.toString(s, prefix1, "    ");
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.children == null) ? 0 : this.children.hashCode());
		result = prime * result + this.symbol.hashCode();
		result = prime * result + this.text.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AST)) {
			return false;
		}
		AST other = (AST) obj;
		if (this.children == null) {
			if (other.children != null) {
				return false;
			}
		} else if (!this.children.equals(other.children)) {
			return false;
		}
		if (!this.symbol.equals(other.symbol)) {
			return false;
		}
		if (!this.text.equals(other.text)) {
			return false;
		}
		return true;
	}
}
