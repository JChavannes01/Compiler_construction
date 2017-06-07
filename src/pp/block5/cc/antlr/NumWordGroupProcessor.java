package pp.block5.cc.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block4.cc.cfg.FragmentParser;
import pp.block5.cc.ErrorListener;
import pp.block5.cc.ParseException;

/** Prettyprints a (number, word)-sentence and adds the numbers. */
public class NumWordGroupProcessor extends NumWordGroupBaseListener {
	public static void main(String[] args) {
		NumWordGroupProcessor grouper = new NumWordGroupProcessor();
		if (args.length == 0) {
			process(grouper, "1sock2shoes 3 holes");
			process(grouper, "4 strands 10 blocks 11 weeks 15 credits");
			process(grouper, "1PJ10minutes0work");
			process(grouper, "1 2 3");
			process(grouper, "1 word");
		} else {
			for (String text : args) {
				process(grouper, text);
			}
		}
	}

	private static void process(NumWordGroupProcessor grouper, String text) {
		try {
			System.out.printf("Processing '%s':%n", text);
			int result = grouper.group(text);
			System.out.println("Total: " + result + '\n');
		} catch (ParseException exc) {
			exc.print();
		}
	}

	/** Mapping from parse tree nodes to (sums of) numbers. */
	private ParseTreeProperty<Integer> values;

	/** Groups a given sentence and prints it to stdout.
	 * Returns the sum of the numbers in the sentence.
	 */
	public int group(String text) throws ParseException {
		CharStream chars = CharStreams.fromString(text);
		ErrorListener listener = new ErrorListener();
		Lexer lexer = new NumWordGroupLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		NumWordGroupParser parser = new NumWordGroupParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.sentence();
		listener.throwException();
		this.values = new ParseTreeProperty<>();
		new ParseTreeWalker().walk(this, tree);
		return this.values.get(tree);
	}

	// Override the listener methods

	@Override
	public void exitNumber(NumWordGroupParser.NumberContext ctx) {
		values.put(ctx, Integer.parseInt(ctx.getText()));
		System.out.print(ctx.getText() + " ");
	}

	@Override
	public void exitWord(NumWordGroupParser.WordContext ctx) {
		System.out.print(ctx.getText());
	}

	@Override
	public void exitGroup(NumWordGroupParser.GroupContext ctx) {
		System.out.print(", ");
		values.put(ctx, values.get(ctx.number()));
	}

	@Override
	public void exitPenultimateGroup(NumWordGroupParser.PenultimateGroupContext ctx) {
		System.out.print(" and ");
		values.put(ctx, values.get(ctx.number()));
	}

	@Override
	public void exitLastGroup(NumWordGroupParser.LastGroupContext ctx) {
		System.out.println();
		values.put(ctx, values.get(ctx.number()));
	}

	@Override
	public void exitSentence(NumWordGroupParser.SentenceContext ctx) {
		int result = 0;
		for (int i = 0; i < ctx.children.size()-1; i++) {
			ParseTree child = ctx.children.get(i);
			result += values.get(child);
		}
		values.put(ctx, result);
	}
}
