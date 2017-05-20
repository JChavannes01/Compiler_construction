// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block2/cc/antlr\Sentence.g4 by ANTLR 4.7
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SentenceParser}.
 */
public interface SentenceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SentenceParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(SentenceParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(SentenceParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSubject(SentenceParser.SubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSubject(SentenceParser.SubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SentenceParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(SentenceParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(SentenceParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SentenceParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(SentenceParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(SentenceParser.ModifierContext ctx);
}