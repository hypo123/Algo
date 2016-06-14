package com.hypo.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII_T216
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	dfs(n , k , 0 , 1 , path , res );
    	
        return (ArrayList)res;
    }
    
    private void dfs(int gap ,int k , int step , int start ,ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res
    		)
    {
    	if(step == k && gap == 0)//找到一个合法解
    	{
    		res.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	if(step == k && gap > 0)//剪枝	
    	{
    		return;
    	}
    		
    	for(int i = start ; i <= 9 ; ++i )//只能用1-9之间的数字.
    	{
    		if(i > gap) break;//剪枝
    		
    		path.add(i);
    		
    		dfs(gap - i , k  , step + 1 , i + 1 , path , res);
    		
    		path.remove(path.size() - 1);
    	}
    }
    public static void main(String[] args)
	{
    	CombinationSumIII_T216 cs216 = new CombinationSumIII_T216();
    	
    	int k = 3;
    	int n = 7;
    	
		ArrayList<ArrayList<Integer>> print = (ArrayList)cs216.combinationSum3(k, n);
				
		for (int i = 0; i < print.size(); ++i)
		{
			ArrayList<Integer> mid = print.get(i);

			for (int j = 0; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j) + " ");
			}

			System.out.println();
		}
	}
}
