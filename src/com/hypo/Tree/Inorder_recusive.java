package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历 递归版本 
 */
public class Inorder_recusive
{
	List<Integer> list = new ArrayList<Integer>();
	
	public List<Integer> inorderTraversal(TreeNode root)
	{
		TreeNode node = root;
		if(node != null)
		{
			inorderTraversal(node.left);
			list.add(node.val);
		    inorderTraversal(node.right);
		}
		return list;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		List<Integer> result = new ArrayList<Integer>();
		
		Inorder_recusive inorder = new Inorder_recusive();
		
		result = inorder.inorderTraversal(root);
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
		
	}

}
