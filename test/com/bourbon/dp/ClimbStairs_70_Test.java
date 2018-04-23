package com.bourbon.dp;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClimbStairs_70_Test
{
	ClimbStairs_70 t70;
	@Before
	public void setUp() throws Exception
	{
		t70 = new ClimbStairs_70();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testClimbStairs1()
	{
		int n = 1;
		int expt1 = 1;
		org.junit.Assert.assertEquals("wrong1", expt1, t70.climbStairs(n));
	}
	
	@Test
	public void testClimbStairs2()
	{
		int n = 2;
		int expt1 = 2;
		org.junit.Assert.assertEquals("wrong2", expt1, t70.climbStairs(n));
	}
	
	@Test
	public void testClimbStairs3()
	{
		int n = 3;
		int expt1 = 3;
		org.junit.Assert.assertEquals("wrong3", expt1, t70.climbStairs(n));
	}
	
	@Test
	public void testClimbStairs4()
	{
		int n = 10;
		int expt1 = 89;
		org.junit.Assert.assertEquals("wrong4", expt1, t70.climbStairs(n));
	}
	
	@Test
	public void testClimbStairs5()
	{
		int n = 0;
		int expt1 = 1;
		org.junit.Assert.assertEquals("wrong5", expt1, t70.climbStairs(n));
	}

}
