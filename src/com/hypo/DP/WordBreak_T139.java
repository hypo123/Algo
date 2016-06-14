package com.hypo.DP;

import java.util.HashSet;
import java.util.Set;

//DP
public class WordBreak_T139
{
	/**
	 * 设状态为f(i),表示s[0,i]之间是否可以分词
	 */ 
    public boolean wordBreak(String s, Set<String> wordDict)
    {
    	//长度为n的字符串有n+1个隔板
    	boolean[] f = new boolean[s.length()+1];
    	
    	f[0] = true;//空字符串.
    	
    	for(int i = 1 ; i <= s.length() ; ++i)
    	{
    		for(int j = i-1 ; j >= 0 ; --j)
    		{
    			if(f[j] && wordDict.contains(s.substring(j , i)))
    			{
    				f[i] = true;
    				break;
    			}
    		}
    	}
        return f[s.length()];
    }
	public static void main(String[] args)
	{
		Set<String> wordDict = new HashSet<String>();
		
		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("sss");
		
		String s = "leetcodess";
		
		WordBreak_T139 wb139 = new WordBreak_T139();
		
		System.out.println(wb139.wordBreak(s, wordDict));
	}
}
