package codingInterview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindPeakElementTest
{
	FindPeakElement fpe;
	@Before
	public void setUp() throws Exception
	{
		fpe = new FindPeakElement();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testFindPeakElement()
	{
		int[] nums1 = new int[]{1,2,3,1};
		int expt1 = 2;
		org.junit.Assert.assertEquals("Wrong1", expt1, fpe.findPeakElement(nums1));
		
		int[] nums2 = new int[]{1};
		int expt2 = 0;
		org.junit.Assert.assertEquals("Wrong2", expt2, fpe.findPeakElement(nums2));
		
		int[] nums3 = new int[]{1,2,3,4,5};
		int expt3 = 4;
		org.junit.Assert.assertEquals("Wrong3", expt3, fpe.findPeakElement(nums3));
		
		int[] nums4 = new int[]{1,2,3,1,2,5,2};
		int expt4 = 5;
		org.junit.Assert.assertEquals("Wrong4", expt4, fpe.findPeakElement(nums4));
		
		int[] nums5 = new int[]{1,2,1};
		int expt5 =1;
		org.junit.Assert.assertEquals("Wrong5", expt5, fpe.findPeakElement(nums5));
		
		int[] nums6 = new int[]{1,2,3,10,7,6,5};
		int expt6 =3;
		org.junit.Assert.assertEquals("Wrong6", expt6, fpe.findPeakElement(nums6));
	}

}
