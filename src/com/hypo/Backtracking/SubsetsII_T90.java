package com.hypo.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//给定一个可能含相同整数的数组，求出所有的可能的子集
//1.子集中所有元素为非降序; 2.不能包含重复子集
public class SubsetsII_T90
{
//	--------------------------方案一：递归 速度比较慢-----------------------------------------
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	Arrays.sort(nums);
    	
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
    	for(int i = 1;  i <= nums.length ; i++)
    	{
    		dfs(result , path , nums , i ,  hm );
    	}
    	
    	result.add(new ArrayList<Integer>());
    	
    	return (List)result;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> result , ArrayList<Integer> path , int[] nums , int len , 
    		HashMap<Integer,Integer> hm )
    {
    	
    	Iterator iterator = hm.entrySet().iterator();    
	  	
    	if(len == 0)//收敛条件
    	{
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	while(iterator.hasNext())
    	{
    		Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)iterator.next();
    		
    		int key = entry.getKey();//键
    		int value = entry.getValue();//值
    		
    		if(value > 0)     
    		{
    			if(!path.isEmpty() && key < path.get(path.size()-1))//如果当前键小于path中最后一个元素，则跳过
    			{
    				continue;
    			}
    			path.add(key);
    			hm.put(key, value-1);
    			dfs(result , path , nums , len - 1 ,  hm );
    			hm.put(key, value);
    			path.remove(path.size()-1);
    		}
    	}
    }
// --------------------------------------------------------------------------------------   
    public static void main(String[] args)
	{
    	SubsetsII_T90 t90 = new SubsetsII_T90();
		
		int[] nums = {1,2,2};
		
		List<List<Integer>> result = (List)t90.subsetsWithDup(nums);
		
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
