package com.hypo.BitManipulation;

public class ReverseBits
{
    // you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
    	int num = 0;
    	for(int i = 0, j = 31; i < 32 && j >= 0; ++i,--j)
    	{
    		if((n & 1 << i) != 0)
    		{
    			num += 1 << j;
    		}
    	}
    	
        return num;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseBits rb = new ReverseBits();
		
		int n = 1;
		
		System.out.println(rb.reverseBits(n));
	}

}
