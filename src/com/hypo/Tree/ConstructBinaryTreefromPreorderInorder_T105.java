package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

//通过先序遍历和中序遍历构建二叉树.递归，时间复杂度O(n)，空间复杂度O(logn)
public class ConstructBinaryTreefromPreorderInorder_T105
{
    private TreeNode buildTree(int[] preorder, int[] inorder) 
    {
    	TreeNode node = null;
    	return build(preorder , inorder ,  0 , preorder.length-1,
    			0 , inorder.length-1 , node);
    }
    
    private TreeNode build(int[] preorder, int[] inorder,int pStart ,int pEnd ,
    		int iStart ,int iEnd ,TreeNode node)
    {
    	if(pStart > pEnd) return null;
    	if(iStart > iEnd) return null;
    	
    	TreeNode root = new TreeNode(preorder[pStart]);//第一个为父节点
    	
    	node = root;
    	
    	int mid = -1;
    	
    	for(int i = iStart ; i <= iEnd ; ++i)//找到父节点在数组中下标，其左边为左子树，右边为右子树.
    	{
    		if(inorder[i] == preorder[pStart])
    		{
    			mid = i;
    			break;
    		}
    	}
    	
    	int leftLen = mid - iStart ;//左子树结点个数.
    	int rightLen = iEnd - mid; //右子树结点个数.
    	
//    	先序遍历的数组中pStart+1到pStart+leftLen是左子树的内容； pStart+leftLen+1到pEnd是右子树的内容.
//    	中序遍历的数组中iStart到mid-1是左子树的内容；mid+1 到iEnd是右子树的内容.
    	root.left = build(preorder , inorder , pStart + 1 , pStart+leftLen ,iStart ,mid-1 , root);
    	root.right = build(preorder , inorder , pStart+leftLen+1 , pEnd ,mid+1 ,iEnd , root);
    	
    	return node;
    }
    
//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ConstructBinaryTreefromPreorderInorder_T105 t105 = 
				new ConstructBinaryTreefromPreorderInorder_T105();
		//二叉树
//	      1
//		 /  \
//	     2   3
//			/
//	       5		
		int[] preorder = new int[]{1,2,3,5};
		int[] inorder = new int[]{2,1,5,3};
		
		TreeNode root = t105.buildTree(preorder, inorder);
		
//		test测试得到的二叉树是否是正确的二叉树.
		Inorder_recusive ir = new Inorder_recusive();
		ArrayList<Integer> print = (ArrayList)ir.inorderTraversal(root);
		
		for(Integer n : print)
		{
			System.out.print(n + " ");
		}
		System.out.println();
		Preorder_recusive pr = new Preorder_recusive();
		ArrayList<Integer> print2 = (ArrayList)pr.preorderTraversal(root);
		
		for(Integer n : print2)
		{
			System.out.print(n + " ");
		}
	}

}
