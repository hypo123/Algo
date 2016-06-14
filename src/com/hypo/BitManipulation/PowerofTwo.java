package com.hypo.BitManipulation;

/**
 * 如果 n > 0 ，如果是2的平方，0-31位上只有一位上是1，其他位为0,其他情况不是2的平方.
 * 
 * 
 * 以下方法是最优的
 * 或一行代码可解决  return ( n & (n - 1) == 0 && n > 0)
 * 也是利用了2的平方只有一位是1,并且2的平方减1后原来是1的位变为0,原来比1位低的位都变为1
 * 如 二进制 100   减1后为    011
 */
public class PowerofTwo
{
    public boolean isPowerOfTwo(int n) 
    {
    	if(n < 0) return false;
    	int count = 0;
    	for(int i = 0 ; i < 32 ; ++i)
    	{
    		if((n & 1 << i) != 0)
    		{
    			count++;
    		}
    	}
    	if(count == 1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PowerofTwo pot = new PowerofTwo();
		
		int n = -2147483648;
		
		int n2 = 3 ;
		
		System.out.println(pot.isPowerOfTwo(n));
		System.out.println(pot.isPowerOfTwo(n2));
	}

}
