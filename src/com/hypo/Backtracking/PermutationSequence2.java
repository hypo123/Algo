package com.hypo.Backtracking;

/**
 * 利用康托编码的思想.
 * 
 * 康托展开：X=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[2]*1!+a[1]*0!
 *
 */
public class PermutationSequence2
{
    private String getPermutation(int n, int k)
    {
    	StringBuffer sb =new StringBuffer();
    	int[] nums = new int[n];
    	for(int i = 0 ; i < n ; ++i)
    	{
    		nums[i] = i + 1;
    	}
    	
    	int base = factorial( n - 1);
    	--k;
    	
//    	这个循环是关键  k %= base   ; base /= i;
    	for(int i = n - 1; i > 0 ; k %= base , base /= i , --i)
    	{
    		int index = findKth(nums, k / base + 1);
    		sb.append( nums[index]);
    		nums[index] = 0;
    	}
    	
    	sb.append(nums[findKth(nums, 1)]);
    	return sb.toString();
    }
    
    private int findKth(int[] nums, int k)
    {
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		if(nums[i] != 0)
    		{
    			if(--k == 0) return i;
    		}
    	}
    	return 0;
    }
    
    private int factorial(int n )
    {
    	int result = 1;
    	for(int i = 1 ;i <= n; ++i)
    	{
    		result *= i;
    	}
    	return result;
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PermutationSequence2 ps2 = new PermutationSequence2();
		
		System.out.println(ps2.getPermutation(3, 4));
	}

}
