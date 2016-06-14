package com.hypo.BitManipulation;

/**
 * 要求时间复杂度为线性的,不适用额外的空间
 * 
 * 给定一个int型数组,其中每个元素都出现两次，只有一个出现一次
 * 
 * 两个相同的数异或运算为全0,所以可以将数组中所有的数一起异或运算，最后的结果就是
 * 出现了一次的元素.
 * -------------------------------------
 * 异或不仅能处理两次的情况，只要是偶数次都可以清零.
 */
public class SingleNumber
{
    public int singleNumber(int[] nums)
    {
    	int start = 0;
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		start ^= nums[i];
    	}
        return start;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		
		int[] nums = new int[]{122,345,777,345,122};
		
		System.out.println(sn.singleNumber(nums));
		
	}

}
