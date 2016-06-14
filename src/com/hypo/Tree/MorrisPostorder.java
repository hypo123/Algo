//package com.hypo.Tree;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Morris后序遍历
// * 
// *
// */
//public class MorrisPostorder
//{
//    private List<Integer> postorderTraversal(TreeNode root)
//    {
//		List<Integer> list = new ArrayList<Integer>();
//		
//		TreeNode dummy  = new TreeNode(0);
//		dummy.right = null;
//		TreeNode curr = null;
//		TreeNode prev = null;
//		
//		dummy.left = root;
//		curr = dummy;
//		
//		while(curr != null)
//		{
//			if(curr.left != null)
//			{
//				prev = curr;
//				curr = curr.right;
//			}
//			else
//			{
//				TreeNode node = curr.left;
//				
//				while(node.right != null && node.right != curr)
//				{
//					node = node.right;
//				}
//				
//				if(node.right == null)
//				{
//					node.right = curr;
//					prev = curr;
//					curr = curr.left;
//				}
//				else
//				{
//					visit_reverse(curr.left , prev);
//					
//					prev.right = null
//					prev = curr;
//					curr = curr.right;
//				}
//			}
//		}
//		
//		/**
//		 * 逆转路径
//		 */
//		private static TreeNode reverse(TreeNode from , TreeNode to)
//		{
//			TreeNode x  = from;
//			TreeNode y = to;
//			TreeNode z = null;
//			
//			if(from == to) return x;
//			
//			while( x != to)
//			{
//				z = y.right;
//				y.right = x;
//				x = y;
//				y = z;
//			}
//		}
//		
//		/**
//		 * 访问逆转后的路径上的所有结点
//		 */
//		private static void visit_reverse(TreeNode from , TreeNode to)
//		{
//			
//		}
//		
//		
//		
//		return list;
//    }
//	public static void main(String[] args)
//	{
//		// TODO Auto-generated method stub
//		//建树
//		TreeNode root = new TreeNode(1);
//		TreeNode right1 = new TreeNode(2);
//		root.right = right1;
//		TreeNode right1_left = new TreeNode(3);
//		right1.left = right1_left;
//		
//		
//		List<Integer> result = new ArrayList<Integer>();
//		
//		MorrisPostorder morrispostorder = new MorrisPostorder();
//		
//		result = morrispostorder.postorderTraversal(root);
//		
//		
//		for(int i = 0 ; i < result.size(); ++i)
//		{
//			System.out.print(result.get(i)+" ");
//		}
//	}
//
//}
