package com.hypo.Greedy;

//给定一个只包含非负整数的数组.
public class JumpGame_T55
{
//	------------------方案一：DFS 超时-----------------------------------------
    private boolean canJump(int[] nums) 
    {
    	if(nums.length == 1) return true;
    	boolean[] flag = new boolean[1];
    	dfs(nums , 0 , flag);
        return flag[0];
    }
    
    private void dfs(int[] nums , int index , boolean[] flag)
    {
    	if(index == nums.length - 1)//终止条件
    	{
    		flag[0] = true;
    		return;
    	}
    	
    	if(index > nums.length - 1 )//剪枝
    	{
    		return;
    	}
    	
    	if(index != nums.length - 1 && nums[index] == 0)//剪枝
    	{
    		return;
    	}
    	
    	for(int i = 1 ; i <= nums[index] ; i++)
    	{
    		dfs(nums , index + i , flag);
    		
    		if(flag[0] == true)
    		{
    			return;
    		}
    	}
    }
//    ----------------------------方案二：贪婪法----------------------------------
    
    private boolean canJump2(int[] nums) 
    {
    	int maxJump = nums[0];
    	int start = 0;
    	
    	for(int i = 0 ; i < nums.length  ; )
    	{
    		start = maxJump + 1;
    		maxJump = 0;
    		
    		if(start > nums.length - 1)
    		{
    			return true;
    		}
    		
    		for(int j = i ; j <= start - 1 ; j++)
    		{
    			if(nums[j]+j > maxJump)
    			{
    				maxJump = nums[j]+j;
    			}
    		}
    		
    		if(maxJump == start - 1)
    		{
    			return false;
    		}
    		
    		if(maxJump >= nums.length - 1)
    		{
    			return true;
    		}
    		
    		i = start;
    	}
        return false;
    }
//    ------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JumpGame_T55 t55 = new JumpGame_T55();
		
		int[] nums = {2,3,1,1,4};
		int[] nums2 = {3,2,1,0,4};
		int[] nums3 = {2,0};
		
		System.out.println(t55.canJump2(nums3));
	}

}
