package com.hypo.Array;

//找出大小为n的数组中出现次数多于[n/2]的数
public class MajorityElement_T169
{
//	[n/2]
// 	多数投票算法
    private int majorityElement(int[] nums) 
    {
    	int n1 = 0;
    	int c1 = 0;
    	
    	int times = nums.length >> 1;
    	
    	//Step1:找出数组中出现次数最多的数
    	for(int n : nums)
    	{
    		if(n == n1)
    		{
    			c1++;
    		}
    		else if(c1 == 0)
    		{
    			n1 = n;
    			c1 = 1;
    		}
    		else
    		{
    			c1--;
    		}
    	}
    	
//    	//Step2:判断数组中众数n1出现的次数是否超过[n/2]次
//    	int count = 0;
//    	
//    	for(int n : nums)
//    	{
//    		if(n == n1)
//    		{
//    			count++;
//    		}
//    	}
//    	
    	
    	return n1;
    }
	public static void main(String[] args)
	{
		MajorityElement_T169 t169 = new MajorityElement_T169();
		
		int[] nums = {1,1,1,1,2,2,2};
		
		System.out.println(t169.majorityElement(nums));
				
	}
}
