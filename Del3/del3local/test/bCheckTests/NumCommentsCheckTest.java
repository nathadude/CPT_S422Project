package bCheckTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import bCheck.NumCommentsCheck;

import static org.mockito.Mockito.times;

import org.junit.Assert;


public class NumCommentsCheckTest 
{
	
	private NumCommentsCheck commCheck = new NumCommentsCheck(); 
	
	@Test
	public void getDefaultTokens() 
	{
		Assert.assertArrayEquals(new int[] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_END}, this.commCheck.getDefaultTokens());
	}
	
	@Test
	public void beginTreeTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		Mockito.when(spy.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		// Operands
		NumCommentsCheck spyCheck = Mockito.spy(NumCommentsCheck.class);
		spyCheck.visitToken(spy);
		
		spyCheck.beginTree(spy);
		
		Mockito.verify(spyCheck, times(1)).beginTree(spy);
	}
	
	@Test
	public void visitTokenTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		
		Mockito.when(spy.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		
		NumCommentsCheck spyCheck = Mockito.spy(NumCommentsCheck.class);
		spyCheck.visitToken(spy);
		
		Mockito.when(spy.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_END);
		
		spyCheck.visitToken(spy);
		
		Mockito.verify(spyCheck, times(2)).visitToken(spy);
	}
	
//	Comment out for PIT Testing
	@Test
	public void getCommentsCountTest() 
	{
		Assert.assertEquals(2, this.commCheck.getCommentsCount());
	}
	
	@Test
	public void getCommentLineCountTest() 
	{
		Assert.assertEquals(0, this.commCheck.getCommentLineCount());
	}
	// IDK how to test FinishTree
}
