package com.hypo.BitManipulation;

import java.util.Arrays;

/**
 * nums = { 0 ,1 , ... , n};
 * 数组中只缺一个数 缺的数是1到n之间的一个
 * n = nums.length
 * 1+2+...+n = (n+1)*n/2;所以可以先求出数组nums的和，然后比较即可
 */
public class MissingNumber2
{
    private int missingNumber(int[] nums) 
    {
    	int sum = 0;
    	for(int num : nums)
    	{
    		sum += num;
    	}
    	
    	return (nums.length*(nums.length + 1) - (sum << 1)) >> 1;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MissingNumber2 mn2 = new MissingNumber2();
		
		int[] nums = new int[]{1,  0 , 3 , 5 , 2};
		
		System.out.println(mn2.missingNumber(nums));
	}

}
