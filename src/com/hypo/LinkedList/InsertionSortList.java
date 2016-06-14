package com.hypo.LinkedList;

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}

public class InsertionSortList
{
	private ListNode insertionSortList(ListNode head)
	{
		if (head == null) return head;
		ListNode sentry = new ListNode(0); // 哨兵
		sentry.next = head;

		ListNode node = head.next; // 当前结点
		ListNode nodeprev = head;// 当前结点的前驱

		while (node != null)
		{
			ListNode nextnode = node.next;// 当前结点后继
			ListNode prevcurr = sentry; // 游标前驱
			ListNode curr = sentry.next; // 移动游标
			
			boolean flag = false;//当前结点需要移动

			while (curr != node)
			{
				if (node.val < curr.val)
				{
					nodeprev.next = nextnode;
					node.next = curr;
					prevcurr.next = node;
					flag = true;
					break;
				} 
				else
				{
					prevcurr = curr;
					curr = curr.next;
				}
			}
			if (!flag)
			{
				nodeprev = node;
			}

			node = nextnode;
		}
		return sentry.next;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		InsertionSortList is = new InsertionSortList();

		//建链表
		ListNode head = new ListNode(2);
		ListNode two = new ListNode(1);
		head.next = two;
		two.next = null;
		
		ListNode result = is.insertionSortList(head);
		
		while(result != null)//打印
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
