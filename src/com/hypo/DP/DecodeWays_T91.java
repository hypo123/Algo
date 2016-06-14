package com.hypo.DP;

//Decode Ways t91
//类似于ClimbingStairs 爬楼梯
/**
 * 
 *  'A' -> 1
 *	'B' -> 2
 *	   ...
 *	'Z' -> 26
 *
 */
public class DecodeWays_T91
{
//-------------------------使用DP-------------------------------------------
    public int numDecodings1(String s) 
    {
    	if(s == null || s.length() == 0 ) return 0;
    	
    	int prev = 0;
    	int cur = 1;
    	
//    	长度为n的字符串有n+1格阶梯
    	for(int i = 1 ; i <= s.length(); i++)
    	{
    		if(s.charAt(i-1) == '0') cur = 0;//f[i-1]
    		
    		if(i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' &&
    				s.charAt(i - 1) <= '6')))//f[i-2]
    		{
    			prev = 0;
    		}
    		
    		int tmp = cur;
    		
    		cur = prev + cur;//新状态     f[i] = f[i-1] + f[i-2]
    		
    		prev = tmp;
    	}
    	
    	return cur;
    }
	
//-------------------------使用深搜，可以解决，但是超时---------------------------
//	字符串s中可能有0
    private int numDecodings2(String s) 
    {
    	if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
    	int[] num = new int[1];
    	
    	dfs(s , 0 , num);
        return num[0];
    }    

    private void dfs(String s , int index , int[] num)
    {
    	if(index >= s.length())//终止条件
    	{
    		num[0]++;
    		return;
    	}
    	
    	if(s.charAt(index) == '0')//只要碰到0，就剪枝
    	{
    		return;
    	}
    	
//    	if(index+2 <= s.length() && Integer.parseInt(s.substring(index,index+2)) <= 26 )//找到另一条路径.
//    	{
//    		dfs( s ,  index + 2 , num);
//    	}
    	
    	//找到另一条路径.
    	if(index+2 <= s.length() && (s.charAt(index) == '1' || ((s.charAt(index) == '2') && (s.charAt(index+1) <= '6'))))
    	{
    		dfs( s ,  index + 2 , num);
    	}
    	
    	dfs(s , index + 1, num);//继续原路径搜索
    }
//---------------------------------------------------------------------------------------------    
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DecodeWays_T91 t91 = new DecodeWays_T91();
		
		String s = "123425677";
		String s2 = "12";
		String s3 = "1706801";
		
		System.out.println(t91.numDecodings1(s));
	}

}
