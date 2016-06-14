package com.hypo.Math;

//Implement pow(x, n)
public class Pow_T50
{
    //二分法，时间复杂度O(logn),空间复杂度O(1)
    private double myPow(double x, int n) 
    {
        if(x == 1.0) return 1.0;
        if(n < 0) return 1.0/power(x , -n);
        return power(x , n);
    }
    
    private double power(double x, int n)
    {
        if(n == 0) return 1;
        
        double mid = power(x , n >> 1);
        
        if(n % 2 == 0) 
        {
            return mid * mid;
        }
        else
        {
            return mid * mid * x;
        }
        
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Pow_T50 p50 = new Pow_T50();
		
		System.out.println(p50.myPow(1.5, 2));
	}

}
