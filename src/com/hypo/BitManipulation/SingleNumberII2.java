package com.hypo.BitManipulation;

/**
 * 	用one 记录到当前处理的元素为止，二进制1 出现“1 次”（mod 3 之后的1）的有哪
 *	些二进制位；用two 记录到当前计算的变量为止，二进制1 出现“2 次”（mod 3 之后的2）的有哪
 *	些二进制位。当one 和two 中的某一位同时为1 时表示该二进制位上1 出现了3 次，此时需要清
 *	零。即用二进制模拟三进制运算。最终one 记录的是最终结果。
 *
 *  这个方法是最快，最优的
 */
public class SingleNumberII2
{
    private int singleNumber(int[] nums) 
    {
    	int one = 0;
    	int two = 0;
    	int three = 0;
    	
    	for(int i = 0 ; i < nums.length; ++i)
    	{
    		two |= one & nums[i];//将one与nums[i]与操作，可以标记出one中有那些位已经累计出现两次了
    		
    		one ^= nums[i];//从one将已经出现两次的位清0
    		
    		three = ~(one & two);//记录出现了三次的位
    		
    		one &= three; //将one中参与三次位的清0
    		
    		two &= three;//将two中参与三次位的清0
    	}
    	
    	return one;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleNumberII2 sn22 = new SingleNumberII2();
		
		int[] n = new int[]{123, 234, 456 , 123, 123 ,234 ,234};
		
		System.out.println(sn22.singleNumber(n));
		
	}
}
