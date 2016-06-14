package com.hypo.DP;

public class UniquePathsII_T63
{
    private int uniquePathsWithObstacles(int[][] grid) 
    {
    	int row = grid.length;
    	int col = grid[0].length;
    	int[][] mark = new int[row][col];
    	
    	if(grid[0][0] != 1) mark[0][0] = 1;
    	
    	for(int i = 0 ; i < row ; ++i)
    	{
    		for(int j = 0 ; j < col ; ++j)
    		{
    			if(grid[i][j] == 1)//此处是障碍
    			{
    				mark[i][j] = 0;
    			}
    			else
    			{
    				//某一个cell有2种可能到达，从上面来，以及从左边来，
    				//只需要把每一个cell的可能数计算好，并且把它们相加即可
    				if(i != 0)//左边来
    				{
    					mark[i][j] += mark[i-1][j];
    				}
    				
    				if(j != 0)//上面来
    				{
    					mark[i][j] += mark[i][j-1];
    				}
    			}
    		}
    	}
    	
        return mark[row-1][col-1];
    }
    
    public static void main(String[] args)
	{
    	UniquePathsII_T63 up63 = new UniquePathsII_T63();
    	
    	int[][] grid = {  {0,0,0},
    					  {0,1,0},
    			          {0,0,0}};
    	int[][] grid2 = {{1}};
    	System.out.println(up63.uniquePathsWithObstacles(grid2));
	}
}
