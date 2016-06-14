package codingInterview;

import java.util.ArrayList;
import java.util.List;
//使用动态规划解题   时间O(n*n) 空间O(n)
public class Triangle
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
    	
        int m = triangle.size();
        
        int n = triangle.get(m-1).size();
        
        int[] minSum = new int[n];
        
        for(int i = 0 ; i < n; i++)
        {
        	minSum[i] = triangle.get(m - 1).get(i);
        }
        
        for(int j = n-2 ; j >= 0 ; j--)
        {
        	List<Integer> mid = triangle.get(j);
        	
        	for(int t = 0 ; t < mid.size(); t++)
        	{
        		minSum[t] = Math.min(minSum[t],minSum[t+1]) + mid.get(t);
        	}
        }
        
        return minSum[0];
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<ArrayList<Integer>> triangle =new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> each1 = new ArrayList<Integer>();
		ArrayList<Integer> each2 = new ArrayList<Integer>();
		ArrayList<Integer> each3 = new ArrayList<Integer>();
		ArrayList<Integer> each4 = new ArrayList<Integer>();
		each1.add(2);
		triangle.add(each1);
		each2.add(3);
		each2.add(4);
		triangle.add(each2);
		each3.add(6);
		each3.add(5);
		each3.add(7);
		triangle.add(each3);
		each4.add(4);
		each4.add(1);
		each4.add(8);
		each4.add(3);
		triangle.add(each4);
		
		Triangle tri = new Triangle();
		System.out.println(tri.minimumTotal((List)triangle));
		
	}

}
