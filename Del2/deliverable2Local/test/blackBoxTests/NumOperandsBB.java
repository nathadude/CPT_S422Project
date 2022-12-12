package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import bCheck.NumOperandsCheck;
import parse.TreeWalker;

class NumOperandsBB {


	@Test
	void test() throws IOException, CheckstyleException {
		NumOperandsCheck check = new NumOperandsCheck();
		String filePath = "test/testFiles/NoOperands.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(2, check.getOperands());
	}

	@Test
	void nestedTest() throws IOException, CheckstyleException {
		NumOperandsCheck check = new NumOperandsCheck();
		String filePath = "test/testFiles/ManyOperands.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(8, check.getOperands());
	}

}
