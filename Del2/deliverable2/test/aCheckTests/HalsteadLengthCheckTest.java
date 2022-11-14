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

import aCheck.HalsteadLengthCheck;
import tokens.*;

public class HalsteadLengthCheckTest {
	
	// Setup
	private HalsteadLengthCheck check = new HalsteadLengthCheck();
	
	private int[] operands = Operands.operands();
	private int[] operators = Operators.operators();
	
	private int[] addLength(int[] first, int[] second) 
	{
		int[] combArr = new int[first.length + second.length];
		System.arraycopy(Operators.operators(), 0, combArr, 0, first.length);
		System.arraycopy(Operands.operands(), 0, combArr, first.length, second.length);
		
		return combArr;
	}
	
	private int[] valid = this.addLength(operators, operands);
	
	// Tree-Scaler
	private void scaler(HalsteadLengthCheck check, DetailAST ast) 
	{
		while (ast != null) 
		{
			check.visitToken(ast);
			scaler(check, ast.getFirstChild());
			ast = ast.getNextSibling();
		}
	}
	
	//
//	private DetailAST getSampleAST() 
//	{
//		try 
//		{
//			File testFile = new File?? // not sure how to set this up - as it isn't working
//			FileText testText = new FileText(testFile, "UTF-8");
//			FileContents testContents = new FileContents(testText);
//			DetailAST ast = JavaParser.parse(testContents);
//			
//			this.scaler(this.check, ast);
//			return ast;
//		}
//		catch(Exception e) 
//		{
//			System.out.print(e.getLocalizedMessage());
//			return null;
//		}
//	}
	
	@Test
	public void getHalsteadLengthTest() 
	{
		assertEquals(0, this.check.getHalsteadLength());
	}
	
	
	@Test
	public void getRequiredTokensTest()
{
		Assert.assertArrayEquals(this.valid, this.check.getRequiredTokens());
	}
	
	@Test
	public void getAcceptableTokensTest() 
	{
		// Spy used to stub previously tested function
		HalsteadLengthCheck spy = Mockito.spy(HalsteadLengthCheck.class);
		Mockito.when(spy.getRequiredTokens()).thenReturn(this.valid);
		Assert.assertArrayEquals(this.valid, spy.getAcceptableTokens());
	}
	
	@Test
	public void getDefaultTokensTest() 
	{
		// Spy used to stub previously tested function
		HalsteadLengthCheck spy = Mockito.spy(HalsteadLengthCheck.class);
		Mockito.when(spy.getAcceptableTokens()).thenReturn(this.valid);
		Assert.assertArrayEquals(this.valid, spy.getDefaultTokens());
	}
	
	@Ignore
	@Test
	public void visitTokenTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		Mockito.when(spy.getType()).thenReturn(TokenTypes.ASSIGN);
		
		HalsteadLengthCheck spyCheck = Mockito.spy(HalsteadLengthCheck.class);
		spyCheck.visitToken(spy);
		
		Mockito.verify(spyCheck, times(1)).visitToken(spy);
	}
	
	//cant test finishtree??
	@Ignore
	@Test
	public void finishTreeTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		HalsteadLengthCheck spyCheck = Mockito.spy(HalsteadLengthCheck.class);
		// spyCheck.finishTree(spy);
		// ??
	}
}
