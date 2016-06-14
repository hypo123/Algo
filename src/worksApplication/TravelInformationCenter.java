package worksApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class node//无向图结点
{
	int label;
	List<node> neighbors;

	node(int x)
	{
		label = x;
		neighbors = new ArrayList<node>();//邻接结点
	}
}

//BFS
public class TravelInformationCenter
{
	private HashSet<node> festivalCity = new HashSet<node>();//节日城市
	private ArrayList<Integer> result = new ArrayList<Integer>();//输出结果
	private boolean flag = false;//是否已经找到节日城市
	private int length = 0;//到最近节日城市的距离
	
	//广度优先搜索
	private void bfs(int city , ArrayList<node> nodes)
	{
		Queue<node> queue = new LinkedList<node>();
		
		node testnode = nodes.get(city - 1);
		
		if(festivalCity.contains(testnode))
		{
			result.add(this.length);
			flag = true;
			this.length = 0 ;
			return;
		}
		
		queue.add(testnode);

		while(!queue.isEmpty())
		{
			node out = queue.poll();
			
			this.length++;
			
			for(node in : out.neighbors)//判断邻接结点中是否有节日城市
			{
				if(festivalCity.contains(in))
				{
					result.add(this.length);
					flag = true;
					this.length = 0;
					return;
				}
			}
			
			for(node in : out.neighbors)//邻接结点中没有节日城市，则要继续向下一层判断
			{
				queue.add(in);
				
				bfs(nodes.indexOf(in) + 1 , nodes);
				
				if(flag)
				{
					return;
				}
			}
		}
	}
	
	//添加节日城市
	private void  addFesitivalCity(int city , ArrayList<node> nodes)
	{
		if(!festivalCity.contains(nodes.get(city - 1)))
		{
			festivalCity.add(nodes.get(city - 1));
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		TravelInformationCenter tic = new TravelInformationCenter();
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();//城市个数
		int m = input.nextInt();//问询个数
		
		//建图
		ArrayList<node> nodes = new ArrayList<node>(n);
		
		//新建结点
		for(int i = 0 ; i < n ; ++i)
		{
			nodes.add(new node(i+1));
		}
		
		tic.addFesitivalCity(1 , nodes);//初始化1号城市为节日城市
		
		//添加结点连接关系
		for(int i = 0 ; i < n - 1; i++)
		{
			int from = input.nextInt() - 1;//下标
			int to = input.nextInt() - 1;
			
			nodes.get(from).neighbors.add(nodes.get(to));//添加邻接结点
			nodes.get(to).neighbors.add(nodes.get(from));
		}
		
		for(int i = 0 ; i < m ; i++)//问询处理
		{
			int order = input.nextInt();
			int city = input.nextInt();
			
			if(order == 1)
			{
				tic.addFesitivalCity(city , nodes);
			}
			else if(order == 2)
			{
				tic.flag = false;
				tic.bfs(city , nodes);
			}
		}
		
		input.close();
		
		//打印结果
		for(int i : tic.result)
		{
			System.out.println(i);
		}
	}

}
