// Generated from ILOC.g4 by ANTLR 4.7
package pp.iloc.parse;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILOCParser}.
 */
public interface ILOCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILOCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ILOCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ILOCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ILOCParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ILOCParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleInstr}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterSingleInstr(ILOCParser.SingleInstrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleInstr}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitSingleInstr(ILOCParser.SingleInstrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instrList}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterInstrList(ILOCParser.InstrListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instrList}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitInstrList(ILOCParser.InstrListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comment}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void enterComment(ILOCParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comment}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void exitComment(ILOCParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realOp}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void enterRealOp(ILOCParser.RealOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realOp}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void exitRealOp(ILOCParser.RealOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#sources}.
	 * @param ctx the parse tree
	 */
	void enterSources(ILOCParser.SourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#sources}.
	 * @param ctx the parse tree
	 */
	void exitSources(ILOCParser.SourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#targets}.
	 * @param ctx the parse tree
	 */
	void enterTargets(ILOCParser.TargetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#targets}.
	 * @param ctx the parse tree
	 */
	void exitTargets(ILOCParser.TargetsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(ILOCParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(ILOCParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#opCode}.
	 * @param ctx the parse tree
	 */
	void enterOpCode(ILOCParser.OpCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#opCode}.
	 * @param ctx the parse tree
	 */
	void exitOpCode(ILOCParser.OpCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(ILOCParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(ILOCParser.OperandContext ctx);
}