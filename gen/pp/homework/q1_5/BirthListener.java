// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/homework/q1_5\Birth.g4 by ANTLR 4.7
package pp.homework.q1_5;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BirthParser}.
 */
public interface BirthListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BirthParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(BirthParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(BirthParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link BirthParser#enter}.
	 * @param ctx the parse tree
	 */
	void enterEnter(BirthParser.EnterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#enter}.
	 * @param ctx the parse tree
	 */
	void exitEnter(BirthParser.EnterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code childBeget}
	 * labeled alternative in {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 */
	void enterChildBeget(BirthParser.ChildBegetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code childBeget}
	 * labeled alternative in {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 */
	void exitChildBeget(BirthParser.ChildBegetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code branchBeget}
	 * labeled alternative in {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 */
	void enterBranchBeget(BirthParser.BranchBegetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code branchBeget}
	 * labeled alternative in {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 */
	void exitBranchBeget(BirthParser.BranchBegetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BirthParser#sex}.
	 * @param ctx the parse tree
	 */
	void enterSex(BirthParser.SexContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#sex}.
	 * @param ctx the parse tree
	 */
	void exitSex(BirthParser.SexContext ctx);
}