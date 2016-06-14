package com.hypo.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_T54
{
    private List<Integer> spiralOrder(int[][] matrix) 
    {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	if(matrix.length == 0) return result;
    	
    	int rowBegin = 0;
    	int rowEnd = matrix.length - 1;
    	int colBegin = 0;
    	int colEnd = matrix[0].length - 1;
    	
//    	先向右遍历，一行遍历完，rowBegin加1 Step1;
//    	再向下遍历，一列遍历完，colEnd减1   Step2;
//    	再向左遍历，一行遍历完，rowEnd减1   Step3;
//    	再向上遍历，一列遍历完，colBegin加1 Step4;
//    	然后重复上面4步，直到二维数组全部遍历完.
    	while(rowBegin <= rowEnd && colBegin <= colEnd)
    	{
    		//向右
    		for(int r = colBegin ; r <= colEnd ; r++)
    		{
    			result.add(matrix[rowBegin][r]);
    		}
    		rowBegin++;//一行遍历完
    		
    		//向下
    		for(int d = rowBegin ; d <= rowEnd ; d++)
    		{
    			result.add(matrix[d][colEnd]);
    		}
    		colEnd--;//一列遍历完
    		
    		//向左
    		if(rowBegin <= rowEnd)
    		{
    			for(int l = colEnd ; l >= colBegin ; l--)
    			{
    				result.add(matrix[rowEnd][l]);
    			}
    		}
    		rowEnd--;//一行遍历完
    		
    		//向上
    		if(colBegin <= colEnd)
    		{
    			for(int u = rowEnd ; u >= rowBegin ; u--)
    			{
    				result.add(matrix[u][colBegin]);
    			}
    		}
    		colBegin++;//一列遍历完
    	}
    	
    	return result;
    }
    
//    test
	public static void main(String[] args)
	{
		SpiralMatrix_T54 t54  = new SpiralMatrix_T54();
		
		int[][] matrix = {
							{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 }
		                  };
		
		List<Integer> result = t54.spiralOrder(matrix);
		for(int i : result)
		{
			System.out.print(i + " ");
		}
	}
}
