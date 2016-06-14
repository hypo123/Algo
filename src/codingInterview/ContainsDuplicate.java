package codingInterview;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate
{
    public boolean containsDuplicate(int[] nums)
    {
    	if(nums.length == 0) return false;
    	Set<Integer> hs = new HashSet<Integer>();
    	
    	for(int i = 0 ; i < nums.length; i++)
    	{
    		if(hs.contains(nums[i]))
    		{
    			return true;
    		}
    		else
    		{
    			hs.add(nums[i]);
    		}
    	}
        return false;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ContainsDuplicate cd = new ContainsDuplicate();
		int[] nums = new int[]{1 ,2 ,3 ,4 ,7 ,5,7};
		System.out.println(cd.containsDuplicate(nums));
	}
	
}
