package com.hypo.DP;

//Edit Distance T72
//给定两个字符串s1,s2;只能有三种对字符的操作：插入，删除，替换；求得从s1变化到s2需要的最小步骤
public class EditDistance_T72
{
//	二维动规
	/** f[i][j]表示从A[0,i]到B[0,j]之间的最短编辑距离，
	 *  设A[0，i]的形式为str1c , B[0,j]的形式为str2d
	 *  1.如果c == d ,则f[i][j] == f[i-1][j-1]
	 *  2.如果c != d ,
	 *  	a)将c替换为d, 则f[i][j] = f[i-1][j-1] + 1;//替换
	 *  	b)在c后面添一个d,则f[i][j] = f[i][j-1] + 1;//插入
	 *  	c)将c删除,则f[i][j] = f[i-1][j] + 1;//删除
	 */
    private int minDistance(String s1, String s2) 
    {
    	int n = s1.length();
    	int m = s2.length();
//    	长度为n的字符串有n+1个隔板
    	int[][] f =  new int[n+1][m+1];//状态
    	
    	for(int i = 0 ; i <= n ; i++)
    	{
    		f[i][0] = i;//从A[0,i]到B[0,0]
    	}
    	
    	for(int j = 0 ; j <= m ; j++)
    	{
    		f[0][j] = j;//从A[0,0]到B[0,j]
    	}
    	
    	for(int i = 1 ; i <= n ; i++)
    	{
    		for(int j = 1 ; j <= m ; j++)
    		{
    			if(s1.charAt(i - 1) == s2.charAt(j - 1))
    			{
    				f[i][j] = f[i -1][j - 1];
    			}
    			else
    			{
    				int mn = Math.min(f[i][j-1], f[i-1][j]);//到状态f[i][j-1],f[i-1][j]那个需要的步骤少
    				
    				f[i][j] = 1 + Math.min(mn , f[i-1][j-1]); //状态转移方程;mn与到状态f[i-1][j-1]的步骤大小
    			}
    		}
    	}
        return f[n][m];
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EditDistance_T72 t72 = new EditDistance_T72();
		String s1 = "heoao";
		String s2 = "hello";
		
		System.out.println(t72.minDistance(s1, s2));

	}

}
