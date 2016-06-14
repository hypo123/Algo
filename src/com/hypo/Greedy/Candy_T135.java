package com.hypo.Greedy;

import java.util.Arrays;

public class Candy_T135
{
//	-----------------------------------------------------------------
//	思路挺巧妙，从左往右扫描 一次，从右往左扫描一次即可
    public int candy(int[] ratings) 
    {
    	int len = ratings.length;
    	int sum = 0;
    	int[] f = new int[len];
    	Arrays.fill(f, 1);//每人至少一颗
    	
    	for(int i = 1 ; i < len ; i++)//从左往右扫描
    	{
    		if(ratings[i] > ratings[i-1])//一个条件
    		{
    			f[i] = f[i-1]+1;
    		}
    	}
    	
    	for(int j = len - 1 ; j >= 1 ; j--)//从右往左扫描
    	{
    		sum += f[j];
    		if(ratings[j-1] > ratings[j] && f[j-1] <= f[j])//两个条件
    		{
    			f[j-1] = f[j] + 1;
    		}
    	}
        return sum+f[0];
    }
//    -----------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Candy_T135 t135 = new Candy_T135();
		
		int[] ratings = {1,2,6,5,4};
		System.out.println(t135.candy(ratings));
		
	}

}
