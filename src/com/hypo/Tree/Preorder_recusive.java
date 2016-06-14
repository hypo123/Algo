package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		val = x;
	}
}

public class Preorder_recusive
{
	List<Integer> list = new ArrayList<Integer>();
	
	public List<Integer> preorderTraversal(TreeNode root)
	{
		TreeNode node = root;
		if(node != null)
		{
			list.add(node.val);
			
			preorderTraversal(node.left);
			preorderTraversal(node.right);
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
		
		Preorder_recusive preorder = new Preorder_recusive();
		
		result = preorder.preorderTraversal(root);
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
		
	}

}
