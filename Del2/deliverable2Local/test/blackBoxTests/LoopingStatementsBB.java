package blackBoxTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import bCheck.LoopingStatementsCheck;
import parse.TreeWalker;

class LoopingStatementsBB {

	@Test
	void oneLoopTest() throws Exception, CheckstyleException {
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		String filePath = "test/testFiles/OneLoop.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(1, check.getLoopingStatements());

	}
	@Test
	void manyLoopTest() throws Exception, CheckstyleException {
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		String filePath = "test/testFiles/ManyLoop.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(3, check.getLoopingStatements());

	}
	@Test
	void noLoopTest() throws Exception, CheckstyleException {
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		String filePath = "test/testFiles/NoLoop.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(0, check.getLoopingStatements());

	}
	@Test
	void nestedLoopTest() throws Exception, CheckstyleException {
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		String filePath = "test/testFiles/NestedLoop.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(4, check.getLoopingStatements());

	}
	
	
}
