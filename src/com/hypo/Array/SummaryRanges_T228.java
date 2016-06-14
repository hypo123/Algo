package com.hypo.Array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_T228
{
    private List<String> summaryRanges(int[] nums)
    {
    	ArrayList<String> res = new ArrayList<String>();
    	StringBuffer path = new StringBuffer();
    	if(nums == null || nums.length == 0) return res;
    	
    	boolean flag = false;
    	
    	for(int i = 0 ; i < nums.length-1 ; ++i)
    	{
    		if(nums[i]+1 == nums[i+1])
    		{
    			if(!flag)
    			{
    				path.append(nums[i]);//左边界
    				path.append("->");
    			}
    			flag = true;
    		}
    		else
    		{
    			path.append(nums[i]);//右边界
    			res.add(path.toString());
    			path.delete(0 , path.length());
    			flag = false;
    		}
    	}
    	int last = nums[nums.length-1];
    	if(flag)
    	{
    		path.append(last);
    		res.add(path.toString());
    	}
    	else
    	{
    		res.add(Integer.toString(last));
    	}
        return res;
    }
    
    public static void main(String[] args)
	{
    	SummaryRanges_T228 sr228 = new SummaryRanges_T228();
    	
    	int[] nums = new int[]{0,1,2,4,5,7};
    	
    	ArrayList<String> print = (ArrayList)sr228.summaryRanges(nums);
    	
    	for(String str : print)
    	{
    		System.out.println(str);
    	}
    	
	}
}
