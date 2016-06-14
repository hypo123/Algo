package com.hypo.DFS;

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

/**
 * 判断二叉树是否是镜面对称的,使用递归的方法
 *
 */
public class SymmetricTree
{
	private boolean isSymmetric(TreeNode root)
	{
		return root == null ? true : isSymmetric(root.left , root.right);
	}
	
	private boolean isSymmetric(TreeNode left , TreeNode right)
	{
		if(left == null && right == null) return true;
		
		if(left == null || right == null) return false;
		
		return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
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
		
		SymmetricTree st = new SymmetricTree();
		
		System.out.println(st.isSymmetric(root));
	}

}
