// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

	import ast.*;
	import ast.definition.*;
	import ast.expression.*;
	import ast.type.*;
	import ast.sentence.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, INT_CONSTANT=40, REAL_CONSTANT=41, IDENT=42, CHAR_CONSTANT=43, 
		LINE_COMMENT=44, MULTILINE_COMMENT=45, WHITESPACE=46;
	public static final int
		RULE_start = 0, RULE_definiciones = 1, RULE_definicion = 2, RULE_definicionVariable = 3, 
		RULE_definicionStruct = 4, RULE_bodyStruct = 5, RULE_definicionFuncion = 6, 
		RULE_definicionInsideFunction = 7, RULE_definicionVariableLocal = 8, RULE_param = 9, 
		RULE_sentencia = 10, RULE_sentencias = 11, RULE_expr = 12, RULE_paramExpr = 13, 
		RULE_tipo = 14, RULE_tipoSimple = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definiciones", "definicion", "definicionVariable", "definicionStruct", 
			"bodyStruct", "definicionFuncion", "definicionInsideFunction", "definicionVariableLocal", 
			"param", "sentencia", "sentencias", "expr", "paramExpr", "tipo", "tipoSimple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'struct'", "'{'", "'};'", "'('", "')'", 
			"'}'", "','", "'println'", "'printsp'", "'print'", "'read'", "'='", "'if'", 
			"'else'", "'while'", "'return'", "'.'", "'['", "']'", "'!'", "'-'", "'*'", 
			"'/'", "'+'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'&&'", "'||'", 
			"'cast<'", "'float'", "'int'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "IDENT", "CHAR_CONSTANT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public DefinicionesContext definiciones;
		public DefinicionesContext definiciones() {
			return getRuleContext(DefinicionesContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((StartContext)_localctx).definiciones = definiciones();
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).definiciones.list); 
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

	public static class DefinicionesContext extends ParserRuleContext {
		public List<Definitions> list = new ArrayList<Definitions>();
		public DefinicionContext definicion;
		public List<DefinicionContext> definicion() {
			return getRuleContexts(DefinicionContext.class);
		}
		public DefinicionContext definicion(int i) {
			return getRuleContext(DefinicionContext.class,i);
		}
		public DefinicionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definiciones; }
	}

	public final DefinicionesContext definiciones() throws RecognitionException {
		DefinicionesContext _localctx = new DefinicionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definiciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << IDENT))) != 0)) {
				{
				{
				setState(35);
				((DefinicionesContext)_localctx).definicion = definicion();
				 _localctx.list.add(((DefinicionesContext)_localctx).definicion.ast); 
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class DefinicionContext extends ParserRuleContext {
		public Definitions ast;
		public DefinicionVariableContext definicionVariable;
		public DefinicionStructContext definicionStruct;
		public DefinicionFuncionContext definicionFuncion;
		public DefinicionVariableContext definicionVariable() {
			return getRuleContext(DefinicionVariableContext.class,0);
		}
		public DefinicionStructContext definicionStruct() {
			return getRuleContext(DefinicionStructContext.class,0);
		}
		public DefinicionFuncionContext definicionFuncion() {
			return getRuleContext(DefinicionFuncionContext.class,0);
		}
		public DefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion; }
	}

	public final DefinicionContext definicion() throws RecognitionException {
		DefinicionContext _localctx = new DefinicionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definicion);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				((DefinicionContext)_localctx).definicionVariable = definicionVariable();
				 ((DefinicionContext)_localctx).ast =  ((DefinicionContext)_localctx).definicionVariable.ast; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				((DefinicionContext)_localctx).definicionStruct = definicionStruct();
				 ((DefinicionContext)_localctx).ast =  ((DefinicionContext)_localctx).definicionStruct.ast; 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				((DefinicionContext)_localctx).definicionFuncion = definicionFuncion();
				 ((DefinicionContext)_localctx).ast =  ((DefinicionContext)_localctx).definicionFuncion.ast; 
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

	public static class DefinicionVariableContext extends ParserRuleContext {
		public Definitions ast;
		public Token IDENT;
		public TipoContext t;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefinicionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionVariable; }
	}

	public final DefinicionVariableContext definicionVariable() throws RecognitionException {
		DefinicionVariableContext _localctx = new DefinicionVariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definicionVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__0);
			setState(55);
			((DefinicionVariableContext)_localctx).IDENT = match(IDENT);
			setState(56);
			match(T__1);
			setState(57);
			((DefinicionVariableContext)_localctx).t = tipo();
			setState(58);
			match(T__2);
			 ((DefinicionVariableContext)_localctx).ast =  new DefinitionVariable(((DefinicionVariableContext)_localctx).IDENT, ((DefinicionVariableContext)_localctx).t.ast, "global"); 
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

	public static class DefinicionStructContext extends ParserRuleContext {
		public Definitions ast;
		public Token IDENT;
		public BodyStructContext b;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public BodyStructContext bodyStruct() {
			return getRuleContext(BodyStructContext.class,0);
		}
		public DefinicionStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionStruct; }
	}

	public final DefinicionStructContext definicionStruct() throws RecognitionException {
		DefinicionStructContext _localctx = new DefinicionStructContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definicionStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__3);
			setState(62);
			((DefinicionStructContext)_localctx).IDENT = match(IDENT);
			setState(63);
			match(T__4);
			setState(64);
			((DefinicionStructContext)_localctx).b = bodyStruct();
			setState(65);
			match(T__5);
			 ((DefinicionStructContext)_localctx).ast =  new DefinitionStruct(((DefinicionStructContext)_localctx).IDENT, ((DefinicionStructContext)_localctx).b.list); 
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

	public static class BodyStructContext extends ParserRuleContext {
		public List<Definitions> list = new ArrayList<Definitions>();
		public Token i;
		public TipoContext t;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public BodyStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyStruct; }
	}

	public final BodyStructContext bodyStruct() throws RecognitionException {
		BodyStructContext _localctx = new BodyStructContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bodyStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(68);
				((BodyStructContext)_localctx).i = match(IDENT);
				setState(69);
				match(T__1);
				setState(70);
				((BodyStructContext)_localctx).t = tipo();
				setState(71);
				match(T__2);
				 _localctx.list.add(new DefinitionVariable(((BodyStructContext)_localctx).i, ((BodyStructContext)_localctx).t.ast,"struct")); 
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class DefinicionFuncionContext extends ParserRuleContext {
		public Definitions ast;
		public Token i1;
		public ParamContext p1;
		public DefinicionInsideFunctionContext d1;
		public SentenciasContext s1;
		public Token i2;
		public ParamContext p2;
		public TipoContext t2;
		public DefinicionInsideFunctionContext d2;
		public SentenciasContext s2;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public DefinicionInsideFunctionContext definicionInsideFunction() {
			return getRuleContext(DefinicionInsideFunctionContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefinicionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionFuncion; }
	}

	public final DefinicionFuncionContext definicionFuncion() throws RecognitionException {
		DefinicionFuncionContext _localctx = new DefinicionFuncionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_definicionFuncion);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((DefinicionFuncionContext)_localctx).i1 = match(IDENT);
				setState(80);
				match(T__6);
				setState(81);
				((DefinicionFuncionContext)_localctx).p1 = param();
				setState(82);
				match(T__7);
				setState(83);
				match(T__4);
				setState(84);
				((DefinicionFuncionContext)_localctx).d1 = definicionInsideFunction();
				setState(85);
				((DefinicionFuncionContext)_localctx).s1 = sentencias();
				setState(86);
				match(T__8);
				 ((DefinicionFuncionContext)_localctx).ast =  new DefinitionFuncion(((DefinicionFuncionContext)_localctx).i1, new TypeVoid(), ((DefinicionFuncionContext)_localctx).p1.list, ((DefinicionFuncionContext)_localctx).d1.list, ((DefinicionFuncionContext)_localctx).s1.list); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				((DefinicionFuncionContext)_localctx).i2 = match(IDENT);
				setState(90);
				match(T__6);
				setState(91);
				((DefinicionFuncionContext)_localctx).p2 = param();
				setState(92);
				match(T__7);
				setState(93);
				match(T__1);
				setState(94);
				((DefinicionFuncionContext)_localctx).t2 = tipo();
				setState(95);
				match(T__4);
				setState(96);
				((DefinicionFuncionContext)_localctx).d2 = definicionInsideFunction();
				setState(97);
				((DefinicionFuncionContext)_localctx).s2 = sentencias();
				setState(98);
				match(T__8);
				 ((DefinicionFuncionContext)_localctx).ast =  new DefinitionFuncion(((DefinicionFuncionContext)_localctx).i2, ((DefinicionFuncionContext)_localctx).t2.ast, ((DefinicionFuncionContext)_localctx).p2.list, ((DefinicionFuncionContext)_localctx).d2.list, ((DefinicionFuncionContext)_localctx).s2.list); 
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

	public static class DefinicionInsideFunctionContext extends ParserRuleContext {
		public List<Definitions> list = new ArrayList<Definitions>();
		public DefinicionVariableLocalContext d;
		public List<DefinicionVariableLocalContext> definicionVariableLocal() {
			return getRuleContexts(DefinicionVariableLocalContext.class);
		}
		public DefinicionVariableLocalContext definicionVariableLocal(int i) {
			return getRuleContext(DefinicionVariableLocalContext.class,i);
		}
		public DefinicionInsideFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionInsideFunction; }
	}

	public final DefinicionInsideFunctionContext definicionInsideFunction() throws RecognitionException {
		DefinicionInsideFunctionContext _localctx = new DefinicionInsideFunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_definicionInsideFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(103);
				((DefinicionInsideFunctionContext)_localctx).d = definicionVariableLocal();
				_localctx.list.add(((DefinicionInsideFunctionContext)_localctx).d.ast);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class DefinicionVariableLocalContext extends ParserRuleContext {
		public Definitions ast;
		public Token IDENT;
		public TipoContext t;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefinicionVariableLocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionVariableLocal; }
	}

	public final DefinicionVariableLocalContext definicionVariableLocal() throws RecognitionException {
		DefinicionVariableLocalContext _localctx = new DefinicionVariableLocalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_definicionVariableLocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__0);
			setState(112);
			((DefinicionVariableLocalContext)_localctx).IDENT = match(IDENT);
			setState(113);
			match(T__1);
			setState(114);
			((DefinicionVariableLocalContext)_localctx).t = tipo();
			setState(115);
			match(T__2);
			 ((DefinicionVariableLocalContext)_localctx).ast =  new DefinitionVariable(((DefinicionVariableLocalContext)_localctx).IDENT, ((DefinicionVariableLocalContext)_localctx).t.ast, "local"); 
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

	public static class ParamContext extends ParserRuleContext {
		public List<Definitions> list = new ArrayList<Definitions>();
		public Token i1;
		public TipoContext t1;
		public Token i2;
		public TipoContext t2;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(118);
				((ParamContext)_localctx).i1 = match(IDENT);
				setState(119);
				match(T__1);
				setState(120);
				((ParamContext)_localctx).t1 = tipo();
				 _localctx.list.add(new DefinitionVariable(((ParamContext)_localctx).i1, ((ParamContext)_localctx).t1.ast, "parameter")); 
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(122);
					match(T__9);
					setState(123);
					((ParamContext)_localctx).i2 = match(IDENT);
					setState(124);
					match(T__1);
					setState(125);
					((ParamContext)_localctx).t2 = tipo();
					 _localctx.list.add(new DefinitionVariable(((ParamContext)_localctx).i2, ((ParamContext)_localctx).t2.ast, "parameter")); 
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

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

	public static class SentenciaContext extends ParserRuleContext {
		public Sentence ast;
		public ExprContext ex;
		public ExprContext left;
		public ExprContext right;
		public ExprContext condition;
		public SentenciasContext cierto;
		public SentenciasContext falso;
		public ExprContext ret;
		public Token IDENT;
		public ParamExprContext r;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<SentenciasContext> sentencias() {
			return getRuleContexts(SentenciasContext.class);
		}
		public SentenciasContext sentencias(int i) {
			return getRuleContext(SentenciasContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParamExprContext paramExpr() {
			return getRuleContext(ParamExprContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentencia);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(T__10);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__22) | (1L << T__23) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					setState(136);
					((SentenciaContext)_localctx).ex = expr(0);
					}
				}

				setState(139);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentencePrint(((SentenciaContext)_localctx).ex == null ? null : ((SentenciaContext)_localctx).ex.ast, "\n"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(T__11);
				setState(142);
				((SentenciaContext)_localctx).ex = expr(0);
				setState(143);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentencePrint(((SentenciaContext)_localctx).ex.ast, " "); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(T__12);
				setState(147);
				((SentenciaContext)_localctx).ex = expr(0);
				setState(148);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentencePrint(((SentenciaContext)_localctx).ex.ast, ""); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				match(T__13);
				setState(152);
				((SentenciaContext)_localctx).ex = expr(0);
				setState(153);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentenceRead(((SentenciaContext)_localctx).ex.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				((SentenciaContext)_localctx).left = expr(0);
				setState(157);
				match(T__14);
				setState(158);
				((SentenciaContext)_localctx).right = expr(0);
				setState(159);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentenceAssignment(((SentenciaContext)_localctx).left.ast, ((SentenciaContext)_localctx).right.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				match(T__15);
				setState(163);
				match(T__6);
				setState(164);
				((SentenciaContext)_localctx).condition = expr(0);
				setState(165);
				match(T__7);
				setState(166);
				match(T__4);
				setState(167);
				((SentenciaContext)_localctx).cierto = sentencias();
				setState(168);
				match(T__8);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(169);
					match(T__16);
					setState(170);
					match(T__4);
					setState(171);
					((SentenciaContext)_localctx).falso = sentencias();
					setState(172);
					match(T__8);
					}
				}

				 ((SentenciaContext)_localctx).ast =  new SentenceIf(((SentenciaContext)_localctx).condition.ast, ((SentenciaContext)_localctx).cierto.list, ((SentenciaContext)_localctx).falso == null ? new ArrayList<>() : ((SentenciaContext)_localctx).falso.list); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				match(T__17);
				setState(179);
				match(T__6);
				setState(180);
				((SentenciaContext)_localctx).condition = expr(0);
				setState(181);
				match(T__7);
				setState(182);
				match(T__4);
				setState(183);
				((SentenciaContext)_localctx).cierto = sentencias();
				setState(184);
				match(T__8);
				 ((SentenciaContext)_localctx).ast =  new SentenceWhile(((SentenciaContext)_localctx).condition.ast,((SentenciaContext)_localctx).cierto.list); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(187);
				match(T__18);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__22) | (1L << T__23) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					setState(188);
					((SentenciaContext)_localctx).ret = expr(0);
					}
				}

				setState(191);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentenceReturn(((SentenciaContext)_localctx).ret == null ? null : ((SentenciaContext)_localctx).ret.ast); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				((SentenciaContext)_localctx).IDENT = match(IDENT);
				setState(194);
				match(T__6);
				setState(195);
				((SentenciaContext)_localctx).r = paramExpr();
				setState(196);
				match(T__7);
				setState(197);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new SentenceFunctionCall(((SentenciaContext)_localctx).IDENT, ((SentenciaContext)_localctx).r.list); 
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

	public static class SentenciasContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenciaContext sentencia;
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(202);
				((SentenciasContext)_localctx).sentencia = sentencia();
				 _localctx.list.add(((SentenciasContext)_localctx).sentencia.ast); 
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ExprContext extends ParserRuleContext {
		public Expression ast;
		public ExprContext left;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token IDENT;
		public ExprContext right;
		public ExprContext expr;
		public TipoContext l;
		public ParamExprContext rig;
		public Token op;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParamExprContext paramExpr() {
			return getRuleContext(ParamExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(211);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new ExpressionIntCte(((ExprContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 2:
				{
				setState(213);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new ExpressionRealCte(((ExprContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 3:
				{
				setState(215);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExprContext)_localctx).ast =  new ExpressionCharCte(((ExprContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			case 4:
				{
				setState(217);
				((ExprContext)_localctx).IDENT = match(IDENT);
				 ((ExprContext)_localctx).ast =  new ExpressionVariable(((ExprContext)_localctx).IDENT); 
				}
				break;
			case 5:
				{
				setState(219);
				match(T__22);
				setState(220);
				((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(9);
				 ((ExprContext)_localctx).ast =  new ExpressionNegative(((ExprContext)_localctx).right.ast); 
				}
				break;
			case 6:
				{
				setState(223);
				match(T__23);
				setState(224);
				((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(8);
				 ((ExprContext)_localctx).ast =  new ExpressionMinus(((ExprContext)_localctx).right.ast); 
				}
				break;
			case 7:
				{
				setState(227);
				match(T__6);
				setState(228);
				((ExprContext)_localctx).expr = expr(0);
				setState(229);
				match(T__7);
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast; 
				}
				break;
			case 8:
				{
				setState(232);
				match(T__35);
				setState(233);
				((ExprContext)_localctx).l = tipo();
				setState(234);
				match(T__32);
				setState(235);
				match(T__6);
				setState(236);
				((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(0);
				setState(237);
				match(T__7);
				 ((ExprContext)_localctx).ast =  new ExpressionCast(((ExprContext)_localctx).l.ast, ((ExprContext)_localctx).right.ast); 
				}
				break;
			case 9:
				{
				setState(240);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(241);
				match(T__6);
				setState(242);
				((ExprContext)_localctx).rig = paramExpr();
				setState(243);
				match(T__7);
				 ((ExprContext)_localctx).ast =  new ExpressionFunctionCall(((ExprContext)_localctx).IDENT, ((ExprContext)_localctx).rig.list); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(278);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(249);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(8);
						 ((ExprContext)_localctx).ast =  new ExpressionArithmetic(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(254);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__26) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).ast =  new ExpressionArithmetic(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(259);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(260);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).ast =  new ExpressionComparision(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(264);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(265);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).ast =  new ExpressionOperator(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(269);
						match(T__19);
						setState(270);
						((ExprContext)_localctx).IDENT = match(IDENT);
						 ((ExprContext)_localctx).ast =  new ExpressionElements(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).IDENT); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(272);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(273);
						match(T__20);
						setState(274);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(0);
						setState(275);
						match(T__21);
						 ((ExprContext)_localctx).ast =  new ExpressionArray(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).right.ast); 
						}
						break;
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class ParamExprContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExprContext l;
		public ExprContext r;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ParamExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramExpr; }
	}

	public final ParamExprContext paramExpr() throws RecognitionException {
		ParamExprContext _localctx = new ParamExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_paramExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__22) | (1L << T__23) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				setState(283);
				((ParamExprContext)_localctx).l = expr(0);
				_localctx.list.add(((ParamExprContext)_localctx).l.ast);
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(285);
					match(T__9);
					setState(286);
					((ParamExprContext)_localctx).r = expr(0);
					 _localctx.list.add(((ParamExprContext)_localctx).r.ast); 
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

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

	public static class TipoContext extends ParserRuleContext {
		public Type ast;
		public Token i0;
		public Token d;
		public TipoContext t2;
		public TipoSimpleContext t3;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TipoSimpleContext tipoSimple() {
			return getRuleContext(TipoSimpleContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo);
		try {
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((TipoContext)_localctx).i0 = match(IDENT);
				 ((TipoContext)_localctx).ast =  new TypeStruct(((TipoContext)_localctx).i0); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(T__20);
				setState(299);
				((TipoContext)_localctx).d = match(INT_CONSTANT);
				setState(300);
				match(T__21);
				setState(301);
				((TipoContext)_localctx).t2 = tipo();
				 ((TipoContext)_localctx).ast =  new TypeArray(((TipoContext)_localctx).d, ((TipoContext)_localctx).t2.ast); 
				}
				break;
			case T__36:
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				((TipoContext)_localctx).t3 = tipoSimple();
				 ((TipoContext)_localctx).ast =  ((TipoContext)_localctx).t3.ast; 
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

	public static class TipoSimpleContext extends ParserRuleContext {
		public Type ast;
		public TipoSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoSimple; }
	}

	public final TipoSimpleContext tipoSimple() throws RecognitionException {
		TipoSimpleContext _localctx = new TipoSimpleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipoSimple);
		try {
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(T__36);
				 ((TipoSimpleContext)_localctx).ast =  new TypeReal(); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(T__37);
				 ((TipoSimpleContext)_localctx).ast =  new TypeInt(); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				match(T__38);
				 ((TipoSimpleContext)_localctx).ast =  new TypeChar(); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
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
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0140\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bh\n\b\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0083\n\13"+
		"\f\13\16\13\u0086\13\13\5\13\u0088\n\13\3\f\3\f\5\f\u008c\n\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b1"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c0\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00cb\n\f\3\r\3\r\3\r\7\r\u00d0"+
		"\n\r\f\r\16\r\u00d3\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00f9\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0119\n\16\f\16\16\16\u011c\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u0124\n\17\f\17\16\17\u0127\13\17\5\17\u0129"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0136"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u013e\n\21\3\21\2\3\32\22\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\6\3\2\33\34\4\2\32\32\35\35\3\2"+
		"\36#\3\2$%\2\u0157\2\"\3\2\2\2\4*\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\n?\3"+
		"\2\2\2\fN\3\2\2\2\16g\3\2\2\2\20n\3\2\2\2\22q\3\2\2\2\24\u0087\3\2\2\2"+
		"\26\u00ca\3\2\2\2\30\u00d1\3\2\2\2\32\u00f8\3\2\2\2\34\u0128\3\2\2\2\36"+
		"\u0135\3\2\2\2 \u013d\3\2\2\2\"#\5\4\3\2#$\b\2\1\2$\3\3\2\2\2%&\5\6\4"+
		"\2&\'\b\3\1\2\')\3\2\2\2(%\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\5\3"+
		"\2\2\2,*\3\2\2\2-.\5\b\5\2./\b\4\1\2/\67\3\2\2\2\60\61\5\n\6\2\61\62\b"+
		"\4\1\2\62\67\3\2\2\2\63\64\5\16\b\2\64\65\b\4\1\2\65\67\3\2\2\2\66-\3"+
		"\2\2\2\66\60\3\2\2\2\66\63\3\2\2\2\67\7\3\2\2\289\7\3\2\29:\7,\2\2:;\7"+
		"\4\2\2;<\5\36\20\2<=\7\5\2\2=>\b\5\1\2>\t\3\2\2\2?@\7\6\2\2@A\7,\2\2A"+
		"B\7\7\2\2BC\5\f\7\2CD\7\b\2\2DE\b\6\1\2E\13\3\2\2\2FG\7,\2\2GH\7\4\2\2"+
		"HI\5\36\20\2IJ\7\5\2\2JK\b\7\1\2KM\3\2\2\2LF\3\2\2\2MP\3\2\2\2NL\3\2\2"+
		"\2NO\3\2\2\2O\r\3\2\2\2PN\3\2\2\2QR\7,\2\2RS\7\t\2\2ST\5\24\13\2TU\7\n"+
		"\2\2UV\7\7\2\2VW\5\20\t\2WX\5\30\r\2XY\7\13\2\2YZ\b\b\1\2Zh\3\2\2\2[\\"+
		"\7,\2\2\\]\7\t\2\2]^\5\24\13\2^_\7\n\2\2_`\7\4\2\2`a\5\36\20\2ab\7\7\2"+
		"\2bc\5\20\t\2cd\5\30\r\2de\7\13\2\2ef\b\b\1\2fh\3\2\2\2gQ\3\2\2\2g[\3"+
		"\2\2\2h\17\3\2\2\2ij\5\22\n\2jk\b\t\1\2km\3\2\2\2li\3\2\2\2mp\3\2\2\2"+
		"nl\3\2\2\2no\3\2\2\2o\21\3\2\2\2pn\3\2\2\2qr\7\3\2\2rs\7,\2\2st\7\4\2"+
		"\2tu\5\36\20\2uv\7\5\2\2vw\b\n\1\2w\23\3\2\2\2xy\7,\2\2yz\7\4\2\2z{\5"+
		"\36\20\2{\u0084\b\13\1\2|}\7\f\2\2}~\7,\2\2~\177\7\4\2\2\177\u0080\5\36"+
		"\20\2\u0080\u0081\b\13\1\2\u0081\u0083\3\2\2\2\u0082|\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087x\3\2\2\2\u0087\u0088\3\2\2\2\u0088\25\3\2\2\2\u0089"+
		"\u008b\7\r\2\2\u008a\u008c\5\32\16\2\u008b\u008a\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\5\2\2\u008e\u00cb\b\f\1\2\u008f"+
		"\u0090\7\16\2\2\u0090\u0091\5\32\16\2\u0091\u0092\7\5\2\2\u0092\u0093"+
		"\b\f\1\2\u0093\u00cb\3\2\2\2\u0094\u0095\7\17\2\2\u0095\u0096\5\32\16"+
		"\2\u0096\u0097\7\5\2\2\u0097\u0098\b\f\1\2\u0098\u00cb\3\2\2\2\u0099\u009a"+
		"\7\20\2\2\u009a\u009b\5\32\16\2\u009b\u009c\7\5\2\2\u009c\u009d\b\f\1"+
		"\2\u009d\u00cb\3\2\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\7\21\2\2\u00a0"+
		"\u00a1\5\32\16\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\b\f\1\2\u00a3\u00cb\3"+
		"\2\2\2\u00a4\u00a5\7\22\2\2\u00a5\u00a6\7\t\2\2\u00a6\u00a7\5\32\16\2"+
		"\u00a7\u00a8\7\n\2\2\u00a8\u00a9\7\7\2\2\u00a9\u00aa\5\30\r\2\u00aa\u00b0"+
		"\7\13\2\2\u00ab\u00ac\7\23\2\2\u00ac\u00ad\7\7\2\2\u00ad\u00ae\5\30\r"+
		"\2\u00ae\u00af\7\13\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\f\1\2\u00b3\u00cb\3\2"+
		"\2\2\u00b4\u00b5\7\24\2\2\u00b5\u00b6\7\t\2\2\u00b6\u00b7\5\32\16\2\u00b7"+
		"\u00b8\7\n\2\2\u00b8\u00b9\7\7\2\2\u00b9\u00ba\5\30\r\2\u00ba\u00bb\7"+
		"\13\2\2\u00bb\u00bc\b\f\1\2\u00bc\u00cb\3\2\2\2\u00bd\u00bf\7\25\2\2\u00be"+
		"\u00c0\5\32\16\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c2\7\5\2\2\u00c2\u00cb\b\f\1\2\u00c3\u00c4\7,\2\2\u00c4"+
		"\u00c5\7\t\2\2\u00c5\u00c6\5\34\17\2\u00c6\u00c7\7\n\2\2\u00c7\u00c8\7"+
		"\5\2\2\u00c8\u00c9\b\f\1\2\u00c9\u00cb\3\2\2\2\u00ca\u0089\3\2\2\2\u00ca"+
		"\u008f\3\2\2\2\u00ca\u0094\3\2\2\2\u00ca\u0099\3\2\2\2\u00ca\u009e\3\2"+
		"\2\2\u00ca\u00a4\3\2\2\2\u00ca\u00b4\3\2\2\2\u00ca\u00bd\3\2\2\2\u00ca"+
		"\u00c3\3\2\2\2\u00cb\27\3\2\2\2\u00cc\u00cd\5\26\f\2\u00cd\u00ce\b\r\1"+
		"\2\u00ce\u00d0\3\2\2\2\u00cf\u00cc\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\31\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d5\b\16\1\2\u00d5\u00d6\7*\2\2\u00d6\u00f9\b\16\1\2\u00d7\u00d8\7"+
		"+\2\2\u00d8\u00f9\b\16\1\2\u00d9\u00da\7-\2\2\u00da\u00f9\b\16\1\2\u00db"+
		"\u00dc\7,\2\2\u00dc\u00f9\b\16\1\2\u00dd\u00de\7\31\2\2\u00de\u00df\5"+
		"\32\16\13\u00df\u00e0\b\16\1\2\u00e0\u00f9\3\2\2\2\u00e1\u00e2\7\32\2"+
		"\2\u00e2\u00e3\5\32\16\n\u00e3\u00e4\b\16\1\2\u00e4\u00f9\3\2\2\2\u00e5"+
		"\u00e6\7\t\2\2\u00e6\u00e7\5\32\16\2\u00e7\u00e8\7\n\2\2\u00e8\u00e9\b"+
		"\16\1\2\u00e9\u00f9\3\2\2\2\u00ea\u00eb\7&\2\2\u00eb\u00ec\5\36\20\2\u00ec"+
		"\u00ed\7#\2\2\u00ed\u00ee\7\t\2\2\u00ee\u00ef\5\32\16\2\u00ef\u00f0\7"+
		"\n\2\2\u00f0\u00f1\b\16\1\2\u00f1\u00f9\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3"+
		"\u00f4\7\t\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6\7\n\2\2\u00f6\u00f7\b"+
		"\16\1\2\u00f7\u00f9\3\2\2\2\u00f8\u00d4\3\2\2\2\u00f8\u00d7\3\2\2\2\u00f8"+
		"\u00d9\3\2\2\2\u00f8\u00db\3\2\2\2\u00f8\u00dd\3\2\2\2\u00f8\u00e1\3\2"+
		"\2\2\u00f8\u00e5\3\2\2\2\u00f8\u00ea\3\2\2\2\u00f8\u00f2\3\2\2\2\u00f9"+
		"\u011a\3\2\2\2\u00fa\u00fb\f\t\2\2\u00fb\u00fc\t\2\2\2\u00fc\u00fd\5\32"+
		"\16\n\u00fd\u00fe\b\16\1\2\u00fe\u0119\3\2\2\2\u00ff\u0100\f\b\2\2\u0100"+
		"\u0101\t\3\2\2\u0101\u0102\5\32\16\t\u0102\u0103\b\16\1\2\u0103\u0119"+
		"\3\2\2\2\u0104\u0105\f\7\2\2\u0105\u0106\t\4\2\2\u0106\u0107\5\32\16\b"+
		"\u0107\u0108\b\16\1\2\u0108\u0119\3\2\2\2\u0109\u010a\f\6\2\2\u010a\u010b"+
		"\t\5\2\2\u010b\u010c\5\32\16\7\u010c\u010d\b\16\1\2\u010d\u0119\3\2\2"+
		"\2\u010e\u010f\f\r\2\2\u010f\u0110\7\26\2\2\u0110\u0111\7,\2\2\u0111\u0119"+
		"\b\16\1\2\u0112\u0113\f\f\2\2\u0113\u0114\7\27\2\2\u0114\u0115\5\32\16"+
		"\2\u0115\u0116\7\30\2\2\u0116\u0117\b\16\1\2\u0117\u0119\3\2\2\2\u0118"+
		"\u00fa\3\2\2\2\u0118\u00ff\3\2\2\2\u0118\u0104\3\2\2\2\u0118\u0109\3\2"+
		"\2\2\u0118\u010e\3\2\2\2\u0118\u0112\3\2\2\2\u0119\u011c\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\33\3\2\2\2\u011c\u011a\3\2\2"+
		"\2\u011d\u011e\5\32\16\2\u011e\u0125\b\17\1\2\u011f\u0120\7\f\2\2\u0120"+
		"\u0121\5\32\16\2\u0121\u0122\b\17\1\2\u0122\u0124\3\2\2\2\u0123\u011f"+
		"\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u011d\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\35\3\2\2\2\u012a\u012b\7,\2\2\u012b\u0136\b\20\1\2\u012c\u012d"+
		"\7\27\2\2\u012d\u012e\7*\2\2\u012e\u012f\7\30\2\2\u012f\u0130\5\36\20"+
		"\2\u0130\u0131\b\20\1\2\u0131\u0136\3\2\2\2\u0132\u0133\5 \21\2\u0133"+
		"\u0134\b\20\1\2\u0134\u0136\3\2\2\2\u0135\u012a\3\2\2\2\u0135\u012c\3"+
		"\2\2\2\u0135\u0132\3\2\2\2\u0136\37\3\2\2\2\u0137\u0138\7\'\2\2\u0138"+
		"\u013e\b\21\1\2\u0139\u013a\7(\2\2\u013a\u013e\b\21\1\2\u013b\u013c\7"+
		")\2\2\u013c\u013e\b\21\1\2\u013d\u0137\3\2\2\2\u013d\u0139\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013e!\3\2\2\2\25*\66Ngn\u0084\u0087\u008b\u00b0\u00bf"+
		"\u00ca\u00d1\u00f8\u0118\u011a\u0125\u0128\u0135\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}