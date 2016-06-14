package com.hypo.DP;

import java.util.Arrays;

public class T62_UniquePaths
{
    private int uniquePaths(int m, int n) 
    {
    	int[][] f = new int[m][n];
    	
    	for(int i = 0 ; i < m ; i++ )
    	{
    		Arrays.fill(f[i], 1);
    	}
    	
    	//只能向下或向右
    	for(int i = 0 ; i < m ; i++)
    	{
    		for(int j = 0 ; j < n ; j++ )
    		{
    			if(i == 0 && j == 0 )
    			{
    				continue;
    			}
    			
    			if(i == 0)//第一行,从左边来
    			{
    				f[i][j] = f[i][j-1];
    				continue;
    			}
    			
    			if(j == 0)//第一列,从上边来
    			{
    				f[i][j] = f[i-1][j];
    				continue;
    			}
    			
    			f[i][j] = f[i-1][j] + f[i][j-1];//状态转移方程
    		}
    	}
    	
    	return f[m-1][n-1];
    }

//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		T62_UniquePaths t62 = new T62_UniquePaths();
		
		int m = 3;
		int n = 3;
		
		System.out.println(t62.uniquePaths(m, n));
	}
}
