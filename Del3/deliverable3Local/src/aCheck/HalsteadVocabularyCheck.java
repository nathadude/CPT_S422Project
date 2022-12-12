package aCheck;

import com.puppycrawl.tools.checkstyle.api.*;

import tokens.Operands;
import tokens.Operators;

import java.util.*;

import org.junit.Ignore;

public class HalsteadVocabularyCheck extends AbstractCheck 
{
	
	private Hashtable<Integer, Integer> uniqueHash = new Hashtable<Integer, Integer>();
	private int sumUnique;

	@Override
	public int[] getDefaultTokens() 
	{
		return this.getAcceptableTokens();
	}
	
	public int getSum() 
	{
		return this.sumUnique;
	}

	@Override
	public int[] getAcceptableTokens() 
	{
		return this.getRequiredTokens();
	}

	//uses token set in src.tokens
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
		if (!this.uniqueHash.containsKey(ast.getType())) 
		{
			// This is the first instance of a unique operator or operand
			this.uniqueHash.put(ast.getType(), 1);
		} else 
		{
			// This is a repeated instance of a unique operator or operand
			this.uniqueHash.put(ast.getType(), this.uniqueHash.get(ast.getType()) + 1);
		}
	}
	
	@Ignore
	@Override
	public void finishTree(DetailAST ast) 
	{
		sumUnique = 0;
		for (Iterator<Integer> iterator = this.uniqueHash.keySet().iterator(); iterator.hasNext();) 
		{
			sumUnique++;
		}
		
		log(ast, "Halstead Vocabulary: ", sumUnique + " -NA");
		this.uniqueHash.clear();
	}
	
}
