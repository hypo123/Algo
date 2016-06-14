package com.hypo.BitManipulation;

import java.util.Arrays;

/**
 * 该方案不是最优的，时间复杂度不是线性时间
 */
public class MissingNumber
{
    private int missingNumber(int[] nums) 
    {
    	Arrays.sort(nums); //O(n)*lg(n)
    	int i ;
    	for(i = 0 ; i < nums.length ; ++i)
    	{
    		if((nums[i] ^ i) != 0)
    		{
    			break;
    		}
    	}
    	return i;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MissingNumber mn = new MissingNumber();
		
		int[] nums = new int[]{1,  0 , 3};
		
		System.out.println(mn.missingNumber(nums));
	}

}
