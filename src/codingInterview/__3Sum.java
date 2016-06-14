package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __3Sum
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
    	List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if(nums.length < 3) return (List)result;
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0; i < nums.length - 2; i++)
    	{
    		if(nums[i] > 0 ) break;
    		
    		//避免重复
    		if(i == 0 || nums[i] > nums[i-1])
    		{
        		int left = -nums[i];
        		int start = i + 1;
        		
        		int end = nums.length - 1;
        		
        		while(start < end)
        		{
        			if((nums[start] + nums[end]) == left)
        			{
        				ArrayList<Integer> each = new ArrayList<Integer>();
        				each.add(nums[i]);
        				each.add(nums[start]);
        				each.add(nums[end]);
        				
       					result.add(each);
        				start++;
        				end--;
        			
        				//避免重复
        				while(start < end && nums[end] == nums[end+1])
        				{
        					end--;
        				}
        				while(start < end && nums[start] == nums[start-1])
        				{
        					start++;
        				}
        				continue;
        			}
        			else if(nums[start] + nums[end] > left)
        			{
        				end--;
        				continue;
        			}
        			else
        			{
        				start++;
        			}
        		}
    		}
    	}
    	
    	return (List)result;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		__3Sum solution = new __3Sum();
		
		int[] nums = new int[]{-2,0,1,1,2};
		
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
