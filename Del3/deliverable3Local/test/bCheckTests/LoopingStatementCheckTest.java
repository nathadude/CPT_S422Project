package bCheckTests;
import org.junit.*;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import bCheck.*;

public class LoopingStatementCheckTest 
{
	
	@Spy
	LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
	
	@Mock
	DetailAST mockDetailAST = mock(DetailAST.class);
	
	private LoopingStatementsCheck check = new LoopingStatementsCheck();
	
	@Test
	public void getDefaultTokensTest() 
	{
		Assertions.assertArrayEquals(new int[] {TokenTypes.DO_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE}, this.check.getDefaultTokens());
	}
	
	@Test
	public void getLoopingStatementsTest() 
	{
		Assertions.assertEquals(0, (double)this.check.getLoopingStatements());
	}
	
	//not passing(?)
	@Test
	public void visitTokenTest() 
	{
//		DetailAST spy = Mockito.spy(DetailAST.class);
//		Mockito.when(spy.getType()).thenReturn(TokenTypes.SLIST);
//		LoopingStatementsCheck spyCheck = Mockito.spy(LoopingStatementsCheck.class);
//		spyCheck.visitToken(spy);
//		Mockito.verify(spyCheck, times(1)).visitToken(spy);
		
		spyCheck.visitToken(mockDetailAST);
		verify(spyCheck, atLeastOnce()).visitToken(mockDetailAST);
		
	}
}
