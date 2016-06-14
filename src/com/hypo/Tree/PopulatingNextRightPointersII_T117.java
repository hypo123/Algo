package com.hypo.Tree;

import com.hypo.Utils.TreeLinkNode;

//给任意二叉树中每个结点添加引用，指向其同一层中右边的结点.
//要求使用常数空间.
public class PopulatingNextRightPointersII_T117
{
//递归版，时间复杂度O(n),空间复杂度O(1)-------------------------------------------------------------------
    private void connect(TreeLinkNode root)
    {
    	if(root == null) return;
    	
        TreeLinkNode dummy = new TreeLinkNode(-1);
        
        for(TreeLinkNode curr = root, prev = dummy ; curr != null ; curr = curr.next)
        {
        	if(curr.left != null)
        	{
        		prev.next = curr.left;
        		prev = prev.next;
        	}
        	
        	if(curr.right != null)
        	{
        		prev.next = curr.right;
        		prev = prev.next;
        	}
        }
        
        connect(dummy.next);
        
    }
//迭代版，时间复杂度O(n),空间复杂度O(1)--------------------------------------------------------------------
    private void connect2(TreeLinkNode root)
    {
    	TreeLinkNode next = null;//下一层的第一个结点.
    	TreeLinkNode prev = null;//同一层的前一个结点.
    	
    	while(root != null)
    	{
    		for( ; root != null	 ; root = root.next )
    		{
    			System.out.println(root.val);
    			if(next == null) next = ((root.left != null) ? root.left : root.right);
    			
    			if(root.left != null)
    			{
    				if(prev == null)
    				{
    					prev = root.left;
    				}
    				else
    				{
    					prev.next = root.left;
    					prev = prev.next;
    				}
    			}
    			
    			if(root.right != null)
    			{
    				if(prev == null)
    				{
    					prev = root.right;
    				}
    				else
    				{
    					prev.next = root.right;
    					prev = prev.next;
    				}
    			}
    		}
    		
    		root = next;//转到下一层.
    		prev = null;
    		next = null;
    	}
    }
//------------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
//	      1
//		 /  \
//	     2   3
//		/	/
//	   4    5
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode l11 = new TreeLinkNode(2);
		TreeLinkNode l12 = new TreeLinkNode(3);
		root.left = l11;
		root.right = l12;
		TreeLinkNode l21 = new TreeLinkNode(4);
		l11.left = l21;
		TreeLinkNode l22 = new TreeLinkNode(5);
		l12.left = l22;
		
		PopulatingNextRightPointersII_T117 t117 = new PopulatingNextRightPointersII_T117();
		
		t117.connect2(root);
	}

}
