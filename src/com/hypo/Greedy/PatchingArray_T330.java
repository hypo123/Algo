package com.hypo.Greedy;

/**
 *	给定数组为正整数升序数组nums和正整数n,要使[1,n]之间的所有数都可由数组nums内几个数之和表示;
 *  最少需要插入几个数可满足该条件.
 */

/*Explanation

Let miss be the smallest sum in [0,n] that we might be missing. Meaning we already know we can build all sums in [0,miss). 
Then if we have a number num <= miss in the given array, we can add it to those smaller sums to build all sums in [0,miss+num). 
If we don't, then we must add such a number to the array, and it's best to add miss itself, to maximize the reach.
Example: Let's say the input is nums = [1, 2, 4, 13, 43] and n = 100. We need to ensure that all sums in the range [1,100] are possible.
Using the given numbers 1, 2 and 4, we can already build all sums from 0 to 7, i.e., the range [0,8). But we can't build the sum 8, 
and the next given number (13) is too large. So we insert 8 into the array. Then we can build all sums in [0,16).
Do we need to insert 16 into the array? No! We can already build the sum 3, and adding the given 13 gives us sum 16. 
We can also add the 13 to the other sums, extending our range to [0,29).
And so on. The given 43 is too large to help with sum 29, so we must insert 29 into our array. 
This extends our range to [0,58). But then the 43 becomes useful and expands our range to [0,101). 
At which point we're done.
*/
public class PatchingArray_T330
{
    private int minPatches(int[] nums, int n) 
    {
    	long miss = 1;
		int count = 0 , i = 0; 
    	
    	while(miss <= n)
    	{
    		if(i < nums.length && miss >= nums[i])
    		{
    			miss += nums[i++];
    		}
    		else
    		{
    			miss += miss;
    			count++;
    		}
    	}
    	return count;
    }
	public static void main(String[] args)
	{
		PatchingArray_T330 t330 = new PatchingArray_T330();
		
		int[] nums = {1 , 5 , 10};
		
		int n = 20;
		
		System.out.println(t330.minPatches(nums, n));
	}
}
