package com.hypo.Tree;

import com.hypo.Utils.ListNode;

//将值递增的链表转换为BST
//采用分治法,但链表不能随机访问，不能像转化数组为BST一样.
public class ConvertSortedListtoBST_T109
{
//分治法，自顶向下，时间复杂度O(n^2),空间复杂度O(logn)-------------------------------
    public TreeNode sortedListToBST(ListNode head) 
    {
    	ListNode p = head;
    	int len = 0;
    	while(p != null)
    	{
    		len++;
    		p = p.next;
    	}
        return toBST(head , 0 , len - 1);
    }
    
    private TreeNode toBST(ListNode head , int start , int end)
    {
    	if(start > end) return null;
    	
    	int mid = start + ((end - start)>>1);
    	int index = start;
    	
    	ListNode now = head;
    	
//    	while(--index >= 0)//超时BUG
//    	{
//    		now = now.next;
//    	}
    	
    	while(++start <= mid)
    	{
    		head = head.next;
    	}

    	TreeNode node = new TreeNode(head.val);
    	
    	node.left = toBST(now , index , mid - 1);
//    	node.right = toBST(now , mid+1 , end);超时BUG
    	node.right = toBST(head.next , mid + 1, end);
    	
    	return node;
    }
//分治法，自底向上，时间复杂度O(n),空间复杂度O(logn)----------------------------------------------------
//    public TreeNode sortedListToBST2(ListNode head) 
//    {
//    	ListNode p = head;
//    	int len = 0;
//    	while(p != null)
//    	{
//    		len++;
//    		p = p.next;
//    	}
//        return toBST2(head , 0 , len - 1);
//    }
//    
//    private TreeNode toBST2(ListNode list , int start , int end)
//    {
//    	if(start > end) return null;
//    	int mid = start + ((end - start)>>1);
//    	
//    	TreeNode leftChild = toBST2(list, start, mid - 1);
//    	
//    	TreeNode parent = new TreeNode(list.val);
//    	
//    	parent.left = leftChild;
//    	
//    	list = list.next;
//    	
//    	TreeNode rightChild = toBST2(list, mid + 1, end);
//    	
//    	return parent;
//    }
    
//-------------------------------------------------------------------------------------------   
    public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建链表
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		four.next = null;
		
		ConvertSortedListtoBST_T109 t109 = new ConvertSortedListtoBST_T109();
		
		System.out.println(t109.sortedListToBST(head).val);
	}

}
