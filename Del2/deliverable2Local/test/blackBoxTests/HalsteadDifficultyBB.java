package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import aCheck.HalsteadDifficultyCheck;
import parse.TreeWalker;

class HalsteadDifficultyBB 
{

	@Test
	void standardTest() throws Exception, CheckstyleException 
	
	{
		HalsteadDifficultyCheck check = new HalsteadDifficultyCheck();
		String filePath = "test/testFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(24, check.getHalsteadDifficulty());

	}
	
	@Test
	void simpleTest() throws Exception, CheckstyleException 
	
	{
		HalsteadDifficultyCheck check = new HalsteadDifficultyCheck();
		String filePath = "test/testFiles/HalsteadDifficultyTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(10, check.getHalsteadDifficulty());

	}
}
