package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import aCheck.HalsteadEffortCheck;
import parse.TreeWalker;

class HalsteadEffortBB 
{


	@Test
	void standardTest() throws Exception, CheckstyleException 
	
	{
		HalsteadEffortCheck check = new HalsteadEffortCheck();
		String filePath = "test/testFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(10153, check.getHalsteadEffort());

	}
	
	@Test
	void effortTest() throws Exception, CheckstyleException 
	{
		HalsteadEffortCheck check = new HalsteadEffortCheck();
		String filePath = "test/testFiles/HalsteadEffortTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(648, check.getHalsteadEffort());

	}
}
