package com.hypo.Sort;

import java.util.Arrays;

//Given an unsorted array, find the maximum difference between the 
//successive elements in its sorted form
//线性时间和空间
public class MaximumGap_T164
{
	//桶排序可在O(n)排序
    public int maximumGap(int[] nums) 
    {
    	if(nums == null || nums.length < 2) 
    	{
    		return 0;
    	}
    	
    	int max = nums[0];
    	int min = nums[0];
    	
    	//找到数组中数的最大值和最小值
    	for(int m : nums)
    	{
    		max = Math.max(m, max);
    		min = Math.min(m, min);
    	}
    	
    	//可能的最小间隔  n个数中间有n-1个间隔     //间隔可以取更小，也会得到正确解,且程序更健壮
    	int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
    	
    	int[] minBucket = new int[nums.length - 1];//装最小值桶
    	int[] maxBucket = new int[nums.length - 1];//装最大值桶
    	
    	//初始化最大值桶和最小值桶
    	Arrays.fill(minBucket, Integer.MAX_VALUE);
    	Arrays.fill(maxBucket, Integer.MIN_VALUE);
    	
    	//将数组中元素放入两个桶中
    	for(int i : nums)
    	{
    		if(i == min || i == max) continue;
    		
    		int index = (i - min) / gap ;//下标
    		
    		minBucket[index] = Math.min(minBucket[index], i);
    		
    		maxBucket[index] = Math.max(maxBucket[index], i);
    		
    	}
    	
    	//扫描两个桶得到最大间隔
    	int maxGap = Integer.MIN_VALUE;
    	int previous = min;
    	
    	for(int i = 0 ; i < nums.length - 1 ; i++ )
    	{
    		//空桶
    		if(minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE)
    		{
    			continue;
    		}
    		
    		maxGap = Math.max(maxGap, minBucket[i] - previous);
    		
    		previous = maxBucket[i];
    	}
    	
    	maxGap = Math.max(maxGap, max - previous);
    	
    	return maxGap;
    }
    
//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MaximumGap_T164 t164 = new MaximumGap_T164();
		
		int[] nums = {1,7,4,6,9};
		
		int[] nums2 = {15252,16764,27963,7817,26155,20757,3478,22602,
		                20404,6739,16790,10588,16521,6644,20880,15632,27078,
		                25463,20124,15728,30042,16604,17223,4388,23646,32683,
		                23688,12439,30630,3895,7926,22101,32406,
		                21540,31799,3768,26679,21799,23740};
		
		System.out.println(t164.maximumGap(nums2));
	}

}
