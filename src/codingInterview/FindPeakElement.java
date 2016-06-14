package codingInterview;

public class FindPeakElement
{
    public int findPeakElement(int[] nums) 
    {
    	if(nums.length == 1) return 0;
    	int start = 0;
    	int end = nums.length - 1;
    	
    	while(start < end)
    	{
    		if(nums[start+1] > nums[start])
    		{
    			start++;
    		}
    		else
    		{
    			return start;
    		}
    		
    		if(nums[end] < nums[end - 1])
    		{
    			end--;
    		}
    		else
    		{
    			return end;
    		}
    	}
        return start;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		FindPeakElement fpe = new FindPeakElement();
		
		int[] nums = new int[]{1, 2, 3, 1};
		
		System.out.println(fpe.findPeakElement(nums));
	}

}
