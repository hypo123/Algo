package com.hypo.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PermutationII_T47
{
    private List<List<Integer>> permuteUnique(int[] nums) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();  	
        
    	for(Integer i : nums)
    	{
    		if(!hm.containsKey(i))
    		{
    			hm.put(i, 1);
    		}
    		else
    		{
    			hm.put(i, hm.get(i)+1);
    		}
    	}
    	
    	dfs(result , path , nums ,  hm);
        return (List)result;
    }
    
  private void dfs(ArrayList<ArrayList<Integer>> result , ArrayList<Integer> path ,
	int[] nums ,  HashMap<Integer,Integer> hm)
    {
	  	Iterator iterator = hm.entrySet().iterator();    
	  	
    	if(path.size() == nums.length)//收敛条件
    	{
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	while(iterator.hasNext())
    	{
    		Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)iterator.next();
    		
    		int key = entry.getKey();
    		int value = entry.getValue();
    		
    		if(value > 0)
    		{
    			path.add(key);
    			hm.put(key, value-1);
    			dfs(result , path , nums , hm);
    			hm.put(key, value);
    			path.remove(path.size()-1);
    		}
    	}
    }
    
	public static void main(String[] args)
	{
		PermutationII_T47 t47 = new PermutationII_T47();
		
		int[] nums = {1,1,2};
		
		List<List<Integer>> result = (List)t47.permuteUnique(nums);
		
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
