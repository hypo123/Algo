package com.hypo.Math;

public class ExcelSheetColumnTitle_T168
{
//	---------------------方案一---------------------------
    private String convertToTitle(int n) 
    {
    	StringBuffer sb = new StringBuffer();
    	
    	int m = n;
    	
    	while(m >= 26)
    	{
    		int left = m % 26;
    		if(left == 0) //注意被26时，left不应该为0 ，而应该为26  1->A , 26->Z
			{	
    			left = 26;
				m -= 26;
			}
    		sb.append((char)(left + 64));
    		m = m / 26;
    	}
    	
    	if(m > 0)//m为0时，不用添加
    	{
    		sb.append((char)(m + 64));
    	}
    	
    	return sb.reverse().toString();
    }

//---------------------方案二---------------------------
    private String convertToTitle2(int n)
    {
    	StringBuilder result = new StringBuilder();
    	
    	while(n > 0)
    	{
    		--n;//1->A
    		
    		result.insert(0, (char)('A' + n % 26 ));
    		
    		n /= 26;
    	}
    	
    	return result.toString();
    }
    
//    test
	public static void main(String[] args)
	{
		ExcelSheetColumnTitle_T168 t168 = new ExcelSheetColumnTitle_T168();
		
		int n = 52;
		
		System.out.println(t168.convertToTitle2(n));
	}
}
