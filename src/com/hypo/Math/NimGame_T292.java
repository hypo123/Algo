package com.hypo.Math;

/*
You are playing the following Nim Game with your friend: 
There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
The one who removes the last stone will be the winner.
You will take the first turn to remove the stones.
Both of you are very clever and have optimal strategies for the game. 
Write a function to determine whether you can win the game given the number of stones in the heap.
For example, if there are 4 stones in the heap, then you will never win the game:
no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/

public class NimGame_T292
{
	/*策略：剩余4个石头一方必败
	 * 设有A,B两方玩家
	 * 假设到A时还剩4K个石头，那么不管是A拿1个，2个，3个，B都可以做到
	 * 这一轮A和B拿的石头总数为4;那么下一轮到A时还有4*(k-1)个石头，
	 * 依次类推，到最后剩4个石头时，还是A开始拿，所以A必输.
	*/
    public boolean canWinNim(int n) 
    {
    	return (n % 4 == 0) ? false : true;
    }
	public static void main(String[] args)
	{
		NimGame_T292 t292 = new NimGame_T292();
		
		int n = 5;
		
		System.out.println(t292.canWinNim(4));
	}
}
