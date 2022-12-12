package aCheck;

import java.util.*;
import java.util.Arrays;

import com.puppycrawl.tools.checkstyle.api.*;

import tokens.Operands;
import tokens.Operators;

import org.apache.commons.*;
// import com.sun.tools.javac.util.*;
// import com.sun.tools.javac.util.ArrayUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Ignore;

public class HalsteadDifficultyCheck extends AbstractCheck 
{
	
	private Hashtable<Integer,Integer> uniqueOperators = new Hashtable<Integer,Integer>();
	private Hashtable<Integer,Integer> uniqueOperands = new Hashtable<Integer,Integer>();

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
		int[] combArr = new int[Operators.operators().length + Operands.operands().length];
		System.arraycopy(Operators.operators(), 0, combArr, 0, Operators.operators().length);
		System.arraycopy(Operands.operands(), 0, combArr, Operators.operators().length, Operands.operands().length);
		
		return combArr;
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		
		// Handles logging unique operators
		if (ArrayUtils.contains(Operators.operators(), ast.getType())) 
		{
			if (!this.uniqueOperators.containsKey(ast.getType())) 
			{
				this.uniqueOperators.put(ast.getType(), 1);
			} else 
			{
				int previous = this.uniqueOperators.get(ast.getType());
				this.uniqueOperators.put(ast.getType(), previous + 1);
			}
		}
		
		// Handles logging unique operands
		if (ArrayUtils.contains(Operands.operands(), ast.getType())) 
		{
			if (!this.uniqueOperands.containsKey(ast.getType())) 
			{
				this.uniqueOperands.put(ast.getType(), 1);
			} else 
			{
				int previous = this.uniqueOperands.get(ast.getType());
				this.uniqueOperands.put(ast.getType(), previous + 1);
			}
		}
	}
	
	public double getHalsteadDifficulty() {
		int uniqueOperators = 0, uniqueOperands = 0, operands = 0;
		
		Iterator<Integer> operandsIter = this.uniqueOperators.keySet().iterator();
		Iterator<Integer> operatorsIter = this.uniqueOperators.keySet().iterator();
			
		while (operatorsIter.hasNext() && !(uniqueOperators >= (int)Integer.MAX_VALUE)) 
		{
			uniqueOperators++; //Iter by 1
		}
		
		while (operandsIter.hasNext() && !(uniqueOperands >= (int)Integer.MAX_VALUE)) 
		{
			uniqueOperands++; //Iter by 1
		}
		
		for (int value : this.uniqueOperands.values()) 
		{
			operands += value; //Updates sum each Iter
		}
		
		if (uniqueOperands == 0) {
			uniqueOperands = 1;
		}
		
		double diff = ((uniqueOperators / 2) * operands) / uniqueOperands;
		return diff;
	}
	
	@Ignore
	@Override
	public void finishTree(DetailAST ast) 
	{
		log(ast, "Halstead Difficulty: ", this.getHalsteadDifficulty() + " -NA");
		uniqueOperands.clear();
		uniqueOperators.clear();
	}
}
