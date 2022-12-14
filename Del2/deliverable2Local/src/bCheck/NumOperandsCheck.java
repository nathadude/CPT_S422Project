package bCheck;

import com.puppycrawl.tools.checkstyle.api.*;

import tokens.Operands;
import tokens.Operators;

// Get the count of the operands present in the passed AST.
public class NumOperandsCheck extends AbstractCheck {
	private int count = 0;
	
	public int getOperands() {
		return count;
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		count++;
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		count = 0;
	}

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
		return Operands.operands();
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(ast, "Number of operands: " + this.getOperands() + " -NA");
	}
}
