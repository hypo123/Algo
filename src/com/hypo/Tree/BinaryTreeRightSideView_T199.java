package com.hypo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.hypo.Utils.TreeNode;

public class BinaryTreeRightSideView_T199
{
//	可以看见右边的，但如果右边没有，就可以看见左边的.可看见每一层的最右边那个结点.可用层次遍历
    private List<Integer> rightSideView(TreeNode root) 
    {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if(root == null) return res;
    	
    	queue.add(root);
    	int prev = 1;//上一层结点个数
    	int curr = 0;//当前层结点个数.
    	while(!queue.isEmpty())
    	{
    		TreeNode now = queue.poll();
    		
    		if(now.left != null) 
    		{
    			curr++;
    			queue.add(now.left);
    		}
    		if(now.right != null)
    		{
    			curr++;
    			queue.add(now.right);
    		}
    		
    		if(--prev == 0)//上一层结点处理完了
    		{
    			res.add(now.val);//上一层结点的最后一个添加到结果
    			prev = curr;//下一层的几点个数确定，赋给prev
    			curr  = 0;
    		}
    	}
        return res;
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
		TreeNode l11 = new TreeNode(2);//p
		TreeNode l12 = new TreeNode(3);
		root.left = l11;
		root.right = l12;
		TreeNode l21 = new TreeNode(5);//q
		l12.left = l21;
		
		BinaryTreeRightSideView_T199 t199 = new BinaryTreeRightSideView_T199();
		
		ArrayList<Integer> print = (ArrayList)t199.rightSideView(root);
		
		for(Integer n : print)
		{
			System.out.print(n + " ");
		}
	}

}
