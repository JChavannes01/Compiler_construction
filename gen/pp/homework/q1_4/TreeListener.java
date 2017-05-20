// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/homework/q1_4\Tree.g4 by ANTLR 4.7
package pp.homework.q1_4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TreeParser}.
 */
public interface TreeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TreeParser#top}.
	 * @param ctx the parse tree
	 */
	void enterTop(TreeParser.TopContext ctx);
	/**
	 * Exit a parse tree produced by {@link TreeParser#top}.
	 * @param ctx the parse tree
	 */
	void exitTop(TreeParser.TopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNumNode(TreeParser.NumNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNumNode(TreeParser.NumNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leftNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void enterLeftNode(TreeParser.LeftNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void exitLeftNode(TreeParser.LeftNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rightNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void enterRightNode(TreeParser.RightNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rightNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void exitRightNode(TreeParser.RightNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void enterBinNode(TreeParser.BinNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binNode}
	 * labeled alternative in {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void exitBinNode(TreeParser.BinNodeContext ctx);
}