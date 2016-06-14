package com.hypo.StackAndHeap;

import java.util.Stack;

/**
 * 使用双栈模拟队列. 
 * 入队列时，如果stack不为空，那么stack里的元素依次退栈，并以退栈的顺序依次进back栈，
 * 然后将要如队列的元素压入back栈，再将back栈的元素依次退栈，并以退栈的顺序依次进stack栈.
 * 那么stack栈内从底到顶的顺序就是元素入队列的顺序.
 * 
 */

//push to top, peek/pop from top, size, and is empty
class MyQueue
{
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> back = new Stack<Integer>();
	// Push element x to the back of queue.
	public void push(int x)
	{
		if(stack.isEmpty())
		{
			stack.push(x);
		}
		else
		{
			while(!stack.isEmpty())//从stack移到back
			{
				back.push(stack.pop());
			}
			
			back.push(x);
			
			while(!back.isEmpty())//从back移到stack
			{
				stack.push(back.pop());
			}
		}
	}

	// Removes the element from in front of queue.
	public void pop()
	{
		stack.pop();
	}

	// Get the front element.
	public int peek()
	{
		return stack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty()
	{
		return stack.isEmpty();
	}
	
	//test
	public static void main(String[] args)
	{
		MyQueue queq = new MyQueue();
		queq.push(1);
		queq.push(2);
		queq.peek();
		queq.push(3);
		queq.peek();
		
		while(!queq.empty())
		{
			System.out.print(queq.peek());
			queq.pop();
		}
		
	}
}