// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/homework/q1_4\Tree.g4 by ANTLR 4.7
package pp.homework.q1_4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TreeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TreeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TreeParser#top}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop(TreeParser.TopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumNode(TreeParser.NumNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leftNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftNode(TreeParser.LeftNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rightNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightNode(TreeParser.RightNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinNode(TreeParser.BinNodeContext ctx);
}