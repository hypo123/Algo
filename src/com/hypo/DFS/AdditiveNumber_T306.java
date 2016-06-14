package com.hypo.DFS;

public class AdditiveNumber_T306
{
    private boolean isAdditiveNumber(String num) 
    {
    	if(num == null || num.length() < 3)
    	{
    		return false;
    	}
    	
    	for(int i = 1 ; i <= (num.length() >> 1) ; i++)
    	{
    		for(int j = i+1 ; j < num.length() ; j++)
    		{
    			String first = num.substring(0, i);
    			String second = num.substring(i, j);
    			
    			
    			boolean state = dfs(num.substring(j) ,first , second);
    			
    			if(state == true)	 return true;
    		}
    	}
    	return false;
    }
    
    private boolean dfs(String num , String first , String second)
    {
    	//if(num == null) return true;
    	
    	//剪枝
    	if((first.charAt(0) == '0' && first.length() > 1) || (second.charAt(0) == '0' && second.length() > 1))
    	{
    		return false;
    	}
    	
    	//剪枝
    	if(num.length() < first.length() || num.length() <  second.length()) return false;
    	
    	String sumString = addStr(first, second);
    	
    	if(sumString.length() > num.length()) return false;
    	
    	if(num.substring(0, sumString.length()).equals(sumString) == false)
    	{
    		return false;
    	}
    	else
    	{
    		if(sumString.length() == num.length()) return true;
    		
    		return dfs(num.substring(sumString.length()) , second , sumString);
    	}
    	
    }
    
    /**
     * @Title: 字符串做加法 
     * @param first
     * @param second
     * @return 返回字符串
     * 
     * 表示位字符串的两个整数相加，并返回一个字符串.可以处理整数相加溢出问题
     */
    private String addStr(String first , String second)
    {
    	
    	if(first.length() > second.length())//交换后first长度不长于second
    	{
    		String temp = first;
    		first = second;
    		second = temp;
    	}
    	
    	int i = first.length() - 1;
    	int j = second.length() - 1;
    	StringBuffer sb = new StringBuffer(second);//结果串
    	
    	int digit = 0;
    	while(j >= 0)
    	{
    		if(i < 0)
    		{
    			digit = sb.charAt(j) - '0' + digit;
    		}
    		else
    		{
    			digit = first.charAt(i)-'0'+sb.charAt(j)-'0'+digit;
    		}
    		
    		if(digit >= 10)
    		{
    			sb.setCharAt(j, String.valueOf(digit-10).charAt(0));
    			digit = 1;
    		}
    		else
    		{
    			sb.setCharAt(j, String.valueOf(digit).charAt(0));
    			digit = 0;
    		}
    		i--;
    		j--;
    	}
    	
    	if(digit == 1)
    	{
    		sb.insert(0, '1');
    	}
    	return sb.toString();
    }
	public static void main(String[] args)
	{
		AdditiveNumber_T306 t306 = new AdditiveNumber_T306();
		
		String num = "199100199"; //true
		String num2 = "1203";     //false
		String num3 = "112358";   //true
		String num4 = "123";      //true
		String num5 = "120122436";//false
		
		
//		System.out.println(t306.addStr(num, num2));
		
		System.out.println(t306.isAdditiveNumber(num4));
	}
}
