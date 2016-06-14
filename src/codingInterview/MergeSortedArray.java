package codingInterview;

import java.util.Arrays;

public class MergeSortedArray
{
    public int[] merge(int[] nums1, int m, int[] nums2, int n)
    {
    	for(int i = 0 ; i < n ; i++)
    	{
    		boolean flag = false;
    		for(int j = 0 ; j < m ; j++)
    		{
    			if(nums2[i] <= nums1[j])
    			{
    				flag = true;
    				int k = m;
    				while(k > j)
    				{
    					nums1[k] = nums1[k-1];
    					k--;
    				}
    				nums1[j] = nums2[i]; 
    				m++;
    				break;
    			}
    		}
    		if(!flag)
    		{
    			nums1[m] = nums2[i];
    			m++;
    		}
    		flag = false;
    	}
    			
        return nums1;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MergeSortedArray msa = new MergeSortedArray();
		
		int[] nums1 = new int[]{3,5,8,9,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
		int[] nums2 = new int[]{2,6,10};
		
		int[] result = msa.merge(nums1, 4, nums2, 3);
		
		for(int i = 0 ; i < result.length; i++)
		{
			System.out.print(result[i]+" ");
		}
	} 

}
