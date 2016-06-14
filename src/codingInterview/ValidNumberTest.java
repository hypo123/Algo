package codingInterview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidNumberTest
{
	ValidNumber vn ;
	@Before
	public void setUp() throws Exception
	{
		vn = new ValidNumber();
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
	}

}
