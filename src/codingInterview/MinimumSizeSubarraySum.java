package codingInterview;

import java.util.Arrays;

//超时
public class MinimumSizeSubarraySum
{
    public int minSubArrayLen(int s, int[] nums) 
    {
    	int len = nums.length;
    	
    	for(int i = 1 ; i <= len ; i++)//个数
    	{
    		int end = len - i ;
    		for(int j = 0 ; j <= end ; j++)//移动游标
    		{
    			int sum = 0;
    			for(int k = j ; k < j+i ;k++)//求和
    			{
    				sum += nums[k];
    				
    				if(sum >= s)
    				{
    					System.out.println();
    					return i;
    				}
    			}
    			System.out.print(sum+" ");
    		}
    		System.out.println();
    	}
    	 return 0;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
		
		int[] nums = new int[]{1,4,4};
		
		int s = 4;
		
		System.out.println(msss.minSubArrayLen(s, nums));
	}

}
