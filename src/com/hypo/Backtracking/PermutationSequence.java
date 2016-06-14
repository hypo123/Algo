package com.hypo.Backtracking;
import com.hypo.Array.NextPermutation;

/**
 * 简单的暴力枚举法，调用k-1次NextPermutation
 * 比较浪费，我们只需要第k个排列速度太慢了
 */
public class PermutationSequence
{
    public String getPermutation(int n, int k)
    {
    	NextPermutation npt = new NextPermutation();
    	int[] nums = new int[n];
    	for(int i = 0 ; i < n ; ++i)
    	{
    		nums[i] = i+1;
    	}
    	while(--k > 0)
    	{
    		npt.change(nums,1);//调用k-1次NextPermutation
    	}
    	
    	StringBuffer sb =new StringBuffer();
    	
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		sb.append(nums[i]);
    	}
    	return sb.toString();
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PermutationSequence ps = new PermutationSequence();
		
		System.out.println(ps.getPermutation(3, 6));
	}

}
