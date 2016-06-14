package com.hypo.Sort;

import com.hypo.Utils.*;

/**
 * 链表的归并排序. 时间复杂度O(nlgn)
 */
public class SortList
{
    private ListNode sortList(ListNode head) 
    {
    	if(head == null || head.next == null) return head;
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	//快慢指针找到中间结点.
    	while(fast.next != null && fast.next.next != null)
    	{
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	//断开链表
    	fast = slow;
    	slow = slow.next;
    	fast.next = null;
    	
    	ListNode l1 = sortList(head);//前半段排序
    	ListNode l2 = sortList(slow);//后半段排序.

    	return merge(l1, l2);
    }
    
    //合并.
    private ListNode merge(ListNode l1 , ListNode l2)
    {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = null;
    	ListNode cur = dummy;
    	
    	while(l1 != null && l2 != null)
    	{
    		if(l1.val <= l2.val)
    		{
    			cur.next = l1;
    			l1 = l1.next;
    		}
    		else
    		{
    			cur.next = l2;
    			l2 = l2.next;
    		}
    		
    		cur = cur.next;
    	}
    	
    	if(l1 != null)
    	{
    		cur.next = l1;
    	}
    	
    	if(l2 != null)
    	{
    		cur.next = l2;
    	}
    	
    	return dummy.next;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建链表
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(3);
		head.next = two;
		ListNode three = new ListNode(5);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		four.next = null;
		
		SortList sl = new SortList();
		
		ListNode result = sl.sortList(head);
		
		while(result != null)//打印
		{			
			System.out.print(result.val+" ");
			result = result.next;
		}
		
	}

}
