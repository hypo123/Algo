package com.hypo.Math;

//LeetCode172 给一个int数n,求n!的后面有多少个0;

public class FactorialTrailingZeroes_T172
{
//---------------------------------------------------------------------
//	此方法超时.且解错误
    private int trailingZeroes(int n)
    {
    	int res = 0;
    	for(int i = 1 ; i <= n ; ++i)
    	{
    		if(i % 10 == 0)
    		{
    			res += countZero(i);
    		}
    	}
    	
        return res;
    }
    
    private int countZero(int n)//n的末尾连续0的个数.
    {
    	int count = 0;
    	while(n % 10 == 0)
    	{
    		if((n /= 10) > 0)
    		{
    			count++;
    		}
    	}
    	return count;
    }
//------------------------------------------------------------------
//  0来自于10，而10又来自于2*5,所以只需计算5的个数，就可得到0的个数.
    private int trailingZeroes2(int n)
    {
    	return n == 0 ? 0 : n / 5 +trailingZeroes2(n / 5) ;
    }
    
    
	public static void main(String[] args)
	{
		FactorialTrailingZeroes_T172 ftz = new FactorialTrailingZeroes_T172();
		
		int n = 10;
				
		System.out.println(ftz.trailingZeroes(n));
	}
}
