package codingInterview;

import java.util.Arrays;

public class KthLargestElementArray
{
    public int findKthLargest(int[] nums, int k) 
    {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		KthLargestElementArray kea = new KthLargestElementArray();
		
		int[] nums = new int[]{3,2,1,5,6,4,5};

		int k = 3;
		
		System.out.println(kea.findKthLargest(nums, k));
	}

}
