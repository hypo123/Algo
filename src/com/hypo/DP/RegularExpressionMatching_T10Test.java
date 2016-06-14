package com.hypo.DP;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatching_T10Test
{
	RegularExpressionMatching_T10 rem;
	@Before
	public void setUp() throws Exception
	{
		rem = new RegularExpressionMatching_T10();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIsMatch()
	{
		String text1 = "aa";
		String pattern1 = "a";
		boolean expt1 = false;
		org.junit.Assert.assertEquals("Wrong1", expt1, rem.isMatch(text1,pattern1));

		String text2 = "aa";
		String pattern2 = "aa";
		boolean expt2 = true;
		org.junit.Assert.assertEquals("Wrong2", expt2, rem.isMatch(text2,pattern2));
		
		String text3 = "aaa";
		String pattern3 = "aa";
		boolean expt3 = false;
		org.junit.Assert.assertEquals("Wrong3", expt3, rem.isMatch(text3,pattern3));
		
		String text4 = "aa";
		String pattern4 = "a*";
		boolean expt4 = true;
		org.junit.Assert.assertEquals("Wrong4", expt4, rem.isMatch(text4,pattern4));
		
		String text5 = "aa";
		String pattern5 = ".*";
		boolean expt5 = true;
		org.junit.Assert.assertEquals("Wrong5", expt5, rem.isMatch(text5,pattern5));
	
		String text6 = "aab";
		String pattern6 = "c*a*b";
		boolean expt6 = true;
		org.junit.Assert.assertEquals("Wrong6", expt6, rem.isMatch(text6,pattern6));
	}

}
