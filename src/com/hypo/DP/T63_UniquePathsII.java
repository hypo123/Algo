package com.hypo.DP;

public class T63_UniquePathsII
{
    private int uniquePathsWithObstacles(int[][] grid) 
    {
    	int row = grid.length;
    	int col = grid[0].length;
    	
    	int[][] f = new int[row][col];
    	
    	if(grid[0][0] != 1) f[0][0] = 1;
    	
    	for(int i = 0 ; i < row ; i++ )
    	{
    		for(int j = 0 ; j < col ; j++)
    		{
    			if(grid[i][j] == 1)//障碍
    			{
    				f[i][j] = 0;
    				continue;
    			}
    			
    			if(i == 0 && j == 0)
    			{
    				continue;
    			}
    			
    			if(i == 0)//第一行
				{
    				f[i][j] += f[i][j-1];
    				continue;
				}
    			if(j == 0 )//第一列
    			{
    				f[i][j] += f[i-1][j];
    				continue;
    			}
    			f[i][j] = f[i-1][j] + f[i][j-1];//来自上边或左边
    		}
    	}
    	return f[row-1][col-1];
    }
//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
    	T63_UniquePathsII t63 = new T63_UniquePathsII();
    	
    	int[][] grid = {  {0,0,0},
    					  {0,1,0},
    			          {0,0,0}};
    	
    	int[][] grid2 = {{1}};
    	
    	System.out.println(t63.uniquePathsWithObstacles(grid));
	}
}
