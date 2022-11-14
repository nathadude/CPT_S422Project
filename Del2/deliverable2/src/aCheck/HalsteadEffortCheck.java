package aCheck;

import com.puppycrawl.tools.checkstyle.api.*;

import aCheck.HalsteadVolumeCheck;

public class HalsteadEffortCheck extends AbstractCheck 
{
	
	private HalsteadVolumeCheck volCheck = new HalsteadVolumeCheck();
	private HalsteadDifficultyCheck diffCheck = new HalsteadDifficultyCheck();

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
		return diffCheck.getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) 
	{
		this.volCheck.beginTree(ast);
		this.diffCheck.beginTree(ast);
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		this.volCheck.visitToken(ast);
		this.diffCheck.visitToken(ast);
	}
	
	// Compute results
	public double getHalsteadEffort() 
	{
		return  Math.round(this.diffCheck.getHalsteadDifficulty())*Math.round(this.volCheck.getHalsteadVolume());
	}
	
	@Override
	public void finishTree(DetailAST ast) 
	{
		this.volCheck.finishTree(ast);
		log(ast, "Halstead Effort: " + this.getHalsteadEffort() + " -NA");
	}
}
