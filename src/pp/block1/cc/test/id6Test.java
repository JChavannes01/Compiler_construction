package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.id6;

public class id6Test {
	private static LexerTester tester = new LexerTester(id6.class);

	@Test
	public void succeedingTest() {
		tester.correct("a2c4e6");
		tester.correct("A2C4E6");
		tester.wrong("123456");
		tester.wrong("1");
	}

	@Test
	public void yieldCountTest() {
        tester.yields("a12345", id6.ID);
        tester.yields("a12345B67890", id6.ID, id6.ID);
    }
}
