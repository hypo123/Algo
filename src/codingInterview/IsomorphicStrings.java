package codingInterview;

import java.util.HashMap;

public class IsomorphicStrings
{
    public boolean isIsomorphic(String s, String t) 
    {
    	boolean flag = true;
        if(null == s || null == t)
        {
        	return flag=false;
        }
        
        if(s.length() != t.length())
        {
        	return flag=false;
        }
        
        HashMap<Character,Character> hm = new HashMap<Character,Character>();
        
        for(int i = 0 ; i < s.length(); i++)
        {
        	char sc = s.charAt(i);
        	char tc = t.charAt(i);
        	if(hm.containsKey(sc))
        	{
        		if(hm.get(sc) != tc)
        		{
        			flag = false;
        			break;
        		}
        	}
        	else
        	{
        		if(!hm.containsValue(tc))
        		{
        			hm.put(sc,tc);
        		}
        		else
        		{
        			flag = false;
        			break;
        		}
        	}
        }
        
        return flag;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		IsomorphicStrings solution = new IsomorphicStrings();
		
		String s = " ";
		String t = " ";
		
		System.out.println(solution.isIsomorphic(s , t));
	}

}
