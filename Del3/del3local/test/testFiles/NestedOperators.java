package testFiles;

public class NestedOperators 
{
	
	public int HelloWorld() 
	{
		int[] arrays = new int[5];
		for(int i = 0; i <5; i++) 
		{
			arrays[i] = 0;
		}
		int nestedOperators = (5+3-(5/8)*4); 
		switch(arrays[0]) 
		{
		case'5':
			nested();
		
		case'0':
			operators();
		}
		return 6;
	}
	
	public void nested() 
	{
		int one = 2;
	}
	
	public void operators() 
	{
		int two;
	}
}
