package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

import com.hypo.Utils.TreeNode;

public class PathSumII_T133
{
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	dfs(sum , root , res , path);
    	
        return (ArrayList)res;
    }
    
    private void dfs(int leave , TreeNode node ,ArrayList<ArrayList<Integer>> res,
    		ArrayList<Integer> path)
    {
    	if(node == null) return;
    	int now = leave;
    	int len = path.size();//path当前长度.
    	
    	if(node.left == null && node.right == null )//找到合法解
    	{
    		if((leave -= node.val) == 0)
    		{
    			path.add(node.val);
    			res.add(new ArrayList(path));
    			path.remove(path.size()-1);
    			leave = now;
    		}
    		return;
    	}
    	
    	leave -= node.val;
    	path.add(node.val);
    	
    	dfs(leave , node.left , res , path);
    	dfs(leave , node.right , res ,path);
    	
    	while(path.size() > len)
    	{
    		path.remove(path.size()-1);
    	}
    	
    	leave = now;
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
		
		PathSumII_T133 ps133 = new PathSumII_T133();
		
		TreeNode root2 = null;
		
		ArrayList<ArrayList<Integer>> print = (ArrayList)ps133.pathSum(root2, 0);
		
		for (int i = 0; i < print.size(); ++i)
		{
			ArrayList<Integer> mid = print.get(i);

			for (int j = 0; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j) + " ");
			}

			System.out.println();
		}
	}

}
