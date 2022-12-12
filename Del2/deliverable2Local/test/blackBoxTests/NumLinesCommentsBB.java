package blackBoxTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import parse.TreeWalker;
import bCheck.NumCommentsCheck;

import org.junit.jupiter.api.Test;
class NumLinesCommentsBB 
{
	@Test
	void noCommentTest() throws Exception, CheckstyleException 
	{
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/NoLines.java"; // NoLines
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(0, check.getCommentLineCount());

	}
	
	@Test
	void oneCommentTest() throws Exception, CheckstyleException 
	{
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/OneLine.java"; // OneLine
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(3, check.getCommentLineCount());

	}
	@Test
	void manyCommentTest() throws Exception, CheckstyleException 
	{
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/ManyLines.java"; // ManyLines
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(10, check.getCommentLineCount());

	} 
	
	@Test
	void singleAndMultiCommentTest() throws Exception, CheckstyleException 
	{
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/CommentTypeTest.java"; // CommentTypeTest
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(8, check.getCommentLineCount());

	} 
}
