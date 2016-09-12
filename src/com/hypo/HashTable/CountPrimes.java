package com.hypo.HashTable;

/**
 * 判断素数  注意 1 不是素数.
 * 
 * 埃拉托色尼选筛法(the Sieve of Eratosthenes)简称埃氏筛法.
 * 它不是去求那些是素数，那是先标记那些不是素数,然后剩下的就是素数了.
 */
public class CountPrimes
{
    private int countPrimes(int n) 
    {
    	boolean[] isPrime = new boolean[n];
    	for(int i = 2; i < n ; ++i)
    	{
    		isPrime[i] = true;
    	}
    	
    	/**
    	 * 这里有个处理技巧，n开平方很耗时,用 i*i <= n 代替  i <= 根号n
    	 */
    	for(int i = 2; i*i <= n ; ++i)//Sieve of Eratosthenes
    	{
    		if(!isPrime[i])//已经标记不是素数，说明它的倍数也已经标记了不是素数.
    		{
    			continue;
    		}
    		
    		for(int j = i * i ; j < n ; j += i)//i不是素数，将i的倍数也标记为非素数.
    		{
    			isPrime[j] = false;
    		}
    	}
    	
    	int count = 0;
    	
    	for(int k = 2; k < n; ++k)
    	{
    		if(isPrime[k]) count++;
    	}

    	return count;
    }
    
    /**
     * countPrimes2 与 countPrimes思路是一样，但就是把isPrime[]数组换成
     * NotPrime[]数组，NotPrime[]数组在数组初始化时自动赋值为false，就免掉了
     * isPrime[]循环赋初值的过程. 速度上有很大的提升.  304ms 208ms
     */
    private int countPrimes2(int n) 
    {
    	boolean[] NotPrime = new boolean[n];
    	
    	//这里有个处理技巧，n开平方很耗时用 i*i <= n 代替  i <= 根号n
    	for(int i = 2; i*i <= n ; ++i)
    	{
    		if(NotPrime[i])//已经标记不是素数，说明它的倍数也已经标记了不是素数.
    		{
    			continue;
    		}
    		
    		for(int j = i * i ; j < n ; j += i)//i不是素数，将i的倍数也标记为非素数.
    		{
    			NotPrime[j] = true;
    		}
    	}
    	
    	int count = 0;
    	
    	for(int k = 2; k < n; ++k)
    	{
    		if(!NotPrime[k]) count++;
    	}

    	return count;
    }
    
 
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CountPrimes cp = new CountPrimes();
		
		int n = 100;
		
		System.out.println(cp.countPrimes(n));
		System.out.println(cp.countPrimes2(n));
	}

}
