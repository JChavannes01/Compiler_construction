// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TabularParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TabularVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TabularParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(TabularParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TabularParser#tablerow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablerow(TabularParser.TablerowContext ctx);
	/**
	 * Visit a parse tree produced by {@link TabularParser#tableentry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableentry(TabularParser.TableentryContext ctx);
}