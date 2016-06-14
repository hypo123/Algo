package com.hypo.Tree;

import java.util.ArrayList;

//通过后序遍历和中序遍历构建二叉树.递归，时间复杂度O(n)，空间复杂度O(logn)
public class ConstructBinaryTreefromInorderPostorder_T106
{
    private TreeNode buildTree(int[] inorder, int[] postorder)
    {
        TreeNode node = null;
        
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, node);
        
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int iStart ,int iEnd,
    		int pStart , int pEnd , TreeNode node)
    {
    	
    	if(pStart > pEnd) return null;
    	if(iStart > iEnd) return null;
    	
    	TreeNode root = new TreeNode(postorder[pEnd]);//postorder[pEnd]为父节点.
    	
    	node = root;
    	
    	int mid = -1;
    	
    	for(int i = iStart ; i <= iEnd ; ++i)
    	{
    		if(inorder[i] == postorder[pEnd])//找到父节点在中序遍历数组中的位置.
    		{
    			mid = i;
    			break;
    		}
    	}
    	
    	int leftLen = mid - iStart;
    	int rightLen = iEnd - mid;
//    	后序遍历的数组中pStart到pEnd-rightLen-1是左子树的内容；pEnd-rightLen到pEnd-1是右子树的内容.
//    	中序遍历的数组中iStart到mid-1是左子树的内容；mid+1 到iEnd是右子树的内容.    	
    	root.right = build(inorder , postorder , mid+1 , iEnd ,pEnd - rightLen ,pEnd-1 , root);
    	
    	root.left = build(inorder, postorder, iStart, mid-1, pStart, pEnd - rightLen - 1, node);
    	
    	return node;
    }
    
//    test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ConstructBinaryTreefromInorderPostorder_T106 t106 = 
				new ConstructBinaryTreefromInorderPostorder_T106();
		//二叉树
//	      1
//		 /  \
//	     2   3
//			/
//	       5		
		int[] inorder = new int[]{2,1,5,3};
		int[] postorder = new int[]{2,5,3,1};
		
		TreeNode root = t106.buildTree(inorder, postorder);
		
//		test测试得到的二叉树是否是正确的二叉树.
		Inorder_recusive ir = new Inorder_recusive();
		ArrayList<Integer> print = (ArrayList)ir.inorderTraversal(root);
		
		for(Integer n : print)
		{
			System.out.print(n+" ");
		}
		
		System.out.println();
		
		Postorder_recusive pr = new Postorder_recusive();
		ArrayList<Integer> print2 = (ArrayList)pr.postTraversal(root);
		for(int n : print2)
		{
			System.out.print(n+" ");
		}
	}

}
