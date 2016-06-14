package com.hypo.BFS;
import java.util.LinkedList;

/**
 * Created by Administrator on 2015/9/9.
 */
public class NumberOfIslands
{
    private int numIslands(char[][] grid)
    {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length; //行
        int n = grid[0].length;//列

        int count = 0; //island numbers
        boolean[][] visited = new boolean[m][n];//标记是否被访问过.

        for(int i = 0 ; i < m ; ++i)
        {
            for(int j = 0 ; j < n ; ++j)
            {
                //在这儿提前判断，如果已访问过就不用调用bfs了，相较于统一调用bfs，在bfs中判断,速度提升很多
                if(!visited[i][j] && bfs(grid, visited, i , j ))
                {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean bfs(char[][] grid ,boolean[][] visited,  int i , int j)
    {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        int row = grid.length;
        int col = grid[0].length;


        if (!visited[i][j] && grid[i][j] == '1')//没有访问过
        {
            queue.add(i);//先进横坐标
            queue.add(j);//再进纵坐标
            visited[i][j] = true;
        }
        else
        {
            return false;
        }


        while (!queue.isEmpty()) {
            int x = queue.poll();//先出横坐标
            int y = queue.poll();//再出纵坐标

            if (x - 1 >= 0 && !visited[x - 1][y])//上
            {
                visited[x - 1][y] = true;//设为已访问

                if (grid[x - 1][y] == '1') {
                    queue.add(x - 1);//横坐标入队
                    queue.add(y);//纵坐标入队.
                }
            }

            if (x + 1 < row && !visited[x + 1][y])//下
            {
                visited[x + 1][y] = true;

                if (grid[x + 1][y] == '1')//下
                {
                    queue.add(x + 1);
                    queue.add(y);
                }
            }


            if (y - 1 >= 0 && !visited[x][y - 1])//左
            {
                visited[x][y - 1] = true;
                if (grid[x][y - 1] == '1') {
                    queue.add(x);
                    queue.add(y - 1);
                }

            }

            if (y + 1 < col && !visited[x][y + 1])//右
            {
                visited[x][y + 1] = true;
                if (grid[x][y + 1] == '1') {
                    queue.add(x);
                    queue.add(y + 1);
                }
            }

        }

        return true;
    }

    public static void main(String[] args)
    {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] grid2 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        NumberOfIslands noi = new NumberOfIslands();

        System.out.println(noi.numIslands(grid2));

//        //print
//        for(int i = 0 ; i < grid.length; ++i)
//        {
//            for(int j = 0 ; j < grid[0].length; ++j)
//            {
//                System.out.print(grid[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
