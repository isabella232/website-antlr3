/*
 * ANTLR-generated file resulting from grammar test.g
 * 
 * Terence Parr, MageLang Institute
 * with John Lilley, Empathy Software
 * ANTLR Version 2.20b7; 1996,1997
 */
import antlr.Tokenizer;
import antlr.TokenBuffer;
import antlr.LLkParserNoInteractive;
import antlr.Token;
import antlr.ParserException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

import antlr.ASTFactory;
import antlr.collections.ASTEnumeration;

public class SupportTest extends antlr.LLkParserNoInteractive implements SupportTestTokenTypes {

/** Test the equals, equalsSubtree, and findAll methods plus AST enumeration.
 *  The output should be: 
	t is  ( = a 1 )
	u is  ( = b )
	v is  ( = 4 )
	w is  =
	
	t.equalsTree(t) is true
	t.equalsTree(u) is false
	t.equalsTree(v) is false
	t.equalsTree(w) is false
	t.equalsTree(null) is false
	
	t.equalsTreePartial(t) is true
	t.equalsTreePartial(u) is true
	t.equalsTreePartial(v) is false
	t.equalsTreePartial(w) is true
	t.equalsTreePartial(null) is true
	
	a is  ( A ( B C ( A B ) ) ( A B ) ( F ( A B ) ) ( A ( A B ) ) ) J
	
	              A---------------------J
	              |
	              B-----A-----F----A
	              |     |     |    |
	              C--A  B     A    A
	                 |        |    |
	                 B        B    B
	
	x is second sibling of upperleftmost A:  ( A B ) ( F ( A B ) ) ( A ( A B ) )
	y is child B of x:  B
	x.equalsTree(#(A B)) is true
	x.equalsList(#(A B)) is false
	x.equalsListPartial(#(A B)) is true
	a.equalsTree(#(A B)) is false
	a.equalsTreePartial(#(A B)) is true
	y.equalsList(#[B]) is true
	y.equalsListPartial(#[B]) is true
	
	a.findAllPartial(#(A B)):
	 ( A ( B C ( A B ) ) ( A B ) ( F ( A B ) ) ( A ( A B ) ) ) J
	 ( A B )
	 ( A B ) ( F ( A B ) ) ( A ( A B ) )
	 ( A B )
	 ( A B )
	
	a.findAllPartial(#[A])):
	 ( A ( B C ( A B ) ) ( A B ) ( F ( A B ) ) ( A ( A B ) ) ) J
	 ( A B )
	 ( A B ) ( F ( A B ) ) ( A ( A B ) )
	 ( A B )
	 ( A ( A B ) )
	 ( A B )
	
	a.findAll(#(A B)):
	 ( A B )
	 ( A B ) ( F ( A B ) ) ( A ( A B ) )
	 ( A B )
	 ( A B )
	
	
	Test results:
	equalsTree is ok
	equalsTreePartial is ok
	equalsList is ok
	equalsListPartial is ok
 */
	public static void main(String[] args) {
		boolean r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17;

		// define "astFactory" so translation of #(...) works
		ASTFactory astFactory = new ASTFactory();
		AST t = (AST)astFactory.make( (new ASTArray(3)).add((AST)astFactory.create(ASSIGN,"=")).add((AST)astFactory.create(ID,"a")).add((AST)astFactory.create(INT,"1"))); // build "a=1" tree
		System.out.println("t is " + t.toStringList());
		AST u = (AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(ASSIGN,"=")).add((AST)astFactory.create(ID,"b"))); // build "b=?" tree
		System.out.println("u is " + u.toStringList());
		AST v = (AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(ASSIGN,"=")).add((AST)astFactory.create(INT,"4"))); // build "4=?" tree
		System.out.println("v is " + v.toStringList());
		AST w = (AST)astFactory.create(ASSIGN,"="); // build "=" tree
		System.out.println("w is " + w.toStringList());
		System.out.println("");

		System.out.println("t.equalsTree(t) is " + (r1=t.equalsTree(t)));
		System.out.println("t.equalsTree(u) is " + (r2=t.equalsTree(u)));
		System.out.println("t.equalsTree(v) is " + (r3=t.equalsTree(v)));
		System.out.println("t.equalsTree(w) is " + (r4=t.equalsTree(w)));
		System.out.println("t.equalsTree(null) is " + (r5=t.equalsTree(null)));
		System.out.println("");

		System.out.println("t.equalsTreePartial(t) is " + (r6=t.equalsTreePartial(t)));
		System.out.println("t.equalsTreePartial(u) is " + (r7=t.equalsTreePartial(u)));
		System.out.println("t.equalsTreePartial(v) is " + (r8=t.equalsTreePartial(v)));
		System.out.println("t.equalsTreePartial(w) is " + (r9=t.equalsTreePartial(w)));
		System.out.println("t.equalsTreePartial(null) is " + (r10=t.equalsTreePartial(null)));
		System.out.println("");

		/* (A (B C (A B)) (A B) (F (A B)) (A (A B)) ) J
		   Visually:
              A---------------------J
              |
              B-----A-----F----A
              |     |     |    |
              C--A  B     A    A
                 |        |    |
                 B        B    B
		*/
		AST a = (AST)astFactory.make( (new ASTArray(3)).add(null).add((AST)astFactory.make( (new ASTArray(5)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.make( (new ASTArray(3)).add((AST)astFactory.create(B,"B")).add((AST)astFactory.create(C,"C")).add((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B")))))).add((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B")))).add((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(F,"F")).add((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B")))))).add((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B")))))))).add((AST)astFactory.create(J,"J"))); 
		System.out.println("a is "+a.toStringList()+"\n");
		System.out.println("              A---------------------J");
		System.out.println("              |");
		System.out.println("              B-----A-----F----A");
		System.out.println("              |     |     |    |");
		System.out.println("              C--A  B     A    A");
		System.out.println("                 |        |    |");
		System.out.println("                 B        B    B\n");

		AST x = a.getFirstChild().getNextSibling();
		System.out.println("x is second sibling of upperleftmost A: "+x.toStringList());
		AST y = a.getFirstChild().getNextSibling().getFirstChild();
		System.out.println("y is child B of x: "+y.toStringList());
		System.out.println("x.equalsTree(#(A B)) is "+(r11=x.equalsTree((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B"))))));
		System.out.println("x.equalsList(#(A B)) is "+(r12=x.equalsList((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B"))))));
		System.out.println("x.equalsListPartial(#(A B)) is "+(r13=x.equalsListPartial((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A)).add((AST)astFactory.create(B))))));
		System.out.println("a.equalsTree(#(A B)) is "+(r14=a.equalsTree((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A)).add((AST)astFactory.create(B))))));
		System.out.println("a.equalsTreePartial(#(A B)) is "+(r15=a.equalsTreePartial((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A)).add((AST)astFactory.create(B))))));
		System.out.println("y.equalsList(#[B]) is "+(r16=y.equalsList((AST)astFactory.create(B,"B"))));
		System.out.println("y.equalsListPartial(#[B]) is "+(r17=y.equalsList((AST)astFactory.create(B,"B"))));

		ASTEnumeration enum;
		System.out.println("\na.findAllPartial(#(A B)):");
		enum = a.findAllPartial((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A)).add((AST)astFactory.create(B))));
		while ( enum.hasMoreNodes() ) {
			System.out.println(enum.nextNode().toStringList());
		}

		System.out.println("\na.findAllPartial(#[A])):");
		enum = a.findAllPartial((AST)astFactory.create(A));
		while ( enum.hasMoreNodes() ) {
			System.out.println(enum.nextNode().toStringList());
		}

		System.out.println("\na.findAll(#(A B)):");
		enum = a.findAll((AST)astFactory.make( (new ASTArray(2)).add((AST)astFactory.create(A,"A")).add((AST)astFactory.create(B,"B"))));
		while ( enum.hasMoreNodes() ) {
			System.out.println(enum.nextNode().toStringList());
		}

		// check results
		System.out.println("\nTest results:");
		if ( r1==true && r2==false && r3==false && r4==false &&
			 r5==false && r11==true && r14==false) {
			System.out.println("equalsTree is ok");
		}
		else {
			System.out.println("equalsTree is bad");
		}
		if ( r6==true && r7==true && r8==false && r9==true && r10==true ) {
			System.out.println("equalsTreePartial is ok");
		}
		else {
			System.out.println("equalsTreePartial is bad");
		}
		if ( r12==false && r16==true ) {
			System.out.println("equalsList is ok");
		}
		else {
			System.out.println("equalslist is bad");
		}
		if ( r13==true && r17==true ) {
			System.out.println("equalsListPartial is ok");
		}
		else {
			System.out.println("equalslistPartial is bad");
		}
	}

