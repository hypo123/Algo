package com.hypo.Array;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram_T84
{
    public int largestRectangleArea(int[] height) 
    {
//    	双端队列也可用作 LIFO（后进先出）堆栈
    	Deque<Integer> stack = new LinkedList<Integer>();
    	
    	int maxArea = 0;
    	
    	for(int i = 0; i < height.length;)
    	{
    		if(stack.isEmpty() || height[i] > stack.peekFirst())
    		{
    			stack.addFirst(height[i]);
    			i++;
    		}
    		else
    		{
    			;
    		}
    	}
    	return maxArea;
    }
	public static void main(String[] args)
	{
		LargestRectangleInHistogram_T84 t84 = new LargestRectangleInHistogram_T84();
		
		int[] height = {2,1,5,6,2,3};//10
		int[] height2 = {1,1,1,1,1};//5
		int[] height3 = {1,2,3,4};//10
		
		System.out.println(t84.largestRectangleArea(height));
		System.out.println(t84.largestRectangleArea(height2));
		System.out.println(t84.largestRectangleArea(height3));
		
	}
}
