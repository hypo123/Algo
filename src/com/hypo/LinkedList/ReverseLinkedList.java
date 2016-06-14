package com.hypo.LinkedList;

/**
 * 翻转链表 
 * 遍历两遍链表
 */
public class ReverseLinkedList
{
    private ListNode reverseList(ListNode head) 
    {
    	if(head == null || head.next == null) return head;
    	
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode curr = head;
    	ListNode prev= head;
    	while(((prev = curr) != null) && ((curr=curr.next) != null)){}
    	ListNode last = prev;
    	ListNode end = null;
    	curr = dummy.next;
    	while(curr != last)
    	{
    		dummy.next = curr.next;
    		curr.next = end;
    		last.next = curr;
    		end = curr;
    		curr = dummy.next;
    	}
        return dummy.next;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseLinkedList rll = new ReverseLinkedList();

		//建链表
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		four.next = null;
		
		ListNode result = rll.reverseList(head);
		
		while(result != null)//打印
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
