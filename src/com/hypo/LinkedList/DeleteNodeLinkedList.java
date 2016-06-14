package com.hypo.LinkedList;

/**
 * 整个链表只给定一个结点，要求删除该结点。
 * 
 * 那么只能将该结点后边的所有结点的值依次赋给他们前一个结点.
 *
 */
public class DeleteNodeLinkedList
{
    private void deleteNode(ListNode node) 
    {
        ListNode curr = node.next;
        ListNode prev = node;
        
        while(curr != null)
        {
            node.val = curr.val;
            prev = node;
            node = curr;
            curr = curr.next;
        }
        prev.next = null;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DeleteNodeLinkedList dnll = new DeleteNodeLinkedList();

		//建链表
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		four.next = null;
		
		dnll.deleteNode(three);
		
		while(head != null)//打印
		{
			System.out.println(head.val);
			head = head.next;
		}
	}

}
