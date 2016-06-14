package com.hypo.String;

public class IntegerToEnglishWords_T273
{
	public String numberToWords(int num) 
	{
		String[] numbers = new String[]{"Zero", "One", "Two", "Three", "Four",
				"Five", "Six", "Seven", "Eight", "Nine"};
		String[] tennumbers = new String[] {"Ten", "Eleven", "Twelve","Thirteen",
				"Fourteen","Fifteen", "Sixteen","Seventeen","Eighteen","Nineteen"};
	    String[] secondnumbers = new String[]{"", "", "Twenty", "Thirty", "Forty", 
	    		"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    String[] unit = new String[]{" Thousand", " Million", " Billion"};
	    
	    
	    StringBuffer sb = new StringBuffer();
	    
	    if(num == 0)  return sb.append(numbers[0]).toString();
	    
	    int bnum = num / 1000000000; //billion
	    int mnum = (num / 1000000) % 1000;//million
	    int tnum = (num / 1000) % 1000;//thousand
	    int hnum = num % 1000;//hundred
	    if(bnum != 0)
	    {
	    	String bStr = int2String(bnum, numbers, tennumbers, secondnumbers);
	    	sb.append(bStr);
	    	sb.append(unit[2]);
	    }
	    
	    if(mnum != 0)
	    {
	    	String mStr = int2String(mnum, numbers, tennumbers, secondnumbers);
	    	sb.append(mStr);
	    	sb.append(unit[1]);
	    }
	    
	    if(tnum != 0)
	    {
	    	String tStr = int2String(tnum, numbers, tennumbers, secondnumbers);
	    	sb.append(tStr);
	    	sb.append(unit[0]);
	    }
	    
	    if(hnum != 0)
	    {
	    	String hStr = int2String(hnum, numbers, tennumbers, secondnumbers);
	    	sb.append(hStr);
	    }
		return sb.deleteCharAt(0).toString();
	}
	
	//1000以下整数转换为字符串
	public String int2String(int num , String[] numbers , String[] tennumbers , String[] secondnumbers )
	{
		StringBuffer ans = new StringBuffer();
		
		int tenleft = num % 100;
		num /= 100;
		
		if(num != 0)
		{
			ans.append(" " + numbers[num]);
			ans.append(" Hundred");
		}
		
		if(tenleft >= 20)
		{
			int d2 = tenleft / 10;
			int left1 = tenleft % 10;
			
			ans.append(" "+ secondnumbers[d2]);
			
			if(left1 != 0)
			{
				ans.append(" "+ numbers[left1]);
			}
		}
		else if(tenleft >= 10)
		{
			int left1 = tenleft % 10;
			
			ans.append(" " + tennumbers[left1]);
		}
		else if(tenleft > 0)
		{
			ans.append(" "+ numbers[tenleft]);
		}
		else
		{
			;
		}
		
		return ans.toString();
	}
	
	public static void main(String[] args)
	{
		IntegerToEnglishWords_T273 t273 = new IntegerToEnglishWords_T273();
		
		int num = 1234567;
		int num2 = 1000010;
		int num3 = 123;
		int num4 = 12345;
		
		System.out.println("["+t273.numberToWords(20)+"]");
		
	}
}
