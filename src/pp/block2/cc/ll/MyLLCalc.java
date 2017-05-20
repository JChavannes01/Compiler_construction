package pp.block2.cc.ll;

import org.antlr.v4.runtime.misc.OrderedHashSet;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

/**
 * Created by Janko on 5/3/2017.
 */
public class MyLLCalc implements LLCalc {

    private Grammar grammar;

    public MyLLCalc(Grammar g){
        this.grammar = g;
    }

    private Set<Term> getRHS(Map<Symbol, Set<Term>> first, List<Symbol> betas) {
        Set<Term> rhs = new HashSet<>(first.get(betas.get(0)));
        rhs.remove(Symbol.EMPTY);

        int i = 0;
        int k = betas.size();
        while (first.get(betas.get(i)).contains(Symbol.EMPTY) && i < k - 1){
            rhs.addAll(first.get(betas.get(i+1)));
            rhs.remove(Symbol.EMPTY);
            i++;
        }
        if (i == k - 1 && first.get(betas.get(i)).contains(Symbol.EMPTY)) {
            rhs.add(Symbol.EMPTY);
        }
        return rhs;
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        Map<Symbol, Set<Term>> first = new HashMap<>();
        // Add term, eof, eps to map.
        for (Term term : grammar.getTerminals()) {
            HashSet<Term> s = new HashSet();
            s.add(term);
            first.put(term, s);
        }

        // Add nonterms to map.
        for (NonTerm nt : grammar.getNonterminals()) {
            first.put(nt, new HashSet<>());
        }

        boolean changes_made = true;
        while (changes_made){
            changes_made = false;
            for (Rule r : grammar.getRules()) {
                List<Symbol> betas = r.getRHS();
                Set<Term> rhs = getRHS(first, betas);
                Set<Term> terminals = first.get(r.getLHS());
                changes_made = changes_made || terminals.addAll(rhs);
                first.put(r.getLHS(), terminals);
            }

        }
        return first;
    }

    public void printFirst() {
        Map<Symbol, Set<Term>> first = getFirst();
        System.out.println("First rules:");
        for (Map.Entry entry : first.entrySet()) {
            if (entry.getKey() instanceof NonTerm) {
                System.out.println(String.format("%2s %-5s = %s", "", entry.getKey(), entry.getValue()));
            }
        }
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        Map<Symbol, Set<Term>> first = getFirst();

        HashMap<NonTerm, Set<Term>> follow = new HashMap<>();

        for (NonTerm nt : grammar.getNonterminals()) {
            follow.put(nt, new HashSet<>());
        }

        HashSet<Term> tmp = new HashSet<>();
        tmp.add(Symbol.EOF);
        follow.put(grammar.getStart(), tmp);
        boolean changes_made = true;
        while (changes_made) {
            changes_made = false;
            for (Rule r : grammar.getRules()) {
                HashSet<Term> trailer = new HashSet<>(follow.get(r.getLHS()));
                List<Symbol> betas = r.getRHS();
                int k = betas.size();
                for (int i = k - 1; i >= 0; i--) {
                    Set<Term> first_bi = first.get(betas.get(i));
                    if (betas.get(i) instanceof NonTerm) {
                        HashSet<Term> temp = new HashSet<>(follow.get(betas.get(i)));
                        changes_made = changes_made || temp.addAll(trailer);
                        follow.put((NonTerm) betas.get(i), temp);
                        if (first_bi.contains(Symbol.EMPTY)) {
                            trailer.addAll(first_bi);
                            trailer.remove(Symbol.EMPTY);
                        } else {
                            trailer = new HashSet<>(first_bi);
                        }
                    } else {
                        trailer = new HashSet<>(first_bi);
                    }
                }
            }
        }
        return follow;
    }

    public void printFollow() {
        Map<NonTerm, Set<Term>> follow = getFollow();
        System.out.println("Follow rules:");
        for (Map.Entry entry : follow.entrySet()) {
            System.out.println(String.format("%2s %-5s = %s", "", entry.getKey(), entry.getValue()));
        }
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        Map<Symbol, Set<Term>> first = getFirst();
        Map<NonTerm, Set<Term>> follow = getFollow();

        Map<Rule, Set<Term>> firstp = new HashMap<>();
        for (Rule r : grammar.getRules()) {
            Symbol beta = r.getRHS().get(0);
            if (!first.get(beta).contains(Symbol.EMPTY)) {
                firstp.put(r, first.get(beta));
            } else {
                HashSet<Term> temp = new HashSet<>(first.get(beta));
                temp.addAll(follow.get(r.getLHS()));
                firstp.put(r, temp);
            }
        }
        return firstp;
    }

    public void printFirstp() {
        Map<Rule, Set<Term>> firstp = getFirstp();
        System.out.println("First plus rules:");
        for (Map.Entry entry : firstp.entrySet()) {
            System.out.println(String.format("%2s %-19s = %s", "", entry.getKey(), entry.getValue()));
        }
    }
    @Override
    public boolean isLL1() {
        Map<Rule, Set<Term>> firstp = getFirstp();
        Map<NonTerm, Set<Term>> result = new HashMap<>();
        for (NonTerm nt : grammar.getNonterminals()) {
            result.put(nt, new HashSet<>());
            for (Rule r : grammar.getRules(nt)) {
                Set<Term> temp_rule = firstp.get(r);
                Set<Term> temp_res = result.get(nt);
                for (Term t : temp_rule) {
                    if (temp_res.contains(t)) return false;
                }
                temp_res.addAll(temp_rule);
                result.put(nt, temp_res);
            }
        }
        return true;
    }
}
