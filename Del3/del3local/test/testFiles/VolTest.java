package testFiles;

public class VolTest 
{
	public String playerState(int a, int b, int c) 
	{
		if( a == b && b ==c) 
		{
			return "ready to go";
		}
		if(a == b && b > c) 
		{
			return "pause";
		}
		else {
			return "dead";
		}
	}
}
