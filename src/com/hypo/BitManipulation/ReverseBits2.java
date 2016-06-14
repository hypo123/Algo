package com.hypo.BitManipulation;

public class ReverseBits2
{
    // you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
    	for(int i = 0 ; i < 16 ; ++i)
    	{
    		int up = n >> (31 - i) & 1 ;
    		int down = n >> i & 1 ;
    		
    		if((up ^ down) == 1)//如果高低两位异或，则要交换
    		{
    			n ^= (1 << i) | (1 << 31 - i);//1 0000 0  与  1 0000 1异或 则交换了最高和最低两位
    		}
    	}
        return n;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseBits2 rb2 = new ReverseBits2();
		
		int n = 43261596;
		
		System.out.println(rb2.reverseBits(n));
	}

}
