package codingInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumWindowSubstring
{
    public String minWindow(String s, String t)
    {
    	int lens = s.length();
    	int lent = t.length();
    	if(lens < lent) return "";
    	int category = 0;
    	HashMap<Character,List<Integer>> hm = new HashMap<Character,List<Integer>>();
    	
    	//List<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>();
    	int p = -1;
    	for(int i = 0 ; i < lent ; i++)	
    	{
    		char mid;
    		if(!hm.containsKey(mid = t.charAt(i)))
    		{
    			hm.put(mid, new ArrayList<Integer>());
    			category++;
    		}
    	}
    	
    	
    	
    	for(int j = 0; j < lens ; j++)
    	{
    		char midd;
    		if(hm.containsKey(midd = s.charAt(j)))
    		{
    			hm.get(midd).add(j);
    			System.out.print(midd+": ");
    			for(int k = 0; k < hm.get(midd).size();k++)
    			{
    				System.out.print(hm.get(midd).get(k)+" ");
    			}
    		}
    		System.out.println();
    	}
    	
    	for(int q = 0 ; q < hm.size();q++)//test
    	{
    	}
    	
    			
        return "";
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		
		String S = "ADOBECODEBANC";
		String S2 = "ADOBECODEBANCNNNNNNNNNNCNNNNNNNNB";
		String T = "ABC";
		
		System.out.println(mws.minWindow(S2, T));
	}

}
