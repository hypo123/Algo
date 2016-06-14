package ZTE;

import java.util.HashSet;
import java.util.Set;

/**
 *	中兴蓝剑计划第二题 
 *	题目描述:给定二维数组,二维数组中1表示屋顶，上下左右相邻的1表示同一幢房子，
 *		      斜对角的1不属于同一幢房子，统计给定二维数组中有多少幢房子.
 *	解题思路:深度优先搜索+HashSet判重
 *	2016.6.13 
 */
public class Houses
{
	public static int houseNumber(int[][] grid)
	{
		//对二维数组中每一个位置(i,j)有唯一的可用于判重的值    i*row+j
		//如果已访问(i,j),则将r*row+j 加入到HashSet中.
		Set<Integer> visited = new HashSet<Integer>();//判重
		
		int houses = 0;

		int row = grid.length;
		int col = grid[0].length;
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < col ; j++)
			{
				if(grid[i][j] == 1 && !visited.contains(i*row+j))
				{
					houses++;
					dfs(visited , grid ,  i , j);
				}
			}
		}
		
		return houses;
	}
	
	private static void dfs(Set<Integer> visited, int[][] grid , int i , int j)
	{
		int row = grid.length;
		int col = grid[0].length;
		
		//上
		if(i - 1 >= 0 && grid[i-1][j] == 1 && !visited.contains((i-1)*row + j))
		{
			visited.add((i-1)*row + j);
			dfs(visited , grid , i-1 , j);
		}
		
		//下
		if(i + 1 < row && grid[i+1][j] == 1 && !visited.contains((i+1)*row + j))
		{
			visited.add((i+1)*row + j);
			dfs(visited , grid , i+1 , j);
		}
		
		//左
		if(j - 1 >= 0 && grid[i][j-1] == 1 && !visited.contains(i*row + j - 1))
		{
			visited.add(i*row + j - 1);
			dfs(visited , grid , i , j - 1);
		}
		
		//右
		if(j + 1 < col && grid[i][j+1] == 1 && !visited.contains(i*row + j + 1))
		{
			visited.add(i*row + j + 1);
			dfs(visited , grid , i , j + 1);
		}
	}
}
