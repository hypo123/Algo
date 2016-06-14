package com.hypo.BitManipulation;

/**
 * 使用位操作
 * 
 * 先将xor与数组中所有的数进行异或操作，那么出现两次的异或为0，有两个只出现
 * 一次的元素相异或就是xor. 再从xor的低位遍历，找到一个是1的位，该位说明
 * 要求的两个数在该位上是不同的，那么我们可以将数组中所有的元素分为两类，一类是该位上
 * 为1的，一类是该位上为0的。因为数组中除这两个元素外，其他的元素都出现了两次，
 * 所以出现两次的元素要么一起出现在一类，要么一起出现在二类。再将一类中所有的元素异或
 * 可得num1,将二类中所有元素异或，，可得num2.
 *
 */
public class SingleNumberIII2
{
    private int[] singleNumber(int[] nums) 
    {
    	int[] result = new int[2];
    	
    	int xor = 0;
    	
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		xor ^= nums[i];
    	}
    	
    	int lastDiff = 0;
    	
    	for(int j = 0 ; j < 32 ; ++j)
    	{
    		if((xor & 1 << j) != 0)
    		{
    			lastDiff = j;
    			break;
    		}
    	}
    	
    	int num1 = 0;
    	int num2 = 0;
    	for(int k = 0 ; k < nums.length; ++k)
    	{
    		if((1 << lastDiff & nums[k]) == 0)
    		{
    			num1 ^= nums[k];
    		}
    		else
    		{
    			num2 ^= nums[k];
    		}
    	}
    	result[0] = num1;
    	result[1] = num2;
        return result;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleNumberIII2 sn32 = new SingleNumberIII2();
		
		int[] n = new int[]{1, 2, 1, 3, 2, 5};
		
		for(int i = 0 ; i < 2 ; ++i)
		{
			System.out.print(sn32.singleNumber(n)[i] + " ");
		}
		
	}

}
