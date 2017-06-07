package pp.block5.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import pp.block5.cc.ParseException;
import pp.block5.cc.SimplePascalCompiler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;

@SuppressWarnings("javadoc")
public class SimpleGeneratorTest {
	private final static String BASE_DIR = "src/pp/block5/cc/sample";
	private final static String EXT = ".pascal";
	private final SimplePascalCompiler compiler = SimplePascalCompiler
			.instance();

	@Test
	public void testBasic() throws IOException, ParseException {
		String file = "basic";
		Program prog = compile(file);
		System.out.println("===============================================");
		System.out.printf("Program %s%s.\n", file,EXT);
		System.out.println("===============================================");
		System.out.println(prog.prettyPrint() + '\n');
	}

	@Test
	public void testGCD() throws IOException, ParseException {
		String file = "gcd";
		Program prog = compile(file);
		System.out.println("===============================================");
		System.out.printf("Program %s%s.\n", file,EXT);
		System.out.println("===============================================");
		System.out.println(prog.prettyPrint() + '\n');
		String out = sim(prog, "3\n8");
		assertEquals("Greatest common divisor: 1", out.trim());
		out = sim(prog, "435\n1935");
		assertEquals("Greatest common divisor: 15", out.trim());
	}

	@Test
	public void testPrime() throws IOException, ParseException {
		String file = "prime";
		Program prog = compile(file);
		System.out.println("===============================================");
		System.out.printf("Program %s%s.\n", file,EXT);
		System.out.println("===============================================");
		System.out.println(prog.prettyPrint() +'\n');
		String out = sim(prog, "365");
		assertEquals("Divisor: 5", out.trim());
		out = sim(prog, "367");
		assertEquals("Is prime 0", out.trim());
	}

	@Test
	public void testGauss() throws IOException, ParseException {
		String file = "Gauss";
		Program prog = compile(file);
		System.out.println("===============================================");
		System.out.printf("Program %s%s.\n", file,EXT);
		System.out.println("===============================================");
		System.out.println(prog.prettyPrint() +'\n');
		String out = sim(prog, "10");
		assertEquals("Total = 55", out.trim());
	}

	private Program compile(String filename) throws IOException, ParseException {
		return this.compiler.compile(new File(BASE_DIR, filename + EXT));
	}

	private String sim(Program prog, String input) {
		Simulator sim = new Simulator(prog);
		sim.setIn(new ByteArrayInputStream(input.getBytes()));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sim.setOut(out);
		sim.run();
		return out.toString();
	}
}
