package com.hypo.StackAndHeap;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram_T84
{
    public int largestRectangleArea(int[] height) 
    {
    	Stack<Integer> stack = new Stack<Integer>();
    	int maxArea = 0;
    	
    	int[] height2 = Arrays.copyOf(height, height.length+1);
    	
    	for(int i = 0 ; i < height2.length; )
    	{
    		if(stack.isEmpty() || height2[i] > height2[stack.peek()])
    		{
    			stack.push(i++);
    		}
    		else
    		{
    			int index = stack.peek();
    			stack.pop();
    			maxArea = Math.max(maxArea, height2[index]*(stack.isEmpty() ? i : i - stack.peek()-1));
    		}
    	}
        return maxArea;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}

}
