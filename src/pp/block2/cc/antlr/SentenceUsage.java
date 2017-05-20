package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SentenceUsage {
	public static void main(String[] args) {
//		parse("all,smart undergraduate students love all compilers.");
//		parse("all students love love.");
		parse("students love students.");
		parse("all all students love students.");
		parse("all,smart,undergraduate students love students.");
	}

	public static void parse(String text) {
		// Convert the input text to a character stream
		CharStream stream = CharStreams.fromString(text);
		// Build a lexer on top of the character stream
		Lexer lexer = new NamedSentenceLexer(stream);
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		NamedSentenceParser parser = new NamedSentenceParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.sentence();
		// Print the (formatted) parse tree
		System.out.println(tree.toStringTree(parser));
	}
}
