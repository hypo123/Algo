package codingInterview;

import java.util.HashMap;

public class MinimumWindowSubstringB
{

    public String minWindow(String s, String t) 
    {
    	HashMap<Character,Integer> hmt = new HashMap<Character,Integer>();
    	HashMap<Character,Integer> hms = new HashMap<Character,Integer>();
    	for(int i = 0 ; i < t.length(); i++)
    	{
    		char midt = t.charAt(i);
    		if(hmt.containsKey(midt))
    		{
    			hmt.put(midt, hmt.get(midt)+1);
    		}
    		else
    		{
    			hmt.put(midt,1);
    		}
    	}
    	
    	//int end = s.length()-1;
    	int minLen = Integer.MAX_VALUE;
    	int minStart = 0;
    	int start = 0;
    	int appear = 0;
    	for(int end = 0 ; end < s.length(); end++)
    	{
    		char mids = s.charAt(end);
    		if(hmt.containsKey(mids))
    		{
    			if(hms.containsKey(mids))
    			{
    				hms.put(mids, hms.get(mids)+1);
    			}
    			else
    			{
    				hms.put(mids,1);
    			}
    			
    			if(hms.get(mids) <= hmt.get(mids))
    			{
    				appear++;
    			}
    			System.out.print("i="+end+"  appear="+appear+" ");//
    			System.out.println();
    		}
    		
    		if(appear == t.length())
    		{
    			boolean flag = false;
    			while((flag = !hmt.containsKey(s.charAt(start))) || hms.get(s.charAt(start)) > hmt.get(s.charAt(start)) )
    			{
    				if(flag)
    				{
    					start++;
    				}
    				else
    				{
        				hms.put(s.charAt(start),hms.get(s.charAt(start))-1);
        				start++;
    				}
    				flag = false;
    				System.out.println("start="+start);
    			}
    			
    			if(minLen > (end - start + 1))
    			{
    				minLen = end - start + 1;
    				minStart = start;
    			}
    			
    		}
    	}
    	
    	if(minLen == Integer.MAX_VALUE)
    	{
    		return "";
    	}
    	else
    	{
    		return s.substring(minStart, minStart+minLen);
    	}
    	
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MinimumWindowSubstringB mwsb = new MinimumWindowSubstringB();
		
		String S = "ADOBECODEBANC";
		String T = "ABC";
		
		System.out.println(mwsb.minWindow(S, T));
	}

}
