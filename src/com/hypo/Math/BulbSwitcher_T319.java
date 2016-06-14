package com.hypo.Math;

import java.util.Arrays;

public class BulbSwitcher_T319
{
//	------------------超时------------------------
/*	前10盏灯泡的开闭过程如下所示：

	0 0 0 0 0 0 0 0 0 0    0
	1 1 1 1 1 1 1 1 1 1    1
	1 0 1 0 1 0 1 0 1 0    2
	1 0 0 0 1 1 1 0 0 0    3
	1 0 0 1 1 1 1 1 0 0    4
	1 0 0 1 0 1 1 1 0 1    5
	1 0 0 1 0 0 1 1 0 1    6
	1 0 0 1 0 0 0 1 0 1    7
	1 0 0 1 0 0 0 0 0 1    8
	1 0 0 1 0 0 0 0 1 1    9
	1 0 0 1 0 0 0 0 1 0    10*/
	
	
    public int bulbSwitch(int n)
    {
    	int on = 0;
    	
    	if(n <= 1) return n;
    	int[] state = new int[n];
    	Arrays.fill(state, 1);//1
    	
    	for(int i = 1 ; i <= state.length ; i++)//2
    	{
    		if(i % 2 == 0)
    		{
    			state[i-1] = 0;
    		}
    	}
    	
    	if(n == 2)
    	{
    		for(int s : state)
    		{
    			if(s == 1) on++;
    		}
    		return on;
    	}
    	
    	for(int k = 3 ; k <= n ; k++)
    	{
    		for(int i = 1 ; i <= state.length ; i++)//3
    		{
    			if(i % k == 0)
    			{
    				state[i-1] ^= 0x1;
    			}
    		}
    	}
    	
    	for(int s : state)
    	{
    		if((s & 0x1) == 1) ++on;
    	}
    		
    	return on; 
    }
//   ===================改思路挺巧妙=================================
   /* 对于第i栈灯泡，当i的因子个数为奇数时，最终会保持点亮状态，例如9的因子为1，3，9
    * 因此对于k号灯，只有遇到k的因子时，才会被toggle
    * 即9号灯之后1,3,9是toggle ; 1的时候开启，3的时候熄灭，9的时候再开启，因此最后是开启的.
                  而当i的因子个数为偶数时，最终会保持熄灭状态，例如8的因子为：1，2，4，8
                 当且仅当i为完全平方数时，其因子个数为奇数 , 平方数是有两个因子是一样的，因此会出现一个奇数个因子的情况*/
    
	/* 1-9号灯的变化情况
	 *  1 --------- 1
	    2 --------- 1, 2
	    3 --------- 1, 3
	    4 --------- 1, 2, 4
	    5 --------- 1, 5
	    6 --------- 1, 2, 3, 6
	    7 --------- 1, 7
	    8 --------- 1, 2, 4, 8
	    9 --------- 1, 3, 9
	    
	          即需要求出的是1至n的范围内有多少个平方数
	*/
    public int bulbSwitch2(int n)
    {
    	//将n开平方值为x, 即1*1 , 2*2, ... , (x-1)*(x-1), x*x 都是1到n之间的平方数
    	//1至n之间的平方数一共有x个，因此有x盏等最后是亮的.
    	return (int)Math.sqrt(n);
    }
//    =====================================================
	public static void main(String[] args)
	{
		BulbSwitcher_T319 t319 = new BulbSwitcher_T319();
		
		int n = 3;
		
		System.out.println(t319.bulbSwitch2(99999));
	}
}
