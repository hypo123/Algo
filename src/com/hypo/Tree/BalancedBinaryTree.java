package com.hypo.Tree;

/*
 * 判断一棵二叉树是否是平衡二叉树，即对每一个结点，其左右子树高度差不超过1.
 */

public class BalancedBinaryTree
{
    private boolean isBalanced(TreeNode root)
    {
    	TreeNode node = root;
        return dfs(node) != -1;
    }
    
    private int dfs(TreeNode root)
    {
    	TreeNode node = root;
    	
    	if(node == null) return 0;
    	
    	int leftHeight = dfs(node.left);
    	
    	if(leftHeight == -1)
    	{
    		return -1;
    	}
    	
    	int rightHeight = dfs(node.right);
    	
    	if(rightHeight == -1)
    	{
    		return -1;
    	}
    	
    	int diff = leftHeight - rightHeight;
    	
    	if(diff < -1 || diff > 1)
    	{
    		return -1;
    	}
    	
//    	return Math.max(leftHeight, rightHeight) + 1;
    	return (diff > 0) ? leftHeight+1 : rightHeight+1;//将上面一句改为这一句速度提升很多.
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//建树
//		      1
//			   \
//		        2
//				/
//		       3
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		
		System.out.println(bbt.isBalanced(root));

	}

}
