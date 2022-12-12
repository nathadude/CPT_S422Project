package testFiles;

public class HalsteadDifficultyTest 
{
	public void funcTest(int[] x) 
	{
		int temp = x[0];
		x[0] = x[x.length-1];
		x[x.length-1] = temp;
	}
}
