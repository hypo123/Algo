package codingInterview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _3SumClosestTest
{
	_3SumClosest _3sum;
	@Before
	public void setUp() throws Exception
	{
		_3sum = new _3SumClosest();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testThreeSumClosest()
	{
		int[] nums1 = new int[] { -1, 2, 1, -4 };
		int target1 = 1;
		int expt1 = 2;
		org.junit.Assert.assertEquals("Wrong1", expt1, _3sum.threeSumClosest(nums1, target1));
		System.out.println();
		
		int[] nums2 = new int[] { 0,1,2 };
		int target2 = 3;
		int expt2 = 3;
		org.junit.Assert.assertEquals("Wrong2", expt2, _3sum.threeSumClosest(nums2, target2));
		System.out.println();
		
		int[] nums3 = new int[] { 1,1,1,0 };
		int target3 = -100;
		int expt3 = 2;
		org.junit.Assert.assertEquals("Wrong3", expt3, _3sum.threeSumClosest(nums3, target3));
		System.out.println();
		
		
		int[] nums4 = new int[] { 1,2,4,8,16,32,64,128 };
		int target4 = 82;
		int expt4 = 82;
		org.junit.Assert.assertEquals("Wrong4", expt4, _3sum.threeSumClosest(nums4, target4));
		System.out.println();
	}

}
