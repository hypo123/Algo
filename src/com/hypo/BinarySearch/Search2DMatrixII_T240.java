package com.hypo.BinarySearch;

public class Search2DMatrixII_T240
{
	private boolean searchMatrix(int[][] matrix, int target) 
	{
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

		int row = 0;
		int col = matrix[0].length - 1;

		while(col >= 0 && row < matrix.length)
		{
			if(target == matrix[row][col])
			{
				return true;
			}
			else if(target > matrix[row][col])
			{
				row++;
			}
			else
			{
				col--;
			}
		}
		return false;
	}
	
//	test
	public static void main(String[] args)
	{
		Search2DMatrixII_T240 t240 = new Search2DMatrixII_T240();
		
		int[][] matrix = {
				
				 {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
		};
		
		int target = 5;
		
		
		System.out.println(t240.searchMatrix(matrix, target));
	}
}
