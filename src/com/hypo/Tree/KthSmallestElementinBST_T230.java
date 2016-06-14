package com.hypo.Tree;

import java.util.ArrayList;

import com.hypo.Utils.TreeNode;

//找到BST中第K小的值.
public class KthSmallestElementinBST_T230
{
    private int kthSmallest(TreeNode root, int k) 
    {
    	int[] count = new int[1];
    	count[0] = k;
    	int[] res = new int[1];
        inorderTraversal(root , count , res);
        return res[0];
    }
    
//  中序遍历
	private void inorderTraversal(TreeNode node , int[] count , int[] res)
	{
		if(node != null)
		{
			inorderTraversal(node.left ,count , res);
			
			if(--count[0] == 0)
			{
				res[0] = node.val;
				return;
			}
			
		    inorderTraversal(node.right ,count , res);
		}
		return;
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
		
		KthSmallestElementinBST_T230 k230 = new KthSmallestElementinBST_T230();
		
		System.out.println(k230.kthSmallest(root, 1));
				
	}

}
