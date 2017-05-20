// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/antlr\CC3Attr.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CC3AttrParser}.
 */
public interface CC3AttrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CC3AttrParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CC3AttrParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CC3AttrParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CC3AttrParser.ExprContext ctx);
}