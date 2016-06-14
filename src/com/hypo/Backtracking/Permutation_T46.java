package com.hypo.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_T46
{
    private List<List<Integer>> permute(int[] nums) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> path = new ArrayList<Integer>();
    
    	dfs(result , path , nums);
    	
        return (List)result;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> result ,ArrayList<Integer> path ,
    		int[] nums)
    {
    	if(path.size() == nums.length)//收敛条件
    	{
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	//扩展状态
    	for(Integer i : nums)
    	{
    		if(!path.contains(i))
    		{
    			path.add(i);
    			dfs(result , path , nums);
    			path.remove(path.size()-1);
    		}
    	}
    }
	public static void main(String[] args)
	{
		Permutation_T46 t46 = new Permutation_T46();
		
		int[] nums = {1,2,3};
		
		List<List<Integer>> result = (List)t46.permute(nums);
		
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
