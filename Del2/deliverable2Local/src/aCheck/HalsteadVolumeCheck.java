package aCheck;

import com.puppycrawl.tools.checkstyle.api.*;

import java.util.*;

public class HalsteadVolumeCheck extends AbstractCheck 
{
	private Hashtable<Integer, Integer> opHash = new Hashtable<Integer, Integer>();
	private int opSum;

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
		return new int[] 
		{
				// Operands
				TokenTypes.CHAR_LITERAL, 	TokenTypes.LITERAL_BOOLEAN, 	TokenTypes.LITERAL_BYTE,
				TokenTypes.LITERAL_CHAR, 	TokenTypes.LITERAL_INT,  		TokenTypes.LITERAL_LONG,
				TokenTypes.LITERAL_SHORT,	TokenTypes.LITERAL_VOID,	 	TokenTypes.STRING_LITERAL, 
				TokenTypes.NUM_DOUBLE,		TokenTypes.NUM_FLOAT, 			TokenTypes.NUM_INT,
				TokenTypes.NUM_LONG,
				// Operators
				TokenTypes.ASSIGN,		TokenTypes.BAND,		TokenTypes.BAND_ASSIGN,
				TokenTypes.BNOT,		TokenTypes.BOR,			TokenTypes.BOR_ASSIGN,
				TokenTypes.BSR,			TokenTypes.BSR_ASSIGN,	TokenTypes.BXOR,
				TokenTypes.BXOR_ASSIGN,	TokenTypes.COLON,		TokenTypes.COMMA,
				TokenTypes.DEC,			TokenTypes.DIV,			TokenTypes.DIV_ASSIGN,
				TokenTypes.DOT,			TokenTypes.EQUAL,		TokenTypes.GE,
				TokenTypes.GT,			TokenTypes.INC,			TokenTypes.INDEX_OP,
				TokenTypes.LAND,		TokenTypes.LE,			TokenTypes.LITERAL_INSTANCEOF,
				TokenTypes.LNOT,		TokenTypes.LOR,			TokenTypes.LT,
				TokenTypes.MINUS,		TokenTypes.MINUS_ASSIGN,TokenTypes.MOD,
				TokenTypes.MOD_ASSIGN,	TokenTypes.NOT_EQUAL,	TokenTypes.PLUS,
				TokenTypes.PLUS_ASSIGN,	TokenTypes.POST_DEC,	TokenTypes.POST_INC,
				TokenTypes.QUESTION,	TokenTypes.SL,			TokenTypes.SR,
				TokenTypes.SR_ASSIGN,	TokenTypes.STAR,		TokenTypes.STAR_ASSIGN,
				TokenTypes.UNARY_MINUS,	TokenTypes.UNARY_PLUS
		};
	}
	
	@Override
	public void visitToken(DetailAST ast) 
	{
		if (ast != null && !this.opHash.containsKey(ast.getType())) 
		{
			this.opHash.put(ast.getType(), 1); //unique
		} else 
		{
			this.opHash.put(ast.getType(), this.opHash.get(ast.getType()) + 1); //repeat
		}
	}
	
	public double getHalsteadVolume() 
	{
		int uniqueOperatorsOperands = 0;
		for (int item : this.opHash.values()) 
		{
			this.opSum += item;
		}
		
		for(int item: this.opHash.keySet()) 
		{
			uniqueOperatorsOperands += 1;
		}
		
		double volume = this.opSum * (Math.log(uniqueOperatorsOperands) / Math.log(2));
		return Math.round(volume);
	}
	
	@Override
	public void finishTree(DetailAST ast) 
	{
		double volume = this.getHalsteadVolume();
		log(ast, "Halstead Volume: " + volume + " -NA");
		this.opHash.clear();
		this.opSum = 0;
	}
}
