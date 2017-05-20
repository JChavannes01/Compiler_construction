package pp.block1.cc.test;
import org.junit.Test;
import pp.block1.cc.antlr.Musical;

public class MusicalTest {
    private static LexerTester tester = new LexerTester(Musical.class);

    @Test
    public void succeedingTest() {
        tester.correct("La");
        tester.correct("Laaa    ");
        tester.correct("Laaa      Laa ");
        tester.correct("Laa Laaa LaaaaaaaaaaaaaaaaaaaaaaaaLi   ");

        tester.wrong("LaLaLi");
        tester.wrong("Laa LaaaLi   ");
        tester.wrong("LaLiLa");
        tester.wrong("LiLaLa");
        tester.wrong("Li");
        tester.wrong("LaLiLaLiLa");
        tester.wrong("Laaaa  LiLa");
        tester.wrong("L");
        tester.wrong("la");
        tester.wrong("li");
        tester.wrong("aLa");
    }

    @Test
    public void keywordsTest() {
        // the following is perfectly fine, so claiming it's wrong will fail
        tester.yields("La", Musical.SONG);
        tester.yields("LaLa", Musical.SONG);
        tester.yields("LaLaLaLi", Musical.SONG);

        tester.yields("LaLaLa", Musical.SONG, Musical.SONG);
        tester.yields("LaLaLaLaLaLi", Musical.SONG, Musical.SONG);
    }
}