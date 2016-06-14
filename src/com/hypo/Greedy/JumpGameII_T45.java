package com.hypo.Greedy;

//求跳到最后一个元素所需最小步骤.
public class JumpGameII_T45
{
//	-----------------方案一：Greedy-------------------------------
    public int jump(int[] nums) 
    {
    	int step = 1;
    	
    	if(nums.length <= 1) return 0;
    	
    	int maxJump = nums[0];
    	int start = 0;
    	
    	for(int i = 0 ;  i < nums.length ; )
    	{
    		start = maxJump + 1;
    		maxJump = 0;
      		if(start > nums.length - 1)
    		{
    			return step;
    		}
    		
    		for(int j = i ; j <= start - 1 ; j++)
    		{
    			if(nums[j]+j > maxJump)
    			{
    				maxJump = nums[j]+j;
    			}
    		}
    		
    		step++;
    		
    		if(maxJump == start - 1)
    		{
    			return -1;
    		}
    		
    		if(maxJump >= nums.length - 1)
    		{
    			return step;
    		}
    		
    		i = start;
    	}
        return step;
    }
//    -------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JumpGameII_T45 t45 = new JumpGameII_T45();
		
//		test data
		int[] nums = {2,1};
		int[] nums2 = {1,2,1,1,1};
		int[] nums3 = {0};
		
		System.out.println(t45.jump(nums3));
	}

}
