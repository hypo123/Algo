package com.hypo.Math;

public class ExcelSheetColumnNumber
{
    private int titleToNumber(String s) 
    {
    	//'A' = 65 'Z'= 90 
    	int len = s.length();
    	if(s == null || s.length() == 0) return 0;
    	int multibase = 1;
    	int sum = 0;
    	
    	for(int i = len-1 ; i >= 0 ; --i)
    	{
    		sum += (s.charAt(i) - 64)*multibase;
    		multibase *= 26;
    	}
    	
        return sum;
    }
    
//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
		
		String s = "AB";
		
		System.out.println(escn.titleToNumber(s));
	}
}
