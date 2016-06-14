package codingInterview;
//Roate Array in Java
//类似冒泡排序
//空间复杂度O(1),时间复杂度O(n*k)
public class RotateArray2
{
	public void rotate(int[] arr , int k)
	{
		if(null == arr || k < 0)
		{
			throw new IllegalArgumentException("illegal Argument");
		}
		
		if(k > arr.length)
		{
			k %= arr.length;
		}
		
		for(int i = 0 ; i < k ; i++)
		{
			int temp = arr[arr.length-1];
			
			for(int j = arr.length-1 ; j > 0; j--)
			{
				arr[j] = arr[j-1];
			}
			
			arr[0] = temp;
		}
		
		print(arr);
	}
	
	public void print(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			System.out.print(array[i]+" ");
			
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RotateArray2 solution = new RotateArray2();
		
		int[] arr = new int[]{1,2,3,4,5,6,7};
		
		int k = 3;
		
		solution.rotate(arr, k);
	}

}
