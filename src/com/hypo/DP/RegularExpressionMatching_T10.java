package com.hypo.DP;

/**
 *	实现支持通配符('.')和闭包('*')的正则表达式.
 *  '.'匹配任意单个字符 , '*'和自身连接的字符可出现任意多次(包括0次)
 */
public class RegularExpressionMatching_T10
{
	//s为文本串  , p为模式串
    public boolean isMatch(String s, String p) 
    {
    	if(p.length() == 0) return s.length() == 0;
    	
    	return solve(s , 0 , p ,  0);
    }
    
    private boolean solve(String s , int indexs , String p , int indexp)
    {
    	//模式串下一个字符不是'*'
    	if(indexp < p.length()-1 && p.charAt(indexp+1) != '*')
    	{
    		if(indexs < s.length() && (s.charAt(indexs) == p.charAt(indexp)
    				|| p.charAt(indexp) == '.'))
			{
    			solve(s , indexs+1 , p , indexp+1);
			}
    		else
    		{
    			return false;
    		}
    	}
    	//模式串下一个字符是'*'
    	else
    	{
    		//情况1: 普通字符+'*'
    		if(p.charAt(indexp) != '.')
    		{
    			//匹配0次
    			if(s.charAt(indexs) != p.charAt(indexp))
    			{
    				solve(s, indexs+1, p, indexp+2);
    			}
    			//匹配任意多次
    			else
    			{
    				
    			}
    		}
    		//情况2: '.' + '*'
    		else
    		{
    			
    		}
    		
    			
    	}
    	return false;
    }
    
    public static void main(String[] args)
	{
    	
	}
}
