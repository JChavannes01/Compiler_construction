package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

public class LLCalcTest {
	Grammar sentenceG = Grammars.makeSentence();
	// Define the non-terminals
	NonTerm subj = sentenceG.getNonterminal("Subject");
	NonTerm obj = sentenceG.getNonterminal("Object");
	NonTerm sent = sentenceG.getNonterminal("Sentence");
	NonTerm mod = sentenceG.getNonterminal("Modifier");
	// Define the terminals
	Term adj = sentenceG.getTerminal(Sentence.ADJECTIVE);
	Term noun = sentenceG.getTerminal(Sentence.NOUN);
	Term verb = sentenceG.getTerminal(Sentence.VERB);
	Term end = sentenceG.getTerminal(Sentence.ENDMARK);
	// Now add the last rule, causing the grammar to fail
	Grammar sentenceXG = Grammars.makeSentence();
	{    sentenceXG.addRule(mod, mod, mod);
	}
	LLCalc sentenceXLL = createCalc(sentenceXG);

	Grammar ifG = Grammars.makeIf();
	// Define the non-terminals
	NonTerm stat = ifG.getNonterminal("Stat");
	NonTerm elsePart = ifG.getNonterminal("ElsePart");
	// Define the terminals (take from the right lexer grammar!)
	Term ifT = ifG.getTerminal(If.IF);
	Term assign = ifG.getTerminal(If.ASSIGN);
	Term expr = ifG.getTerminal(If.COND);
	Term elsee = ifG.getTerminal(If.ELSE);
	Term then = ifG.getTerminal(If.THEN);
	Term eof = Symbol.EOF;
	Term empty = Symbol.EMPTY;
	LLCalc ifLL = createCalc(ifG);

	Grammar lG = Grammars.makeL();
	// Define the non-terminals
	NonTerm l = lG.getNonterminal("L");
	NonTerm r = lG.getNonterminal("R");
	NonTerm rp = lG.getNonterminal("R`");
	NonTerm q = lG.getNonterminal("Q");
	NonTerm qp = lG.getNonterminal("Q`");
	// Define the terminals (take from the right lexer grammar!)
	Term a = lG.getTerminal(L.A);
	Term b = lG.getTerminal(L.B);
	Term c = lG.getTerminal(L.C);
	MyLLCalc lLL = (MyLLCalc) createCalc(lG);

	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testLFirst() {
		Map<Symbol, Set<Term>> first = lLL.getFirst();
		lLL.printFirst();
		System.out.println("========================================");
		assertEquals(set(a, b, c), first.get(l));
		assertEquals(set(a, c), first.get(r));
		assertEquals(set(b, empty), first.get(rp));
		assertEquals(set(b), first.get(q));
		assertEquals(set(b, c), first.get(qp));
	}

	@Test
	public void testLFollow() {
		Map<NonTerm, Set<Term>> follow = lLL.getFollow();
		lLL.printFollow();
		System.out.println("========================================");
		assertEquals(set(eof), follow.get(l));
		assertEquals(set(a), follow.get(r));
		assertEquals(set(a), follow.get(rp));
		assertEquals(set(b), follow.get(q));
		assertEquals(set(b), follow.get(qp));
	}

	@Test
	public void testLFirstPlus() {
		Map<Rule, Set<Term>> firstp = lLL.getFirstp();
		lLL.printFirstp();
		System.out.println("========================================");
		List<Rule> lRules = lG.getRules(l);
		List<Rule> rRules = lG.getRules(r);
		List<Rule> rpRules = lG.getRules(rp);
		List<Rule> qRules = lG.getRules(q);
		List<Rule> qpRules = lG.getRules(qp);
		assertEquals(set(a, c), firstp.get(lRules.get(0)));
		assertEquals(set(b), firstp.get(lRules.get(1)));
		assertEquals(set(a), firstp.get(rRules.get(0)));
		assertEquals(set(c), firstp.get(rRules.get(1)));
		assertEquals(set(b), firstp.get(rpRules.get(0)));
		assertEquals(set(a, empty), firstp.get(rpRules.get(1)));
		assertEquals(set(b), firstp.get(qRules.get(0)));
		assertEquals(set(b), firstp.get(qpRules.get(0)));
		assertEquals(set(c), firstp.get(qpRules.get(1)));
	}

	@Test
	public void testLLl1() {
		assertTrue(lLL.isLL1());
	}

	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testIfFirst() {
		Map<Symbol, Set<Term>> first = ifLL.getFirst();
		assertEquals(set(assign, ifT), first.get(stat));
		assertEquals(set(elsee, empty), first.get(elsePart));
	}

	@Test
	public void testIfFollow() {
		Map<NonTerm, Set<Term>> follow = ifLL.getFollow();
		assertEquals(set(eof, elsee), follow.get(stat));
		assertEquals(set(eof, elsee), follow.get(elsePart));
	}

	@Test
	public void testIfFirstPlus() {
		Map<Rule, Set<Term>> firstp = ifLL.getFirstp();
		List<Rule> statRules = ifG.getRules(stat);
		List<Rule> elseRules = ifG.getRules(elsePart);
		assertEquals(set(assign), firstp.get(statRules.get(0)));
		assertEquals(set(ifT), firstp.get(statRules.get(1)));
		assertEquals(set(elsee), firstp.get(elseRules.get(0)));
		assertEquals(set(eof, elsee, empty), firstp.get(elseRules.get(1)));
	}

	@Test
	public void testIfLl1() {
		assertFalse(ifLL.isLL1());
	}

	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testSentenceOrigLL1() {
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(sentenceG).isLL1());
	}

	@Test
	public void testSentenceXFirst() {
		Map<Symbol, Set<Term>> first = sentenceXLL.getFirst();
		assertEquals(set(adj, noun), first.get(sent));
		assertEquals(set(adj, noun), first.get(subj));
		assertEquals(set(adj, noun), first.get(obj));
		assertEquals(set(adj), first.get(mod));
	}
	
	@Test
	public void testSentenceXFollow() {
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = sentenceXLL.getFollow();
		assertEquals(set(Symbol.EOF), follow.get(sent));
		assertEquals(set(verb), follow.get(subj));
		assertEquals(set(end), follow.get(obj));
		assertEquals(set(noun, adj), follow.get(mod));
	}
	
	@Test
	public void testSentenceXFirstPlus() {
		// Test per rule
		Map<Rule, Set<Term>> firstp = sentenceXLL.getFirstp();
		List<Rule> subjRules = sentenceXG.getRules(subj);
		assertEquals(set(noun), firstp.get(subjRules.get(0)));
		assertEquals(set(adj), firstp.get(subjRules.get(1)));
	}
	
	@Test
	public void testSentenceXLL1() {
		assertFalse(sentenceXLL.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {

		 return new MyLLCalc(g); // TODO your implementation of LLCalc (Ex. 2-CC.3)
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
