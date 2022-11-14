package bCheck;

import com.puppycrawl.tools.checkstyle.api.*;

public class GetCommentsCheck extends AbstractCheck 
{
	private static int commCount = 0, commLineCount = 0;
	
	public int getCommentsCount() 
	{
		return commCount;
	}
	
	public int getCommentLineCount() 
	{
		return commLineCount;
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		commCount++;
		
		if (ast.getType() == TokenTypes.SINGLE_LINE_COMMENT) 
		{
			commLineCount++;
		} else if (ast.getType() == TokenTypes.BLOCK_COMMENT_END) 
		{
			int lineStart = (ast.getParent() != null) ? ast.getParent().getLineNo() : ast.getLineNo(),
				lineEnd = ast.getLineNo();
			
			commLineCount += (lineStart - lineEnd + 1);
		}
	}
	
	@Override
	public void beginTree(DetailAST ast) 
	{
		commCount = commLineCount = 0;
	}

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
			TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_END
		};
	}
	
	@Override
	public void finishTree(DetailAST ast) 
	{
		log(ast, "Number of comments: " + this.getCommentsCount() + " -NA");
		log(ast, "Number of lines of comments: " + this.getCommentLineCount() + " -NA");
	}
}
