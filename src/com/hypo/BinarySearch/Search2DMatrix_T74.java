package com.hypo.BinarySearch;

public class Search2DMatrix_T74
{
    private boolean searchMatrix(int[][] matrix, int target) 
    {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	if(matrix == null || row < 1 || col < 1) return false;

    	for(int i = 0 ; i < row ; i++)
    	{
    		int ret = BinarySearch(matrix[i] , target);
    		
    		if(ret >= 0)
    		{
    			return true;
    		}
    		else if(ret == -col - 1)
    		{
    			continue;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	
    	return false;
    }
    
    private int BinarySearch(int[] a , int key)//二分查找模板2JDK版
    {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) 
        {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
//   如果它包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。插入点 被定义为将键插入数组的那一点：
//   即第一个大于此键的元素索引，如果数组中的所有元素都小于指定的键，则为 a.length。注意，这保证了当且仅当此键被找到时，返回的值将 >= 0。
    }
    
    
//    test
	public static void main(String[] args)
	{
		Search2DMatrix_T74 t74 = new Search2DMatrix_T74();
		
		int[][] matrix = {
				
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
		};
		
		int target = 9;
		System.out.println(t74.searchMatrix(matrix, target));
	}
}
