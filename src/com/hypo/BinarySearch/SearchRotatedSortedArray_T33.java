package com.hypo.BinarySearch;

import java.util.Arrays;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	You may assume no duplicate exists in the array.
 */
public class SearchRotatedSortedArray_T33
{
//	==============================================
    private int search(int[] nums, int target) 
    {
    	int len = nums.length;
    	int low = 0 , high = len - 1;
    	
    	//寻找最小值的下标
    	while(low < high)
    	{
    		int mid = low + (high - low >>> 1);
    		if(nums[mid] > nums[high]) low = mid + 1;
    		else high = mid;
    	}
    	
    	//要特别注意target == nums[len-1]时的特殊情况
    	int start = (target > nums[len - 1]) ? 0 : low;//BUG
    	int end = (target > nums[len - 1]) ? low :len;//BUG
    	
    	return ((end = Arrays.binarySearch(nums, start, end, target)) < 0) ? -1 : end ;

    	//二分查找
    	/*while(start <= end)
    	{
    		int mid = start + (end - start >> 1);
    		if(target == nums[mid]) return mid;
    		else if (target > nums[mid]) start = mid + 1;
    		else end = mid - 1;
    	}
    	return -1;*/
    }
    
	/*我们返回target在nums array中的index，如果target不存在的话，返回小于并最接近target的数字
	 （极端情况下返回大于且最接近target的数字，如果数组中所有数都比target大的话）。
	    这个循环中有几个invariant：
	 low和high指针指向的元素都一直有效，inclusive。不会数组越界
	    由于int除法的特性，mid有可能等于low，为了避免陷入死循环，我们让low=mid+1。
	    如果反过来，我们让high=mid-1; low = mid的话，就会陷入死循环。
	    退出循环时，low==high
	 */
    private int BinarySearch(int[] nums , int target)//二分查找模板1
    {
    	int low = 0;
    	int high = nums.length - 1;//low和high都是内含的，不会超界
    	while(low < high)
    	{
    		int mid = low + (high - low) / 2;//防止溢出，如果是(low+high)/2，low+high有溢出风险
    		if(nums[mid] < target)
    		{
    			low = mid + 1;//mid可能等于low,所以让low等于mid+1
    		}
    		else
    		{
    			high = mid;
    		}
    	}
    	return high;
    }
    
    private int BinarySearch2(int[] a , int key)//二分查找模板2(JDK源代码)
    {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) 
        {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
//    ============================================
    private int search2(int[] nums, int target) 
    {
    	int first = 0;
    	int last = nums.length - 1;
    	
    	while(first <= last)
    	{
    		int mid = first + (last - first) / 2;
    		
    		if(target == nums[mid]) return mid;
    		
    		if(nums[first] <= nums[mid]) //[first,mid]之间为递增序列
    		{
    			if( nums[first] <= target && target < nums[mid])
    			{
    				last = mid;
    			}
    			else
    			{
    				first = mid + 1;
    			}
    		}
    		else
    		{
    			if(nums[mid] < target   && target <= nums[last])
    			{
    				first = mid + 1;
    			}
    			else
    			{
    				last = mid;
    			}
    		}
    	}
    	return -1;
    }
	public static void main(String[] args)
	{
		SearchRotatedSortedArray_T33 t33 = new SearchRotatedSortedArray_T33();
		
		int[] nums = {4 ,5, 6, 7, 0, 1, 2};
		int[] nums2 = {1,3};
		int[] nums3 = {3,1};
		int[] nums4 = {4,5,6,7,0,1,2};
		int[] a = {0 ,1 ,2, 4 ,5, 6 ,7};
		
		System.out.println(t33.search2(nums, 1));
		System.out.println(t33.search2(nums2, 3));
		System.out.println(t33.search2(nums3, 1));
		System.out.println(t33.search2(nums4, 2));
		System.out.println(t33.BinarySearch2(a, 0));
	}
}
