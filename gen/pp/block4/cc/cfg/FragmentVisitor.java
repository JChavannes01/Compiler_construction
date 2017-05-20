// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block4/cc/cfg\Fragment.g4 by ANTLR 4.7
package pp.block4.cc.cfg;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FragmentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FragmentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FragmentParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FragmentParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(FragmentParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(FragmentParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(FragmentParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(FragmentParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(FragmentParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(FragmentParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(FragmentParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContStat(FragmentParser.ContStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTarget(FragmentParser.IdTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTarget(FragmentParser.ArrayTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(FragmentParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(FragmentParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(FragmentParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldExpr(FragmentParser.FieldExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(FragmentParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOrExpr(FragmentParser.BitOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(FragmentParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(FragmentParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(FragmentParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndExpr(FragmentParser.BitAndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(FragmentParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(FragmentParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(FragmentParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FragmentParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FragmentParser.TypeContext ctx);
}