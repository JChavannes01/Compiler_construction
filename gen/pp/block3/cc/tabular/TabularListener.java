// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TabularParser}.
 */
public interface TabularListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TabularParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TabularParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TabularParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#tablerow}.
	 * @param ctx the parse tree
	 */
	void enterTablerow(TabularParser.TablerowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#tablerow}.
	 * @param ctx the parse tree
	 */
	void exitTablerow(TabularParser.TablerowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#tableentry}.
	 * @param ctx the parse tree
	 */
	void enterTableentry(TabularParser.TableentryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#tableentry}.
	 * @param ctx the parse tree
	 */
	void exitTableentry(TabularParser.TableentryContext ctx);
}