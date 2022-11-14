package optional;

import com.puppycrawl.tools.checkstyle.api.*;

public class VariableDeclarationsCheck extends AbstractCheck 
{
	
	private int varCount = 0;

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
				TokenTypes.VARIABLE_DEF
		};
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		varCount++;
	}
	
	public int getDeclarations() 
	{
		return this.varCount;
	}
	
	@Override
	public void finishTree(DetailAST ast) 
	{
		log(ast, "Number of variable declarations: " + this.getDeclarations() + " -NA");
		this.varCount = 0;
	}
}