// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/antlr\CC3.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		POWER=1, PLUS=2, EQUAL=3, LPAR=4, RPAR=5, NUM=6, BOOL=7, STR=8, WS=9;
	public static final int
		RULE_t = 0;
	public static final String[] ruleNames = {
		"t"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'^'", "'+'", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "POWER", "PLUS", "EQUAL", "LPAR", "RPAR", "NUM", "BOOL", "STR", 
		"WS"
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
	public String getGrammarFileName() { return "CC3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CC3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TContext extends ParserRuleContext {
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
	 
		public TContext() { }
		public void copyFrom(TContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolTContext extends TContext {
		public TerminalNode BOOL() { return getToken(CC3Parser.BOOL, 0); }
		public BoolTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterBoolT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitBoolT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitBoolT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrTContext extends TContext {
		public TerminalNode STR() { return getToken(CC3Parser.STR, 0); }
		public StrTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterStrT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitStrT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitStrT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParTContext extends TContext {
		public TerminalNode LPAR() { return getToken(CC3Parser.LPAR, 0); }
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CC3Parser.RPAR, 0); }
		public ParTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterParT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitParT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitParT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusTContext extends TContext {
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CC3Parser.PLUS, 0); }
		public PlusTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterPlusT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitPlusT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitPlusT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowTContext extends TContext {
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TerminalNode POWER() { return getToken(CC3Parser.POWER, 0); }
		public PowTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterPowT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitPowT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitPowT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualTContext extends TContext {
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CC3Parser.EQUAL, 0); }
		public EqualTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterEqualT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitEqualT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitEqualT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumTContext extends TContext {
		public TerminalNode NUM() { return getToken(CC3Parser.NUM, 0); }
		public NumTContext(TContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterNumT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitNumT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3Visitor ) return ((CC3Visitor<? extends T>)visitor).visitNumT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException {
		return t(0);
	}

	private TContext t(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TContext _localctx = new TContext(_ctx, _parentState);
		TContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_t, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				_localctx = new ParTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(LPAR);
				setState(4);
				t(0);
				setState(5);
				match(RPAR);
				}
				break;
			case NUM:
				{
				_localctx = new NumTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				match(NUM);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(8);
				match(BOOL);
				}
				break;
			case STR:
				{
				_localctx = new StrTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(21);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new PowTContext(new TContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(12);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(13);
						match(POWER);
						setState(14);
						t(8);
						}
						break;
					case 2:
						{
						_localctx = new PlusTContext(new TContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(15);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(16);
						match(PLUS);
						setState(17);
						t(7);
						}
						break;
					case 3:
						{
						_localctx = new EqualTContext(new TContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(18);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(19);
						match(EQUAL);
						setState(20);
						t(6);
						}
						break;
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return t_sempred((TContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean t_sempred(TContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\35\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\r\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\2\3\2\3\2\2\2\2!\2\f\3\2\2\2\4\5"+
		"\b\2\1\2\5\6\7\6\2\2\6\7\5\2\2\2\7\b\7\7\2\2\b\r\3\2\2\2\t\r\7\b\2\2\n"+
		"\r\7\t\2\2\13\r\7\n\2\2\f\4\3\2\2\2\f\t\3\2\2\2\f\n\3\2\2\2\f\13\3\2\2"+
		"\2\r\31\3\2\2\2\16\17\f\t\2\2\17\20\7\3\2\2\20\30\5\2\2\n\21\22\f\b\2"+
		"\2\22\23\7\4\2\2\23\30\5\2\2\t\24\25\f\7\2\2\25\26\7\5\2\2\26\30\5\2\2"+
		"\b\27\16\3\2\2\2\27\21\3\2\2\2\27\24\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2"+
		"\2\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\5\f\27\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}