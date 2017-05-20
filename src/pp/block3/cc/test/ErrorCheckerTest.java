package pp.block3.cc.test;

import org.junit.Before;
import org.junit.Test;
import pp.block3.cc.symbol.ErrorChecker;

import static org.junit.Assert.assertEquals;

public class ErrorCheckerTest {
    private ErrorChecker errorChecker;
    private String path = "src/pp/block3/cc/symbol/prog";

    @Before
    public void init() { this.errorChecker = new ErrorChecker();}

    @Test
    public void testDecl () {
        assertEquals(0, errorChecker.checkErrors(path + "1").size());
        assertEquals(1, errorChecker.checkErrors(path + "2").size());
        assertEquals(1, errorChecker.checkErrors(path + "3").size());
        assertEquals(2, errorChecker.checkErrors(path + "4").size());
        assertEquals(0, errorChecker.checkErrors(path + "5").size());
    }

}
