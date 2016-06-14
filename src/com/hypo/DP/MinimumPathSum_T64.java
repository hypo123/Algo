package com.hypo.DP;

//找到二维数组从左上角到右下角，路径之和的最小值.只能向下，或向右.
public class MinimumPathSum_T64
{
//	设f[i][j]为从[0,0]到[i,j]的最小路径和，那么状态转移方程为
//	f[i][j] = min(f[i-1][j] , f[i][j-1])+grid[i][j]
    public int minPathSum(int[][] grid) 
    {
    	int row = grid.length;
    	int col = grid[0].length;
    	int[][] f = new int[row][col];
    	
    	for(int i = 0 ; i < row ; ++i)
    	{
    		for(int j = 0 ; j < col ; ++j)
    		{
    			if(i == 0 && j == 0) 
    			{
    				
    				f[i][j] = grid[i][j]; 
    				continue;
    			}
    			if(i == 0) 
    			{
    				f[i][j] = f[i][j-1] + grid[i][j];
    				continue;
    			}
    			if(j == 0) 
    			{
    				f[i][j] = f[i-1][j] + grid[i][j];
    				continue;
    			}
    			
    			f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
    		}
    	}
        return f[row-1][col-1];
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[][] grid = {
				{1,1,1,2,3,4},
				{3,1,1,5,6,7},
				{5,5,1,1,6,8},
				{6,7,8,1,1,9},
				{7,7,7,7,1,1},
				{5,6,5,5,5,1}
		};
		
		MinimumPathSum_T64 t64 = new MinimumPathSum_T64();
		
		System.out.println(t64.minPathSum(grid));
	}

}
