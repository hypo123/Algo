package com.hypo.HashTable;

/**
 * 使用回溯法解数独问题. 
 *
 */
public class SudokuSolver
{
	private void solveSudoku(char[][] board)
	{
		if(board == null || board.length == 1) return ;
		solve(board);
	}
    private boolean solve(char[][] board) 
    {
    	
    	for(int i = 0 ; i < 9 ; ++i)
    	{
    		for(int j = 0; j < 9 ; ++j)
    		{
    			if(board[i][j] == '.')
    			{
    				for(char c = '1' ; c <= '9' ; ++c)
    				{
    					if(isValid(board , i , j , c) )
    					{
    						board[i][j] = c;
    						
    						if(solve(board))
    						{
    							return true;
    						}
    						else //回溯
    						{
    							board[i][j] = '.';
    						}
    					}
    				}
    				//9个数都试完了，都不行，说明前面填的是错误的.回溯
    				return false;//当前方案失败.
    			}
    		}
    	}
    	return true;
    }
    
    private boolean isValid(char[][] board ,int x ,int y, char c)
    {
    	//检查列
    	for(int row = 0; row < 9 ; ++row)
    	{
//    		if(row != x && board[row][y] == c)
    		if( board[row][y] == c)
    		{
    			return false;
    		}
    	}
    	//检查行
    	for(int col = 0; col < 9 ; ++col )
    	{
//    		if(col != y && board[x][col] == c)
    		if(board[x][col] == c)
    		{
    			return false;
    		}
    	}
    	
    	//检查3*3小格子.
    	for(int i =3 * ( x / 3)  ; i < 3 * (x/3 + 1) ; ++i)
    	{
    		for(int j = 3 * ( y / 3)  ; j < 3 * (y/3 + 1) ; ++j)
    		{
//    			if(i != x && j != y &&board[i][j] == c)
    			if(board[i][j] == c)
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SudokuSolver sudokusolver = new SudokuSolver();
		
		char[][] board = 
		{
		 {'5' ,'3' ,'.' ,'.' ,'7' ,'.' ,'.' ,'.' ,'.'},
		 {'6' ,'.' ,'.' ,'1' ,'9' ,'5' ,'.' ,'.' ,'.'},
		 {'.' ,'9' ,'8' ,'.' ,'.' ,'.' ,'.' ,'6' ,'.'},
		 
		 {'8' ,'.' ,'.' ,'.' ,'6' ,'.' ,'.' ,'.' ,'3'},
		 {'4' ,'.' ,'.' ,'8' ,'.' ,'3' ,'.' ,'.' ,'1'},
		 {'7' ,'.' ,'.' ,'.' ,'2' ,'.' ,'.' ,'.' ,'6'},
		 
		 {'.' ,'6' ,'.' ,'.' ,'.' ,'.' ,'2' ,'8' ,'.'},
		 {'.' ,'.' ,'.' ,'4' ,'1' ,'9' ,'.' ,'.' ,'5'},
		 {'.' ,'.' ,'.' ,'.' ,'8' ,'.' ,'.' ,'7' ,'9'},
			
		};
		
		sudokusolver.solveSudoku(board);
		
		for(char[] row:board)
		{
			for(char c:row)
			{
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

}
