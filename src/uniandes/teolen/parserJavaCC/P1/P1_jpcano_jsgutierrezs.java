/* Generated By:JavaCC: Do not edit this line. P1_jpcano_jsgutierrezs.java */
package uniandes.teolen.parserJavaCC.P1;

import java.util.ArrayList;

public class P1_jpcano_jsgutierrezs implements P1_jpcano_jsgutierrezsConstants {

  private static ArrayList<String > variables = new ArrayList<String >();

  private static ArrayList<String > metodos = new ArrayList<String >();

  public static boolean buscarNombre(String a, ArrayList<String > list)
  {
        for(int i = 0; i < list.size(); ++i)
        {
          if(a.equalsIgnoreCase(list.get(i)))
          {
            return true;
          }
        }
        return false;
  }

  public static void main(String args []) throws ParseException
  {
    System.out.println("hello world");
    try
    {
      P1_jpcano_jsgutierrezs parser = new P1_jpcano_jsgutierrezs(System.in);
      parser.programa();
      System.out.println("\u005ctAnalizador terminado");
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
          System.out.println("\u005ctAnalizador ha terminado.");
    }
  }

//es usado en la interfaz
  static final public void one_line() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      guardarVar();
      break;
    case DEFINE:
      methods();
      break;
    case PRINT:
      print();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//es usado en consola
  static final public void programa() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      guardarVar();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DEFINE:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      methods();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRINT:
      print();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(0);
  }

  static final public void guardarVar() throws ParseException, Error {
  Token t = null;
    jj_consume_token(VAR);
    t = jj_consume_token(IDENTIFIER);
    jj_consume_token(EQUALS);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      jj_consume_token(CONSTANT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
      case CONSTANT:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
    }
    String a = t.image;

        if(buscarNombre(a, variables))
        {
          System.out.println("La variable ya existe");
          {if (true) throw new Error("La variable ya existe");}
        }
        else if(a.equalsIgnoreCase("var") || a.equalsIgnoreCase("if") || a.equalsIgnoreCase("define") || a.equalsIgnoreCase("print"))
        {
          System.out.println("La palabra var est\u00c3\u00a1 reservada");
          {if (true) throw new Error("La palabra var est\u00c3\u00a1 reservada");}
        }
        else
        {
          variables.add(a);
        }
  }

  static final public Token name() throws ParseException {
  Token t;
    t = jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LP:
      jj_consume_token(LP);
      expresionArit();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_4;
        }
        jj_consume_token(COMMA);
        expresionArit();
      }
      jj_consume_token(RP);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    String a = t.image;

    if(!buscarNombre(a, variables) && !buscarNombre(a, metodos))
    {
      {if (true) throw new Error("El nombre no existe");}
    }
    else
    {
      {if (true) return t;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public void methods() throws ParseException, Error {
  Token t;
    jj_consume_token(DEFINE);
    t = jj_consume_token(IDENTIFIER);
    jj_consume_token(LP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_5;
        }
        jj_consume_token(COMMA);
        jj_consume_token(IDENTIFIER);
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(RP);
    jj_consume_token(SEMICOLON);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case IDENTIFIER:
      case SR:
      case MINUS:
      case CONSTANT:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        ifSentence();
        break;
      case IDENTIFIER:
      case SR:
      case MINUS:
      case CONSTANT:
        expresionArit();
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    String a = t.image;

    if(buscarNombre(a, metodos) || buscarNombre(a, variables))
    {
      {if (true) throw new Error("Ya existe el nombre");}
    }
    else if(a.equals("var") || a.equalsIgnoreCase("if") || a.equalsIgnoreCase("define") || a.equalsIgnoreCase("print"))
    {
      {if (true) throw new Error("Var est\u00c3\u00a1 reservado");}
    }
    else
    {
      metodos.add(a);
    }
  }

  static final public void operadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MA:
      jj_consume_token(MA);
      break;
    case EQ:
      jj_consume_token(EQ);
      break;
    case ME:
      jj_consume_token(ME);
      break;
    case PE:
      jj_consume_token(PE);
      break;
    case LE:
      jj_consume_token(LE);
      break;
    case DI:
      jj_consume_token(DI);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ifSentence() throws ParseException {
  Token t;
    jj_consume_token(IF);
    t = jj_consume_token(LP);
    condicion();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
      case OR:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        jj_consume_token(AND);
        break;
      case OR:
        jj_consume_token(OR);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      condicion();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
    case SR:
    case MINUS:
    case CONSTANT:
      expresionArit();
      break;
    case IF:
      ifSentence();
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
    case SR:
    case MINUS:
    case CONSTANT:
      expresionArit();
      break;
    case IF:
      ifSentence();
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RP);
  }

  static final public void valor() throws ParseException {
    if (jj_2_1(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        name();
        break;
      case MINUS:
      case CONSTANT:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MINUS:
          jj_consume_token(MINUS);
          break;
        default:
          jj_la1[17] = jj_gen;
          ;
        }
        jj_consume_token(CONSTANT);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
      case SR:
      case MINUS:
      case CONSTANT:
        expresionArit();
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void expresionArit() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
    case MINUS:
    case CONSTANT:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
      case CONSTANT:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MINUS:
          jj_consume_token(MINUS);
          break;
        default:
          jj_la1[20] = jj_gen;
          ;
        }
        jj_consume_token(CONSTANT);
        break;
      case IDENTIFIER:
        name();
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      operadorArit();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
      case CONSTANT:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MINUS:
          jj_consume_token(MINUS);
          break;
        default:
          jj_la1[22] = jj_gen;
          ;
        }
        jj_consume_token(CONSTANT);
        break;
      case IDENTIFIER:
        name();
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case SR:
      jj_consume_token(SR);
      expresionArit();
      jj_consume_token(SL);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void condicion() throws ParseException {
    valor();
    operadores();
    valor();
  }

  static final public void print() throws ParseException {
  Token t;
    t = jj_consume_token(PRINT);
    jj_consume_token(LP);
    expresionArit();
    jj_consume_token(RP);
  }

  static final public void operadorArit() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
      break;
    case DIVIDE:
      jj_consume_token(DIVIDE);
      break;
    case MODULO:
      jj_consume_token(MODULO);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(LP)) return true;
    return false;
  }

  static private boolean jj_3R_8() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_8()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) return true;
    }
    return false;
  }

  static private boolean jj_3R_9() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(20)) jj_scanpos = xsp;
    if (jj_scan_token(CONSTANT)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public P1_jpcano_jsgutierrezsTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[26];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1c0,0x40,0x80,0x100,0x100000,0x100000,0x10000,0x2000,0x10000,0x800,0x120820,0x120820,0x7e000000,0x80000000,0x80000000,0x120820,0x120820,0x100000,0x100800,0x120800,0x100000,0x100800,0x100000,0x100800,0x120800,0x1780000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x2,0x0,0x0,0x0,0x0,0x2,0x2,0x0,0x1,0x1,0x2,0x2,0x0,0x2,0x2,0x0,0x2,0x0,0x2,0x2,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public P1_jpcano_jsgutierrezs(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public P1_jpcano_jsgutierrezs(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new P1_jpcano_jsgutierrezsTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public P1_jpcano_jsgutierrezs(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new P1_jpcano_jsgutierrezsTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public P1_jpcano_jsgutierrezs(P1_jpcano_jsgutierrezsTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(P1_jpcano_jsgutierrezsTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[35];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 26; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 35; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
