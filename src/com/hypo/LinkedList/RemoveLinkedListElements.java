package com.hypo.LinkedList;

public class RemoveLinkedListElements
{
    public ListNode removeElements(ListNode head, int val)
    {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode prev = dummy;
    	ListNode curr = head;
    	
    	while(curr != null)
    	{
    		if(curr.val == val)
    		{
    			ListNode tmp = curr;
    			prev.next = curr.next;
    			curr = curr.next;
    			tmp.next = null;
    		}
    		else
    		{
    			prev = curr;
    			curr = curr.next;
    		}
    	}
    	
        return dummy.next;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RemoveLinkedListElements rlle = new RemoveLinkedListElements();
		
		//建链表
		ListNode head = new ListNode(6);
		ListNode two = new ListNode(3);
		head.next = two;
		ListNode three = new ListNode(6);
		two.next = three;
		ListNode four = new ListNode(6);
		three.next = four;
		four.next = null;
		
		ListNode  result = rlle.removeElements(head, 6);
		
		while(result != null)
		{
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

}
