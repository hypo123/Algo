package com.hypo.Math;

//计算平面上两个矩形的所表示的面积(两个矩形的并 = 两个矩形面积之和 - 两个矩形的交)
public class RectangleArea_T223
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) 
    {
    	int area1 = (C - A) * (D - B);
    	int area2 = (G - E) * (H - F); 
    	
    	//重叠区域
    	int left = Math.max(A, E);
    	int right =  Math.min(C, G);
    	int bottom = Math.max(B, F);
    	int top = Math.min(D, H);
    	
    	int overlap = 0;
    	
    	//是否有重叠区域
    	if(right > left && top > bottom)
    	{	
    		overlap = (right - left) * (top - bottom);//重叠部分面积
    	}
    	
    	return area1 + area2 - overlap;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RectangleArea_T223 t223 = new RectangleArea_T223();
		
		int A = -3, B = 0, C = 3, D = 4 , E = 0, F = -1, G = 9, H = 2 ;
		
		int result = t223.computeArea(A, B, C, D, E, F, G, H);
		
		System.out.println(result);
	}

}
