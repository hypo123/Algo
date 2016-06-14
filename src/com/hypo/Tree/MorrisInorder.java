package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的Morris中序遍历              空间复杂度O(1) 
 *
 * Morris中序遍历步骤如下：
 * 1.初始化当前结点curr为root结点
 * 
 * 2.如果curr没有左孩子，则输出当前结点并将其右孩子作为当前结点，即curr = curr.right;
 * 
 * 3.如果curr有左孩子，则寻找curr的前驱，即curr的左子树的最右下角的结点.
 * 	 a)如果前驱结点的右孩子为空，将它的右孩子指向当前结点，当前结点更新为当前结点的左孩子. //加线索
 * 
 *   b)如果前驱结点的右孩子为当前结点，将它的右孩子重新设为空(恢复树的形状),输出当前结点    //访问结点，去线索(恢复)
 *     将当前结点更新为当前结点的右孩子.
 *     
 * 4.重复2、3步骤，直到curr为空.
 * 
 * Morris中序遍历很快 在LeetCode的Java提交中速度最快.beat 100% java coder.
 *
 */
public class MorrisInorder
{
    private List<Integer> inorderTraversal(TreeNode root) //Morris中序遍历，不用栈
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
					node.right = curr;//建立线索
					curr = curr.left;
				}
				else	//已经线索化，则访问结点，并删除线索
				{
					list.add(curr.val);//访问当前结点
					node.right = null; //删除线索
					prev = curr;
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
		
		MorrisInorder morrisorder = new MorrisInorder();
		
		result = morrisorder.inorderTraversal(root);
		
		
		for(int i = 0 ; i < result.size(); ++i)
		{
			System.out.print(result.get(i)+" ");
		}
	}

}
