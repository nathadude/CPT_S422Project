package subdeliverable1;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class ACheck extends AbstractCheck{

	//Checks for Halstead Length
	//Add operand and operator count
	private int operandCount;
	private int operatorCount;
	private int halsteadLength;
	
	@Override
	public int[] getDefaultTokens() {
		return new int[] 
		{ 
				//Include all operators types, operands
				//Include booleans
				TokenTypes.ASSIGN, TokenTypes.BAND, TokenTypes.BAND_ASSIGN, TokenTypes.BNOT, TokenTypes.BOR,
				TokenTypes.BOR_ASSIGN, TokenTypes.BSR, TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN,
				TokenTypes.COLON, TokenTypes.COMMA, TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN, TokenTypes.DOT,
				TokenTypes.EQUAL,TokenTypes.GE, TokenTypes.GT, TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, 
				TokenTypes.LCURLY, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LNOT,TokenTypes.LOR,
				TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN,
				TokenTypes.NOT_EQUAL, TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, 
				TokenTypes.QUESTION, TokenTypes.SL, TokenTypes.SL_ASSIGN, TokenTypes.SR, TokenTypes.SR_ASSIGN, TokenTypes.STAR,
				TokenTypes.STAR_ASSIGN, TokenTypes.UNARY_MINUS, TokenTypes.UNARY_PLUS,TokenTypes.IDENT,TokenTypes.NUM_FLOAT,TokenTypes.NUM_INT,TokenTypes.NUM_DOUBLE,
				TokenTypes.NUM_LONG, TokenTypes.STRING_LITERAL
		};
	}

	@Override
	public int[] getAcceptableTokens() {
		return getDefaultTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return new int[0];
	}
	
	@Override
	public void beginTree(DetailAST rootAST)
	{
		operandCount = 0;
		operatorCount = 0;
		halsteadLength = 0;
	}
	
	public void finishTree(DetailAST rootAST)
	{
		//calculate and log the results
		halsteadLength = operandCount + operatorCount;
		log(rootAST.getLineNo(), "Halstead length:" + halsteadLength + "-NA");
		operandCount = 0;
		operatorCount = 0;
		halsteadLength = 0;
	}
	
	@Override
	public void visitToken(DetailAST ast)
	{
		if(ast.branchContains(TokenTypes.ASSIGN)|| ast.branchContains(TokenTypes.BAND)|| ast.branchContains(TokenTypes.BAND_ASSIGN)|| ast.branchContains(TokenTypes.BNOT)|| ast.branchContains(TokenTypes.BOR)||
				ast.branchContains(TokenTypes.BOR_ASSIGN)|| ast.branchContains(TokenTypes.BSR)||ast.branchContains(TokenTypes.BSR_ASSIGN)|| ast.branchContains(TokenTypes.BXOR)||ast.branchContains(TokenTypes.BXOR_ASSIGN)|| 
				ast.branchContains(TokenTypes.COLON)||ast.branchContains(TokenTypes.COMMA)|| ast.branchContains(TokenTypes.DEC)||ast.branchContains(TokenTypes.DIV)|| ast.branchContains(TokenTypes.DIV_ASSIGN)||ast.branchContains(TokenTypes.DOT)||
				ast.branchContains(TokenTypes.EQUAL)|| ast.branchContains(TokenTypes.GE)|| ast.branchContains(TokenTypes.GT)||ast.branchContains(TokenTypes.INC)|| ast.branchContains(TokenTypes.INDEX_OP)||ast.branchContains(TokenTypes.LAND)||
				ast.branchContains(TokenTypes.LCURLY)||ast.branchContains(TokenTypes.LE)|| ast.branchContains(TokenTypes.LITERAL_INSTANCEOF)||ast.branchContains(TokenTypes.LNOT)|| ast.branchContains(TokenTypes.LOR)||
				ast.branchContains(TokenTypes.LT)|| ast.branchContains(TokenTypes.MINUS)|| ast.branchContains(TokenTypes.MINUS_ASSIGN)|| ast.branchContains(TokenTypes.MOD)||ast.branchContains(TokenTypes.MOD_ASSIGN)|| 
				ast.branchContains(TokenTypes.NOT_EQUAL)||ast.branchContains(TokenTypes.PLUS)|| ast.branchContains(TokenTypes.PLUS_ASSIGN)||ast.branchContains(TokenTypes.POST_DEC)|| ast.branchContains(TokenTypes.POST_INC)||
				ast.branchContains(TokenTypes.QUESTION)|| ast.branchContains(TokenTypes.SL)|| ast.branchContains(TokenTypes.SL_ASSIGN)|| ast.branchContains(TokenTypes.SR)|| ast.branchContains(TokenTypes.SR_ASSIGN)|| ast.branchContains(TokenTypes.STAR)||
				ast.branchContains(TokenTypes.STAR_ASSIGN)|| ast.branchContains(TokenTypes.UNARY_MINUS)|| ast.branchContains(TokenTypes.UNARY_PLUS))
		{
			operatorCount++;
		}
		else if(ast.branchContains(TokenTypes.IDENT)|| ast.branchContains(TokenTypes.NUM_FLOAT)|| ast.branchContains(TokenTypes.NUM_INT)|| ast.branchContains(TokenTypes.NUM_DOUBLE)|| 
				ast.branchContains(TokenTypes.NUM_LONG)||ast.branchContains(TokenTypes.STRING_LITERAL))
		{
			operandCount++;
		}
	}
	
	//Done!
}
