package com.hypo.BFS;

import java.util.LinkedList;
/**
 * Created by Administrator on 2015/9/9.
 */

/**
 * LeetCode130 Surrounded Regions
 * 广度优先搜索，从上下左右四个边界往里走，遇到的'O',都是应该保留的，先更改为'+',
 * 最后遍历时，将'+'改为'O',将其余的'O'改为'X'.
 */
public class SurroundedRegions
{
    private void solve(char[][] board)
    {
        if(board == null || board.length == 0) return;


        int m = board.length; //行
        int n = board[0].length;//列

        boolean[][] visited = new boolean[m][n];//标记是否被访问过.

        for(int i = 0 ; i < n; ++i)
        {
            bfs(board , 0 , i , visited);//左边界
            bfs(board , m-1 , i , visited);//右边界
        }

        for(int j = 0 ; j < m ; ++j)
        {
            bfs(board , j , 0 , visited);//上边界
            bfs(board, j , n-1 , visited);//下边界
        }

        for(int i = 0 ; i < m ; ++i)
        {
            for(int j = 0 ; j < n ; ++j)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '+')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board , int i , int j , boolean[][] visited)
    {
        LinkedList<Integer> queue = new LinkedList<Integer>();

//        int[] index = new int[2];//记录坐标.

        int row = board.length;
        int col = board[0].length;

        if(!visited[i][j] && board[i][j] == 'O')//没有访问过
        {
            board[i][j] = '+';
            queue.add(i);//先进横坐标
            queue.add(j);//再进纵坐标
            visited[i][j] = true;
        }
        else
        {
            return;
        }


        while(!queue.isEmpty())
        {
            int x = queue.poll();//先出横坐标
            int y = queue.poll();//再出纵坐标

            if(x-1 >= 0 && !visited[x-1][y])//上
            {
                visited[x-1][y] = true;//设为已访问

                if(board[x-1][y] == 'O')
                {
                    board[x-1][y] = '+';
                    queue.add(x-1);//横坐标入队
                    queue.add(y);//纵坐标入队.
                }
            }

            if(x+1 < row && !visited[x+1][y])//下
            {
                visited[x+1][y] = true;

                if(board[x+1][y] == 'O')//下
                {
                    board[x+1][y] = '+';
                    queue.add(x+1);
                    queue.add(y);
                }
            }


            if(y-1 >= 0 && !visited[x][y-1])//左
            {
                visited[x][y-1] = true;
                if(board[x][y-1] == 'O')
                {
                    board[x][y-1] = '+';
                    queue.add(x);
                    queue.add(y-1);
                }

            }

            if(y+1 < col && !visited[x][y+1])//右
            {
                visited[x][y+1] = true;
                if(board[x][y+1] == 'O')
                {
                    board[x][y+1] = '+';
                    queue.add(x);
                    queue.add(y+1);
                }
            }


        }

    }

    public static void main(String[] args)
    {
            char[][] board = {
                    {'X','X','X','X'},
                    {'X','O','O','X'},
                    {'X','X','O','X'},
                    {'X','O','X','X'}
            };
        SurroundedRegions sr = new SurroundedRegions();

        sr.solve(board);

        //print
        for(int i = 0 ; i < board.length; ++i)
        {
            for(int j = 0 ; j < board[0].length; ++j)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}