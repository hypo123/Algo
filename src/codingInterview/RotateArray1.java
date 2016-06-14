package codingInterview;
//Roate Array in Java
//使用中间数组
//空间复杂度O(n),时间复杂度O(n)
public class RotateArray1
{
	int[] result = null;
	public void rotate(int[] arr , int k)
	{
		if(k > arr.length)
		{
			k %= arr.length;
		}
		
		int[] copyarray = new int[arr.length];
		
		for(int i = 0 ; i < k ; i++)
		{
			copyarray[i] = arr[arr.length-k+i];
		}
		
		int s = 0;
		for(int j = k ; j < arr.length; j++)
		{
			copyarray[j] = arr[s];
			s++;
		}
		
		System.arraycopy(copyarray, 0, arr, 0, arr.length);
		
		this.result = arr;
		
		//this.print(arr);
		print(this.result);
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
		RotateArray1 solution = new RotateArray1();
		
		int[] arr = new int[]{1,2,3,4,5,6,7};
		
		int k = 3;
		
		solution.rotate(arr, k);
	}

}
