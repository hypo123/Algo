package com.hypo.LinkedList;

public class ReverseLinkedListII
{
    private ListNode reverseBetween(ListNode head, int m, int n)
    {
    	if(m == n) return head;
    	
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode first = dummy;
    	ListNode prevfirst = dummy;
    	int count = 0;
    	
    	while(count++ != m)
    	{
    		prevfirst = first;
    		first = first.next;
    	}
    	count--;
    	ListNode curr = first.next;
    	ListNode currnext = curr.next;
    	ListNode before = first;
    	
    	while(++count <= n)
    	{
    		first.next = currnext;
    		prevfirst.next = curr;
    		curr.next = before;
    		before = curr;
    		curr = currnext;
    		currnext = currnext.next;
    	}
    	return head;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseLinkedListII rll2 = new ReverseLinkedListII();

		//建链表  1->2->3->4->5
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(5);
		four.next = five;
		five.next = null;
		
		ListNode result = rll2.reverseBetween(head , 2 , 4);
		
		while(result != null)//打印
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
