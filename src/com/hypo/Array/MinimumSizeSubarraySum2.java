package com.hypo.Array;

public class MinimumSizeSubarraySum2
{
    private int minSubArrayLen2(int s, int[] nums) 
    {
        if(nums == null || nums.length == 0) return 0;
    	int low = 0;
    	int high = 0;
    	int sum = nums[0];
    	int len = Integer.MAX_VALUE;
    	
    	while(high < nums.length && low <= high)
    	{
    		if(sum < s)//sum小于s,则向右移动high游标.增大sum.
    		{
    			if(high < nums.length - 1)
    			{
    				sum += nums[++high];
    			}
    			else
    			{
    				break;
    			}
    		}
    		else
    		{
    			len = Math.min(len , high - low + 1);
    			
    			while(++low <= high)//尝试缩小范围
    			{
    				sum -= nums[low-1];
    				if(sum < s)//缩小到其和小于s退出
    				{
    					break;
    				}
    				else
    				{
    					len = Math.min(len, high - low + 1);
    				}
    			}
    		}
    	}
    	return (len == Integer.MAX_VALUE) ? 0 : len;//如果没有找到返回 0
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum2 msss2 = new MinimumSizeSubarraySum2();
		
		int[] nums = new int[]{2,3,1,2,4,3};
		int[] nums2 = new int[]{1,2,3,4,5};
//		int[] nums3 = new int[]{};
		int s = 7;
		int s2 = 11;
		System.out.println(msss2.minSubArrayLen2(s, nums));
		System.out.println(msss2.minSubArrayLen2(s2, nums2));
	}

}
