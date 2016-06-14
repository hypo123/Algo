package com.hypo.BitManipulation;

/**
 * Java中int型有32位，可以从 0-31循环一次，每次将1的值左移i位，然后与
 * n与操作，即可知n的第i位上是1还是0 
 *
 * 注意java中没有无符号的int,所以按题意最高位的符号位也要参与判断.
 */
public class Numberof1Bits
{
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) 
    {
    	int count = 0;
    	
    	for(int i = 0 ; i <= 31; ++i)
    	{
    		if(checkBit(n , i) == true)
    		{
    			count++;
    		}
    	}
        return count;
    }
    
    private boolean checkBit(int n , int i)
    {	
    	return (n & (1 << i)) != 0;
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Numberof1Bits nob = new Numberof1Bits();
		
		int n = Integer.MAX_VALUE;
		
		System.out.println(nob.hammingWeight(n));
	}

}
