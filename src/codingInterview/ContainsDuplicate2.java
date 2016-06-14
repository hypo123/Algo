package codingInterview;

import java.util.HashMap;

public class ContainsDuplicate2
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	
    	for(int i = 0 ; i < nums.length; i++)
    	{
    		int diff = Integer.MAX_VALUE;
    		if(hm.containsKey(nums[i]))
    		{
    			diff = i - hm.get(nums[i]);
    			hm.remove(nums[i]);
    			hm.put(nums[i], i);
    			if(diff <= k) return true;
    		}
    		else
    		{
    			hm.put(nums[i], i);
    		}
    	}
        return false;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,2,5,6,7,8,9,4};
		int k = 1;
		
		ContainsDuplicate2 cd2 =new ContainsDuplicate2();
		
		System.out.println(cd2.containsNearbyDuplicate(nums, k));
		
	}

}
