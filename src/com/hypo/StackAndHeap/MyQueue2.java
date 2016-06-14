package com.hypo.StackAndHeap;

import java.util.Stack;

/**
 * 也是使用双栈模拟队列. 
 * 
 */
public class MyQueue2
{
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> back = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x)
	{
		stack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop()
	{
		peek();
		back.pop();
	}

	// Get the front element.
	public int peek()
	{
		if(back.isEmpty())
		{
			while (!stack.isEmpty())
			{
				back.push(stack.pop());
			}
		}

		return back.peek();
	}

	// Return whether the queue is empty.
	public boolean empty()
	{
		return stack.isEmpty() && back.isEmpty();
	}
	
	public static void main(String[] args)
	{
		MyQueue2 que = new MyQueue2();
		que.push(1);
		que.push(2);
		que.peek();
		que.push(3);
		que.peek();
		
		while(!que.empty())
		{
			System.out.print(que.peek());
			que.pop();
		}
		
	}

}
