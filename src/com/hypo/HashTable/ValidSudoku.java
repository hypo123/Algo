package com.hypo.HashTable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku
{
    private boolean isValidSudoku(char[][] board) 
    {
    	Set<Character> set = new HashSet<Character>();
    	
    	for(int i = 0 ; i < 9 ; ++i)
    	{
    		set.clear();
    		for(int j = 0 ; j < 9 ; ++j)//检查行
    		{
    			if(board[i][j] == '.')
				{
					continue;
				}
    			else if(set.contains(board[i][j]))
    			{
    				return false;
    			}
    			else
    			{
    				set.add(board[i][j]);
    			}
    		}
    		set.clear();
    		for(int k = 0; k < 9 ; ++k)//检查列
    		{
    			if(board[k][i] == '.')
				{
					continue;
				}
    			else if(set.contains(board[k][i]))
    			{
    				return false;
    			}
    			else
    			{
    				set.add(board[k][i]);
    			}
    		}
    	}
    	
    	//检查9个小格子
		for(int r = 0 ; r < 3 ; ++r)//3大行
		{
			for(int c = 0 ; c < 3 ; ++c)//3大列
			{
				set.clear();
				for(int x = 3 * r; x < 3 * r+3 ; ++x)//小格
				{
					for(int y = 3 * c ; y < 3 * c +3 ; ++y )
					{
						if(board[x][y] == '.')
						{
							continue;
						}
						else if(set.contains(board[x][y]))
						{
							return false;
						}
						else
						{
							set.add(board[x][y]);
						}
						
					}
				}
			}
		}
        return true;
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ValidSudoku vs = new ValidSudoku();
		
		char[][] board = new char[9][9];
		
		System.out.println(vs.isValidSudoku(board));
	}

}
