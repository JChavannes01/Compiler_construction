// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block2/cc/antlr\NamedSentence.g4 by ANTLR 4.7
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NamedSentenceParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NOUN=2, VERB=3, ADJECTIVE=4, ENDMARK=5, WS=6, TYPO=7;
	public static final int
		RULE_sentence = 0, RULE_subject = 1, RULE_object = 2, RULE_modifier = 3;
	public static final String[] ruleNames = {
		"sentence", "subject", "object", "modifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, "'love'", null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "NOUN", "VERB", "ADJECTIVE", "ENDMARK", "WS", "TYPO"
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
	public String getGrammarFileName() { return "NamedSentence.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NamedSentenceParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SentenceContext extends ParserRuleContext {
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public TerminalNode VERB() { return getToken(NamedSentenceParser.VERB, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode ENDMARK() { return getToken(NamedSentenceParser.ENDMARK, 0); }
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NamedSentenceVisitor ) return ((NamedSentenceVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			subject();
			setState(9);
			match(VERB);
			setState(10);
			object();
			setState(11);
			match(ENDMARK);
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

	public static class SubjectContext extends ParserRuleContext {
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
	 
		public SubjectContext() { }
		public void copyFrom(SubjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ModSubjectContext extends SubjectContext {
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public ModSubjectContext(SubjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).enterModSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).exitModSubject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NamedSentenceVisitor ) return ((NamedSentenceVisitor<? extends T>)visitor).visitModSubject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleSubjectContext extends SubjectContext {
		public TerminalNode NOUN() { return getToken(NamedSentenceParser.NOUN, 0); }
		public SimpleSubjectContext(SubjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).enterSimpleSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).exitSimpleSubject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NamedSentenceVisitor ) return ((NamedSentenceVisitor<? extends T>)visitor).visitSimpleSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subject);
		try {
			setState(17);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADJECTIVE:
				_localctx = new ModSubjectContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				modifier(0);
				setState(14);
				subject();
				}
				break;
			case NOUN:
				_localctx = new SimpleSubjectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(NOUN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ObjectContext extends ParserRuleContext {
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode NOUN() { return getToken(NamedSentenceParser.NOUN, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NamedSentenceVisitor ) return ((NamedSentenceVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_object);
		try {
			setState(23);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADJECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				modifier(0);
				setState(20);
				object();
				}
				break;
			case NOUN:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(NOUN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode ADJECTIVE() { return getToken(NamedSentenceParser.ADJECTIVE, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NamedSentenceListener ) ((NamedSentenceListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NamedSentenceVisitor ) return ((NamedSentenceVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		return modifier(0);
	}

	private ModifierContext modifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ModifierContext _localctx = new ModifierContext(_ctx, _parentState);
		ModifierContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_modifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(26);
			match(ADJECTIVE);
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
					{
					_localctx = new ModifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_modifier);
					setState(28);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(29);
					match(T__0);
					setState(30);
					modifier(2);
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
		case 3:
			return modifier_sempred((ModifierContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean modifier_sempred(ModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t\'\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\24\n\3\3\4"+
		"\3\4\3\4\3\4\5\4\32\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\"\n\5\f\5\16\5%\13"+
		"\5\3\5\2\3\b\6\2\4\6\b\2\2\2%\2\n\3\2\2\2\4\23\3\2\2\2\6\31\3\2\2\2\b"+
		"\33\3\2\2\2\n\13\5\4\3\2\13\f\7\5\2\2\f\r\5\6\4\2\r\16\7\7\2\2\16\3\3"+
		"\2\2\2\17\20\5\b\5\2\20\21\5\4\3\2\21\24\3\2\2\2\22\24\7\4\2\2\23\17\3"+
		"\2\2\2\23\22\3\2\2\2\24\5\3\2\2\2\25\26\5\b\5\2\26\27\5\6\4\2\27\32\3"+
		"\2\2\2\30\32\7\4\2\2\31\25\3\2\2\2\31\30\3\2\2\2\32\7\3\2\2\2\33\34\b"+
		"\5\1\2\34\35\7\6\2\2\35#\3\2\2\2\36\37\f\4\2\2\37 \7\3\2\2 \"\5\b\5\4"+
		"!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\t\3\2\2\2%#\3\2\2\2\5\23"+
		"\31#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}