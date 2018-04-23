package com.bourbon.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: 组合总和II</p>
 * <p>Difficulty: 中等</p>
 * <p>Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *				   candidates 中每个数字在每个组合中只能使用一次。
 *                 说明：
 *				         所有数字（包括 target）都是正整数。
 *				         解集不能包含重复的组合。 </p>
 * <p>Solution: 
 *            深度优先搜索+回溯
 * </p>
 * <p>Example:input [10,1,2,7,6,1,5,1] 8
 *             output[[1,1,1,5],[1,1,6],[1,2,5],[1,7],[2,6]]
 * 
 * @author lihaibo
 * 2018-04-23 23:06
 */

public class CombinationSum2_40
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	if(candidates == null || candidates.length == 0) return result;
    	
    	List<Integer> path = new ArrayList<Integer>();
    	
    	Arrays.sort(candidates);//将数组从小到大排序
    	
    	dfs(target , 0 , result , path , candidates);
    	
    	return result;
    }
    
    /**
     * @param diff 离目标结果距离
     * @param index 当前需访问的数组下标
     * @param result 结果
     * @param path   中间结果
     * @param candidates 需访问数组
     */
    public void dfs(int diff , int index , List<List<Integer>> result , List<Integer> path ,int[] candidates)
    {
    	//收敛条件，找到一个组合
    	if(diff == 0)
    	{
    		result.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	//每个数字在每个组合中只能使用一次，去重复解
    	int prevnum = -1;
    	
    	for(int i = index ; i < candidates.length ; ++i)
    	{
    		//剪枝,当前值大于离结果的差,此路不通,需break
    		if(candidates[i] > diff)
    		{
    			break;
    		}
    		
    		//剪枝,如果上一轮循环已经选用candidates[i],则本轮循环不能重复使用
    		if(candidates[i] == prevnum)
    		{
    			continue;
    		}
    		
    		path.add(candidates[i]);
    		
    		prevnum = candidates[i];
    		
    		//candidates中的元素不可以重复使用，故下一步开始下标是i+1
    		dfs(diff - candidates[i] , i + 1 , result , path , candidates);
    		
    		//回溯，遍历数组中下一个数
    		path.remove(path.size() - 1);
    	}
    }
}
