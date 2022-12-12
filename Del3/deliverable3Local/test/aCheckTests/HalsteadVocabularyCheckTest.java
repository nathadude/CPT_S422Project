package aCheckTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.io.File;

import org.junit.jupiter.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import aCheck.HalsteadVocabularyCheck;
import tokens.Operands;
import tokens.Operators;

public class HalsteadVocabularyCheckTest 
{
	// Setup
	private HalsteadVocabularyCheck check = new HalsteadVocabularyCheck();
	
	private int[] operands = Operands.operands();
	private int[] operators = Operators.operators();
	
	private int[] addVocab(int[] first, int[] second) 
	{
		int[] combArr = new int[first.length + second.length];
		System.arraycopy(Operators.operators(), 0, combArr, 0, first.length);
		System.arraycopy(Operands.operands(), 0, combArr, first.length, second.length);
		
		return combArr;
	}
	
	private int[] valid = this.addVocab(operators, operands);
	
	@Test
	public void getRequiredTokensTest() 
	{
		Assert.assertArrayEquals(this.valid, this.check.getRequiredTokens());
	}
	
	@Test
	public void getAcceptableTokensTest() 
	{
		// Spy used to stub previously tested function
		HalsteadVocabularyCheck spy = Mockito.spy(HalsteadVocabularyCheck.class);
		Mockito.when(spy.getRequiredTokens()).thenReturn(this.valid);
		Assert.assertArrayEquals(this.valid, spy.getAcceptableTokens());
	}
	
	@Test
	public void getDefaultTokensTest() 
	{
		// Spy used to stub previously tested function
		HalsteadVocabularyCheck spy = Mockito.spy(HalsteadVocabularyCheck.class);
		Mockito.when(spy.getAcceptableTokens()).thenReturn(this.valid);
		Assert.assertArrayEquals(this.valid, spy.getDefaultTokens());
	}
	
	@Test
	public void visitTokenTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		Mockito.when(spy.getType()).thenReturn(TokenTypes.LITERAL_INT);
		HalsteadVocabularyCheck spyCheck = Mockito.spy(HalsteadVocabularyCheck.class);
		
		// Check first conditional
		spyCheck.visitToken(spy);
		spyCheck.visitToken(spy);
		// Verify function was called
		
		Mockito.verify(spyCheck, times(2)).visitToken(spy);
	}
	
	// ??
	@Ignore
	@Test
	public void finishTreeTest() 
	{
		DetailAST ast = Mockito.spy(DetailAST.class);
		Mockito.when(ast.getType()).thenReturn(TokenTypes.LITERAL_INT);
		
		HalsteadVocabularyCheck spy = Mockito.spy(HalsteadVocabularyCheck.class);
	}
	
	@Test
	public void getSumTest() 
	{
		assertEquals(0, this.check.getSum());
	}
}
