package com.hypo.BitManipulation;

public class SingleNumberII
{
    private int singleNumber(int[] nums) 
    {
    	int result = 0;
    	byte[] count = new byte[32];
    	//int有32位，记录每一位上1出现的次数，如果出现三次则清零，那么最后数组里的元素
    	//就是只出现一次的元素，从高位到低位的二进制形式
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		for(int j = 0 ; j < 32 ; ++j)
    		{
    			count[j] += (nums[i] >> j) & 1;
    			
    			count[j] %= 3;
    		}
    	}
    	
    	for(int k = 31 ; k >= 0; --k)
    	{
    		result += count[k] << k;
    	}
    	
    	return result;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleNumberII sn2 = new SingleNumberII();
		
		int[] n = new int[]{123, 234, 456 , 123, 123 ,234 ,234};
		
		System.out.println(sn2.singleNumber(n));
		
	}

}
