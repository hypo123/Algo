package com.hypo.String;

import java.math.BigInteger;

/**
 * 大数相乘
 */
public class MultiplyStrings_T43
{
//	---------------------------方案一----------------------------
    public static String multiply(String num1, String num2) 
    {
    	BigInteger b1 = new BigInteger(num1);
    	BigInteger b2 = new BigInteger(num2);
    	return b1.multiply(b2).toString();
    }
//    -------------------------方案二--------------------------------
//    从最低位依次向最高位做乘法
    public static String multiply2(String num1, String num2) 
    {
    	int m = num1.length();
    	int n = num2.length();
    	StringBuffer sb = new StringBuffer(m+n);
    	
    	int[] p = new int[m+n];
    	
    	for(int i = m - 1 ; i >= 0 ; i--)
    	{
    		for(int j = n - 1; j >= 0 ; j--)
    		{
    			int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
    			
    			int p1 = i + j ; 
    			int p2 = i + j + 1;
    			
    			int sum = multi + p[p2];
    			
    			p[p1] += sum / 10;
    			p[p2] = sum % 10;
    		}
    	}
    	
    	for(int s : p)
    	{
    		if(!(sb.length() == 0 && s == 0))
    		{
    			sb.append(s);
    		}
    	}
    			
    	return (sb.length() == 0) ? "0" : sb.toString();
    }
//    -------------------------------------------------------
	public static void main(String[] args)
	{
		String num1 = "12345666";
//		int size = num1.length();
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.parseInt(num1));
		String num2 = "1133445555555566567";
		
		System.out.println(MultiplyStrings_T43.multiply(num1, num2));
		System.out.println(MultiplyStrings_T43.multiply2(num1, num2));
	}
}
