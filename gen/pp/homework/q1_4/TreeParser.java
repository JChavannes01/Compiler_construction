// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/homework/q1_4\Tree.g4 by ANTLR 4.7
package pp.homework.q1_4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TreeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, LEFT=3, RIGHT=4, NUM=5, WS=6;
	public static final int
		RULE_top = 0, RULE_node = 1;
	public static final String[] ruleNames = {
		"top", "node"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'<'", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAR", "RPAR", "LEFT", "RIGHT", "NUM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tree.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TreeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TopContext extends ParserRuleContext {
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).enterTop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).exitTop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeVisitor ) return ((TreeVisitor<? extends T>)visitor).visitTop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopContext top() throws RecognitionException {
		TopContext _localctx = new TopContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_top);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			node();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeContext extends ParserRuleContext {
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
	 
		public NodeContext() { }
		public void copyFrom(NodeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumNodeContext extends NodeContext {
		public TerminalNode NUM() { return getToken(TreeParser.NUM, 0); }
		public NumNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).enterNumNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).exitNumNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeVisitor ) return ((TreeVisitor<? extends T>)visitor).visitNumNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftNodeContext extends NodeContext {
		public TerminalNode LPAR() { return getToken(TreeParser.LPAR, 0); }
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TerminalNode LEFT() { return getToken(TreeParser.LEFT, 0); }
		public TerminalNode NUM() { return getToken(TreeParser.NUM, 0); }
		public TerminalNode RPAR() { return getToken(TreeParser.RPAR, 0); }
		public LeftNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).enterLeftNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).exitLeftNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeVisitor ) return ((TreeVisitor<? extends T>)visitor).visitLeftNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RightNodeContext extends NodeContext {
		public TerminalNode LPAR() { return getToken(TreeParser.LPAR, 0); }
		public TerminalNode NUM() { return getToken(TreeParser.NUM, 0); }
		public TerminalNode RIGHT() { return getToken(TreeParser.RIGHT, 0); }
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TreeParser.RPAR, 0); }
		public RightNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).enterRightNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).exitRightNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeVisitor ) return ((TreeVisitor<? extends T>)visitor).visitRightNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinNodeContext extends NodeContext {
		public TerminalNode LPAR() { return getToken(TreeParser.LPAR, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode LEFT() { return getToken(TreeParser.LEFT, 0); }
		public TerminalNode NUM() { return getToken(TreeParser.NUM, 0); }
		public TerminalNode RIGHT() { return getToken(TreeParser.RIGHT, 0); }
		public TerminalNode RPAR() { return getToken(TreeParser.RPAR, 0); }
		public BinNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).enterBinNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeListener ) ((TreeListener)listener).exitBinNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeVisitor ) return ((TreeVisitor<? extends T>)visitor).visitBinNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_node);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new NumNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(NUM);
				}
				break;
			case 2:
				_localctx = new LeftNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(7);
				match(LPAR);
				setState(8);
				node();
				setState(9);
				match(LEFT);
				setState(10);
				match(NUM);
				setState(11);
				match(RPAR);
				}
				break;
			case 3:
				_localctx = new RightNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(13);
				match(LPAR);
				setState(14);
				match(NUM);
				setState(15);
				match(RIGHT);
				setState(16);
				node();
				setState(17);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new BinNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(19);
				match(LPAR);
				setState(20);
				node();
				setState(21);
				match(LEFT);
				setState(22);
				match(NUM);
				setState(23);
				match(RIGHT);
				setState(24);
				node();
				setState(25);
				match(RPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b \4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\3\2\2\4\2\4\2\2\2 \2\6\3\2\2\2\4"+
		"\35\3\2\2\2\6\7\5\4\3\2\7\3\3\2\2\2\b\36\7\7\2\2\t\n\7\3\2\2\n\13\5\4"+
		"\3\2\13\f\7\5\2\2\f\r\7\7\2\2\r\16\7\4\2\2\16\36\3\2\2\2\17\20\7\3\2\2"+
		"\20\21\7\7\2\2\21\22\7\6\2\2\22\23\5\4\3\2\23\24\7\4\2\2\24\36\3\2\2\2"+
		"\25\26\7\3\2\2\26\27\5\4\3\2\27\30\7\5\2\2\30\31\7\7\2\2\31\32\7\6\2\2"+
		"\32\33\5\4\3\2\33\34\7\4\2\2\34\36\3\2\2\2\35\b\3\2\2\2\35\t\3\2\2\2\35"+
		"\17\3\2\2\2\35\25\3\2\2\2\36\5\3\2\2\2\3\35";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}