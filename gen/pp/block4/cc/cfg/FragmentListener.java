// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block4/cc/cfg\Fragment.g4 by ANTLR 4.7
package pp.block4.cc.cfg;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FragmentParser}.
 */
public interface FragmentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FragmentParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FragmentParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FragmentParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FragmentParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDecl(FragmentParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDecl(FragmentParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(FragmentParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(FragmentParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(FragmentParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(FragmentParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(FragmentParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(FragmentParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(FragmentParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(FragmentParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(FragmentParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(FragmentParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(FragmentParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(FragmentParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContStat(FragmentParser.ContStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContStat(FragmentParser.ContStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(FragmentParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(FragmentParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayTarget(FragmentParser.ArrayTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayTarget(FragmentParser.ArrayTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(FragmentParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(FragmentParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(FragmentParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(FragmentParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(FragmentParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(FragmentParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFieldExpr(FragmentParser.FieldExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFieldExpr(FragmentParser.FieldExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(FragmentParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(FragmentParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpr(FragmentParser.BitOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpr(FragmentParser.BitOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(FragmentParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(FragmentParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(FragmentParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(FragmentParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(FragmentParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(FragmentParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpr(FragmentParser.BitAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpr(FragmentParser.BitAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(FragmentParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(FragmentParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(FragmentParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(FragmentParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(FragmentParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(FragmentParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FragmentParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(FragmentParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FragmentParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(FragmentParser.TypeContext ctx);
}