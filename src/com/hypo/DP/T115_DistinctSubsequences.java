package com.hypo.DP;

import java.util.Arrays;

/**给定字符串S和T,计算S中包含多少个T.即S串有多少种方法形成子串T
*	S = "rabbbit", T = "rabbit" return 3;
*/
public class T115_DistinctSubsequences
{
// ----------------方案一：二维动归--------------------------------------------
	/**
	 * 设状态为f(i,j),表示T[0,i]在S[0,j]中出现的次数.
	 * 若T[i] != S[j] , f(i,j) = f(i-1,j)
	 * 若T[i] == S[j] , f(i ,j) = f(i-1,j) + f(i-1,j-1)
	 * 
	 *  一个例子      S:[acdabefbc] 和 T:[ab]
	 *  1:先检查 a
	 *        S =    [acdabefbc]
			  f[1] =[0111222222]
		2.再检查 b	  
		 	S =      [acdabefbc]
			f[1] =  [0111222222]
			f[2] =  [0000022244]
			
			  S =    [a   b    ]
	      	  S =    [a      b ]
	          S =    [   ab    ]
	          S =    [   a   b ]
	 */
	    public int numDistinct1(String s, String t)
	    {
	    	int lens = s.length();
	    	int lent = t.length();
//	    	if(lens < lent) return 0;
	    	
	    	int[][] f = new int[lent+1][lens+1];//设状态为f[i,j],表示T[0,i]在S[0,j]中出现的次数.
	    										//长度定为lent+1是因为要从空串开始
	    	
	    	Arrays.fill(f[0], 1);//将二维数组f第一行所有元素赋值为1; 空字符串是任何字符串的字串
	    	
	    	for(int i = 0 ; i < lent ; i++)
	    	{
	    		for(int j = 0 ; j < lens ; j++)
	    		{
	    			if(t.charAt(i) == s.charAt(j))//t[i] == s[j]
	    			{
	    				f[i+1][j+1] = f[i+1][j] + f[i][j];
	    			}
	    			else
	    			{
	    				f[i+1][j+1] = f[i+1][j];
	    			}
	    			
	    		}
	    	}
	    	return f[lent][lens];
	    }
	//  ----------------------------------------------------------------------------------------
//----------------方案一：二维动归+滚动数组-------------------------------
/**
 * 二维动归+滚动数组
 * 设状态为f(i,j),表示T[0,i]在S[0,j]中出现的次数.
 * 若T[i] != S[j] , f(i,j) = f(i-1,j)
 * 若T[i] == S[j] , f(i ,j) = f(i-1,j) + f(i-1,j-1)
 */
    public int numDistinct2(String s, String t)
    {
    	int lens = s.length();
    	int lent = t.length();
    	if(lens < lent) return 0;
    	
    	int[] f = new int[lens + 1];
    	
    	f[0] = 1;
    	
    	for(int i = 0 ; i < lens ; i++)
    	{
    		for(int j = lent - 1; j >= 0 ; j--)
    		{
    			f[j+1] += s.charAt(i) == t.charAt(j) ? f[j] : 0;
    		}
    	}
    	
        return f[lent];
    }

    public static void main(String[] args)
	{
    	T115_DistinctSubsequences t115 = new T115_DistinctSubsequences();
    	
    	String s = "rabbbit";
    	String t = "rabbit";
    	
    	System.out.println(t115.numDistinct1(s, t));
	}
}
