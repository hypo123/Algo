package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的先序遍历 非递归 空间O(n) 
 */
public class Preorder_nonRecusive
{
	
	private List<Integer> preorderTraversal(TreeNode root)//用单栈
	{
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while(node != null || !stack.isEmpty())
		{
			if(node != null)
			{
				list.add(node.val);
				stack.push(node.right);
				node = node.left;
			}
			else
			{
				node = stack.pop();
			}
		}
		return list;
	}
	
	private List<Integer> preorderTraversal2(TreeNode root)//用单栈，这个更简单
	{
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		if(node != null) stack.push(node);
		
		while(!stack.isEmpty())
		{
			node = stack.pop();;
			list.add(node.val);
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
		
		return list;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		
		List<Integer> result = new ArrayList<Integer>();
		
		Preorder_nonRecusive preorder2 = new Preorder_nonRecusive();
		
		result = preorder2.preorderTraversal(root);
		
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
		
		System.out.println();
		
		result = preorder2.preorderTraversal2(root);
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
	}
}
