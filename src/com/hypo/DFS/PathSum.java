package com.hypo.DFS;

/**
 * 判断所给的二叉树中是否有从根结点到叶子节点上的值的总和等于sum
 * 
 *  采用递归的方法.
 *
 */
public class PathSum
{
    public boolean hasPathSum(TreeNode root, int sum) 
    {
    	if(root == null) return false;
    	if(root.left == null && root.right == null && sum - root.val == 0) return true; 
    	return hasPathSum(root.left , sum - root.val) || hasPathSum(root.right , sum - root.val);
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
		
		PathSum ps = new PathSum();
		int sum = 6;
		
		System.out.println(ps.hasPathSum(root , sum));
	}

}
