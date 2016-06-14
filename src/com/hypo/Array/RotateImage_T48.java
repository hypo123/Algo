package com.hypo.Array;

//就地将n*n二维数组顺时针旋转90度.

/*
 * 逆时针旋转90度
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/


/*
 * 顺时针旋转
 * 1.先第一行与最后一行交换，第二行与倒数第二行交换...
 * 2.对称交换.
 * 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
public class RotateImage_T48
{
    public void rotate(int[][] matrix) 
    {
    	int start = 0;
    	int end = matrix.length - 1;
    	int width = matrix[0].length;
    	
    	int mid = 0;
    	while(start < end)//行交换
    	{
    		for(int i = 0 ; i < width ; i++)
    		{
    			mid = matrix[start][i];
    			matrix[start][i] = matrix[end][i];
    			matrix[end][i] = mid;
    		}
    		start++;
    		end--;
    	}
    	
    	mid = 0;
    	for(int i = 0 ; i < matrix.length ; i++)//对称交换.
    	{
    		for(int j = i + 1 ; j < width ; j++)
    		{
    			mid = matrix[j][i];
    			matrix[j][i] = matrix[i][j];
    			matrix[i][j] = mid;
    		}
    	}
    }
    
    public static void main(String[] args)
	{
    	RotateImage_T48 t48 = new RotateImage_T48();
    	
    	int[][] matrix = {{1,2,3,4,4},
    					  {6,6,6,6,5},
    					  {8,8,8,8,6},
    					  {8,8,8,8,7},
    					  {8,8,8,8,8}};
    	
    	 t48.rotate(matrix);
    	
    	//test
    	for(int i = 0 ; i < matrix.length; i++)
    	{
    		for(int j = 0; j < matrix[0].length;j++)
    		{
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	
	}
}
