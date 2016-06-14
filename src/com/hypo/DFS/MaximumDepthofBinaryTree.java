package com.hypo.DFS;

/**
 * 求树的最大深度：根结点到<<叶子节点>>的最大距离 
 * 
 * 使用递归的方法.
 */
public class MaximumDepthofBinaryTree
{
    public int maxDepth(TreeNode root) 
    {
    	if(root == null) return 0;
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	
    	return (left==0 || right==0) ? left+right+1 : Math.max(left, right)+1;
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
		
		MaximumDepthofBinaryTree mdobt2 = new MaximumDepthofBinaryTree();
		
		System.out.println(mdobt2.maxDepth(root));
	}

}
