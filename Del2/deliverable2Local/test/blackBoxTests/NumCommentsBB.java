package blackBoxTests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import parse.TreeWalker;
import bCheck.NumCommentsCheck;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class NumCommentsBB {

	@Test
	void noCommentTest() throws Exception, CheckstyleException {
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/NoComm.java"; // NoComm
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(0, check.getCommentsCount());

	}
	@Test
	void oneCommentTest() throws Exception, CheckstyleException {
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/OneComm.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(1, check.getCommentsCount());

	}
	
	@Test
	void ManyCommentTest() throws Exception, CheckstyleException {
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/ManyComm.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(3, check.getCommentsCount());
	}
	
	@Test
	void multilineCommentTest() throws Exception, CheckstyleException {
		NumCommentsCheck check = new NumCommentsCheck();
		String filePath = "test/testFiles/TwoCommentTypeTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(4, check.getCommentsCount());
	}
}
