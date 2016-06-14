package com.hypo.Math;

public class UglyNumber_T263
{
    public boolean isUgly(int num)
    {
    	if(num <= 0) return false;
    	
    	while(num % 2 == 0) num >>= 1;
    	while(num % 3 == 0) num /= 3;
    	while(num % 5 == 0) num /= 5;
    	
    	if(num == 1)
    		return true;
    	else return false;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		UglyNumber_T263 t263 = new UglyNumber_T263();
		
		System.out.println(t263.isUgly(14));
	}

}
