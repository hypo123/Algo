package com.hypo.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

//分治法.
public class DifferentWaysAddParentheses_T241
{
	public List<Integer> diffWaysToCompute(String input)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) == '+' || input.charAt(i) == '-'
					|| input.charAt(i) == '*')
			{
				//input.charAt(i)为加减乘字符，则将字符串分为两部分[0,i-1],[i+1,input.length()-1]
				String left = input.substring(0, i);
				String right = input.substring(i + 1);

				List<Integer> leftRes = diffWaysToCompute(left);
				List<Integer> rightRes = diffWaysToCompute(right);
				
				//System.out.println(leftRes.size() + " " + rightRes.size() + " "+ i + "|");

				for (int l : leftRes)
				{
					for (int r : rightRes)
					{
						int c = 0;
						switch (input.charAt(i))
						{
							case '+':
								c = l + r;
								break;
							case '-':
								c = l - r;
								break;
							case '*':
								c = l * r;
								break;
						}
						
						result.add(c);
					}
				}
			}
		}

		if(result.size() == 0)//只有一个数字字符
		{
			result.add(Integer.valueOf(input));
		}
		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DifferentWaysAddParentheses_T241 t241 = new DifferentWaysAddParentheses_T241();

		String input = "2*3-4*5";

		ArrayList<Integer> result = (ArrayList) t241.diffWaysToCompute(input);

		for (int n : result)
		{
			System.out.print(n + " ");
		}
	}

}
