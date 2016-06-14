package com.hypo.BitManipulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用位操作的方法不知道怎么做，只能用HashMap了
 * 使用位操作见SingleNumberIII2
 */
public class SingleNumberIII
{
    private int[] singleNumber(int[] nums) 
    {
    	int[] result = new int[2];
    	
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	
    	for(int i = 0 ; i < nums.length ; ++i)
    	{
    			if(hm.containsKey(nums[i]))
    			{
    				hm.remove(nums[i]);
    			}
    			else
    			{
    				hm.put(nums[i], 1);
    			}
    	}
    	
    	Set<Integer> set = hm.keySet();
    	Iterator<Integer> iterator = set.iterator();
    	int i = 0;
    	while(iterator.hasNext())
    	{
    		result[i++] = iterator.next();
    	}
        return result;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleNumberIII sn3 = new SingleNumberIII();
		
		int[] n = new int[]{1, 2, 1, 3, 2, 5};
		
		for(int i = 0 ; i < 2 ; ++i)
		{
			System.out.print(sn3.singleNumber(n)[i] + " ");
		}
		
	}

}
