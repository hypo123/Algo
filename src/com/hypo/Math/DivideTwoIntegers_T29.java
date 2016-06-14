package com.hypo.Math;

//不使用乘，除，mod实现整数的除法.
//这题做得真蛋疼.主要是要考虑除数和被除数为Integer.MIN_VALUE的情况
//因为Integer.MIN_VALUE = -(Integer.MAX_VALUE)-1;
//所以求Integer.MIN_VALUE的绝对值会溢出.
public class DivideTwoIntegers_T29
{
//	超时.--------------------------------------------------------------------
    public int divide(int dividend, int divisor)
    {
    	//有几种情况可能溢出:1.除数为0   2:dividend=INT_MIN (因为abs(INT_MIN)=INT_MAX+1)
    	if(divisor == 0 )return Integer.MAX_VALUE;//溢出
    	if(dividend == Integer.MIN_VALUE)//可能溢出，但有的通过处理避免.
    	{
    		if(divisor == -1) return Integer.MAX_VALUE;//溢出,返回MAX_VALUE
    		else if(divisor == 1) return dividend;//未溢出
    		else if(divisor == Integer.MIN_VALUE) return 1;//未溢出
    		else return ((divisor&0x1)==1) ? divide(dividend+1 , divisor) : divide(dividend >>1, divisor >>1);//未溢出.
    	}
    	else if(divisor == Integer.MIN_VALUE)//未溢出
    	{
    		return 0;
    	}
    	
        int sign = (((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))) ? 1 : -1;
        
        int res = 0;
        
        int up = Math.abs(dividend);
        int down = Math.abs(divisor);
        
        while(up >= down)
        {
        	int curr = down , multi = 1;
        	while(up >= (curr << 1))
        	{
        		curr <<= 1;
        		multi <<= 1;
        	}
        	
        	up -= curr;
        	res += multi;
        }
        return (sign == 1) ? res : -res;
    }
//----------------------------------------------------------------------------------------    
	public int divide2(int dividend, int divisor)
	{
		if (divisor == 0)return Integer.MAX_VALUE;
		else if (dividend == Integer.MIN_VALUE)
		{ 
			if (divisor == -1)	return Integer.MAX_VALUE;//溢出,返回MAX_VALUE
			else if (divisor == 1)	return dividend;//未溢出
			else if(divisor == Integer.MIN_VALUE) return 1;
			else return ((divisor & 1) == 1) ? divide(dividend + 1, divisor)
						: divide(dividend >> 1, divisor >> 1);
		} 
		else if (divisor == Integer.MIN_VALUE)	return 0;
		else if (dividend < 0 && divisor < 0)	return divide(-dividend, -divisor);
		else if (dividend < 0 || divisor < 0)	return -divide(-dividend, divisor);
		int res = 0;
		while (dividend >= divisor)
		{ // positive division method
			int tmp = divisor, tmpres = 1;
			while (dividend >= tmp << 1 && ((tmp << 1)) > divisor)
			{ // avoid tmp integer overflow
				tmp <<= 1;
				tmpres <<= 1;
			}
			res += tmpres;
			dividend -= tmp;
		}
		return res;
	}
//-------------------------------------------------------------------------------------    
    public static void main(String[] args)
	{
    	DivideTwoIntegers_T29 di29 = new DivideTwoIntegers_T29();
    	
    	int dividend = Integer.MIN_VALUE;//被除数
    	int divisor  = Integer.MIN_VALUE;//除数
    	
    	//test
    	int a = Integer.MIN_VALUE;
    	System.out.println("|a| = "+ Math.abs(a));//Math的abs函数并不能处理溢出的情况.
    	
    	System.out.println(di29.divide2(dividend, divisor));
	}
}
