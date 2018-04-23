package com.bourbon.string;

/**
 * <p>Title: 最后一个单词的长度</p>
 * <p>Difficulty: 简单</p>
 * <p>Description: 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *				         如果不存在最后一个单词，请返回 0 。
 *				         说明：一个单词是指由字母组成，但不包含任何空格的字符串。</p>
 * @author lihaibo
 * 2018年4月23日 2018-04-23 21:57
 */
public class LengthOfLastWord_58 
{
    public int lengthOfLastWord(String s) 
    {
    	if(s == null || s.length() < 1)
    	{
    		return 0;
    	}
    	
    	int len = s.length();
    	int wordsize = 0;
    	boolean hasStart = false;
    	
    	for(int i = len - 1 ; i >= 0; --i)
    	{
    		if(!hasStart)
    		{
    			if(s.charAt(i) != ' ')
        		{
    				hasStart = true;
        			wordsize++;
        		}
    		}    		
    		else
    		{
    			if(s.charAt(i) != ' ')
        		{
    				wordsize++;
        		}
    			else
    			{
    				break;
    			}
    		}
    	}
    	
        return wordsize;
    }
}
