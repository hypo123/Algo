package com.bourbon.dp;

/**
 * <p>Title: 爬楼梯</p>
 * <p>Difficulty: 简单</p>
 * <p>Description: 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 *				         每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *				       注意：给定 n 是一个正整数。</p>
 * <p>Solution: 使用dp,有规律，第n阶爬法数是第(n-1)阶和第(n-2)阶爬法数之和.</p>
 * @author lihaibo
 * 2018年4月23日 2018-04-23 22:21
 */
public class ClimbStairs_70
{
    public int climbStairs(int n) 
    {
    	if(n <= 1) return 1;
    	int[] f = new int[n + 1];
    	f[0] = 1;
    	f[1] = 1;
    	
    	for(int i = 2 ; i <= n ; i++)
    	{
    		f[i] = f[i - 1] + f[i - 2];
    	}
   	
    	return f[n];
    }
}
