package com.hypo.Array;

/**
 * 找出比给定数组排列，字典序刚好比它大一点的排列
 * 如果不存在,则给出当前数组的最小排列.
 *
 */
public class NextPermutation
{
    public void nextPermutation(int[] nums) 
    {
    	change(nums,1);
    }
    
    public void change(int[] nums , int start)
    {
        for(int i = nums.length-1; i >= start; --i)
        {
        	if(nums[i] > nums[i-1])
        	{
        		for(int j = nums.length-1 ; j > i; --j)//判断i后面是否有比nums[i-1]大的
        		{
        			if(nums[j] > nums[i-1])//i后面有比nums[i-1]大的
        			{
        				int tmp = nums[j];
        				nums[j] = nums[i-1];
        				nums[i-1] = tmp;
        				reverse(nums, i , nums.length-1);
        				return;
        			}
        		}
        		
        		//i后面没有比nums[i-1]大的,那么交换nums[i]与nums[i-1]的值
        		int temp = nums[i];
        		nums[i] = nums[i-1];
        		nums[i-1] = temp;
        		reverse(nums, i , nums.length-1);
        		return ;
        	}
        }
        reverse(nums,0, nums.length-1);//数组是逆序的,那么就把数组反转
    }
    
    public void reverse(int[] nums , int start , int end)//翻转数组
    {
        int down = start-1;
        int up = end+1;
        while(++down < --up)
        {
     	   int temp = nums[down];
     	   nums[down] = nums[up];
     	   nums[up] = temp;
        }
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		NextPermutation np = new NextPermutation();
		
		int[] nums = new int[]{1,2,3};//1,3,2
		int[] nums2 = new int[]{3,2,1};//1,2,3
		int[] nums3 = new int[]{1,1,5};//1,5,1
		int[] nums4 = new int[]{1,3,2};//2,1,3
		int[] nums5	= new int[]{5,4,7,5,3,2};
		
		np.nextPermutation(nums4);
		
		//打印结果
		for(int n : nums4)
		{
			System.out.print(n+" ");
		}
				
	}

}
