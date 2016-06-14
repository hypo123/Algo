package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder_nonRecusive
{
    private List<Integer> postorderTraversal(TreeNode root)//用单栈
    {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		TreeNode visit = null;
		do
		{
			while(node != null)//往左下走
			{
				stack.push(node);
				node = node.left;
			}
			
			visit = null;
			
			while(!stack.isEmpty())
			{
				node = stack.pop();
				//右孩子不在或已被访问，则访问当前结点
				if(node.right == visit)
				{
					list.add(node.val);
					visit = node;    //保存刚访问过的结点
				}
				else
				{   //当前结点不能访问，需二次进栈
					stack.push(node);
					//先处理右子树
					node = node.right;
					break;
				}
			}
		}
		while(!stack.isEmpty());
		
		return list;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
		TreeNode root = new TreeNode(1);
		TreeNode right1 = new TreeNode(2);
		root.right = right1;
		TreeNode right1_left = new TreeNode(3);
		right1.left = right1_left;
		
		
		List<Integer> result = new ArrayList<Integer>();
		
		Postorder_nonRecusive postorder2 = new Postorder_nonRecusive();
		
		result = postorder2.postorderTraversal(root);
		
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
	}

}