protected SupportTest(TokenBuffer tokenBuf, int k) {
	super(tokenBuf,k);
	tokenNames = _tokenNames;
}

public SupportTest(TokenBuffer tokenBuf) {
	this(tokenBuf,1);
}

protected SupportTest(Tokenizer lexer, int k) {
	super(lexer,k);
	tokenNames = _tokenNames;
}

public SupportTest(Tokenizer lexer) {
	this(lexer,1);
}

	public final void defTokenTypes() throws ParserException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST defTokenTypes_AST = null;
		
		try {      // for error handling
			AST tmp1_AST = null;
			tmp1_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp1_AST);
			match(ID);
			AST tmp2_AST = null;
			tmp2_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
			match(INT);
			AST tmp3_AST = null;
			tmp3_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp3_AST);
			match(ASSIGN);
			AST tmp4_AST = null;
			tmp4_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp4_AST);
			match(PLUS);
			AST tmp5_AST = null;
			tmp5_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp5_AST);
			match(A);
			AST tmp6_AST = null;
			tmp6_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp6_AST);
			match(B);
			AST tmp7_AST = null;
			tmp7_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp7_AST);
			match(C);
			AST tmp8_AST = null;
			tmp8_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp8_AST);
			match(D);
			AST tmp9_AST = null;
			tmp9_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp9_AST);
			match(E);
			AST tmp10_AST = null;
			tmp10_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp10_AST);
			match(F);
			AST tmp11_AST = null;
			tmp11_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp11_AST);
			match(G);
			AST tmp12_AST = null;
			tmp12_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp12_AST);
			match(H);
			AST tmp13_AST = null;
			tmp13_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp13_AST);
			match(I);
			AST tmp14_AST = null;
			tmp14_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp14_AST);
			match(J);
			AST tmp15_AST = null;
			tmp15_AST = (AST)astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp15_AST);
			match(K);
			defTokenTypes_AST = (AST)currentAST.root;
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
		returnAST = defTokenTypes_AST;
	}

	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<epsilon>",
		"NULL_TREE_LOOKAHEAD",
		"ID",
		"INT",
		"ASSIGN",
		"PLUS",
		"A",
		"B",
		"C",
		"D",
		"E",
		"F",
		"G",
		"H",
		"I",
		"J",
		"K"
	};
	
	private static final long _tokenSet_0_data_[] = { 2L, 0L };
	public static final BitSet _tokenSet_0 = new BitSet(_tokenSet_0_data_);
	
}
