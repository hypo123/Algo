package codingInterview;

import java.util.Arrays;

//太慢了
class MinStack
{
	private int[] array = new int[1024];
	private int index = -1;
	
    public void push(int x) 
    {
        if(index == array.length-1)
        {
        	array = Arrays.copyOf(array, array.length<<1);
        }
        array[++index] = x;
    }

    public void pop() 
    {
        if(index > -1)
        {
        	if(index == array.length>>1 && array.length > 1024)
        	{
        		array = Arrays.copyOf(array, array.length>>1);
        	}
        	index--;
        }
        
    }

    public int top() 
    {
        if(index > -1)
        {
        	return array[index];
        }
        else
        {
        	return 0;
        }
    }

    public int getMin() 
    {
        int min = Integer.MAX_VALUE;
        
        for(int i = index ; i >=0 ;i--)
        {
        	if(array[i] < min)
        	{
        		min = array[i];
        	}
        }
        
        return min;
    }
}

public class MinStackTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
