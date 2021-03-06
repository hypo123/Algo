package com.hypo.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UndirectedGraphNode//无向图结点
{
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x)
	{
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph_T133
{
//----------------------------方案一：DFS-------------------------------------------
//	标记已访问结点
	private HashMap<Integer , UndirectedGraphNode> mark = new HashMap<Integer , UndirectedGraphNode>();

	//	复制无向图函数    图中结点可能有自环
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
    	return dfs(node);
    }
    
//   DFS
    private UndirectedGraphNode dfs(UndirectedGraphNode node)
    {
    	if(node == null)
    	{
    		return null;
    	}
    	
    	if(mark.containsKey(node.label))//结点的label是唯一的
    	{
    		return mark.get(node.label);//处理结点有自环的情况
    	}

    	UndirectedGraphNode  clone = new UndirectedGraphNode(node.label);
    	
    	mark.put(clone.label, clone);
    	
    	for(UndirectedGraphNode neighbor : node.neighbors)//遍历结点node的相邻结点
    	{
    		clone.neighbors.add(dfs(neighbor));
    	}
    	
    	return clone;
    }
    

//-----------------------------------方案二：BFS----------------------------------------
	
    private UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) 
    {
    	if(node == null) return null;

    	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    	
    	HashMap<Integer, UndirectedGraphNode> visited = new HashMap();//访问标记，存放新接点
    	visited.put(clone.label, clone);
    	
    	Queue<UndirectedGraphNode> queue = new LinkedList();//队列
    	queue.add(node);//BUG注意第一个加入队列中的结点为node,而不是clone,因为clone邻接结点还未加入；全部存放旧接点
    	
    	while(!queue.isEmpty())
    	{
    		UndirectedGraphNode n = queue.poll();//访问完结点出队
    		
    		for(UndirectedGraphNode neighbor : n.neighbors)//遍历邻接结点
    		{
    			
    			if(!visited.containsKey(neighbor.label))
    			{
    				UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
    				
    				queue.add(neighbor);//相邻未访问结点入队
    				
    				visited.put(newNode.label, newNode);
    			}
    			
    			visited.get(n.label).neighbors.add(visited.get(neighbor.label));//添加n的邻接结点关系
    		}
    	}
    	return clone;
    }
    
    
//    --------------------------------test------------------------------------------
//  打印图
    private void printGraph(UndirectedGraphNode  node)
    {
    	if(node == null) return;
    	if(mark.containsKey(node.label))
    	{
    		return;
    	}
    	else
    	{
    		mark.put(node.label, node);
    		
    		System.out.print(node.label+": ");
    		
    		for(UndirectedGraphNode  n : node.neighbors)
    		{
    			System.out.print(n.label + ",");
    		}
    		System.out.println(" #");
    	}
    	
    	
    	for(UndirectedGraphNode  n : node.neighbors)
    	{
    		printGraph(n);
    	}
    }
    
    public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CloneGraph_T133 t133 = new CloneGraph_T133();
		
//		初始化无向图
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		
		node1.neighbors.add(node2);
		
		node2.neighbors.add(node2);

		UndirectedGraphNode  copy = t133.cloneGraph(node0);
		UndirectedGraphNode  copy2 = t133.cloneGraph2(node0);
		
//		打印方案一：DFS结果
		t133.mark.clear();
		t133.printGraph(copy);
		
		System.out.println();
		System.out.println("-----");
		
		
//		打印方案二：BFS结果
		t133.mark.clear();
		t133.printGraph(copy2);
	}

}
