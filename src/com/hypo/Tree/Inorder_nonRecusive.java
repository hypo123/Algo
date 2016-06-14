package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder_nonRecusive
{
    private List<Integer> inorderTraversal(TreeNode root) //用单栈
    {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while(!stack.isEmpty() || node != null)
		{
			if(node != null)
			{
				stack.push(node);
				node = node.left;
			}
			else
			{
				node = stack.pop();
				list.add(node.val);
				node = node.right;
			}
		}
		
		return list;
    }
	public static void main(String[] args)
	{
		//建树
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		
		List<Integer> result = new ArrayList<Integer>();
		
		Inorder_nonRecusive inorder2 = new Inorder_nonRecusive();
		
		result = inorder2.inorderTraversal(root);
		
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}

	}

}
