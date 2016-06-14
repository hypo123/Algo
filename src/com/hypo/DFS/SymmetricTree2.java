package com.hypo.DFS;

import java.util.Stack;

/**
 * 判断二叉树是否是镜面对称的,使用非递归的方法，用栈
 *
 */
public class SymmetricTree2
{
	private boolean isSymmetric(TreeNode root)
	{
		if(root == null) return true;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root.left);
		stack.push(root.right);
		
		while(!stack.isEmpty())
		{
			TreeNode right = stack.pop();
			TreeNode left = stack.pop();
			
			if(left == null && right == null) continue;
			if(left == null || right == null) return false;
			
			if(left.val != right.val) return false;
			
			stack.push(left.left);//左子的左子
			stack.push(right.right);//右子的右子
			
			stack.push(left.right);//左子的右子
			stack.push(right.left);//右子的左子
		}
		return true;
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
		
		SymmetricTree2 st2 = new SymmetricTree2();
		
		System.out.println(st2.isSymmetric(root));
	}

}
