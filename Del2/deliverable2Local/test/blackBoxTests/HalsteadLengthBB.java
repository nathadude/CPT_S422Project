package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import aCheck.HalsteadLengthCheck;
import parse.TreeWalker;

class HalsteadLengthBB 
{

	@Test
	void standardTest() throws Exception, CheckstyleException 
	{
		HalsteadLengthCheck check = new HalsteadLengthCheck();
		String filePath = "test/testFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(95, check.getHalsteadLength());

	}
	
	@Test
	void minimumTest() throws Exception, CheckstyleException 
	{
		HalsteadLengthCheck check = new HalsteadLengthCheck();
		String filePath = "test/testFiles/NoHalsteadLength.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(7, check.getHalsteadLength());

	}
}
