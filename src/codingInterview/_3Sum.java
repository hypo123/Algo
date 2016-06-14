package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//超时

public class _3Sum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
    	List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(nums);
        
//        for(Integer s : nums)
//        {
//        	System.out.print(s + " ");
//        }
//        System.out.println();
        
        int len = nums.length;
       
        for(int i = 0 ; i < len - 2; i++)
        {
        	if(nums[i] > 0) break;
        	
        	for(int j = i + 1 ; j < len - 1 ; j++)
        	{
        		if(nums[i] + nums[j] > 0) break;
        		
        		for(int k = j + 1; k < len ; k++)
        		{
        			
        			if(nums[i] + nums[j] + nums[k] == 0)
        			{
        				if(nums[i] == nums[j] && nums[j] == nums[k]) break;
        				
        				ArrayList<Integer> each = new ArrayList<Integer>();
        				
        				each.add(nums[i]);
        				each.add(nums[j]);
        				each.add(nums[k]);
        				
        				if(!result.contains(each))
        				{
        					result.add(each);
        				}
        				
        			}
        		}
        	}
        }
        
        return (List)result;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		_3Sum solution = new _3Sum();
		
		int[] nums = new int[]{-1 ,0 ,1 ,2 ,-1 ,-4};
		
		ArrayList<ArrayList<Integer>> res = (ArrayList)solution.threeSum(nums);
		
//		System.out.println(res.size());
		
		for(int i = 0 ; i < res.size(); i++)
		{
			ArrayList<Integer> mid = res.get(i);
			
			
			for(int j = 0 ; j < mid.size(); j++)
			{
				System.out.print(mid.get(j)+" ");
			}
			
			mid.clear();
			
			System.out.println();
		}
	}

}
