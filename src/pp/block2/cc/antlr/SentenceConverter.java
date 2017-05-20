package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;
import pp.block2.cc.*;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.Grammars;
import pp.block2.cc.ll.Sentence;

public class SentenceConverter 
		extends SentenceBaseListener implements Parser {
	/** Factory needed to create terminals of the {@link Sentence}
	 * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;

	/** Map from Antlr tree nodes to ASTs. */
	private ParseTreeProperty<AST> asts;
	private AST finalAST;
	private Grammar grammar;
	private int errorcount;

	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
	}

	@Override
	public void exitSentence(SentenceParser.SentenceContext ctx) {
		computeAST(ctx, "Sentence");
		this.finalAST = getAST(ctx);
	}

	@Override
	public void exitSubject(SentenceParser.SubjectContext ctx) {
		computeAST(ctx, "Subject");
	}

	@Override
	public void exitModifier(SentenceParser.ModifierContext ctx) {
		computeAST(ctx, "Modifier");
	}

	@Override
	public void exitObject(SentenceParser.ObjectContext ctx) {
		computeAST(ctx, "Object");
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		Token token = node.getSymbol();
		String name = fact.getTerminal(token.getType()).getName();
		Term term = new Term(token.getType(), name);
		setAST(node, new AST(term, node.getSymbol()));
	}

	public AST computeAST(ParseTree tree, String name) {
		NonTerm nt = grammar.getNonterminal(name);

		AST result = new AST(nt);
		for (int i = 0; i < tree.getChildCount(); i++) {
			result.addChild(getAST(tree.getChild(i)));
		}
		setAST(tree, result);
		return result;
	}

	private void setAST(ParseTree node, AST ast) {
		this.asts.put(node, ast);
	}

	private AST getAST(ParseTree child) {
		return this.asts.get(child);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		errorcount++;
	}

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.grammar = Grammars.makeSentence();
		this.asts = new ParseTreeProperty<>();
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		if (errorcount > 0) throw new ParseException("found the error!!");
		return finalAST; // TODO return root ast
	}

	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs

}
