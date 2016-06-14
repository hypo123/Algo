package com.hypo.LinkedList;

public class RotateList_T61
{
	//注意k的值可能比链表长还要大
    private ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        int sec = -k-1;

        int count = -1;//记结点个数

        ListNode curr = dummy;
        ListNode prev = dummy;

        while(curr != null)
        {
            curr = curr.next;
            count++;

            if(sec < 0)
            {
                sec++;
            }
            else
            {
                prev = prev.next;
            }
        }

        if(sec == 0 && prev == dummy)
        {
            return dummy.next;
        }

        if(sec < 0)
        {
            sec = -(k % count)-1;
            curr = dummy;
            prev = dummy;

            while(curr != null)
            {
                curr = curr.next;

                if(sec < 0)
                {
                    sec++;
                }
                else
                {
                    prev = prev.next;
                }
            }
        }


        ListNode now = dummy;//在该结点后插入

        ListNode leftCurr = prev.next;//当前游标

        while(leftCurr != null)
        {
            prev.next = leftCurr.next;

            ListNode nextNode = now.next;
            now.next = leftCurr;
            leftCurr.next = nextNode;
            now = leftCurr;

            leftCurr = prev.next;
        }

        return dummy.next;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RotateList_T61 t61 = new RotateList_T61();
		
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
		
		int k  = 13;
		
		ListNode result = t61.rotateRight(head, k);
		
		while(result != null)//打印
		{
			System.out.print(result.val +" -> ");
			result = result.next;
		}
	}

}
