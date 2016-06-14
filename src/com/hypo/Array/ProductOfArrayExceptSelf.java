package com.hypo.Array;

//LeetCode238  Product of Array Except Self  category:Array
//requirement:时间复杂度O(n),常数空间

public class ProductOfArrayExceptSelf
{
	//该方法超时.
    private int[] productExceptSelf(int[] nums) 
    {
    	int[] result = new int[nums.length];
    	
    	for(int i = 0 ; i < nums.length ; ++i)
    	{
    		for(int j = 0 ; j < result.length ; ++j)
    		{
    			if(i != j)
    			{
    				if(result[j] == 0) 
    				{
    					result[j] += nums[i];
    				}
    				else
    				{
    					result[j] *= nums[i];
    				}
    			}
    		}
    	}
        return result;
    }
    
//    此方法比较巧妙.
    private int[] productExceptSelf2(int[] nums) 
    {
    	int len = nums.length;
    	int[] res = new int[len];
    	
    	res[0] = 1;
    	for(int i = 1 ; i < len ; ++i)
    	{
    		res[i] = res[i-1] * nums[i-1];
    	}
    	
    	int right = 1;
    	for(int j = len-1; j >= 0 ; --j)
    	{
    		res[j] *= right;
    		right *= nums[j];
    	}
        return res;
    }
    
    
	public static void main(String[] args)
	{
		ProductOfArrayExceptSelf paes = new ProductOfArrayExceptSelf();
		
		int[] nums = new int[]{1,2,3,4};
		
		int[] print = paes.productExceptSelf2(nums);
		
		for(int k = 0 ; k < print.length; ++k)
		{
			System.out.print(print[k]+" ");
		}
		
	}
}
