package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder
{
	private List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<Integer>();		
		
		TreeNode curr,prev;
		
		curr = root;
		
		while(curr != null)
		{
			if(curr.left == null)//当前结点没有左孩子
			{
				list.add(curr.val);
				curr = curr.right;
			}
			else //当前结点有左孩子
			{
				//查找当前结点的前驱,，即curr的左子树的最右下角的结点
				TreeNode node = curr.left;
				while(node.right != null && node.right != curr)
				{
					node = node.right;
				}
				
				if(node.right == null)//找到前驱，但还没有线索化，则建立线索
				{
					list.add(curr.val);//访问当前结点    //仅这一行与中序不同
					node.right = curr;//建立线索
					curr = curr.left;
				}
				else	//已经线索化，则访问结点，并删除线索
				{
					node.right = null; //删除线索
					//prev = curr; 不能有这一句，curr已经被访问
					curr = curr.right;
				}
			}
		}		
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
		
		MorrisPreorder morrispreorder = new MorrisPreorder();
		
		result = morrispreorder.preorderTraversal(root);
		
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}

	}

}
