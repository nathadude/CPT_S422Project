package blackBoxTests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import bCheck.NumOperatorsCheck;
import parse.TreeWalker;
class NumOperatorsBB {

	@Test
	void test() throws IOException, CheckstyleException {
		NumOperatorsCheck check = new NumOperatorsCheck();
		String filePath = "test/testFiles/ManyOperators.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(23, NumOperatorsCheck.getOperators());
	}

	@Test
	void nestedTest() throws IOException, CheckstyleException {
		NumOperatorsCheck check = new NumOperatorsCheck();
		String filePath = "test/testFiles/NestedOperators.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(60, NumOperatorsCheck.getOperators());
	}
}
