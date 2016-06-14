package codingInterview;

//Rotate Array int Java
//1. Divide the array two parts: 1,2,3,4 and 5, 6
//2. Rotate first part: 4,3,2,1,5,6
//3. Rotate second part: 4,3,2,1,6,5
//4. Rotate the whole array: 5,6,1,2,3,4

//时间复杂度O(n),空间复杂度O(1)
public class RotateArray3
{
	public static void rotate(int[] arr, int k)
	{
		if(null == arr || k < 0)
		{
			throw new IllegalArgumentException("illegal argument");
		}
		
		if( k > arr.length)
		{
			k %= arr.length;
		}
		
		reverse(arr, 0 , arr.length-k-1);
		reverse(arr, arr.length-k , arr.length-1);
		reverse(arr, 0 , arr.length - 1);
		
		print(arr);
	}
	
	public static void reverse(int[] array , int begin , int end)
	{
		if(null == array || begin > end)
		{
			throw new IllegalArgumentException("illegal argument haha");
		}
		
		while(begin < end)
		{
			int temp = array[end];
			array[end] = array[begin];
			array[begin] = temp;
			begin++;
			end--;
		}
	}
	
	public static void print(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			System.out.print(array[i]+" ");
			
		}
	}
	public static void main(String[] args)
	{
		
		int[] arr = new int[]{1,2,3,4,5,6,7};
		
		int k = 3;
		
		RotateArray3.rotate(arr, k);
	}

}
