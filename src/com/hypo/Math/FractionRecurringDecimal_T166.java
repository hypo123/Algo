package com.hypo.Math;

public class FractionRecurringDecimal_T166
{
    private String fractionToDecimal(int numerator, int denominator) 
    {
    	if(numerator == 0)
    	{
    		return "0";
    	}
    	
    	StringBuilder result = new StringBuilder();
    	
    	String sign = (numerator > 0 && denominator > 0 ) ? "" : "-";
    	
    	result.append(sign);
    	
    	long up = Math.abs(numerator);
    	long down = Math.abs(denominator);
    	
    	//整数部分
    	result.append(up / down);
    	
    	up %= down;
    	
    	if(up == 0)
    	{
    		return result.toString();
    	}
    	
    	//分数部分
    	result.append(".");
    	
    	
    	
    	
    	return null;
    }
}
