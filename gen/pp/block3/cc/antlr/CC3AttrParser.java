// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/antlr\CC3Attr.g4 by ANTLR 4.7
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
public class CC3AttrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		POWER=1, PLUS=2, EQUAL=3, LPAR=4, RPAR=5, NUM=6, BOOL=7, STR=8, WS=9;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
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
	public String getGrammarFileName() { return "CC3Attr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    
	public CC3AttrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public pp.block3.cc.antlr.Type val;
		public ExprContext t0;
		public ExprContext t;
		public ExprContext t1;
		public TerminalNode LPAR() { return getToken(CC3AttrParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CC3AttrParser.RPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BOOL() { return getToken(CC3AttrParser.BOOL, 0); }
		public TerminalNode STR() { return getToken(CC3AttrParser.STR, 0); }
		public TerminalNode NUM() { return getToken(CC3AttrParser.NUM, 0); }
		public TerminalNode POWER() { return getToken(CC3AttrParser.POWER, 0); }
		public TerminalNode PLUS() { return getToken(CC3AttrParser.PLUS, 0); }
		public TerminalNode EQUAL() { return getToken(CC3AttrParser.EQUAL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3AttrListener ) ((CC3AttrListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3AttrListener ) ((CC3AttrListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC3AttrVisitor ) return ((CC3AttrVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(3);
				match(LPAR);
				setState(4);
				((ExprContext)_localctx).t = expr(0);
				setState(5);
				match(RPAR);
				 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).t.val; 
				}
				break;
			case BOOL:
				{
				setState(8);
				match(BOOL);
				 ((ExprContext)_localctx).val =  Type.BOOL;
				}
				break;
			case STR:
				{
				setState(10);
				match(STR);
				 ((ExprContext)_localctx).val =  Type.STR; 
				}
				break;
			case NUM:
				{
				setState(12);
				match(NUM);
				 ((ExprContext)_localctx).val =  Type.NUM; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(31);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(16);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(17);
						match(POWER);
						setState(18);
						((ExprContext)_localctx).t1 = expr(8);
						((ExprContext)_localctx).val =  (((ExprContext)_localctx).t0.val != Type.BOOL && ((ExprContext)_localctx).t1.val == Type.NUM) ? ((ExprContext)_localctx).t0.val : Type.ERR;
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(21);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(22);
						match(PLUS);
						setState(23);
						((ExprContext)_localctx).t1 = expr(7);
						 ((ExprContext)_localctx).val =  (((ExprContext)_localctx).t0.val == ((ExprContext)_localctx).t1.val) ? ((ExprContext)_localctx).t0.val : Type.ERR;
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(26);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(27);
						match(EQUAL);
						setState(28);
						((ExprContext)_localctx).t1 = expr(6);
						 ((ExprContext)_localctx).val =  (((ExprContext)_localctx).t0.val == ((ExprContext)_localctx).t1.val) ? Type.BOOL : Type.ERR;
						}
						break;
					}
					} 
				}
				setState(35);
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
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\'\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\2\2\3\2\3\2\2\2\2+\2\20\3\2\2\2\4\5\b\2\1\2\5\6\7\6\2\2\6\7\5\2\2"+
		"\2\7\b\7\7\2\2\b\t\b\2\1\2\t\21\3\2\2\2\n\13\7\t\2\2\13\21\b\2\1\2\f\r"+
		"\7\n\2\2\r\21\b\2\1\2\16\17\7\b\2\2\17\21\b\2\1\2\20\4\3\2\2\2\20\n\3"+
		"\2\2\2\20\f\3\2\2\2\20\16\3\2\2\2\21#\3\2\2\2\22\23\f\t\2\2\23\24\7\3"+
		"\2\2\24\25\5\2\2\n\25\26\b\2\1\2\26\"\3\2\2\2\27\30\f\b\2\2\30\31\7\4"+
		"\2\2\31\32\5\2\2\t\32\33\b\2\1\2\33\"\3\2\2\2\34\35\f\7\2\2\35\36\7\5"+
		"\2\2\36\37\5\2\2\b\37 \b\2\1\2 \"\3\2\2\2!\22\3\2\2\2!\27\3\2\2\2!\34"+
		"\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2\2\5\20!#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}