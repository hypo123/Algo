package com.hypo.Tree;

import java.util.ArrayList;

import com.hypo.Utils.TreeNode;

//找二叉树中两个结点的最近公共祖先.规定一个结点可以是它自己的祖先.

public class LCAOfBinaryTree_T236
{
//方案一-------------------------------------------------------------------------------------
//比较长的树，出现java.lang.StackOverflowError	
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	ArrayList<TreeNode> pathp = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> pathq = new ArrayList<TreeNode>();
    	ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
    	dfs(root , p , pathp , res);
    	dfs(root ,q , pathq , res);
    	
    	pathp = res.get(0);
    	pathq = res.get(1);
    	
      	for(int i = pathp.size()-1 ; i >= 0 ; --i)
      	{
      		for(int j =  pathq.size()-1 ; j >= 0 ; --j)
      		{
      			if(pathp.get(i) == pathq.get(j))
      			{
      				return pathp.get(i);
      			}
      		}
      	}
        return null;
    }
    
    private void dfs(TreeNode node , TreeNode target , ArrayList<TreeNode> path ,
    		ArrayList<ArrayList<TreeNode>> res)
    {
    	if(node == null) return;//剪枝.
    	
    	int len = path.size();
    	
    	if(node == target)//找到了，终止.
    	{
    		path.add(node);
    		res.add(new ArrayList<TreeNode>(path));
    		return;
    	}
    	
    	path.add(node);
    	
    	dfs(node.left , target , path , res);
    	
    	dfs(node.right , target , path ,res);
    	
    	while(path.size() > len)
    	{
    		path.remove(path.size()-1);
    	}
    }
//   方案二 ----------------------------------------------------------------------------
    private TreeNode lowestCommonAncestor2(TreeNode node, TreeNode p, TreeNode q)   
    {
    	if(node == null || node == p || node == q) return node;
    	
    	TreeNode left = lowestCommonAncestor2(node.left, p, q);//left是p或q的父节点
    	TreeNode right = lowestCommonAncestor2(node.right, p, q);//right是p或q的父节点
    	
    	if(left != null && right != null) return node;
    	return (left != null) ? left : right;
    }
//    -----------------------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
//	      1
//		 /  \
//	     2   3
//			/
//	       5
		TreeNode root = new TreeNode(1);
		TreeNode l11 = new TreeNode(2);//p
		TreeNode l12 = new TreeNode(3);
		root.left = l11;
		root.right = l12;
		TreeNode l21 = new TreeNode(5);//q
		l12.left = l21;
		
		TreeNode p = l11;
		TreeNode q = l21;
		
		LCAOfBinaryTree_T236 t236 = new LCAOfBinaryTree_T236();
		
		System.out.println(t236.lowestCommonAncestor2(root, p, q).val);
		
	}

}
