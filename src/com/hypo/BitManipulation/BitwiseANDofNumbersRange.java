package com.hypo.BitManipulation;

/**
 * 超时
 */
public class BitwiseANDofNumbersRange
{
    private int rangeBitwiseAnd(int m, int n) 
    {
        int start = Integer.MAX_VALUE;
    	
    	for(int i = m ; i <= n ; ++i)
    	{
    		start &= i;
    	}
    	return start;
    	
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BitwiseANDofNumbersRange baon = new BitwiseANDofNumbersRange();
		
		int m = 5;
		int n = 7;
		
		
		System.out.println(baon.rangeBitwiseAnd(m, n));
	}

}
