package codingInterview;

import java.util.HashMap;

public class ValidAnagram
{
    public boolean isAnagram(String s, String t) 
    {
    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
    	
    	if(t.length() == 0 && s.length() == 0) return true;
    	if(t.length() != s.length()) return false;
    	
    	for(int i = 0 ; i < s.length(); i++)
    	{
    		char tmp = s.charAt(i);
    		if(hm.containsKey(tmp))
    		{
    			hm.put(tmp , hm.get(tmp)+1);
    		}
    		else
    		{
    			hm.put(tmp , 1);
    		}
    	}
    	
    	for(int j = 0 ; j < t.length() ; j++)
    	{
    		char temp = t.charAt(j);
    		
    		int num = hm.get(temp);
    		
    		if(hm.containsKey(temp))
    		{
    			if(--num == 0)
    			{
    				hm.remove(temp);
    			}
    			else
    			{
    				hm.put(temp, num);
    			}
    		}
    		else
    		{
    			return false;
    		}
    	}
        return (hm.isEmpty()) ? true : false;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ValidAnagram va = new ValidAnagram();
		
		String s = "anagram";
		String t = "nagaram3";
		
		System.out.println(va.isAnagram(s, t));
	}

}
