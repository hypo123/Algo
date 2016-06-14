package com.hypo.BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//删除最小数量的不合法圆括号，使字符串合法
public class RemoveInvalidParentheses_T301
{
    private List<String> removeInvalidParentheses(String s)
    {
//    	BFS
    	List<String> ans = new ArrayList<String>();//存取找到的合法字符串
    	Queue<String> queue = new LinkedList<String>();//存取删除'('或')'后得到的字符串
    	if(s == null) return ans;
    	
    	Set<String> visited = new HashSet<String>();//防止重复
    	
    	queue.add(s);
    	visited.add(s);
    	boolean found = false;
    	
    	while(!queue.isEmpty())
    	{
    		String out = queue.poll();
    		
    		if(isValid(out))
    		{
    			ans.add(out);
    			found = true;
    			continue;
    		}
    		
    		if(found == true) continue;
    		
    		for(int i = 0 ; i < out.length() ; i++)
    		{
    			if(out.charAt(i) != '(' && out.charAt(i) != ')') continue;
    			
    			String next = out.substring(0,i) + out.substring(i+1);
    			
    			if(!visited.contains(next))
    			{
    				queue.add(next);
    				visited.add(next);
    			}
    		}
    	}
        return ans;
    }
    
//    判断字符串中圆括号是否合法
    private boolean isValid(String t)
    {
    	int count = 0;
    	
    	for(int i = 0 ; i < t.length(); i++)
    	{
    		if(t.charAt(i) == '(')
    		{
    			count++;
    		}
    		
    		if(t.charAt(i) == ')')
    		{
    			count--;
    		}
    		
    		if(count < 0) return false;
    	}
    	
    	return count == 0;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RemoveInvalidParentheses_T301 t301 = new RemoveInvalidParentheses_T301();
		
		String s = "()())()";
		String s2 = "(a)())()";
		String s3 = ")(";
		
		List<String> print = t301.removeInvalidParentheses(s);
		
		for(String r : print)
		{
			System.out.println("["+r+"]");
		}
	}

}
