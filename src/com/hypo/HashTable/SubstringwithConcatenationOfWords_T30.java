package com.hypo.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationOfWords_T30
{
    private List<Integer> findSubstring(String s, String[] words) 
    {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	HashMap<String , Integer> hm = new HashMap<String , Integer>();
    	
    	int wordlen = words[0].length();
    	int wordCount = words.length;
    	boolean flag = false;
    	
    	
    	for(String t : words)
    	{
    		if(hm.containsKey(t))
    		{
    			hm.put(t, hm.get(t)+1);
    		}
    		else
    		{
    			hm.put(t, 1);
    		}
    	}
    	HashMap<String , Integer> back = new HashMap(hm);
    	
    	for(int i = 0 ; i < s.length();)
    	{
    		if(i + wordlen >= s.length()) break;
    		String mid = s.substring(i, i+wordlen);
    		
    		if(hm.containsKey(mid))
    		{
    			flag = true;
    			
    			if(hm.get(mid) > 0)
    			{
    				hm.put(mid, hm.get(mid)-1);
    				if(--wordCount == 0)
    				{
    					result.add(i + wordlen - wordlen * words.length);
    					wordCount = words.length;
    					hm.putAll(back);
    					i -= wordlen * (words.length - 1) - 1;
    					continue;
    				}
    				i += wordlen;
    			}
    			else
    			{
    				hm.putAll(back);
    				wordCount = words.length;
    				
    				hm.put(mid, hm.get(mid)-1);
    				if(--wordCount == 0)
    				{
    					result.add(i + wordlen - wordlen * words.length);
        				wordCount = words.length;
        				hm.putAll(back);

    				}
    				i += wordlen;
    			}
    		}
    		else
    		{
    			wordCount = words.length;
    			if(flag == true)
    			{
    				hm.putAll(back);
    				flag = false;
    			}
    			i++;
    		}
    	}
    	
    	return result;
    }
    public static void main(String[] args)
	{
    	SubstringwithConcatenationOfWords_T30 t30 = new SubstringwithConcatenationOfWords_T30();
		String s = "barfoofoobarthefoobarman";
		String[] words = {"foo" , "bar"};
		String[] words2 = {"foo" , "bar","the"};
		
		String s3 = "wordgoodgoodgoodbestword";
		String[] words3 = {"word","good","best","good"};
		ArrayList<Integer> result =  (ArrayList<Integer>)t30.findSubstring(s3, words3);
		
		for(int i : result)
		{
			System.out.print(i + " | ");
		}
	}
}
