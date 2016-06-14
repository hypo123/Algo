package com.hypo.Math;

public class NumberOfDigitOne_T233
{
//	-----------------暴力破解 超时------------------------
    private int countDigitOne(int n) 
    {
    	int count = 0;
    	
    	for(int i = 1 ; i <= n ; i++)
    	{
    		int j = i;
    		while(j > 0)
    		{
    			if(j % 10 == 1)
    			{
    				count++;
    			}
    			
    			j /= 10;
    		}
    	}
    	return count;
    }
//    -------------------------------------
    /**
     * 这个方法不好理解
     *	可计算1在每一位上出现的次数
     *	n = xyzdabc
     *	则1在千位上出现的次数有三种情况：
     *	(1) xyz * 1000                     if d == 0
	 *	(2) xyz * 1000 + abc + 1           if d == 1
	 *	(3) xyz * 1000 + 1000              if d > 1 
     */
    private int countDigitOne2(int n)
    {
    	if(n <= 0) return 0;
    	
    	int q = n , x = 1 , ans = 0;
    	
    	do
    	{
    		int digit = q % 10;
    		q /= 10;
    		
    		ans += q * x;
    		
    		if(digit == 1) 
    		{
    			ans += n % x + 1;
    		}
    		
    		if(digit >1)
    		{
    			ans += x ;
    		}
    		
    		x *= 10;
    	}
    	while(q > 0);
    	
    	return ans;
    }
//    ---------------------------------------
	public static void main(String[] args)
	{
		NumberOfDigitOne_T233 t233 = new NumberOfDigitOne_T233();
		int n = 13;
		System.out.println(t233.countDigitOne2(n));
	}
}
