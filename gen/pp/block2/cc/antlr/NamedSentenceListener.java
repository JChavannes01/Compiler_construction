// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block2/cc/antlr\NamedSentence.g4 by ANTLR 4.7
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NamedSentenceParser}.
 */
public interface NamedSentenceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NamedSentenceParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(NamedSentenceParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NamedSentenceParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(NamedSentenceParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modSubject}
	 * labeled alternative in {@link NamedSentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterModSubject(NamedSentenceParser.ModSubjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modSubject}
	 * labeled alternative in {@link NamedSentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitModSubject(NamedSentenceParser.ModSubjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleSubject}
	 * labeled alternative in {@link NamedSentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSubject(NamedSentenceParser.SimpleSubjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleSubject}
	 * labeled alternative in {@link NamedSentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSubject(NamedSentenceParser.SimpleSubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link NamedSentenceParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(NamedSentenceParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link NamedSentenceParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(NamedSentenceParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link NamedSentenceParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(NamedSentenceParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NamedSentenceParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(NamedSentenceParser.ModifierContext ctx);
}