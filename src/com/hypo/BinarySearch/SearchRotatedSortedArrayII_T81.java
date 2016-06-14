package com.hypo.BinarySearch;

//旋转数组中可能有值相同的元素
public class SearchRotatedSortedArrayII_T81
{
//	时间复杂度O(n)，空间复杂度O(1)
    private boolean search(int[] nums, int target) 
    {
    	int len = nums.length;
    	int low = 0;
    	int high = len - 1;
    	
    	while(low <= high)
    	{
    		int mid = low + (high - low >>> 1);
    		
    		if(target == nums[mid]) return true;
    		
    		if(nums[low] <nums[mid])//[low,mid]为递增序列
    		{
    			if(nums[low] <= target && target <nums[mid])
    			{
    				high = mid;
    			}
    			else
    			{
    				low = mid + 1;
    			}
    		}
    		else if(nums[low] > nums[mid])
    		{
    			if(nums[mid] < target && target <= nums[high])
    			{
    				low = mid + 1;
    			}
    			else
    			{	
    				high = mid;
    			}
    		}
    		else
    		{
    			low++;
    		}
    	}
    	return false;   
    }
	public static void main(String[] args)
	{
		SearchRotatedSortedArrayII_T81 t81 = new SearchRotatedSortedArrayII_T81();
		
		int[] nums = {4 ,5, 6, 7,7,0, 0, 1, 2 ,4};
		
		System.out.println(t81.search(nums, 3));
	}
}
