package worksApplication;
import java.util.HashSet;
import java.util.Scanner;

//DFS
public class game2
{
	private static long output = Long.MIN_VALUE;
	private static HashSet<Integer> path = new HashSet<Integer>();//判重
	
	private static long solve(int[][] grid , int row , int col)
	{
		
		long sum = grid[row-1][0];//左下角开始
		
		path.add((row - 1)*row);
		
		dfs(grid , row - 1 , 0, sum);
		
		return output;
	}
	
	
	private static void dfs(int[][] grid ,int r , int c ,long sum)
	{
		int row = grid.length;
		int col = grid[0].length;
		
		if(r >= row || c >= col)//超界
		{
			return;
		}
		
		if(grid[r][c] == -1)//障碍
		{
			return;
		}
		
		//右上角
		if(r == 0  && c == col - 1)//终止条件,找到一条路径
		{
			output = Math.max(output, sum);
			return;
		}
		
		if(r - 1 >= 0 && !path.contains((r-1)*row + c))//向上
		{
			
			path.add((r-1) * row + c);
			
			sum += grid[r-1][c] ;
			
			dfs(grid , r - 1 , c , sum);
			
			sum -= grid[r-1][c] ;
			
			path.remove((r-1) * row + c);
		}
			
		if(r + 1 < row && !path.contains((r+1)*row + c))//向下 超界判断和判重剪枝
		{
			path.add((r+1) * row + c);
			
			sum += grid[r+1][c];
			
			dfs(grid , r + 1 , c ,  sum);
			
			sum -= grid[r+1][c];
			
			path.remove((r+1) * row + c);
		}
			
		if(c + 1 < col && !path.contains(r*row + c + 1))//向右 超界判断和判重剪枝
		{
			path.add(r*row + c + 1);
			
			sum += grid[r][c+1];
					
			dfs(grid , r , c + 1 , sum);
			
			sum -= grid[r][c+1];
			
			path.remove(r*row + c + 1);
		}
		
		if(r == 0 && !path.contains((row - 1)*row + c ))//向下跳跃 判重剪枝
		{
			path.add((row - 1)*row + c);
			
			long mid = sum ;
			
			sum = grid[row - 1][c];
			
			dfs(grid , row , c , sum);
			
			sum = mid;
			
			path.remove((row - 1)*row + c);
		}
		
		if(r == row - 1 && !path.contains(c ))//向上跳跃 判重剪枝
		{
			path.add(c);
			
			long mid = sum;
			
			sum = grid[0][c];
			
			dfs(grid , 0 , c ,  sum);
			
			sum = mid;
			
			path.remove(c);
		}
	}
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int row = input.nextInt();
		int col = input.nextInt();
		
		int[][] grid = new int[row][col];
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < col ; j++)
			{
				grid[i][j] = input.nextInt();
			}
		}
		
		input.close();
		
		System.out.println(game2.solve(grid , row , col));
	}

}
