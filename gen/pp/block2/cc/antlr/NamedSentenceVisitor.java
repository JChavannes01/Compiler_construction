// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block2/cc/antlr\NamedSentence.g4 by ANTLR 4.7
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NamedSentenceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NamedSentenceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NamedSentenceParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(NamedSentenceParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modSubject}
	 * labeled alternative in {@link NamedSentenceParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModSubject(NamedSentenceParser.ModSubjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleSubject}
	 * labeled alternative in {@link NamedSentenceParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSubject(NamedSentenceParser.SimpleSubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link NamedSentenceParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(NamedSentenceParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link NamedSentenceParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(NamedSentenceParser.ModifierContext ctx);
}