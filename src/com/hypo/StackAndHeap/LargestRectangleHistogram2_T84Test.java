package com.hypo.StackAndHeap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LargestRectangleHistogram2_T84Test
{
	LargestRectangleHistogram2_T84 lrh;
	@Before
	public void setUp() throws Exception
	{
		lrh = new LargestRectangleHistogram2_T84();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLargestRectangleArea()
	{
		int[] heights1 = {2,1,5,6,2,3};
		int	expt1 = 10;
		org.junit.Assert.assertEquals("Wrong1", expt1, lrh.largestRectangleArea(heights1));

		int[] heights2 = {1};
		int	expt2 = 1;
		org.junit.Assert.assertEquals("Wrong2", expt2, lrh.largestRectangleArea(heights2));

		int[] heights3 = {6,2,5,4,5,1,6};
		int	expt3 = 12;
		org.junit.Assert.assertEquals("Wrong3", expt3, lrh.largestRectangleArea(heights3));

		int[] heights4 = {1,2,1};
		int	expt4 = 3;
		org.junit.Assert.assertEquals("Wrong4", expt4, lrh.largestRectangleArea(heights4));
	}

}
