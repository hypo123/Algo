package com.hypo.String;

import java.util.Stack;

public class BasicCalculatorII_T227
{
    private int calculate(String s) 
    {
    	int len = s.length();
    	if(s == null || len == 0) return 0;
    	
//    	用一个栈来求
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	int num = 0;
    	char sign = '+';//运算符,初始化为+
    	
    	for(int i = 0 ; i < len ; i++ )
    	{
    		if(Character.isDigit(s.charAt(i)))
    		{
    			num = num * 10 + (s.charAt(i) - '0');
    			if(i != len - 1) //如果最后是减号 和一个数结束，要特殊处理
    				continue;
    		}
    		
    		if(s.charAt(i) != ' ' || i == len - 1)
    		{
    			if(sign == '+')
    			{
    				stack.push(num);
    			}
    			
    			if(sign == '-')
    			{
    				stack.push(-num);
    			}
    			
    			if(sign == '*')
    			{
    				stack.push(stack.pop() * num );
    			}
    			
    			if(sign == '/')
    			{
    				stack.push(stack.pop() / num );
    			}
    			
    			sign = s.charAt(i);//下次运算的运算符
    			num = 0;
    		}
    		
    	}
    	
    	int result = num;//最后一个字符为数字时，则最后的数并没有入栈
    	
    	for(int i : stack)
    	{
    		result += i;
    	}
    	return result;
    }
//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BasicCalculatorII_T227 t227 = new BasicCalculatorII_T227();
		
		String s = "3+2*2";
		String s2 = "3+5 / 2 ";
		String s3 = " 3/2 ";
		String s4 = "0-2147483647";
		
		System.out.println(t227.calculate(s4));
	}

}
