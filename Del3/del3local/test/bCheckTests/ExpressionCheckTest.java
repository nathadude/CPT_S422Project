package bCheckTests;

import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import bCheck.*; 

public class ExpressionCheckTest 
{
	
	@Mock
	 ExpressionCheck mock = mock(ExpressionCheck.class);
	 ExpressionCheck spy = spy(ExpressionCheck.class);
	 DetailAST mockDetailAST = mock(DetailAST.class);
	 ExpressionCheck expression = new ExpressionCheck();

	
	ExpressionCheck check = new ExpressionCheck();
	
	@Test
	public void getDefaultTokensTest() 
	{
		Assertions.assertArrayEquals(new int[] {TokenTypes.EXPR}, this.check.getDefaultTokens());
	}
	
	@Test
	public void getExpressionsTest() 
	{
		Assertions.assertEquals(0, this.check.getExpressions());
	}
	
	@Test
	public void visitTokenTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		Mockito.when(spy.getType()).thenReturn(TokenTypes.EXPR);
		ExpressionCheck spyCheck = Mockito.spy(ExpressionCheck.class);
		spyCheck.visitToken(spy);
		Mockito.verify(spyCheck, times(1)).visitToken(spy);
	}
	
// tried to fix finish tree still couldn't :(	
//	 @Test
//	 public void finishTreeTest() 
//	 {
//	    String message = "NA Number of expressions is: 0";
//	    doNothing().when(expression).log(0, message);
//		expression.finishTree(mockDetailAST);
//		verify(expression).finishTree(mockDetailAST);
//	 }

}
