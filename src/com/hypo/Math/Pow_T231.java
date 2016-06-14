package com.hypo.Math;

//判断一个数是否是2的t次方.
public class Pow_T231
{
    private boolean isPowerOfTwo(int n) 
    {
        return((n & (n - 1 )) == 0 && n > 0); //位操作.如果某个数是2的t次方，那么该数的二进制表示位上只有一位为1
    }
	public static void main(String[] args)
	{
		Pow_T231 p231 = new Pow_T231();
		
		System.out.println(p231.isPowerOfTwo(10));
	}
}
