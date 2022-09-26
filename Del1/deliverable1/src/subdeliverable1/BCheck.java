package subdeliverable1;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class BCheck extends AbstractCheck{

	//Checks number of comments
	private int commCount = 0;
	
	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	}

	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[0];
	}
	
	@Override
	public boolean isCommentNodesRequired() 
	{
		return true;
	}
	
	@Override
	public void beginTree(DetailAST rootAST)
	{
		commCount = 0;
	}
	
	@Override
	public void finishTree(DetailAST rootAST)
	{
		log(rootAST.getLineNo(), "Total comment count:" + commCount + "-NA");
		commCount = 0;
	}
	
	//Now we actually count the single line and block comments
	@Override
	public void visitToken(DetailAST ast) 
	{
		if (ast.branchContains(TokenTypes.SINGLE_LINE_COMMENT))
		{
			commCount++;
		}
		else if (ast.branchContains(TokenTypes.BLOCK_COMMENT_BEGIN))
		{
			commCount++;
		}
	}
	
	//Done!
}
