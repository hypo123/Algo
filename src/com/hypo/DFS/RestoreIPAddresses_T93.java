package com.hypo.DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_T93
{
    public List<String> restoreIpAddresses(String s) 
    {
        ArrayList<String> res = new ArrayList<String>();//最后结果
        
        ArrayList<String> path = new ArrayList<String>();//一种IP
        
        dfs(s , 0 , 0 , path , res);
        
        return res;
    }
    
    private void dfs(String s ,int start , int step , ArrayList<String> path , ArrayList<String> res)
    {
    	if(step == 4 && start == s.length())//终止条件,产生一种正确ip
    	{
    		StringBuffer sb = new StringBuffer();
    		
    		for(String str : path)
    		{
    			sb.append(str + ".");
    		}
    		
    		sb.deleteCharAt(sb.length() - 1);
    		
    		res.add(sb.toString());
    		
    		return;
    	}
    	
    	if((s.length() - start) > (4 - step) * 3)//剪枝,剩余太多
    	{
    		return;
    	}
    	
    	if((s.length() - start) < (4 - step))//剪枝,剩余太少
    	{
    		return;
    	}
    	
    	for(int i = 1 ; i <= 3 && (start + i) <= s.length() ; ++i)
    	{
    		String mid = s.substring(start , start + i);
    		
    		if(mid.length() > 1 && mid.charAt(0) == '0')//不允许前缀为0，单允许单独的0
    		{
    			continue;
    		}
    		
    		if(Integer.parseInt(mid) <= 255)//当前结点合法，则继续往下递归.
    		{
    			path.add(mid);
    			
    			dfs(s, start + i, step + 1, path, res);
    			
    			path.remove(path.size() - 1);//一步一步清空path，以备下次使用.
    		}
    	}
    }
    
//  test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RestoreIPAddresses_T93 ripa93 = new RestoreIPAddresses_T93();
		String s = "010010";
		String s2 = "25525511135";
		
		ArrayList<String> result2 = (ArrayList)ripa93.restoreIpAddresses(s2);
		ArrayList<String> result = (ArrayList)ripa93.restoreIpAddresses(s);
		
		for(String n : result2)
		{
			System.out.println(n + " ");
			
		}
	}
}
