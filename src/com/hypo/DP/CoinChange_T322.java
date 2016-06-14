package com.hypo.DP;

import java.util.Arrays;

//动态规划
public class CoinChange_T322
{
    public int coinChange(int[] coins, int amount) 
    {
    	int[] dp = new int[amount+1];
    	
    	Arrays.fill(dp, amount+1);
    	
    	dp[0] = 0;
    	
    	for(int i = 1 ; i < amount + 1 ; i++)
    	{
    		for(int c : coins)
    		{
    			if(i - c < 0) continue;
    			
    			dp[i] = Math.min(dp[i-c] + 1, dp[i]);
    		}
    	}
    	return (dp[amount] != amount + 1 ) ? dp[amount] : -1;   
    }
	public static void main(String[] args)
	{
		CoinChange_T322 t322 = new CoinChange_T322();
		
		int[] coins = {186,419,83,408};
		
		int amount = 6249;
		
		System.out.println(t322.coinChange(coins, amount));
	}
}
