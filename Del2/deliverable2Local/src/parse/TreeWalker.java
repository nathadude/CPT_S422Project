package parse;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import org.junit.jupiter.api.Test;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.JavaParser.Options;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.*;

public class TreeWalker 
{
	
	private AbstractCheck check;
	private String path;
	private DetailAST root;
	
	public TreeWalker(String filePath, AbstractCheck check) 
	{
		this.path = filePath;
		this.check = check;
	}
	

	public void test() throws IOException, CheckstyleException 
	{
			// This builds the file
			String filePath = path;
			File file = new File(filePath);
			FileText ft = new FileText(file,"UTF-8");
			FileContents fc = new FileContents(ft);
			
			// AST built
			if (check.isCommentNodesRequired()) 
			{
				 root = JavaParser.parseFile(file, Options.WITH_COMMENTS);
			} 
			
			else 
			{
				 root = JavaParser.parse(fc);
			}
			
			this.check.configure(new DefaultConfiguration("Local"));
			this.check.contextualize(new DefaultContext());
			this.check.beginTree(root);
			// Visit
			helper(this.check,root);
			// Complete tree
			this.check.finishTree(root);
	}
	
	public void helper(AbstractCheck b, DetailAST curNode) 
	{
		int[] tokens = b.getAcceptableTokens();
		 while (curNode != null) 
		 {
			 if (contains(tokens, curNode.getType())) 
			 {
					b.visitToken(curNode);
			 }
 
			  DetailAST toVisit = curNode.getFirstChild();
			   while (curNode != null && toVisit == null) 
			   {
				   b.leaveToken(curNode);
			       toVisit = curNode.getNextSibling();
			       curNode = curNode.getParent();
			   }
			             curNode = toVisit;
		}
	}
	
	
	public boolean contains(int[] array, int key) {
		
	    for (final int i : array) 
	    {
	        if (i == key) 
	        {
	            return true;
	        }
	    }
	    return false;
	}



}
