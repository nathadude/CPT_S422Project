package tokens;

import com.puppycrawl.tools.checkstyle.api.*;

//made so I don't have to type/copy paste one million times
public class Operands 
{
	public static int[] operands() 
	{
		return new int[] 
		{
				TokenTypes.CHAR_LITERAL, 	TokenTypes.LITERAL_BOOLEAN, 	TokenTypes.LITERAL_BYTE,
				TokenTypes.LITERAL_CHAR, 	TokenTypes.LITERAL_INT,  		TokenTypes.LITERAL_LONG,
				TokenTypes.LITERAL_SHORT,	TokenTypes.LITERAL_VOID,	 	TokenTypes.STRING_LITERAL, 
				TokenTypes.NUM_DOUBLE,		TokenTypes.NUM_FLOAT, 			TokenTypes.NUM_INT,
				TokenTypes.NUM_LONG
		};
	};
}
