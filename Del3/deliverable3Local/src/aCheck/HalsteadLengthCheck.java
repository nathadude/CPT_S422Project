package aCheck;

import com.puppycrawl.tools.checkstyle.api.*;

import tokens.Operands;
import tokens.Operators;

public class HalsteadLengthCheck extends AbstractCheck  
{
	private int halsteadLength = 0;

	@Override
	public int[] getDefaultTokens() {

		return this.getAcceptableTokens();
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		this.halsteadLength++;
	}

	@Override
	public int[] getAcceptableTokens() 
	{

		return this.getRequiredTokens();
	}
	
	public int getHalsteadLength() 
	{
		return this.halsteadLength;
	}

	@Override
	public int[] getRequiredTokens() 
	{
		int[] combArr = new int[Operators.operators().length + Operands.operands().length];
		System.arraycopy(Operators.operators(), 0, combArr, 0, Operators.operators().length);
		System.arraycopy(Operands.operands(), 0, combArr, Operators.operators().length, Operands.operands().length);
		
		return combArr;
	}

	@Override
	public void finishTree(DetailAST root) 
	{
		//Output for runtime
		log(root, "Halstead Length: "+ halsteadLength + " -NA");
		this.halsteadLength = 0; //set back to 0
	}
}
