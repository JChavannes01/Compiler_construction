package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janko on 4/25/2017.
 */
public class MyScanner implements Scanner {
    @Override
    public List<String> scan(State dfa, String text) {
        State state = dfa;
        char[] chars = text.toCharArray();
        List<String> tokens = new ArrayList<String>();
        String token = "";
        if (chars.length > 0) {
            System.out.println("chars *" + new String(chars) + "* first char *" + chars[0]);
        }

        for (Character cha : chars) {
            //System.out.printf("char: %s current state: %d is_accepting: %s\n", cha, start.getNumber(), start.isAccepting());
            if (!state.hasNext(cha)) {
                return null;

            }
            state = state.getNext(cha);
            token += cha;
            if (state.isAccepting()) {
                tokens.add(token);
                token = "";
                state = dfa;
            }
        }
        return tokens;
    }
}
