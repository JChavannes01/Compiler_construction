// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/antlr\CC3.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CC3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CC3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code boolT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolT(CC3Parser.BoolTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrT(CC3Parser.StrTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParT(CC3Parser.ParTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusT(CC3Parser.PlusTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowT(CC3Parser.PowTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualT(CC3Parser.EqualTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numT}
	 * labeled alternative in {@link CC3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumT(CC3Parser.NumTContext ctx);
}