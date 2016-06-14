package com.hypo.DP;

//给定一个字符串，算出最少需切多少次后，得到的所有子字符串都是回文的.
public class PalindromePartitioningII_T132
{
    public int minCut(String s)
    {
    	int len  = s.length();
    	int[] f = new int[len + 1];
    	boolean[][] p = new boolean[len][len];//如果s[i,j]之间字符串是回文的，则p[i][j]为true.
    	
//    	最坏的情况是每一个字符都要切割.
    	for(int k = 0 ; k <= len ; ++k)
    	{
    		f[k] = len - 1 - k;//最后一个f[len]=-1;
    	}
    	
    	for(int i = len - 1; i >= 0 ; --i )//i从右往左扫描
    	{
    		for(int j = i ; j < len ; ++j)
    		{
    			if(s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i+1][j-1] == true))
    			{
    				p[i][j] = true;
    				f[i] = Math.min(f[i], f[i+1]+1);//状态转移方程
    			}
    		}
    	}
        return f[0];
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PalindromePartitioningII_T132 t132 = new PalindromePartitioningII_T132();
		
		String s = "aab";
		
		int result = t132.minCut(s);
		
		System.out.println(result);
	}

}
