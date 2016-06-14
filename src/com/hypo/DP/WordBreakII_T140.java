package com.hypo.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_T140
{
//	方案一 深搜超时--------------------------------------------------------------------------------
    private List<String> wordBreak(String s, Set<String> wordDict) 
    {
    	ArrayList<String> res = new ArrayList<String>();
    	
    	ArrayList<String> path = new ArrayList<String>();//一种分割方案.
    	
    	dfs(s , wordDict , 0 , res , path);
    	
    	if(res.size() > 0)
    	{
    		res.remove(res.size()-1);
    	}
        return res;
    }
    
    private void dfs(String s , Set<String> wordDict , int start , ArrayList<String> res,
    		ArrayList<String> path )
    {
    	if(start == s.length())
    	{
    		path.remove(path.size()-1);//去掉最后空格.
    		path.add(", ");
    		res.addAll(new ArrayList<String>(path));
    		
    		while(path.size() != 0)//将path清为空，以备下次使用.
    		{
    			path.remove(path.size()-1);
    		}
    		return;
    	}
    	
    	for(int i = start + 1 ; i <= s.length(); ++i)
    	{
    		String word = s.substring(start , i);
    		
    		if(!wordDict.contains(word))
    		{
    			continue;
    		}
    		
    		path.add(word);//添加word
    		path.add(" ");//word后面加空格
    		
    		dfs(s , wordDict , i , res , path);
    		
    		//path.remove(path.size()-1);//去掉空格
    		//path.remove(path.size()-1);//去掉最后加入的word
    	}
    }
// ---------------------------------------------------------------------------------------------  
  
//  方案二：动规-------------------------------------------------------------------------------------
    public List<String> wordBreak2(String s, Set<String> wordDict) 
    {
    	//长度为n的字符串有n+1个隔板.
    	boolean[] f = new boolean[s.length() + 1];//状态.
    	
    	f[0] = true;
    	//prev[i][j]为true,表示s[j,i)是一个合法单词，可以从j处切开.
    	boolean[][] prev = new boolean[s.length()+1][s.length()];
    	
    	for(int i = 1 ; i <= s.length() ; ++i)
    	{
    		for(int j = i - 1; j >= 0 ; --j)
    		{
    			if(f[j] && wordDict.contains(s.substring(j , i)))
    			{
    				f[i] = true;
    				prev[i][j] = true;
    			}
    		}
    	}
    	
    	ArrayList<String> res = new ArrayList<String>();
    	ArrayList<String> path = new ArrayList<String>();
    	
    	gen_path(s, s.length(), prev, path, res);
    	
    	return res;
    }
    
    //DFS遍历，生成路径.
    private void gen_path(String s , int cur , boolean[][] prev ,ArrayList<String> path , ArrayList<String> res)
    {
    	if(cur == 0)//终止条件.
    	{
    		StringBuffer tmp = new StringBuffer();
    		
    		for(int i = path.size()-1 ; i >= 0 ; --i)
    		{
    			tmp.append(path.get(i));
    			tmp.append(" ");
    		}
    		
    		tmp.deleteCharAt(tmp.length()-1);
    		res.add(tmp.toString());
    	}
    	
    	for(int i = 0 ; i < s.length() ; ++i)
    	{
    		if(prev[cur][i])
    		{
    			path.add(s.substring(  i , cur));
    			
    			gen_path(s, i, prev, path, res);    	
    			
    			path.remove(path.size() - 1);
    		}
    	}
    }
//------------------------------------------------------------------------------------------------
    public static void main(String[] args)
	{
    	WordBreakII_T140 wb140 = new WordBreakII_T140();
    	
    	String s = "catsanddog";
    	
    	Set<String> wordDict = new HashSet<String>();
    	
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	
    	
    	String s2 = "a";
    	
    	Set<String> wordDict2 = new HashSet<String>();  	    	
    	
    	
    	ArrayList<String> print = (ArrayList)wb140.wordBreak2(s, wordDict);
    	
    	for(String t : print)
    	{
    		System.out.print(t );
    	}
	}
}
