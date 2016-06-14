package com.hypo.Array;
/*
Given n non-negative integers a1, a2, ..., an, 
	where each represents a point at coordinate (i, ai).
	n vertical lines are drawn such that the two endpoints of line i is at (i, ai) 
	and (i, 0). Find two lines, which together with x-axis forms a container,
	such that the container contains the most water.
	Note: You may not slant the container.
	题意是有个高度数组，就相当于隔板的高度，求数组中任意两隔板间盛水的最大量。隔板间的距离与较低隔板的高度乘积即为盛水的容量。
*/
public class ContainerWithMostWater_T11
{
  /*用两个指针从两端开始向中间靠拢，如果左端线段短于右端，那么左端右移，
	反之右端左移，知道左右两端移到中间重合，记录这个过程中每一次组成木桶的容积，返回其中最大的*/
    public int maxArea(int[] height) 
    {
    	int low = 0 , high = height.length - 1;
    	if(height.length < 2) return 0;
    	int area = -1;
    	while(low < high)
    	{
    		int temparea = Math.min(height[high], height[low]) * (high - low);
    		
    		area = (temparea > area) ? temparea : area;
    		
    		if(height[low] < height[high]) low++;
    		else high--;
    	}
    	
        return area;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ContainerWithMostWater_T11 t11 = new ContainerWithMostWater_T11();
		
		int[] height = {1,4,7,2,9};
		int[] height2 = {1,2};
		int[] height3 = {1};
		
		System.out.println(t11.maxArea(height));
		System.out.println(t11.maxArea(height2));
		
	}

}
