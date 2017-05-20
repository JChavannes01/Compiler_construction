// Generated from C:/Users/Janko/IdeaProjects/Compiler_construction/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TABLEENTRY=1, BEGINTABLE=2, ENDTABLE=3, COMMENT=4, AND=5, ENDROW=6, ALPHANUM=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TABLEENTRY", "BEGINTABLE", "ENDTABLE", "COMMENT", "AND", "ENDROW", "ALPHANUM", 
		"NEWLINE", "ALLIGNMENT"
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


	public TabularLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tabular.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tp\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2"+
		"\27\n\2\r\2\16\2\30\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4C\n\4\f\4\16\4F\13\4"+
		"\3\4\7\4I\n\4\f\4\16\4L\13\4\3\5\3\5\3\5\7\5Q\n\5\f\5\16\5T\13\5\3\5\6"+
		"\5W\n\5\r\5\16\5X\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\5\te\n\t\3\t"+
		"\3\t\3\n\3\n\6\nk\n\n\r\n\16\nl\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\2\23\2\3\2\5\3\2\"\"\6\2\"\"\62;C\\c|\5\2eenntt\2v\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\3\26\3\2\2\2\5\32\3\2\2\2\7\63\3\2\2\2\tM\3\2\2\2\13Z\3\2\2\2"+
		"\r\\\3\2\2\2\17a\3\2\2\2\21d\3\2\2\2\23h\3\2\2\2\25\27\5\17\b\2\26\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\4\3\2\2\2\32\33"+
		"\7^\2\2\33\34\7d\2\2\34\35\7g\2\2\35\36\7i\2\2\36\37\7k\2\2\37 \7p\2\2"+
		" !\7}\2\2!\"\7v\2\2\"#\7c\2\2#$\7d\2\2$%\7w\2\2%&\7n\2\2&\'\7c\2\2\'("+
		"\7t\2\2()\7\177\2\2)*\3\2\2\2*.\5\23\n\2+-\t\2\2\2,+\3\2\2\2-\60\3\2\2"+
		"\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\5\21\t\2\62\6\3\2"+
		"\2\2\63\64\7^\2\2\64\65\7g\2\2\65\66\7p\2\2\66\67\7f\2\2\678\7}\2\289"+
		"\7v\2\29:\7c\2\2:;\7d\2\2;<\7w\2\2<=\7n\2\2=>\7c\2\2>?\7t\2\2?@\7\177"+
		"\2\2@D\3\2\2\2AC\t\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EJ\3\2"+
		"\2\2FD\3\2\2\2GI\5\21\t\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\b\3"+
		"\2\2\2LJ\3\2\2\2MR\7\'\2\2NQ\5\17\b\2OQ\7\60\2\2PN\3\2\2\2PO\3\2\2\2Q"+
		"T\3\2\2\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2\2TR\3\2\2\2UW\5\21\t\2VU\3\2\2\2"+
		"WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\n\3\2\2\2Z[\7(\2\2[\f\3\2\2\2\\]\7^\2"+
		"\2]^\7^\2\2^_\3\2\2\2_`\5\21\t\2`\16\3\2\2\2ab\t\3\2\2b\20\3\2\2\2ce\7"+
		"\17\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\f\2\2g\22\3\2\2\2hj\7}\2\2i"+
		"k\t\4\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\177\2"+
		"\2o\24\3\2\2\2\f\2\30.DJPRXdl\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}