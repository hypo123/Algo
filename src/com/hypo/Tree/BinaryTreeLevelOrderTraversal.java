package com.hypo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 二叉树的层次遍历. 
 * 
 * 使用BFS,使用两个队列来完成.		
 *
 */
public class BinaryTreeLevelOrderTraversal
{
//	-------------------------第一种方法------------------------------------------
//	使用两个队列.
    private List<List<Integer>> levelOrder(TreeNode root) 
    {
    	ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> back = new LinkedList<TreeNode>();
    	
    	if(root == null) return (ArrayList)all;
    	
    	queue.add(root);
    	
    	bfs(queue , back , all );
    	
        return (ArrayList)all;
    }
    //使用两个队列.
    private void bfs(LinkedList<TreeNode> queue, LinkedList<TreeNode> back ,ArrayList<ArrayList<Integer>> all )
    {
    	ArrayList<Integer> mid = new ArrayList<Integer>();//一层上所有结点.
    	while(!queue.isEmpty())//将上一层所有结点弹出，并将上一层结点的左右子结点入队.
    	{
    		TreeNode temp = queue.poll();
    		mid.add(temp.val);
    		
    		//将temp的左右子结点都入到back队中
    		if(temp.left != null)
    		{
    			back.add(temp.left);
    		}
    		
    		if(temp.right != null)
    		{
    			back.add(temp.right);
    		}
    	}
    	
    	if(mid.size() != 0 ) all.add(mid);
    	
    	if(back.isEmpty()) return ;//结束条件.当前层所有结点都没有子结点.
    	
    	//将back队中的所有结点倒到queue队中.
    	while(!back.isEmpty())
    	{
    		queue.add(back.poll());
    	}
    	
    	bfs(queue, back ,all);
    }
    
//-----------------------------第二种方法----------------------------------------    
//    使用一个队列要比上面使用两个队列快.
    private List<List<Integer>> levelOrder2(TreeNode root) 
    {
    	ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if(root == null) return (ArrayList)all;
    	
    	queue.add(root);
    	
    	bfs2(queue , 1 , all);
    	
    	return (ArrayList)all;
    }
    //使用一个队列
    private void bfs2(LinkedList<TreeNode> queue,int num ,ArrayList<ArrayList<Integer>> all )
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
    	
    	all.add(mid);
    	
    	if(count != 0)
    	{
    		bfs2(queue , count , all);
    	}
    	else
    	{
    		return ;
    	}
    }
//---------------------------------------------------------------------    
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
		
		BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();
		
		ArrayList<ArrayList<Integer>> result = (ArrayList)btlot.levelOrder2(root);
		
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
