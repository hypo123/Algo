package com.hypo.DP;

public class T64_MinimumPathSum
{
    public int minPathSum(int[][] grid) 
    {
    	return 0;   
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		T64_MinimumPathSum t64 = new T64_MinimumPathSum();
		
		int[][] grid = {
				{1,1,1,2,3,4},
				{3,1,1,5,6,7},
				{5,5,1,1,6,8},
				{6,7,8,1,1,9},
				{7,7,7,7,1,1},
				{5,6,5,5,5,1}
		};
		
		System.out.println(t64.minPathSum(grid));
	}

}
