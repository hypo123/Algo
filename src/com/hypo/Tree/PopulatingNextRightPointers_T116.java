package com.hypo.Tree;
import java.util.LinkedList;

import com.hypo.Utils.TreeLinkNode;

//给完全二叉树中每个结点添加引用，指向其同一层中右边的结点.通过层次遍历可解决.
//这个实现不是完全二叉树也可以.即也使用与T117
//题目要求是常数空间，这个实现不是常数空间.
public class PopulatingNextRightPointers_T116
{
    public void connect(TreeLinkNode root) 
    {
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	
    	if(root == null) return ;
    	
    	queue.add(root);
    	int prev = 1;//上一层结点个数
    	int curr = 0;//当前层结点个数.
    	int reprev = 1;
    	TreeLinkNode prevnode = root;
    	while(!queue.isEmpty())
    	{
    		TreeLinkNode now = queue.poll();
    		
    		if(prev == reprev)//now是一层中第一个结点.
    		{
    			prevnode = now;
    		}
    		else
    		{
    			prevnode.next = now;
    			prevnode = now;
    		}
    			
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
    			now.next = null;//now是一层中最后一个结点.
    			prev = curr;//下一层的几点个数确定，赋给prev
    			reprev = curr;
    			curr  = 0;
    		}
    	}
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
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode l11 = new TreeLinkNode(2);
		TreeLinkNode l12 = new TreeLinkNode(3);
		root.left = l11;
		root.right = l12;
		TreeLinkNode l21 = new TreeLinkNode(5);
		l12.left = l21;
		
		PopulatingNextRightPointers_T116 t116 = new PopulatingNextRightPointers_T116();
		
		t116.connect(root);
	}

}
