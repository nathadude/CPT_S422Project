package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;
import parse.TreeWalker;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import bCheck.ExpressionCheck;
class ExpresionCheckBB 
{

		@Test
		void noExpressionTest() throws Exception, CheckstyleException 
		{
			ExpressionCheck check = new ExpressionCheck();
			String filePath = "test/testFiles/NoExpressionTest.java";
			TreeWalker treeWalker = new TreeWalker(filePath,check);
			treeWalker.test();
			assertEquals(0, check.getExpressions());

		}
		
		@Test
		void oneExpressionTest() throws Exception, CheckstyleException 
		{
			ExpressionCheck check = new ExpressionCheck();
			String filePath = "test/testFiles/OneExpression.java";
			TreeWalker treeWalker = new TreeWalker(filePath,check);
			treeWalker.test();
			assertEquals(1, check.getExpressions());

		}
		
		@Test
		void manyExpressionTest() throws Exception, CheckstyleException 
		{
			ExpressionCheck check = new ExpressionCheck();
			String filePath = "test/testFiles/ManyExpressions.java"; 
			TreeWalker treeWalker = new TreeWalker(filePath,check);
			treeWalker.test();
			assertEquals(5, check.getExpressions());

		}

}
