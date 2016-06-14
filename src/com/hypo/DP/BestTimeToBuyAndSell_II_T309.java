package com.hypo.DP;


//不好懂
/**Best Time to Buy and Sell Stock with Cooldown T309
*卖出之后要隔一天才能再次买入;对于某一天，有三种情况，buy , sell , rest(aka cooldown),其中rest表示这一天没有交易
*一个交易的序列有可能以三个状态中的任一个结束.
*有三个数组buy[n],sell[n],rest[n]
*
*状态buy[i]表示第i天之前，以buy状态结束的任意序列的最大利润
*状态sell[i]表示第i天之前，以sell状态结束的任意序列的最大利润
*状态rest[i]表示第i天之前，以rest状态结束的任意序列的最大利润
*
*过渡状态：
*buy[i] = max(rest[i-1] - prices[i] , buy[i-1])
*sell[i] = max(buy[i-1]+price[i] , sell[i-1])
*rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
*
*/
public class BestTimeToBuyAndSell_II_T309
{
//	-------------------DP-----------------------------------------------
    private int maxProfit(int[] prices) 
    {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) 
        {
            prev_buy = buy;
            
            buy = Math.max(prev_sell - price, prev_buy);
            
            prev_sell = sell;
            
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    	
    }
    
//    -----------------------------------------------------------------------------
	
/**
 * 
 *	prices：  1,  2,  3, 0, 2
 *	buy:   -1, -1, -1, 1, 1 
 *	sell    0,  1,  2, 2, 3
 */
  private int maxProfit2(int[] prices) 
  {
	  if(prices == null || prices.length < 2) return 0;
	  
	  int len = prices.length;
	  
//	  buy[i] 买进操作的最大利润。它需要考虑的是，第i天是否买进。（手上没有stock在第i天所能获得的最大利润）
	  int[] buy = new int[len];
	  
//	  sell[i] 卖出操作的最大利润。它需要考虑的是，第i天是否卖出。（手上有stock在第i天所能获得的最大利润）
	  int[] sell = new int[len];
	  
	  buy[0] = -prices[0];
	  buy[1] = Math.max(buy[0], -prices[1]);
	  sell[0] = 0;
	  sell[1] = Math.max(0, prices[1] - prices[0]);
	  
	  for(int i = 2; i < len; i++) 
	  {
          buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);//状态转移方程  
          
          sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);//状态转移方程
      }
	  
      return sell[len-1];
	  
  }
    
	public static void main(String[] args)
	{
		BestTimeToBuyAndSell_II_T309 t309 = new BestTimeToBuyAndSell_II_T309();
		
		int[] prices = {1, 2, 3, 0, 2};
		
		System.out.println(t309.maxProfit(prices));
		System.out.println(t309.maxProfit2(prices));
		
	}
}
