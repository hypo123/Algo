package com.hypo.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_T39
{
    private List<List<Integer>> combinationSum(int[] candidates, int target)
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	Arrays.sort(candidates);
    	
    	dfs(target , 0 , path , res , candidates);
    	
        return (ArrayList)res;
    }
    
    private void dfs(int gap , int start , ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res,
    		int[] candidates)
    {
    	if(gap == 0) //终止条件，找到一个合法解
    	{
    		res.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	for(int i = start ; i < candidates.length; ++i)
    	{
    		if(gap < candidates[i])//剪枝
    		{
    			break;
    		}
    		path.add(candidates[i]);
    		
    		dfs(gap - candidates[i] , i , path , res , candidates);
    		
    		path.remove(path.size() - 1);
    	}
    }
    public static void main(String[] args)
	{
    	CombinationSum_T39 cs39 = new CombinationSum_T39();
    	
    	int[] candidates = new int[]{2,3,6,7};
    	int target = 7;
    	
    	ArrayList<ArrayList<Integer>> print = (ArrayList)cs39.combinationSum(candidates, target);
    	
		for(int i = 0 ; i < print.size() ; ++i)
		{
			ArrayList<Integer> mid = print.get(i);
			
			for(int j = 0 ; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j) + " ");
			}
			
			System.out.println();
		}
	}
}
