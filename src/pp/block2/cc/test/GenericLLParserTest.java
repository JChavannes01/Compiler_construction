package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.junit.Test;

import pp.block2.cc.AST;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.ll.GenericLLParser;
import pp.block2.cc.ll.Grammars;
import pp.block2.cc.ll.Sentence;
import pp.block2.cc.ll.SentenceParser;

public class GenericLLParserTest {
	private Parser parser1;
	private Parser parser2;

	private Class<? extends Lexer> lexerType;

	@Test
	public void testSentence() {
		this.lexerType = Sentence.class;
		this.parser1 = new SentenceParser();
		this.parser2 = new GenericLLParser(Grammars.makeSentence());
		compare("students love students.");
		compare("all undergraduate students love all compilers.");
		fails("all undergraduate students love all compilers");
		fails("all undergraduate students love love.");
		fails("all undergraduate students all compilers.");
	}

	private void fails(String text) {
		try {
			this.parser1.parse(scan(text));
			fail(String.format("Parsing '%s' should have failed but didn't",
					text));
		} catch (ParseException e) {
			// success
		}
		try {
			this.parser2.parse(scan(text));
			fail(String.format("Parsing '%s' should have failed but didn't",
					text));
		} catch (ParseException e) {
			// success
		}
	}

	private void compare(String text) {
		AST ast1 = parse(this.parser1, text);
		AST ast2 = parse(this.parser2, text);
		assertEquals(ast1, ast2);
	}

	private AST parse(Parser parser, String text) {
		AST result = null;
		try {
			result = parser.parse(scan(text));
		} catch (ParseException e) {
			fail(e.getMessage());
		}
		return result;
	}

	/** Converts a text into a token stream, using the preset lexer type. */
	private Lexer scan(String text) {
		Lexer result = null;
		CharStream stream = CharStreams.fromString(text);
		try {
			Constructor<? extends Lexer> lexerConstr = this.lexerType
					.getConstructor(CharStream.class);
			result = lexerConstr.newInstance(stream);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			// should never occur, as all Antlr-generated lexers are
			// well-behaved
			e.printStackTrace();
		}
		return result;
	}
}
