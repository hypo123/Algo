package com.hypo.Tree;

import com.hypo.Utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

//返回所有根结点到叶子节点的路径.
public class BinaryTreePaths_T257
{
    private List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> res = new ArrayList<String>();
        
        StringBuffer path = new StringBuffer();
        
        dfs(root , res , path);
        
        return res;
    }
    
    private void dfs(TreeNode node , List<String> res ,StringBuffer path)
    {
    	if(node == null) return;
    	
    	int len = path.length();
    	
    	if(node.left == null && node.right == null)//终止条件.
    	{
    		path.append(node.val);
    		res.add(new String(path));
    		path.delete(len, path.length());
    		return;
    	}
    	
    	path.append(node.val + "->");
    	
    	dfs(node.left , res , path);
    	dfs(node.right , res , path);
    	
    	path.delete(len, path.length());
    }
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
		TreeNode l11 = new TreeNode(2);
		TreeNode l12 = new TreeNode(3);
		root.left = l11;
		root.right = l12;
		TreeNode l21 = new TreeNode(5);
		l12.left = l21;
		
		BinaryTreePaths_T257 btp257 = new BinaryTreePaths_T257();
		
		ArrayList<String> print = (ArrayList)btp257.binaryTreePaths(root);
		
		for(String n : print)
		{
			System.out.println(n);
		}
	}

}
