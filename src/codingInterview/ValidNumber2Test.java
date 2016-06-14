package codingInterview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidNumber2Test
{
	ValidNumber2 vn;

	@Before
	public void setUp() throws Exception
	{
		vn = new ValidNumber2();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIsNumber()
	{
		String s1 = "0";
		boolean expt1 = true;
		org.junit.Assert.assertEquals("Wrong1", expt1, vn.isNumber(s1));
		
		String s2 = " 0.1 ";
		boolean expt2 = true;
		org.junit.Assert.assertEquals("Wrong2", expt2, vn.isNumber(s2));
		
		String s3 = "abc";
		boolean expt3 = false;
		org.junit.Assert.assertEquals("Wrong3", expt3, vn.isNumber(s3));
		
		String s4 = "1 a";
		boolean expt4 = false;
		org.junit.Assert.assertEquals("Wrong4", expt4, vn.isNumber(s4));
		
		String s5 = "2e10";
		boolean expt5 = true;
		org.junit.Assert.assertEquals("Wrong5", expt5, vn.isNumber(s5));
		
		String s6 = ".3";
		boolean expt6 = true;
		org.junit.Assert.assertEquals("Wrong6", expt6, vn.isNumber(s6));
		
		String s7 = "3.";
		boolean expt7 = true;
		org.junit.Assert.assertEquals("Wrong7", expt7, vn.isNumber(s7));
	}

}
