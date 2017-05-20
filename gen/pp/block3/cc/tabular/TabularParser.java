// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TABLEENTRY=1, BEGINTABLE=2, ENDTABLE=3, COMMENT=4, AND=5, ENDROW=6, ALPHANUM=7;
	public static final int
		RULE_start = 0, RULE_tablerow = 1, RULE_tableentry = 2;
	public static final String[] ruleNames = {
		"start", "tablerow", "tableentry"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TABLEENTRY", "BEGINTABLE", "ENDTABLE", "COMMENT", "AND", "ENDROW", 
		"ALPHANUM"
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
	public String getGrammarFileName() { return "Tabular.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TabularParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode BEGINTABLE() { return getToken(TabularParser.BEGINTABLE, 0); }
		public TerminalNode ENDTABLE() { return getToken(TabularParser.ENDTABLE, 0); }
		public TerminalNode COMMENT() { return getToken(TabularParser.COMMENT, 0); }
		public List<TablerowContext> tablerow() {
			return getRuleContexts(TablerowContext.class);
		}
		public TablerowContext tablerow(int i) {
			return getRuleContext(TablerowContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TabularVisitor ) return ((TabularVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(6);
				match(COMMENT);
				}
			}

			setState(9);
			match(BEGINTABLE);
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				tablerow();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TABLEENTRY) | (1L << AND) | (1L << ENDROW))) != 0) );
			setState(15);
			match(ENDTABLE);
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

	public static class TablerowContext extends ParserRuleContext {
		public TerminalNode ENDROW() { return getToken(TabularParser.ENDROW, 0); }
		public List<TableentryContext> tableentry() {
			return getRuleContexts(TableentryContext.class);
		}
		public TableentryContext tableentry(int i) {
			return getRuleContext(TableentryContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(TabularParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TabularParser.AND, i);
		}
		public TablerowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablerow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterTablerow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitTablerow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TabularVisitor ) return ((TabularVisitor<? extends T>)visitor).visitTablerow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablerowContext tablerow() throws RecognitionException {
		TablerowContext _localctx = new TablerowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tablerow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TABLEENTRY) {
				{
				setState(17);
				tableentry();
				}
			}

			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(20);
				match(AND);
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TABLEENTRY) {
					{
					setState(21);
					tableentry();
					}
				}

				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(ENDROW);
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

	public static class TableentryContext extends ParserRuleContext {
		public TerminalNode TABLEENTRY() { return getToken(TabularParser.TABLEENTRY, 0); }
		public TableentryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableentry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterTableentry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitTableentry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TabularVisitor ) return ((TabularVisitor<? extends T>)visitor).visitTableentry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableentryContext tableentry() throws RecognitionException {
		TableentryContext _localctx = new TableentryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableentry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(TABLEENTRY);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t$\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\5\2\n\n\2\3\2\3\2\6\2\16\n\2\r\2\16\2\17\3\2\3\2\3\3\5"+
		"\3\25\n\3\3\3\3\3\5\3\31\n\3\7\3\33\n\3\f\3\16\3\36\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\2\2\5\2\4\6\2\2\2%\2\t\3\2\2\2\4\24\3\2\2\2\6!\3\2\2\2\b\n\7\6"+
		"\2\2\t\b\3\2\2\2\t\n\3\2\2\2\n\13\3\2\2\2\13\r\7\4\2\2\f\16\5\4\3\2\r"+
		"\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\21\3\2\2\2\21\22"+
		"\7\5\2\2\22\3\3\2\2\2\23\25\5\6\4\2\24\23\3\2\2\2\24\25\3\2\2\2\25\34"+
		"\3\2\2\2\26\30\7\7\2\2\27\31\5\6\4\2\30\27\3\2\2\2\30\31\3\2\2\2\31\33"+
		"\3\2\2\2\32\26\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\37"+
		"\3\2\2\2\36\34\3\2\2\2\37 \7\b\2\2 \5\3\2\2\2!\"\7\3\2\2\"\7\3\2\2\2\7"+
		"\t\17\24\30\34";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}