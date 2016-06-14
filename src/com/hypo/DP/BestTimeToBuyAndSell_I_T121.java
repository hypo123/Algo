package com.hypo.DP;

//给定一个股票价格序列，最多只能交易一次，求最大利润.
/**
 * DP
 * 从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，
 * 并计算以当天价格出售的收益，作为可能的最大收益，
 * 整个遍历过程中，出现过的最大收益就是所求。
 *
 */
public class BestTimeToBuyAndSell_I_T121
{
    private int maxProfit(int[] prices) 
    {
    	if(prices.length < 2) return 0;
    	int profit = 0;
    	int low = prices[0];
    	
    	for(int price : prices)
    	{
    		low = Math.min(low, price);
    		profit = Math.max(profit, price - low);
    	}
        return profit;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BestTimeToBuyAndSell_I_T121 t121 = new BestTimeToBuyAndSell_I_T121();
		
		int[] prices = {1, 2, 3, 0, 2,10};
		
		System.out.println(t121.maxProfit(prices));
	}

}
