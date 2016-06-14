package com.hypo.LinkedList;

/**
 *Given a singly linked list, group all odd nodes together followed by the even nodes. 
 *Please note here we are talking about the node number and not the value in the nodes.
 *就地完成.O(1)空间复杂度O(nodes)时间复杂度. 
 *
 */

public class OddEvenLinkedList_T328
{
    public ListNode oddEvenList(ListNode head) 
    {
    	ListNode slow = head;
    	
    	if(slow == null || slow.next == null)  return slow;
    	
    	ListNode odd = slow;
    	ListNode even = slow.next;
    	ListNode prev = slow;
    	
    	slow = slow.next.next;
    	
    	ListNode odddummy = new ListNode(-1);
    	odddummy.next = odd;//奇数
    	
    	
    	ListNode evendummy = new ListNode(-2);
    	evendummy.next = even;//偶数
    	
    	
    	while(slow != null)
    	{
    		odd.next = slow;
    		odd = odd.next;
    		
    		prev = slow;
    		
    		even.next = slow.next;//偶数
    		
    		even = even.next;

    		if(even == null)
    		{
    			break;
    		}
    		
    		slow = slow.next.next;//奇数
    	}
    	
    	prev.next = evendummy.next;
    	
    	return odddummy.next;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		OddEvenLinkedList_T328 t328 = new OddEvenLinkedList_T328();
		
		//建链表
		ListNode head = new ListNode(1);
//		head.next = null;
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(5);
		four.next = five;
		ListNode six = new ListNode(6);
		five.next = six;
		six.next = null;

		ListNode result = t328.oddEvenList(head);
		
		while(result != null)//打印
		{
			System.out.println(result.val);
			result = result.next;
		}
		
	}

}
