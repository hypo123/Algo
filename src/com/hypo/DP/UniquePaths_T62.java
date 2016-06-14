package com.hypo.DP;

/**
 * DP
 */
public class UniquePaths_T62
{
//--------------------------------------------------------
    private int uniquePaths(int m, int n) 
    {
    	int[][] mark = new int[m][n];
    	for(int i = 0; i < m; ++i)
    	{
    		for(int j = 0 ; j < n; ++j)
    		{
    			mark[i][j] = 1;
    		}
    	}
    	
    	for(int i = 1 ; i < m; ++i)
    	{
    		for(int j = 1 ; j < n ; ++j)
    		{
    			//某一个cell有2种可能到达，从上面来，以及从左边来，
    			//只需要把每一个cell的可能数计算好，并且把它们相加即可
    			mark[i][j] = mark[i-1][j] + mark[i][j-1];//状态转移方程.
    		}
    	}
        return mark[m-1][n-1];
    }
//------------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		UniquePaths_T62 up62 = new UniquePaths_T62();
		
		int m = 1;
		int n = 1;
		
		System.out.println(up62.uniquePaths(m, n));
		
	}

}
