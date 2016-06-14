package com.hypo.HashTable;

import java.util.HashMap;

public class BullsAndCows_T299
{
    private String getHint(String secret, String guess) 
    {
    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
    	StringBuffer sb = new StringBuffer();
    	int bulls = 0;
    	int cows = 0;
    	
    	int len = secret.length();
    	
    	for(int j = 0  ; j < len ;j++)
    	{
    		char sec = secret.charAt(j);
    		char gue = guess.charAt(j);
    		
    		if(sec == gue) 
    		{
    			bulls++;
    			continue;
    		}
    		
    		if(hm.containsKey(sec))
    		{
    			hm.put(sec, hm.get(sec)+1);
    		}
    		else
    		{
    			hm.put(sec , 1);
    		}
    	}
    	
    	for(int i = 0 ; i < len ; i++)
    	{
    		char sec = secret.charAt(i);
    		char gue = guess.charAt(i);
    		if(sec == gue) 
    		{
    			continue;
    		}
    		if(hm.containsKey(gue) && hm.get(gue) > 0)
    		{
    			cows++;
    			hm.put(gue, hm.get(gue)-1);
    		}
    	}
    	
    	sb.append(bulls);
    	sb.append("A");
    	sb.append(cows);
    	sb.append("B");
        return sb.toString();
    }
	public static void main(String[] args)
	{
		BullsAndCows_T299 t299 = new BullsAndCows_T299();
		String secret = "1123";
		String guess =  "0111";
		
		System.out.println(t299.getHint(secret, guess));
	}
}
