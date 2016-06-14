package com.hypo.LinkedList;

/**
 * 翻转链表
 * 只需遍历一次，每碰到一个结点，则将其插入到dummy后面，直到全部插完. 
 *
 */
public class ReverseLinkedList2
{
    private ListNode reverseList(ListNode head) 
    {
    	if(head == null || head.next == null) return head;
    	
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode curr = head;
    	ListNode currnext = head.next;
    	ListNode before = head;
    	
    	while(curr != null)
    	{
    		head.next = currnext;
    		
    		curr.next = before;
    		dummy.next = curr;
    		before = curr;
    		
    		curr = currnext;
    		if(curr == null) break;
    		currnext = currnext.next;
    	}
    	
        return dummy.next;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseLinkedList2 rll22 = new ReverseLinkedList2();

		//建链表
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		four.next = null;
		
		ListNode result = rll22.reverseList(head);
		
		while(result != null)//打印
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
