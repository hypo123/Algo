package com.hypo.DP;

/**
 * 爬n阶梯子，一次爬一格或两格，有多少种不同的爬法
 * 
 *  使用递归，超时.
 *  
 *  使用dp,有规律，n阶爬法数是(n-1)阶和(n-2)阶爬数之和.
 */
public class ClimbingStairs
{
//    public int climbStairs(int n) //这个比下面的要快
//    {
//    	int count = 0;
//    	int prevone = 1;
//    	int prevtwo = 0;
//        for(int i = 1 ; i <= n ; ++i)
//        {
//        	count = prevone + prevtwo;
//        	prevtwo = prevone;
//        	prevone = count; 
//        }
//    	return count;
//    }
    public int climbStairs(int n) //dp
    {
    	int count = 0;
    	int prevone = 2;
    	int prevtwo = 1;
    	int j = 2;
    	if(n == 1) 
    	{
    		return 1;
    	}
    	else if(n == 2)
    	{
    		return 2;
    	}
    	else
    	{
    	 	while(++j <= n)
        	{
        		count = prevone + prevtwo;
        		prevtwo = prevone;
        		prevone = count;
        	}	
    	}
        return count;
    }
    
    public int climbStairs2(int n) 
    {
        int[] f = new int[n+1];
        
        if(n <= 1) return 1;
        
        f[0] = 1;
        f[1] = 1;
        
        for(int i = 2; i <= n ; i++)
        {
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ClimbingStairs cs = new ClimbingStairs();
		
		int n = 5;
		
		System.out.println(cs.climbStairs(n));
	}

}
