package com.hypo.DFS;

/**
 * 判断两棵树是否完全一样
 * 使用递归的方法. 
 */
public class SameTree
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
    	if(p == null && q == null) return true;
    	if(p == null || q == null) return false;
    	
    	return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
		TreeNode root1 = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root1.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		//建树
		TreeNode root2 = new TreeNode(1);
		TreeNode right2 = new TreeNode(2);
		root2.right = right2;
		TreeNode right2_left = new TreeNode(3);
		right2.left = right2_left;
		
		SameTree st = new SameTree();
		
		System.out.println(st.isSameTree(root1, root2));
	}

}
