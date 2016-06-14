package jd;

import java.util.Scanner;

/**
 *	这个写得有问题.
 */
public class Main2
{
	private static String solve(char[][] board ,int xnum , int onum ,int dotnum)
	{
		if(xnum > onum + 1 || xnum < onum - 1)
		{
			return "x";
		}
		
		int status = judgeWin(board);
		
		if(status < 0)
		{
			if(xnum + onum == 9)
			{
				return "draw";
			}
			
			if(xnum == onum + 1)
			{
				return "2";
			}
			
			if(xnum == onum )
			{
				return "1";
			}
		}
		
		if(status == 1)
		{
			if(xnum == onum + 1)
			{
				return "1 won";
			}
		}
		
		if(status == 2)
		{
			if(xnum == onum)
			{
				return "2 won";
			}
		}
		
		return "x";
	}
	
	private static int judgeWin(char[][] board )
	{
		for(int i = 0 ; i < 3 ; i++)//row
		{
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2])
			{
				if(board[i][0]  == '.')
				{
					continue;
				}
				
				if(board[i][0]  == 'X')
				{
					return 1;
				}
				else
				{
					return 2;
				}
			}
		}
		
		for(int i = 0 ; i < 3 ; i++)//col
		{
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i])
			{
				if(board[0][i] == '.')
				{
					continue;
				}
				
				if(board[0][i]  == 'X')
				{
					return 1;
				}
				else
				{
					return 2;
				}
			}
		}

		if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
		{
			if(board[0][0] == 'X')
			{
				return 1;
			}
			else if(board[0][0] == '0')
			{
				return 2;
			}
		}
		

		if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
		{
			if(board[0][2] == 'X')
			{
				return 1;
			}
			else if(board[0][2] == '0')
			{
				return 2;
			}
		}
		return -1;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		
		char[][] board = new char[3][3];
		
		int xnum = 0 , onum = 0 , dotnum = 0;
		
		for(int i = 0 ; i < 3 ; i++)
		{
			String temp = cin.next();
			
			for(int j = 0 ; j < 3 ; j++)
			{
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'X')
				{
					xnum++;
				}
				else if(board[i][j]  == '0')
				{
					onum++;
				}
				else
				{
					dotnum++;
				}
			}
		}
		System.out.println(Main2.solve(board, xnum , onum , dotnum));
	}
}
