package com.hypo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 层次遍历 ， 不过要从最底一层开始存储.
 * 
 */
public class BinaryTreeLevelOrderTraversalII
{
//-----------------------------方案一------------------------------------------------------
//   虽然功能实现了，但速度太慢.
//	 
	private List<List<Integer>> levelOrderBottom(TreeNode root)
    {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();//最后结果
    	
    	ArrayList<Integer> record = new ArrayList<Integer>();//记录每层有几个非null结点,即有几个值.
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if(root == null) return (ArrayList)all;
    	
    	queue.add(root);
    	
    	record.add(1);//第一层的结点个数.
    	
    	bfs(queue , 1 , record , stack);
    	
    	int len = record.size();
    	
    	for(int i = len -1 ; i >= 0 ; --i)
    	{
    		ArrayList<Integer> mid = new ArrayList<Integer>();
    		
    		int num = record.get(i);//每一层的个数，从最后一层开始
    		
    		for(int j = 0; j < num ; ++j)
    		{
    			mid.add(stack.pop());
    		}
    		all.add(mid);
    	}
    	return (ArrayList)all;
    }
    
    private void bfs(LinkedList<TreeNode> queue,int num  ,ArrayList<Integer> record ,
    		Stack<Integer> stack)
    {
    	int count = 0; //计数，下一层有多少个结点进队了.
    	while(--num >= 0)
    	{
    		TreeNode temp = queue.poll();
    		
    		stack.push(temp.val);//将每层结点值入队.
    		
    		if(temp.right != null)//先右结点
    		{
    			count++;
    			queue.add(temp.right);
    		}
    		
    		if(temp.left != null)//再左结点
    		{
    			count++;
    			queue.add(temp.left);
    		}
    	}
    	
    	if(count != 0)
    	{
    		record.add(count);
    		bfs(queue , count ,  record , stack);
    	}
    	else
    	{
    		return ;
    	}
    }
    
//-------------------------------方案二----------------------------------------------
//    层次遍历每一层得到的ArrayList前插到LinkedList中，速度比方案一有提高.但速度任不理想.
	private List<List<Integer>> levelOrderBottom2(TreeNode root)
    {
    	
    	LinkedList<ArrayList<Integer>> all = new LinkedList<ArrayList<Integer>>();//最后结果
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if(root == null) return (LinkedList)all;
    	
    	queue.add(root);
    	
    	bfs2(queue , 1 , all);
    	
    	return (LinkedList)all;
    }
    
	private void bfs2(LinkedList<TreeNode> queue,int num ,LinkedList<ArrayList<Integer>> all )
    {
    	ArrayList<Integer> mid = new ArrayList<Integer>();//一层上所有结点.
    	int count = 0; //计数，下一层有多少个结点进队了.
    	while(--num >= 0)
    	{
    		TreeNode temp = queue.poll();
    		
    		if(temp != null)
    		{
    			mid.add(temp.val);
    		}
    		
    		if(temp.left != null)
    		{
    			count++;
    			queue.add(temp.left);
    		}
    		
    		if(temp.right != null)
    		{
    			count++;
    			queue.add(temp.right);
    		}
    	}
    	
    	all.addFirst(mid);//前插.
    	
    	if(count != 0)
    	{
    		bfs2(queue , count , all);
    	}
    	else
    	{
    		return ;
    	}
    }
//-----------------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
//	      1
//		   \
//	        2
//			/
//	       3
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		BinaryTreeLevelOrderTraversalII btlot2 = new BinaryTreeLevelOrderTraversalII();
		
		LinkedList<ArrayList<Integer>> result = (LinkedList)btlot2.levelOrderBottom2(root);
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			for(int j = 0 ; j < result.get(i).size() ; ++j)
			{
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
