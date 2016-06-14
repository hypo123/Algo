package com.hypo.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含不同整数的数组，求出所有的可能的子集
//1.子集中所有元素为非降序; 2.不能包含重复子集
public class Subsets_T78
{
//	--------------------------方案一：递归 速度比较慢-----------------------------------------
    public List<List<Integer>> subsets(int[] nums)
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	Arrays.sort(nums);
    	
    	for(int i = 1;  i <= nums.length ; i++)
    	{
    		dfs(result , path , nums , i , 0 );
    	}
    	
    	result.add(new ArrayList<Integer>());
    	
    	return (List)result;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> result , ArrayList<Integer> path , int[] nums , int len , int index)
    {
    	if(len == 0 )//收敛条件
    	{
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	if(nums.length - index < len )//剪枝
    	{
    		return;
    	}
    	
    	for(int i = index ; i < nums.length ; i++)
    	{
    		if(!path.contains(nums[i]))
    		{
    			path.add(nums[i]);
    			dfs(result , path , nums , len - 1 , i + 1);
    			path.remove(path.size()-1);
    		}
    	}
    }
 // --------------------------------------------------------------------------------------  
	public static void main(String[] args)
	{
		Subsets_T78 t78 = new Subsets_T78();
		
		int[] nums = {1,2,3};
		
		List<List<Integer>> result = (List)t78.subsets(nums);
		
		//打印结果
		for(int i = 0 ; i < result.size(); ++i)
		{
			for(int j = 0 ; j < result.get(i).size() ; ++j)
			{
				System.out.print(result.get(i).get(j)+ " ");
			}
			System.out.println();
		}
	}
}
