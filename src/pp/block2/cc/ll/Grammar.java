/**
 * 
 */
package pp.block2.cc.ll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

/**
 * Collection of rules with a start symbol.
 * @author Arend Rensink
 */
public class Grammar {
	private final NonTerm start;
	/** Collection of rules of this grammar. */
	private final List<Rule> rules;
	/** Mapping from known non-terminal names to the corresponding non-terminals. */
	private final Map<String, NonTerm> nonTermMap;
	/** Mapping from known non-terminals to the corresponding rule collections. */
	private final Map<NonTerm, List<Rule>> ruleMap;
	/** Sets of terminals occurring in the rules. */
	private final Set<Term> terminals;
	/** List of terminals, indexed by token type. */
	private final List<Term> termList;

	/** Constructs a grammar, with a given start symbol.
	 * Fill in the rules using {@link #addRule}.
	 */
	public Grammar(NonTerm start) {
		this.start = start;
		this.rules = new ArrayList<>();
		this.ruleMap = new LinkedHashMap<>();
		this.nonTermMap = new LinkedHashMap<>();
		this.nonTermMap.put(start.getName(), start);
		this.terminals = new HashSet<>();
		this.termList = new ArrayList<>();
	}

	/** Returns the start symbol of this grammar. */
	public NonTerm getStart() {
		return this.start;
	}

	/** Adds a rule to this grammar, consisting of a given LHS and
	 * a sequence of RHS symbols.
	 * For an empty RHS, just leave the RHS sequence empty
	 * (as in <code>addRule(elsePart)</code> for elsePart -> epsilon).
	 */
	public void addRule(NonTerm lhs, Symbol... rhs) {
		addRule(new Rule(lhs, rhs));
	}

	/** Adds a pre-constructed rule to this grammar. */
	public void addRule(Rule rule) {
		this.rules.add(rule);
		NonTerm lhs = rule.getLHS();
		List<Rule> lhsRules = this.ruleMap.get(lhs);
		if (lhsRules == null) {
			this.ruleMap.put(lhs, lhsRules = new ArrayList<>());
			this.nonTermMap.put(lhs.getName(), lhs);
		}
		lhsRules.add(rule);
		for (Symbol symbol : rule.getRHS()) {
			if (symbol instanceof Term) {
				Term term = (Term) symbol;
				this.terminals.add(term);
				int tokenType = term.getTokenType();
				if (tokenType != 0) {
					while (this.termList.size() <= tokenType) {
						this.termList.add(null);
					}
					Term oldTerm = this.termList.set(tokenType, term);
					assert oldTerm == null || oldTerm.equals(term) : String
							.format("Duplicate token '%s' and '%s' with type %d",
									oldTerm, term, tokenType);
				}
			}
		}
	}

	/** Returns all rules of this grammar. */
	public List<Rule> getRules() {
		return this.rules;
	}

	/** Returns the set of all nonterminals for which this grammar contains a rule. */
	public Set<NonTerm> getNonterminals() {
		return this.ruleMap.keySet();
	}

	/** Returns the nonterminal of a given name, if any. */
	public NonTerm getNonterminal(String name) {
		return this.nonTermMap.get(name);
	}

	/** Returns all rules corresponding to a given LHS symbol. */
	public List<Rule> getRules(NonTerm lhs) {
		return this.ruleMap.get(lhs);
	}

	/** Returns the set of all terminals in the RHSs of this grammar. */
	public Set<Term> getTerminals() {
		return this.terminals;
	}

	/** Returns the terminal for a given token type. */
	public Term getTerminal(int tokenType) {
		return this.termList.get(tokenType);
	}

	@Override
	public String toString() {
		return "Rules: " + getRules() + "; Start symbol: "
				+ getStart().getName();
	}
}
