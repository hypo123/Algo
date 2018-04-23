package com.bourbon.string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LengthOfLastWord_58_Test
{
	LengthOfLastWord_58 t58;
	
	@Before
	public void setUp() throws Exception
	{
		t58 = new LengthOfLastWord_58();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLengthOfLastWord1()
	{
		String s1 = "hello world";
		int expt1 = 5;
		org.junit.Assert.assertEquals("wrong1", expt1, t58.lengthOfLastWord(s1));
	}
	
	@Test
	public void testLengthOfLastWord2()
	{
		String s1 = "hello world  ";
		int expt1 = 5;
		org.junit.Assert.assertEquals("wrong2", expt1, t58.lengthOfLastWord(s1));
	}
	
	@Test
	public void testLengthOfLastWord3()
	{
		String s1 = " ";
		int expt1 = 0;
		org.junit.Assert.assertEquals("wrong3", expt1, t58.lengthOfLastWord(s1));
	}

	@Test
	public void testLengthOfLastWord4()
	{
		String s1 = null;
		int expt1 = 0;
		org.junit.Assert.assertEquals("wrong4", expt1, t58.lengthOfLastWord(s1));
	}
}
