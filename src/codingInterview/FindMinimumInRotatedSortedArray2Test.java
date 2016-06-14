package codingInterview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindMinimumInRotatedSortedArray2Test
{
	FindMinimumInRotatedSortedArray2 fm;

	@Before
	public void setUp() throws Exception
	{
		fm = new FindMinimumInRotatedSortedArray2();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testFindMin()
	{
		int[] nums1 = new int[]{4,5,6,7,0,1,2};
		int expt1 = 0;
		org.junit.Assert.assertEquals("Wrong1", expt1, fm.findMin(nums1));
		
		int[] nums2 = new int[]{4,4,4,4,4,4,4};
		int expt2 = 4;
		org.junit.Assert.assertEquals("Wrong2", expt2, fm.findMin(nums2));
		
		int[] nums3 = new int[]{1,2,3,4,5,6,7};
		int expt3 = 1;
		org.junit.Assert.assertEquals("Wrong3", expt3, fm.findMin(nums3));
		
		int[] nums4 = new int[]{7 , 4};
		int expt4 = 4;
		org.junit.Assert.assertEquals("Wrong4", expt4, fm.findMin(nums4));
		
		int[] nums5 = new int[]{3 , 1 ,3};
		int expt5 = 1;
		org.junit.Assert.assertEquals("Wrong5", expt5, fm.findMin(nums5));
		
		int[] nums6 = new int[]{3 , 1 ,3,3};
		int expt6 = 1;
		org.junit.Assert.assertEquals("Wrong6", expt6, fm.findMin(nums6));
	}

}
