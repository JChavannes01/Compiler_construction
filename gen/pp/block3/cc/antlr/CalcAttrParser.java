// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/antlr\CalcAttr.g4 by ANTLR 4.7
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
public class CalcAttrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TIMES=1, PLUS=2, MINUS=3, LPAR=4, RPAR=5, NUMBER=6, WS=7;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'+'", "'-'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TIMES", "PLUS", "MINUS", "LPAR", "RPAR", "NUMBER", "WS"
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
	public String getGrammarFileName() { return "CalcAttr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int getValue(String text) {
	        return Integer.parseInt(text);
	    }

	public CalcAttrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public int val;
		public ExprContext e0;
		public ExprContext e;
		public Token NUMBER;
		public ExprContext e1;
		public TerminalNode LPAR() { return getToken(CalcAttrParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CalcAttrParser.RPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CalcAttrParser.MINUS, 0); }
		public TerminalNode NUMBER() { return getToken(CalcAttrParser.NUMBER, 0); }
		public TerminalNode TIMES() { return getToken(CalcAttrParser.TIMES, 0); }
		public TerminalNode PLUS() { return getToken(CalcAttrParser.PLUS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcAttrListener ) ((CalcAttrListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcAttrListener ) ((CalcAttrListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcAttrVisitor ) return ((CalcAttrVisitor<? extends T>)visitor).visitExpr(this);
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
			setState(16);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(3);
				match(LPAR);
				setState(4);
				((ExprContext)_localctx).e = expr(0);
				setState(5);
				match(RPAR);
				 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).e.val; 
				}
				break;
			case MINUS:
				{
				 System.out.println("[CalcAttr.g4] Evaluating NEGATIVE NUMBER"); 
				setState(9);
				match(MINUS);
				setState(10);
				((ExprContext)_localctx).NUMBER = match(NUMBER);
				 ((ExprContext)_localctx).val =  (-1) * getValue((((ExprContext)_localctx).NUMBER!=null?((ExprContext)_localctx).NUMBER.getText():null)); 
				 System.out.println("[CalcAttr.g4] Evaluating NEGATIVE NUMBER"); 
				}
				break;
			case NUMBER:
				{
				 System.out.println("[CalcAttr.g4] Evaluating NUMBER"); 
				setState(14);
				((ExprContext)_localctx).NUMBER = match(NUMBER);
				 ((ExprContext)_localctx).val =  getValue((((ExprContext)_localctx).NUMBER!=null?((ExprContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(34);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e0 = _prevctx;
						_localctx.e0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(18);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(19);
						match(TIMES);
						setState(20);
						((ExprContext)_localctx).e1 = expr(7);
						 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).e0.val * ((ExprContext)_localctx).e1.val; 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e0 = _prevctx;
						_localctx.e0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(23);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(24);
						match(PLUS);
						setState(25);
						((ExprContext)_localctx).e1 = expr(6);
						 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).e0.val + ((ExprContext)_localctx).e1.val; 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e0 = _prevctx;
						_localctx.e0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(28);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(29);
						match(MINUS);
						setState(30);
						((ExprContext)_localctx).e1 = expr(5);
						System.out.println("[CalcAttr.g4] Evaluating MINUS expression");
						 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).e0.val - ((ExprContext)_localctx).e1.val; 
						}
						break;
					}
					} 
				}
				setState(38);
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
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t*\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2%\n\2\f\2"+
		"\16\2(\13\2\3\2\2\3\2\3\2\2\2\2-\2\22\3\2\2\2\4\5\b\2\1\2\5\6\7\6\2\2"+
		"\6\7\5\2\2\2\7\b\7\7\2\2\b\t\b\2\1\2\t\23\3\2\2\2\n\13\b\2\1\2\13\f\7"+
		"\5\2\2\f\r\7\b\2\2\r\16\b\2\1\2\16\23\b\2\1\2\17\20\b\2\1\2\20\21\7\b"+
		"\2\2\21\23\b\2\1\2\22\4\3\2\2\2\22\n\3\2\2\2\22\17\3\2\2\2\23&\3\2\2\2"+
		"\24\25\f\b\2\2\25\26\7\3\2\2\26\27\5\2\2\t\27\30\b\2\1\2\30%\3\2\2\2\31"+
		"\32\f\7\2\2\32\33\7\4\2\2\33\34\5\2\2\b\34\35\b\2\1\2\35%\3\2\2\2\36\37"+
		"\f\6\2\2\37 \7\5\2\2 !\5\2\2\7!\"\b\2\1\2\"#\b\2\1\2#%\3\2\2\2$\24\3\2"+
		"\2\2$\31\3\2\2\2$\36\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2"+
		"\2(&\3\2\2\2\5\22$&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}