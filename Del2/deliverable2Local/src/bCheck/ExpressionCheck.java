package bCheck;

import com.puppycrawl.tools.checkstyle.api.*;

public class ExpressionCheck extends AbstractCheck 
{
	
	private int count = 0;

	@Override
	public int[] getDefaultTokens() 
	{
		return this.getAcceptableTokens();
	}

	@Override
	public int[] getAcceptableTokens() 
	{
		return this.getRequiredTokens();
	}

	@Override
	public int[] getRequiredTokens() 
	{
		return new int[] {
				TokenTypes.EXPR
		};
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		count++;
	}
	
	public int getExpressions() 
	{
		return count;
	}
	
	@Override
	public void finishTree(DetailAST ast) 
	{
		log(ast, "Number of expressions: " + Integer.toString(count) + " -NA");
		count = 0;
	}
}
