package tencent;

import java.util.Scanner;

public class BigNumberMultiply
{
	private static String mulitply(String num1 , String num2)
	{
		int m = num1.length();
		int n = num2.length();
		
		int p[] = new int[m+n];
		
		StringBuffer result = new StringBuffer(m+n);
		
		
		for(int i = m - 1; i >= 0 ; i--)
		{
			for(int j = n - 1 ; j >= 0 ; j--)
			{
				int index1 = i + j;
				int index2 = i + j + 1;
				
				int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				
				sum += p[index2];
				
				p[index1] += sum / 10;
				p[index2] = sum % 10;
			}
		}
		
		for(int i : p)
		{
			//得到的数组p可能是从0开始的，这个0要去掉
			//注意StringBuffer的length()方法是返回StringBuffer中已有字符的个数.
			if(!(result.length() == 0 && i == 0))
			{
				result.append(i);
			}
		}
		
		return result.toString();
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan  = new Scanner(System.in);
		String num1 = scan.next();
		String num2 = scan.next();
		
		System.out.println(BigNumberMultiply.mulitply(num1, num2));
	}

}
