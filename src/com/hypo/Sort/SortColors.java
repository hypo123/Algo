package com.hypo.Sort;

/**
 * LeetCode75  Sort Colors
 * 先遍历一遍数组，统计出white,blue ,red的个数,
 * 然后重新对数组赋值.
 */
public class SortColors
{
    private void sortColors(int[] nums)//two-pass algorithm using counting sort
    {
    	int red = 0; // 0
        int white = 0;//1
        int blue = 0;//2
        
        for(int i = 0 ; i < nums.length ; ++i)
        {
        	if((nums[i] ^ 0x1) == 0)
        	{
        		white++;
        	}
        	else if((nums[i] ^ 0x2) == 0)
        	{
        		blue++;
        	}
        }
        
        red = nums.length - white - blue;
        
        for(int j = 0 ;  j < nums.length; ++j)
        {
        	if(--red >= 0)
        	{
        		nums[j] = 0;
        		continue;
        	}
        	
        	if(--white >= 0)
        	{
        		nums[j] = 1;
        		continue;
        	}
        	
        	if(--blue >= 0)
        	{
        		nums[j] = 2;
        		continue;
        	}
        }
    }
    
    private void sortColors2(int[] nums)//遍历一遍
    {
    	int red = -1;//0 数组中已排序部分最后一个0的位置
    	int white = -1;//1 最后一个1的位置
    	int blue = -1;//2 最后一个2的位置
    	
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		if((nums[i] ^ 0x0) == 0)//0 则后边的1和2都要向后移动一个
    		{
    			nums[++blue] = 2;
    			nums[++white] = 1;
    			nums[++red] = 0;
    		}
    		else if((nums[i] ^ 0x1) == 0)//1 则后面的2要向后移动一个
    		{
    			nums[++blue] = 2;
    			nums[++white] = 1;
    		}
    		else//2
    		{
     			nums[++blue] = 2;
    		}
    	}
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SortColors sc = new SortColors();
		
		int[] nums = new int[]{2,1,1,1,0,1,2,0,2,0};
		
		sc.sortColors2(nums);
		
		for(int n : nums)
		{
			System.out.print(n + " ");
		}
	}

}
