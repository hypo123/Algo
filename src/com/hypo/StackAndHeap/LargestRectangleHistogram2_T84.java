package com.hypo.StackAndHeap;

import java.util.Stack;

public class LargestRectangleHistogram2_T84
{
    public int largestRectangleArea(int[] heights) 
    {
    	Stack<Integer> stack = new Stack<Integer>();//存数组下标.
    	
    	int maxArea = 0;
    	
    	for(int i = 0 ; i <= heights.length ;)
    	{
    		if(stack.isEmpty() || (i != heights.length && heights[stack.peek()] < heights[i]))
    		{
    			stack.push(i++);
    		}
    		else
    		{
    			int index = stack.pop();//做最小值
    			
    			maxArea = Math.max(maxArea, heights[index] * (stack.isEmpty() ? i : i - stack.peek() - 1 ));
    		}
    	}
    	
    	return maxArea;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
}
