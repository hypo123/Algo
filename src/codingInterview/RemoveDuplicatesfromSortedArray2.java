package codingInterview;

public class RemoveDuplicatesfromSortedArray2
{
    public int removeDuplicates(int[] nums)
    {
    	if(nums.length == 0) return 0;
    	int len = nums.length;
    	int same = 1;
    	int start = 0;
    	int delete = 0;
    	for(int i = 1 ; i < (len -= delete);)
    	{
    		delete = 0;
    		if(nums[i] == nums[start])
    		{
    			same++;
    			i++;
    			start++;
    		}
    		else
    		{
    			if(same > 2)
    			{
    				delete = same - 2;
    				int j = i;
    				while(j < len)
    				{
    					nums[j - delete] = nums[j];
    					j++;
    				}
    				i -= delete;
    				start -= delete;
    				start++;
    				i++;
    				same = 1;
    			}
    			else
    			{
    				i++;
    				start++;
    			}
    			same = 1;
    		}
    	}
    	
    	if(same > 2)
    	{
    		delete = same - 2;
    		len -= delete;
    	}
    	
        return len;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray2 rdfs2 = new RemoveDuplicatesfromSortedArray2();
		
		//int[] nums = new int[]{1,1,1,2,2,3,3,3,3,3,3,5};
		//int[] nums2 = new int[]{1,1,1,2,2,3};
		int[] nums3 = new int[]{1,1,1};
		
		System.out.println(rdfs2.removeDuplicates(nums3));
	}

}
