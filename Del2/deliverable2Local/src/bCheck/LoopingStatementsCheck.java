package bCheck;

import com.puppycrawl.tools.checkstyle.api.*;
import org.apache.commons.*;
import org.apache.commons.lang3.ArrayUtils;

public class LoopingStatementsCheck extends AbstractCheck {
	
	public int count = 0;

	@Override
	public int[] getDefaultTokens() {
		return this.getAcceptableTokens();
	}

	@Override
	public int[] getAcceptableTokens() {
		return this.getRequiredTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.DO_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		count++;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(ast, "Looping statements check: " + Integer.toString(count) + " -NA");
		this.count = 0;
	}

	public double getLoopingStatements() {
		return count;
	}
}
