package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.List;

public class MyErrorListener extends BaseErrorListener {
    private List<String> errors = new ArrayList<>();
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String error = "line " + line + ":" + charPositionInLine + " " + msg;
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }
}
