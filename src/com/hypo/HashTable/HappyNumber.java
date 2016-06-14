package com.hypo.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个数是否是快乐数(Happy Number).
 * 
 * 不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，
 * 最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
 */
public class HappyNumber
{
//	-----------------------方案一----------------------------------
    private boolean isHappy(int n) 
    {
    	Set<Integer> set = new HashSet<Integer>();
    	int sum = 0;
    	int left = -1;
    	
    	while(true)
    	{
    	   	while(n != 0)//求它的各个位上数的平方的和
        	{
        		left = n % 10;
        		sum += left * left;//还是先将left算出来比较好，防止两次求余
//    	   		sum += (n % 10) * (n % 10);
        		n /= 10;
        	}
    	   	if(sum == 1)//如果sum为1则是Happy Number
    	   	{
    	   		return true;
    	   	}
    	   	else if(set.contains(sum))//如果sum的值以往已经出现，说明给各个位求平方和出现了循环.
    	   	{
    	   		return false;
    	   	}
    	   	else
    	   	{
    	   		set.add(sum);
    	   	}
    	   	
    	   	n = sum;
    	   	sum = 0;
    	}
    }
    
//    -----------------------方案二----------------------------------------------
    private boolean isHappy2(int n) //不使用HashSet，使用类似链表判断是否有环的方法.快慢指针.
    {
    	int slow = n;
    	int fast = n;
    	
    	do
    	{
    		slow = digitSquareSum(slow);
    		fast = digitSquareSum(fast);
    		fast = digitSquareSum(fast);
    	}
    	while(slow != fast);
    	
    	if(slow == 1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    private int digitSquareSum(int n)//求它的各个位上数的平方的和
    {
    	int sum = 0;
	   	while(n != 0)//求它的各个位上数的平方的和
    	{
    		int left = n % 10;
    		sum += left * left;//还是先将left算出来比较好，防止两次求余
    		n /= 10;
    	}
	   	return sum;
    }
//  ----------------------------------------------------------------------------  
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		HappyNumber hn = new HappyNumber();
		
		int n = 19;
		
		System.out.println(hn.isHappy(n));
		System.out.println(hn.isHappy2(n));
		
	}

}
