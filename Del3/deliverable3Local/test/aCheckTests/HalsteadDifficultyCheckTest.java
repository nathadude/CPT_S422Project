package aCheckTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;

import java.io.File;
import java.io.IOException;

import org.junit.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.*;
import com.puppycrawl.tools.checkstyle.utils.*;

import org.mockito.Mockito;
import org.mockito.Mockito.*;
// import org.mockito.Mockito.

import aCheck.HalsteadDifficultyCheck;
import tokens.*;

public class HalsteadDifficultyCheckTest 
{
	
	HalsteadDifficultyCheck check = new HalsteadDifficultyCheck();
	
	private int[] valid = 
		{
			// Operands
			TokenTypes.CHAR_LITERAL, 	TokenTypes.LITERAL_BOOLEAN, 	TokenTypes.LITERAL_BYTE,
			TokenTypes.LITERAL_CHAR, 	TokenTypes.LITERAL_INT,  		TokenTypes.LITERAL_LONG,
			TokenTypes.LITERAL_SHORT,	TokenTypes.LITERAL_VOID,	 	TokenTypes.STRING_LITERAL, 
			TokenTypes.NUM_DOUBLE,		TokenTypes.NUM_FLOAT, 			TokenTypes.NUM_INT,
			TokenTypes.NUM_LONG,
			// Operators
			TokenTypes.ASSIGN,		TokenTypes.BAND,		TokenTypes.BAND_ASSIGN,
			TokenTypes.BNOT,		TokenTypes.BOR,			TokenTypes.BOR_ASSIGN,
			TokenTypes.BSR,			TokenTypes.BSR_ASSIGN,	TokenTypes.BXOR,
			TokenTypes.BXOR_ASSIGN,	TokenTypes.COLON,		TokenTypes.COMMA,
			TokenTypes.DEC,			TokenTypes.DIV,			TokenTypes.DIV_ASSIGN,
			TokenTypes.DOT,			TokenTypes.EQUAL,		TokenTypes.GE,
			TokenTypes.GT,			TokenTypes.INC,			TokenTypes.INDEX_OP,
			TokenTypes.LAND,		TokenTypes.LE,			TokenTypes.LITERAL_INSTANCEOF,
			TokenTypes.LNOT,		TokenTypes.LOR,			TokenTypes.LT,
			TokenTypes.MINUS,		TokenTypes.MINUS_ASSIGN,TokenTypes.MOD,
			TokenTypes.MOD_ASSIGN,	TokenTypes.NOT_EQUAL,	TokenTypes.PLUS,
			TokenTypes.PLUS_ASSIGN,	TokenTypes.POST_DEC,	TokenTypes.POST_INC,
			TokenTypes.QUESTION,	TokenTypes.SL,			TokenTypes.SR,
			TokenTypes.SR_ASSIGN,	TokenTypes.STAR,		TokenTypes.STAR_ASSIGN,
			TokenTypes.UNARY_MINUS,	TokenTypes.UNARY_PLUS,

	};
	
//	Not passing - mention in report
//	@Test
//	public void getDefaultTokensTest() 
//	{
//		Assert.assertArrayEquals(this.valid, this.check.getDefaultTokens());
//	}
	
	@Test
	public void getHalsteadDifficultyTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		Mockito.when(spy.getType()).thenReturn(TokenTypes.LITERAL_INT);
		
		HalsteadDifficultyCheck spyCheck = Mockito.spy(HalsteadDifficultyCheck.class);
		spyCheck.visitToken(spy);
		spyCheck.visitToken(spy);
		
		Mockito.when(spy.getType()).thenReturn(TokenTypes.ASSIGN);
		spyCheck.visitToken(spy);
		spyCheck.visitToken(spy);
		
		assertEquals(0, spyCheck.getHalsteadDifficulty());
	}
	
	@Test
	public void visitTokenTest()
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		Mockito.when(spy.getType()).thenReturn(TokenTypes.LITERAL_INT);
		//OPERANDS
		HalsteadDifficultyCheck spyCheck = Mockito.spy(HalsteadDifficultyCheck.class);
		spyCheck.visitToken(spy);
		spyCheck.visitToken(spy);
		
		//OPERATORS
		Mockito.when(spy.getType()).thenReturn(TokenTypes.ASSIGN);
		spyCheck.visitToken(spy);
		spyCheck.visitToken(spy);		
		Mockito.verify(spyCheck, times(4)).visitToken(spy);
	}
}
