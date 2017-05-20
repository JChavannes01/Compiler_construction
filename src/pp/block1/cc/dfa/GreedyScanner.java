package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janko on 4/26/2017.
 */
public class GreedyScanner implements Scanner{
    @Override
    public List<String> scan(State dfa, String text) {
        State state = dfa;
        char[] chars = text.toCharArray();
        List<String> tokens = new ArrayList<>();
        String token;
        int i = 0;
        int fi = 0;

        // Potential token vars
        int pot_i = 0;
        int pot_fi = 0;
        String pot_token;
        boolean pot_found = false;

        while (i < chars.length) {
            Character cha = chars[i];

            if (state.isAccepting()) {
                pot_i = i;
                pot_found = true;
            }

            if (state.hasNext(cha)){
                state = state.getNext(cha);
            } else {
                System.out.println("state has no next..");
                if (pot_found) {
                    pot_token = text.substring(pot_fi, pot_i);
                    System.out.println("Potential token added *" + pot_token);
                    tokens.add(pot_token);
                    pot_fi = i;
                    fi = i;
                    i = pot_i - 1;
                    state = dfa;
                    pot_found = false;
                } else {
                   return null;
                }
            }

            System.out.printf("char: %s current state: %d is_accepting: %s\n", cha, state.getNumber(), state.isAccepting());
            i++;
            if (i == chars.length && pot_found && !state.isAccepting()) {
                pot_token = text.substring(pot_fi, pot_i);
                System.out.println("End potential token added *" + pot_token);
                tokens.add(pot_token);
                i = pot_i;
                fi = i;
                state = dfa;
                pot_found = false;
            }
        }
        if (state.isAccepting()) {
            token = text.substring(fi, i);
            System.out.println("End token added *" + token);
            tokens.add(token);
        }

        System.out.println();
        return tokens;
    }
}
