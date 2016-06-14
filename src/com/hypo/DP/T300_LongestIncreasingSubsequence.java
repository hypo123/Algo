package com.hypo.DP;

import java.util.Arrays;

//经典DP题，最长递增子序列
//给一个未排序的整形数组，求最长递增字串的长度.
//时间复杂度O(n^2)或O(nlogn)
/**	Arrays类的静态方法 
 *  binarySearch(int[] a, int fromIndex, int toIndex, int key) 
 * 	a - 要搜索的数组
 *	fromIndex - 要搜索的第一个元素的索引（包括）
 *	toIndex - 要搜索的最后一个元素的索引（不包括）
 *	key - 要搜索的值 
 *  返回值:  如果它包含在数组的指定范围内，则返回搜索键的索引
 *		        否则返回 (-(插入点) - 1)。
 *	                   插入点:( 被定义为将键插入数组的那一点：即范围中第一个大于此键的元素索引;如果范围中的所有元素都小于指定的键，则为 toIndex)
 *  这保证了当且仅当此键被找到时，返回的值将 >= 0。 
 */
public class T300_LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums) 
    {
    	int[] f = new int[nums.length];
    	
    	int len = 0;//当前最长递增字串的长度
    	
    	for(int n : nums)
    	{
    		int i = Arrays.binarySearch(f, 0, len, n);
    		
    		if(i < 0) i = -(i + 1);
    		
    		f[i] = n;//f[]中存储的递增的子序列
    		
    		if(i == len) len++;//i == len 表明范围中的所有元素都小于n,当前最长递增字串的长度可加1
    		
    	}
        return len;
    }
    
    public static void main(String[] args)
	{
    	T300_LongestIncreasingSubsequence t300 = new T300_LongestIncreasingSubsequence();
    	
    	int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    	int[] nums2 = {10, 11, 14, 2 ,3, 4 ,15};
    	
    	System.out.println(t300.lengthOfLIS(nums2));
	}
}










