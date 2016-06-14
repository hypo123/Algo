package codingInterview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinimumSizeSubarraySumTest
{
	MinimumSizeSubarraySum msss;
	@Before
	public void setUp() throws Exception
	{
		msss = new MinimumSizeSubarraySum();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMinSubArrayLen()
	{
		int[] nums1 = new int[]{2,3,1,2,4,3};
		int s1 = 7;
		int expt1 = 2;
		org.junit.Assert.assertEquals("Wrong1", expt1, msss.minSubArrayLen(s1, nums1));
		
		int[] nums2 = new int[]{-5,-3,1,2,3,4,12};
		int s2 = 9;
		int expt2 = 2;
		org.junit.Assert.assertEquals("Wrong2", expt2, msss.minSubArrayLen(s2, nums2));
		
		int[] nums3 = new int[]{-5,-2,1,2,3,4,17};
		int s3 = 10;
		int expt3 = 3;
		org.junit.Assert.assertEquals("Wrong3", expt3, msss.minSubArrayLen(s3, nums3));
	}

}
