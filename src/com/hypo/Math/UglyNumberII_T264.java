package com.hypo.Math;
//
//找第n个丑数  
//丑数即该数的质数因子只包含2,3,5

/*
(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …

We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.
Every step we choose the smallest one, and move one step after

*/
public class UglyNumberII_T264
{
    private int nthUglyNumber(int n) 
    {
    	int[] ugly = new int[n];
    	ugly[0] = 1;
    	
    	int index2 = 0 , index3 = 0 , index5 = 0;
    	int factor2 = 2 , factor3 = 3 , factor5 = 5;
    	
    	for(int i = 1 ; i < n ; i++)
    	{
    		int min = Math.min(Math.min(factor2, factor3), factor5);
    		
    		ugly[i] = min;
    		
    		if(min == factor2)
    		{
    			factor2 = 2 * ugly[++index2] ;
    		}
    		if(min == factor3)
    		{
    			factor3 = 3 * ugly[++index3];
    		}
    		if(min == factor5)
    		{
    			factor5 = 5 * ugly[++index5];
    		}
    	}
    	return ugly[n-1];
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		UglyNumberII_T264 t264 = new UglyNumberII_T264();
		System.out.println(t264.nthUglyNumber(10));
	}

}
