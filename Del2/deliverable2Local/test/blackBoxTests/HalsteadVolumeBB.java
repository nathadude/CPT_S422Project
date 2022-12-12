package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import parse.TreeWalker;
import aCheck.HalsteadVolumeCheck;
class HalsteadVolumeBB {

	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadVolumeCheck check = new HalsteadVolumeCheck();
		String filePath = "test/testFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		DecimalFormat df=new DecimalFormat("0.00");
		String formate = df.format(check.getHalsteadVolume()); 
		double finalValue = (Double)df.parse(formate) ;
		assertEquals(423.05, finalValue);

	}
	
	@Test
	void volumeTest() throws IOException, CheckstyleException, ParseException {
		HalsteadVolumeCheck check = new HalsteadVolumeCheck();
		String filePath = "test/testFiles/VolTest.java"; // VolTest
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		DecimalFormat df=new DecimalFormat("0.00");
		String formate = df.format(check.getHalsteadVolume()); 
		double finalValue = (Double)df.parse(formate) ;
		assertEquals(217.13, finalValue);
	}
}
