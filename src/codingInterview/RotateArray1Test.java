package codingInterview;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RotateArray1Test
{
	RotateArray1 ra;

	@Before
	public void setUp() throws Exception
	{
		ra = new RotateArray1();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testRotate()
	{
		int[] re = new int[]{5,6,7,1,2,3,4};
		int[] arr= new int[]{1,2,3,4,5,6,7};
		int k = 3;
		ra.rotate(arr, k);
		org.junit.Assert.assertArrayEquals("Wrong", re, ra.result);
		//fail("Not yet implemented");
		
		System.out.println();
		
		int[] re1 = new int[]{4,5,6,7,1,2,3};
		int[] arr1= new int[]{1,2,3,4,5,6,7};
		int k1 = 4;
		ra.rotate(arr1, k1);
		org.junit.Assert.assertArrayEquals("Wrong", re1, ra.result);
		System.out.println();
		
		int[] re2 = new int[]{4,5,6,7,1,2,3};
		int[] arr2= new int[]{1,2,3,4,5,6,7};
		int k2 = 11;
		ra.rotate(arr2, k2);
		org.junit.Assert.assertArrayEquals("Wrong", re2, ra.result);
	}
}
