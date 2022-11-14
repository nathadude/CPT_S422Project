package bCheckTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import bCheck.GetCommentsCheck;

import static org.mockito.Mockito.times;

import org.junit.Assert;


public class GetCommentsCheckTest 
{
	
	private GetCommentsCheck commCheck = new GetCommentsCheck(); 
	
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
		GetCommentsCheck spyCheck = Mockito.spy(GetCommentsCheck.class);
		spyCheck.visitToken(spy);
		
		spyCheck.beginTree(spy);
		
		Mockito.verify(spyCheck, times(1)).beginTree(spy);
	}
	
	@Test
	public void visitTokenTest() 
	{
		DetailAST spy = Mockito.spy(DetailAST.class);
		
		Mockito.when(spy.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		
		GetCommentsCheck spyCheck = Mockito.spy(GetCommentsCheck.class);
		spyCheck.visitToken(spy);
		
		Mockito.when(spy.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_END);
		
		spyCheck.visitToken(spy);
		
		Mockito.verify(spyCheck, times(2)).visitToken(spy);
	}
	
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
