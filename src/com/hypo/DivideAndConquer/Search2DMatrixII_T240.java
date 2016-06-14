package com.hypo.DivideAndConquer;

import java.util.Arrays;

public class Search2DMatrixII_T240
{
// --------------------有错误---------------------------------
	public boolean searchMatrix(int[][] matrix, int target) 
    {
    	int length = matrix.length;
    	int width = matrix[0].length;
    	int[] vertical = new int[length];
    	int lenx = 0;
    	int lena = -1;
    	int leny = 0;
    	int lenb = -1;
    	
    	while(true)
    	{
    		int value = Arrays.binarySearch(matrix[leny], target); 
    		if(value >= 0) 
    		{
    			return true;
    		}
    		else
    		{
    			lenx = -(value + 1)-1; 
    			if(lenx < 0) lenx = 0;
    		}
    		
    		if(target > matrix[leny][lenx] && lenx < width-1 && leny == width-1) lenx++;
    		
    		if(lenx == lena) return false;
    		lenb = lenx;
    		
    		for(int k = 0 ; k < length; k++)
    		{
    			vertical[k] = matrix[k][lenx];
    		}
    		
    		value = Arrays.binarySearch(vertical, target);
    		
    		if(value >= 0)
    		{
    			return true;
    		}
    		else
    		{
    			leny = -(value + 1)-1; 
    			if(leny < 0) leny = 0;
    		}
    		if(target > matrix[leny][lenx] && leny < length -1 && lenx == length-1) leny++;
    		if(lenb == leny) return false;
    		lena = leny;
    	}
    }
    
//    ----------------------AC-----------------------------------------
	public boolean searchMatrix2(int[][] matrix, int target)
	{
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
		
		int row = matrix.length;
		int col = matrix[0].length;
		
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
//    ------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Search2DMatrixII_T240 t240 = new Search2DMatrixII_T240();
		
		int[][] matrix = {
				  {1,  4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
		};
		
		int[][] matrix2 = {{-5}};
		
		int[][] matrix3 = {{5},
						   {6}};
		
		int[][] matrix4 = {{1, 2,  3, 4, 5},
						   {6, 7,  8, 9,10},
						   {11,12,13,14,15},
						   {16,17,18,19,20},
						   {21,22,23,24,25}};
		
		
		int[][] matrix5 = {{1,4},
				           {2,5}};
		int[][] matrix6 = {{1,1}};
		int target = 5;
		int target2 = 20;
		int target3 = -10;
		int target4 = 6;
		int target5 = 19;
		int target6 = 3;
		System.out.println(t240.searchMatrix2(matrix5, target6));
	}

}
