package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import aCheck.HalsteadVocabularyCheck;
import parse.TreeWalker;
class HalsteadVocabularyBB {
	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadVocabularyCheck check = new HalsteadVocabularyCheck();
		String filePath = "test/testFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(28, check.getSum());

	}
	@Test
	void onlyUnqueTest() throws Exception, CheckstyleException {
		HalsteadVocabularyCheck check = new HalsteadVocabularyCheck();
		String filePath = "test/testFiles/UniqueVocabTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(13, check.getSum());

	}

}
