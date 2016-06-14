package com.hypo.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_T40
{
    private List<List<Integer>> combinationSum2(int[] candidates, int target)
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
    	
    	int previous = -1;//定义在循环外面.
    	for(int i = start ; i < candidates.length; ++i)
    	{
    		if(gap < candidates[i])//剪枝
    		{
    			break;
    		}
    		//如果上一轮循环已经选用candidates[i],则本轮循环不能重复使用.
    		//本题最重要的就是怎样去掉重复的解
    		if(previous == candidates[i]) continue;
    		
    		path.add(candidates[i]);
    		
    		previous = candidates[i];
    		
    		dfs(gap - candidates[i] , i + 1 , path , res , candidates);
    		
    		path.remove(path.size() - 1);
    	}
    }
    
    public static void main(String[] args)
	{
    	CombinationSumII_T40 cs40 = new CombinationSumII_T40();
    	
    	int[] candidates = new int[]{10,1,2,7,6,1,5,1};
    	int target = 8;
    	
    	ArrayList<ArrayList<Integer>> print = (ArrayList)cs40.combinationSum2(candidates, target);
    	
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
