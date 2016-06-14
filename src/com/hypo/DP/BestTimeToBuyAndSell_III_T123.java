package com.hypo.DP;

//Best Time to Buy and Sell Stock III T123
//最多交易两次，求最大利润.
public class BestTimeToBuyAndSell_III_T123
{
    public int maxProfit(int[] prices) 
    {
    	int n = prices.length;
    	if(n < 2) return 0;
    	int[] f = new int[n];//状态f[i]表示[0,i]之间的最大利润
    	int[] g = new int[n];//状态g[i]表示[i,n-1]之间的最大利润
    	
    	for(int i = 1 , low = prices[0] ; i < n ; i++)
    	{
    		low = Math.min(low, prices[i]);
    		
    		f[i] = Math.max(f[i-1], prices[i] - low);
    	}
    	
    	for(int j = n-2 , high = prices[n-1] ; j >= 0 ; j--)
    	{
    		high = Math.max(high, prices[j]);
    		
    		g[j] = Math.max(g[j], high - prices[j]);
    	}
    	
    	int max_profit = 0;
    	
    	for(int k = 0 ; k < n ; k++)
    	{
    		//最终最大利润就是max{f[k]+g[k]} , 0 <= k <= n-1
    		max_profit = Math.max(max_profit , f[k] + g[k]);
    	}
    	
        return max_profit;
    }
	public static void main(String[] args)
	{
		BestTimeToBuyAndSell_III_T123 t123 = new BestTimeToBuyAndSell_III_T123();
		
		int[] prices = {1, 2, 3, 0, 2,10};
		
		System.out.println(t123.maxProfit(prices));
	}
}
