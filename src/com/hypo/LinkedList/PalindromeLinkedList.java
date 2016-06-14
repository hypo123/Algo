package com.hypo.LinkedList;

import java.util.Stack;
/**
 *  判断链表是否是回文的.
 *  链表前一半入栈，然后开始后一半的遍历，每遍历一个节点，栈中弹出一个元素与该结点值比较.
 */
public class PalindromeLinkedList
{
    public boolean isPalindrome(ListNode head) 
    {
    	if(head == null || head.next == null) return true;
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	stack.push(slow.val);
//    	使用快慢指针，找到链表的中点.
    	while(fast.next != null && fast.next.next != null)
    	{
    		slow = slow.next;
    		stack.push(slow.val);
    		fast = fast.next.next;
    	}
    	
    	ListNode mark = fast;
    	if(mark.next == null) //说明原链表结点个数为奇数个，stack栈顶元素丢弃.
    	{
    		stack.pop();
    	}
    	fast = slow;
    	slow = slow.next;//链表后半部分.
    	fast.next = null;//一开始出错，是在这里，有可能前面的fast = slow,则此句将使mark.next = null;
    	
    	while(slow != null )
    	{
    		if(slow.val != stack.pop())
    		{
    			return false;
    		}
    		else
    		{
    			slow = slow.next;
    		}
    	}
        return true;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建链表
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
//		two.next = null;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(2);
		three.next = four;
		ListNode five = new ListNode(1);
		four.next = five;
		five.next = null;
		
		PalindromeLinkedList pll = new PalindromeLinkedList();
		
		System.out.println(pll.isPalindrome(head));
	}

}
