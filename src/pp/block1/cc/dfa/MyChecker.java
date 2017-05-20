package pp.block1.cc.dfa;

import static pp.block1.cc.dfa.State.ID6_DFA;
/**
 * Created by Janko on 4/25/2017.
 */
public class MyChecker implements Checker {

    @Override
    public boolean accepts(State start, String word) {
        char chars[] = word.toCharArray();

        for (Character cha : chars) {
            //System.out.printf("char: %s current state: %d is_accepting: %s\n", cha, start.getNumber(), start.isAccepting());
            if (!start.hasNext(cha)) {
                return false;
            }
            start = start.getNext(cha);
        }
        return start.isAccepting();
    }
    /*
    public static void main(String[] args) {
        MyChecker checker = new MyChecker();
        State dfa;
        dfa = ID6_DFA;
        String text = "i12345";
        checker.accepts(dfa, text);
    }*/
}
