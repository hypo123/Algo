package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历 递归版本
 */
public class Postorder_recusive
{
	List<Integer> list = new ArrayList<Integer>();
	
	public List<Integer> postTraversal(TreeNode root)
	{
		TreeNode node = root;
		if(node != null)
		{
			postTraversal(node.left);
			postTraversal(node.right);
			list.add(node.val);
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
		
		Postorder_recusive postorder = new Postorder_recusive();
		
		result = postorder.postTraversal(root);
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
		
	}
}
