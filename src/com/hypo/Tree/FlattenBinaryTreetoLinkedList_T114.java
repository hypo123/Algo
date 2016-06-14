package com.hypo.Tree;

import com.hypo.Utils.TreeNode;

//原地将二叉树转换为链表.
public class FlattenBinaryTreetoLinkedList_T114
{
	private TreeNode last = null;
    private void flatten(TreeNode root) 
    {
    	if(root == null) return;
        if(last != null)
        {
        	last.left = null;
        	last.right = root;
        }
        
        last = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
//	      2
//		 /  \
//	     1   5
//			/
//	       4
		TreeNode root = new TreeNode(2);
		TreeNode l11 = new TreeNode(1);
		TreeNode l12 = new TreeNode(5);
		root.left = l11;
		root.right = l12;
		TreeNode l21 = new TreeNode(4);
		l12.left = l21;
		
		FlattenBinaryTreetoLinkedList_T114 f114 = new FlattenBinaryTreetoLinkedList_T114();
		
		f114.flatten(root);
		
		while(root != null)
		{
			System.out.println(root.val);
			root = root.right;
		}
	}

}
