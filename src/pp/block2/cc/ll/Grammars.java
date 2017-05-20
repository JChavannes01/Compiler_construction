/**
 * 
 */
package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence.g4 lexer grammar
		// Make sure you take the token constantss from the right class!
		SymbolFactory fact = new SymbolFactory(Sentence.class);
		Term noun = fact.getTerminal(Sentence.NOUN);
		Term verb = fact.getTerminal(Sentence.VERB);
		Term adj = fact.getTerminal(Sentence.ADJECTIVE);
		Term end = fact.getTerminal(Sentence.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}

	/** Returns a grammar for simple English sentences. */
	public static Grammar makeIf() {
		// Define the non-terminals
		NonTerm stat = new NonTerm("Stat");
		NonTerm elsePart = new NonTerm("ElsePart");
		// Define the terminals, using the Sentence.g4 lexer grammar
		// Make sure you take the token constantss from the right class!
		SymbolFactory fact = new SymbolFactory(If.class);
		Term assign = fact.getTerminal(If.ASSIGN);
		Term expr = fact.getTerminal(If.COND);
		Term elsee = fact.getTerminal(If.ELSE);
		Term iff = fact.getTerminal(If.IF);
		Term then = fact.getTerminal(If.THEN);
		// Build the context free grammar
		Grammar g = new Grammar(stat);
		g.addRule(stat, assign);
		g.addRule(stat, iff, expr, then, stat, elsePart);
		g.addRule(elsePart, elsee, stat);
		g.addRule(elsePart, Symbol.EMPTY);
		return g;
	}

	/** Returns a grammar for simple English sentences. */
	public static Grammar makeL() {
		// Define the non-terminals
		NonTerm l = new NonTerm("L");
		NonTerm r = new NonTerm("R");
		NonTerm rp = new NonTerm("R`");
		NonTerm q = new NonTerm("Q");
		NonTerm qp = new NonTerm("Q`");
		// Define the terminals, using the Sentence.g4 lexer grammar
		// Make sure you take the token constantss from the right class!
		SymbolFactory fact = new SymbolFactory(L.class);
		Term a = fact.getTerminal(L.A);
		Term b = fact.getTerminal(L.B);
		Term c = fact.getTerminal(L.C);
		// Build the context free grammar
		Grammar g = new Grammar(l);
		g.addRule(l, r, a);
		g.addRule(l, q, b, a);
		g.addRule(r, a, b ,a, rp);
		g.addRule(r, c, a, b ,a, rp);
		g.addRule(rp, b, c, rp);
		g.addRule(rp, Symbol.EMPTY);
		g.addRule(q, b, qp);
		g.addRule(qp, b, c);
		g.addRule(qp, c);
		return g;
	}
}
