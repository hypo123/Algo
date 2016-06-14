package com.hypo.DP;

import java.util.Arrays;

public class InterleavingString_T97
{
//递归版，会超时，仅用来理解.未写完.
//	---------------------------------------------------------------------
    public boolean isInterleave(String s1, String s2, String s3) 
    {
    	if(s3.length() != s1.length() + s2.length()) return false;
    	
    	return interleave(s1, s2, s3, 0, s1.length()-1, 0, s2.length()-1, 0, s3.length()-1);
    }
    
    private boolean interleave(String s1, String s2, String s3 , 
    		int first1 , int last1 , int first2 , int last2 ,
    		int first3 , int last3)
    {
    	System.out.println("ok");
    	if(first3 == last3)//终止条件.
    	{
    		return first1 == last1 && first2 == last2;
    	}
    	
    	if(first1 > last1) return false;
    	if(first2 > last2) return false;
    	
    	return false;
//    	return (s1.charAt(first1) == s3.charAt(first3) && interleave(s1, s2, s3, first1+1, last1, first2, last2, first3+1, last3)
//    			|| s2.charAt(first2) == s3.charAt(first3) && interleave(s1, s2, s3, first1, last1, first2+1, last2, first3+1, last3));
    }
// 解法错误.   ----------------------------------------------------------------------------
//    public boolean isInterleave2(String s1, String s2, String s3) 
//    {
//    	int len1 = s1.length();
//    	int len2 = s2.length();
//    	int len3 = s3.length();
//    	
//    	if(len3 != len1 + len2) return false;
//    	
//    	int m = 0;
//    	int n = 0;
//    	boolean flag = false;
//    	
//    	for(int i = 0 ; i < len3 ; ++i)
//    	{
//    		flag = false;
//    		
//    		boolean f1 = false;
//    		boolean f2 = false;
//    		
//    		if( (f1 = (m <= len1-1 && s3.charAt(i) == s1.charAt(m)))  ||
//    				(f2 = (n <= len2-1 && s3.charAt(i) == s2.charAt(n)))  )
//    		{
//    			if(f1 && f2)
//    			{
//    				if((i < len3-1) && (s1.charAt(m) != s3.charAt(i+1)))
//    				{
//    					m++;
//    					flag = true;
//    				}
//    				else
//    				{
//    					n++;
//    					flag = true;
//    				}
//    			}
//    			else if(f1)
//    			{
//    				m++;
//    				flag = true;
//    			}
//    			else
//    			{
//    				n++;
//    				flag = true;
//    			}
//    			
//    		}
//    		System.out.println(flag);
//    		if(!flag) return false;
//    	}
//    	
//    	return true;
//    	
//    }
//    -----------------------二维动归------------------------------------------
    /**
     * //状态f[i][j]表示s1[0,i],s2[0,j]匹配s3[0,i+j];
     * 如果s1的最后一个字符等于s3的最后一个字符,则有f[i][j] == f[i-1][j]
     * 如果s2的最后一个字符等于s3的最后一个字符,则有f[i][j] == f[i][j-1]
     * 
     * 
     * 例1   s1 = "aabcc"
     * 		s2 = "dbbca"
     * 		s3 = "aadbbcbcac"
     * 
     */
    public boolean isInterleave2(String s1, String s2, String s3) 
    {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();
    	
    	if((len3 ^ (len1 + len2)) != 0) return false;
    	
    	boolean[][] f = new boolean[len1+1][len2+1];//状态f[i][j]表示s1[0,i],s2[0,j]匹配s3[0,i+j]
    	
    	for(int i = 0 ;i < len1+1 ; i++)
    	{
    		Arrays.fill(f[i], true);//将数组f中所有元素置为true
    	}
    	
    	for(int i = 1 ; i < len1 ; i++)
    	{
    		f[i][0] = f[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    	}
    	
    	for(int j = 1 ; j < len2 ; j++)
    	{
    		f[0][j] = f[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    	}
    	
    	for(int i = 1 ; i <= len1 ; i++)
    	{
    		for(int j = 1; j <= len2 ; j++)
    		{
    			f[i][j] = ((f[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
    					|| (f[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)));//状态转移方程
    		}
    	}
    	
    	
    	return f[len1][len2];
    }
//    -----------------------二维动归+滚动数组--------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    ------------------------------------------------------------------
//    -------------------------------BFS---------------------------------

/*    转化为寻路问题，用广度优先搜索解决
  s1 = "aab"  
  s2 = "abc"
  s3 = "aaabcb"
  找一条从最左上角到最右下角的路径.
		  o--a--o--b--o--c--o
		  |     |     |     |
		  a     a     a     a
		  |     |     |     |
		  o--a--o--b--o--c--o
		  |     |     |     |
		  a     a     a     a
		  |     |     |     |
		  o--a--o--b--o--c--o
		  |     |     |     |
		  b     b     b     b
		  |     |     |     |
		  o--a--o--b--o--c--o
		  
		  一种可能的路径，x表示从此经过
		  x--a--x--b--o--c--o
		  |     |     |     |
		  a     a     a     a
		  |     |     |     |
		  o--a--x--b--o--c--o
		  |     |     |     |
		  a     a     a     a
		  |     |     |     |
		  o--a--x--b--x--c--x
		  |     |     |     |
		  b     b     b     b
		  |     |     |     |
		  o--a--o--b--o--c--x
  */
    public boolean isInterleave3(String s1, String s2, String s3) 
    {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();
    	
    	if((len3 ^ (len1 + len2)) != 0) return false;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return false;
    }
  
 
    
    
//    ----------------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		InterleavingString_T97 t97 = new InterleavingString_T97();
		String s1 = "aabcc";
		String s2 = "dbbca";

		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		
		System.out.println(t97.isInterleave2(s1, s2, s3));
	}

}
