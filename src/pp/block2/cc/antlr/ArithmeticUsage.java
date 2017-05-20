package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class ArithmeticUsage {
	public static void main(String[] args) {
		parse("5--3*2+1^4");
	}

	public static void parse(String text) {
		// Convert the input text to a character stream
		CharStream stream = CharStreams.fromString(text);
		// Build a lexer on top of the character stream
		Lexer lexer = new ArithmeticLexer(stream);
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		ArithmeticParser parser = new ArithmeticParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.start();
		// Print the (formatted) parse tree
		System.out.println(tree.toStringTree(parser));
	}
}
