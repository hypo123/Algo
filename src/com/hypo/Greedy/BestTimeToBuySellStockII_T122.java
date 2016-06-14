package com.hypo.Greedy;

public class BestTimeToBuySellStockII_T122
{
    private int maxProfit(int[] prices) 
    {
    	int sum = 0;
    	
    	for(int i = 1; i < prices.length; i++)	
    	{
    		int diff = prices[i] - prices[i-1];
    		if(diff > 0) sum += diff;
    	}
        return sum;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BestTimeToBuySellStockII_T122 t122 = new BestTimeToBuySellStockII_T122();
		
		int[] prices = {1, 2, 3, 0, 2};
		
		System.out.println(t122.maxProfit(prices));
	}

}
