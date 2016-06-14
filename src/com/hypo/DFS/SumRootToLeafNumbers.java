package com.hypo.DFS;

/**
 * LeetCode 129	Sum Root to Leaf Numbers 
 *
 */
public class SumRootToLeafNumbers
{
    private int sumNumbers(TreeNode root) 
    {
    	
    	
        return 0;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SumRootToLeafNumbers srtlf = new SumRootToLeafNumbers();
		
		//建树
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		System.out.println(srtlf.sumNumbers(root));
	}

}
