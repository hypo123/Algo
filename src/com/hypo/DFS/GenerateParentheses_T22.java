package com.hypo.DFS;

import java.util.ArrayList;
import java.util.List;

//提供n对圆括号，给出所有合法的形式.
public class GenerateParentheses_T22
{
    public List<String> generateParenthesis(int n) 
    {
    	ArrayList<String> res = new ArrayList<String>();
    	StringBuffer path = new StringBuffer();
    	
    	generate(n , 0 , 0 , path , res);
    	
        return (List)res;
    }
    
//  解题思路：当左括号数小于n时，可以放置左括号；当右括号数小于左括号数时，可以放置右括号.
    private void generate(int n , int l , int r , StringBuffer path , ArrayList<String> res)
    {
    	if(l == n)//终止条件.
    	{
    		while(++r <= n)
    		{
    			path.append(")");
    		}
    		res.add(path.toString());
    	}
    	
    	String tmp = path.toString();
    	
    	//从当前path中分两个方向，一是加左括号，二是加右括号.
    	if(l < n)generate(n , l + 1 , r , new StringBuffer(tmp+"(") , res);//从tmp开始加左括号
    	if(l > r) generate(n, l, r + 1, new StringBuffer(tmp+")"), res);//从tmp开始加右括号.
    }
    
    
    public static void main(String[] args)
	{
    	GenerateParentheses_T22 gp22 = new GenerateParentheses_T22();
    	
    	int n = 3;
    	
    	ArrayList<String> print = (ArrayList)gp22.generateParenthesis(n);
    	
    	for(String str : print)
    	{
    		System.out.println(str);
    	}
	}
}
