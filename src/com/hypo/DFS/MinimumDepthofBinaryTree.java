package com.hypo.DFS;

/**
 * 
 *这里定义的最小深度是从根结点到最近 <<叶子节点>>的距离.
 *
 *采用递归的方法
 *
 */
public class MinimumDepthofBinaryTree
{
    public int minDepth(TreeNode root) 
    {
    	if(root == null) return 0;
    	
    	int left = minDepth(root.left);
    	int right = minDepth(root.right);
    	
    	return (left == 0 || right == 0) ? left+right+1 : Math.min(left, right)+1;
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
		
		MinimumDepthofBinaryTree mdobt = new MinimumDepthofBinaryTree();
		
		System.out.println(mdobt.minDepth(root));
	}

}
