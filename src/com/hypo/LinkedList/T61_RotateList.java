package com.hypo.LinkedList;

public class T61_RotateList
{
    private ListNode rotateRight(ListNode head, int k) 
    {
    	if(head == null) return head;
    	
    	ListNode dummy = new ListNode(Integer.MIN_VALUE);//哨兵
    	dummy.next = head;
    	
    	ListNode fast = head;
    	ListNode slow = head;

    	ListNode cusor = head;
    	int countnode = 0;//链表长度
    	while(cusor != null)
    	{
    		countnode++;
    		cusor = cusor.next;
    	}
    	
    	int count = k % countnode;
    	
    	while(--count >= 0)//使fast指针指向顺数第(k%countnode)个结点的下一个结点
    	{
    		if(fast == null) return dummy.next;
    		fast = fast.next;
    	}
    	
     	if(fast == null) return dummy.next ;
    	
    	while(fast.next != null)//快慢指针使slow指向倒数第(k%countnode)个结点的前一个结点
    	{
    		fast = fast.next;
    		slow = slow.next;
    	}
    			
    	fast.next = dummy.next;
    	
    	dummy.next = slow.next;
    	
    	slow.next = null;
    	
        return dummy.next;
    }
    
//  test
	public static void main(String[] args)
	{
		T61_RotateList tt61 = new T61_RotateList();
		//建链表 1->2->3->4->5->6->null
		ListNode head = new ListNode(1);
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
		
		int k  = 14;
		
		ListNode result = tt61.rotateRight(head, k);
		
		while(result != null)//打印
		{
			System.out.print(result.val +"->");
			result = result.next;
		}
	}
}
