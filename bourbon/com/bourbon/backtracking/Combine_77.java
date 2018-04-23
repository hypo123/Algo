package com.bourbon.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: 组合</p>
 * <p>Difficulty: 中等</p>
 * <p>Description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合</p>
 * <p>Solution: 深度优先搜索+回溯</p>
 * @author lihaibo
 * 2018-04-23 23:33
 */
public class Combine_77
{
    public List<List<Integer>> combine(int n, int k) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	List<Integer> path = new ArrayList<Integer>();  
    	
    	dfs(1 , 1 , n, k, result , path);
    	
    	return result;
    }
    
    /**
     * 
     * @param step  当前添加到第step个数
     * @param index 当前需访问n个数中的第index个
     * @param n     需访问的n个数
     * @param k     组合大小为k个数
     * @param result结果
     * @param path  中间结果
     */
    public void dfs(int step, int index, int n ,int k ,List<List<Integer>> result , List<Integer> path)
    {
    	//剪枝，步数超过
    	if(step > k + 1)
    	{
    		return;
    	}
    	
    	//剪枝,剩余个数不够
    	if(n - index < k - step)
    	{
    		return;
    	}
    	
    	//收敛条件，找到一组正确解
    	if(step == k + 1)
    	{
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	for(int i = index ; i <= n ; ++i)
    	{
    		path.add(i);
    		
    		dfs(step + 1 , i + 1, n , k , result , path);
    		
    		path.remove(path.size() - 1);//回溯
    	}
    }
    
    
}
