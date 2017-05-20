// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/antlr\CC3.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CC3Parser}.
 */
public interface CC3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code boolT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterBoolT(CC3Parser.BoolTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitBoolT(CC3Parser.BoolTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterStrT(CC3Parser.StrTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitStrT(CC3Parser.StrTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterParT(CC3Parser.ParTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitParT(CC3Parser.ParTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterPlusT(CC3Parser.PlusTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitPlusT(CC3Parser.PlusTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterPowT(CC3Parser.PowTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitPowT(CC3Parser.PowTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterEqualT(CC3Parser.EqualTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitEqualT(CC3Parser.EqualTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterNumT(CC3Parser.NumTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitNumT(CC3Parser.NumTContext ctx);
}