package com.hypo.DFS;

import java.util.ArrayList;
import java.util.List;

public class T93_RestoreIPAddresses
{
	private List<String> result = new ArrayList<String>();
	private List<String>  path = new ArrayList<String>();
	
    private List<String> restoreIpAddresses(String s) 
    {
    	dfs(s , 0 , 0);
        return result;
    }
    
    private void dfs(String s , int step , int start)
    {
    	if(step == 4 && start == s.length())////终止条件,产生一种正确ip
    	{
    		StringBuffer ip = new StringBuffer();
    		
    		for(String str : path)
    		{
    			ip.append(str + ".");
    		}
    		
    		result.add(ip.substring(0, ip.length() - 1));
    		
    		return;
    	}
    	
    	if((s.length() - start) > (4 - step) * 3 || (s.length() - start) < (4 - step))//剪枝
    	{
    		return;
    	}
    	
    	
    	for(int i = 1 ; i <= 3 && i + start <= s.length() ; i++)
    	{
    		String sub = s.substring(start, start + i);
    		
    		if(sub.length() > 1 && sub.charAt(0) == '0')
    		{
    			continue;
    		}
    		
    		if(Integer.parseInt(sub) <= 255)
    		{
    			path.add(sub);
    			
    			dfs(s , step + 1 , start + i);
    			
    			path.remove(path.size() - 1);
    		}
    	}
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		T93_RestoreIPAddresses t2_93 = new T93_RestoreIPAddresses();
//		String s = "010010";
		String s2 = "25525511135";
		
		ArrayList<String> result2 = (ArrayList)t2_93.restoreIpAddresses(s2);
//		ArrayList<String> result = (ArrayList)t2_93.restoreIpAddresses(s);
		
		for(String n : result2)
		{
			System.out.println(n + " ");
		}

	}

}
