package codingInterview;

import java.util.HashMap;

public class MajorityElement
{
    public int majorityElement(int[] nums) 
    {
    	int len = nums.length;
    	if(len == 1	) return nums[0];
    	int times = len >> 1;
    	
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	
    	for(int i = 0 ; i < len ; i++)
    	{
    		int mid = nums[i];
    		if(hm.containsKey(mid))
    		{
    			hm.put(mid, hm.get(mid)+1);
    			if(hm.get(mid) > times)
    			{
    				return mid;
    			}
    		}
    		else
    		{
    			hm.put(mid, 1);
    		}
    	}
        return 0;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MajorityElement me = new MajorityElement();
		
		int[] nums = new int[]{1,1,1,1,1,1,4,4,4,4,4,4,4};
		
		System.out.println(me.majorityElement(nums));
	}

}
