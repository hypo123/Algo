package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

import com.hypo.Utils.TreeNode;

//判断一棵树是否是BST
public class ValidateBST_T98
{
//	先中序遍历给定树,再判断遍历后得到的数组是否是递增的即可.
    private boolean isValidBST(TreeNode root) 
    {
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	inorderTraversal(root , path);
    	
//    	if(root == null) return true;
    	
    	for(int i = 0 ; i < path.size()-1 ; ++i)
    	{
    		if(path.get(i) >= path.get(i+1))
    		{
    			return false;
    		}
    	}
    	
        return true;
    }
    
//    中序遍历
	private ArrayList<Integer> inorderTraversal(TreeNode node , ArrayList<Integer> path)
	{
		if(node != null)
		{
			inorderTraversal(node.left , path);
			path.add(node.val);
		    inorderTraversal(node.right , path);
		}
		return path;
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
		
		TreeNode root2 = null;
		ValidateBST_T98 v98 = new ValidateBST_T98();
		
		System.out.println(v98.isValidBST(root2));
	}

}
