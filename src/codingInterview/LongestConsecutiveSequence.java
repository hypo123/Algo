package codingInterview;

import java.util.Arrays;

public class LongestConsecutiveSequence
{
	public int longestConsecutive(int[] nums)
	{
		int len = nums.length;
		if(len <= 1) return len;
		
		int lon  = 1;
		int max = 1;
		
		Arrays.sort(nums);
		
		int start = nums[0] ;
		
		for(int i = 1 ; i < len; i++)
		{
			if(nums[i] == start)//处理接连重复数字 如 0 1 1 2
			{
				continue;
			}
			if(nums[i] == ++start)
			{
				lon++;
			}
			else
			{
				if(lon > max) max = lon;
				start = nums[i];
				lon = 1;
			}
		}
		
		if(lon > max) max = lon;
		
		return max;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1,2,0,1 };

		LongestConsecutiveSequence lss = new LongestConsecutiveSequence();

		System.out.println(lss.longestConsecutive(nums));
	}

}
