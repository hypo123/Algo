package com.hypo.String;

import java.util.Stack;

public class BasicCalculator_T224
{
	private int calculate2(String s)
	{
		int len = s.length();
		
		if(s == null || len == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();

		int result = 0;
		int number = 0;
		int sign = 1;//1为正,-1为负
		
		for(int i = 0 ; i < len ; i++)
		{
			char c = s.charAt(i);
			
			if(Character.isDigit(c))
			{
				number = number * 10 + (int)(c - '0');
			}
			else if(c == '+')
			{
				result += sign * number;
				number = 0;
				sign = 1;//下个数符号为正
			}
			else if(c == '-')
			{
				result += sign * number;
				number = 0;
				sign = -1;//下个数符号为负
			}
			else if(c == '(')
			{
				stack.push(result);//左括号前所求的运算值
				stack.push(sign);//左括号前的符号
				result = 0;
				sign = 1;
			}
			else if(c == ')')
			{
				result += sign * number;
				number = 0;
				result *= stack.pop();//弹出左括号前符号与括号内的运算值相乘
				result += stack.pop();//弹出括号前所求的运算值
			}
		}
		
		if(number != 0)//以数符结束字符串要特殊处理
		{
			result += sign * number;
		}
		return result;
	}

//	test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BasicCalculator_T224 t224 = new BasicCalculator_T224();

		String s = "(1+(4+5+2)-3)+(6+8)";
		String s2 = "1 + 1";
		String s3 = "2-(5-6)";
		String s4 = "0-2147483647";
		String s5 = " 2-1 + 2 ";

		System.out.println(t224.calculate2(s));
		System.out.println(t224.calculate2(s2));
		System.out.println(t224.calculate2(s3));
		System.out.println(t224.calculate2(s4));
		System.out.println(t224.calculate2(s5));
	}

}
