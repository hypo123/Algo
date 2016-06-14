package com.hypo.Tree;

import java.util.ArrayList;

/**
 *	寻找BST树给定两个结点的最近公共祖先. 
 *
 */
public class LowestCommonAncestorOfBST
{
//---------------------------------方案一-------------------------------------------------
//先分别找出从根结点到所给的两个结点的路径，然后反序遍历这两个路径，找到第一个相同的点即可.+ 
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	TreeNode LCA = null;
    	
    	ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
    	
    	dfs(root , p ,  path1 );
    	dfs(root , q , path2);
    	
    	int len1 = path1.size();
    	int len2 = path2.size();
    	
    	for(int i = len1-1 ; i >= 0 ; --i)
    	{
    		for(int j = len2-1 ; j >= 0; --j)
    		{
    			if(path1.get(i) == path2.get(j))
    			{
    				return LCA = path1.get(i);
    			}
    		}
    	}
    	return LCA;
    }
    
    private void dfs(TreeNode node , TreeNode target , ArrayList<TreeNode> path)
    {
    	path.add(node);
    	
    	if(target.val == node.val)//找到了.
    	{
    		return;
    	}
    	else if(target.val > node.val)//往右走.
    	{
    		dfs(node.right , target , path);
    	}
    	else//往左走.
    	{
    		dfs(node.left , target , path);
    	}
    }
//----------------------------------------------------------------------------------------   
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
//	      6
//		 /  \
//	    2    8
//		 \	  \
//	      4    9
		TreeNode root = new TreeNode(6);
		TreeNode l1 = new TreeNode(2);//l1
		TreeNode r1 = new TreeNode(8);//r1
		root.left = l1;
		root.right = r1;
		TreeNode r2 = new TreeNode(4);//r2
		l1.right = r2;
		TreeNode l1r = new TreeNode(9);
		r1.right = l1r;
	
		LowestCommonAncestorOfBST lcaob = new LowestCommonAncestorOfBST();
		
		TreeNode result = lcaob.lowestCommonAncestor(root, l1, r2);
		
		System.out.println(result.val);
		
	}

}
