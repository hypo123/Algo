package codingInterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _3SumClosest
{
	public int threeSumClosest(int[] nums, int target)
	{
		Arrays.sort(nums);
		int result = Integer.MAX_VALUE;
		int len = nums.length;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < len - 2; i++)
		{
			int start = i + 1;
			int end = len - 1;

			while (start < end)
			{
				int sum = nums[i] + nums[start] + nums[end];
				
				int diff = Math.abs(sum - target);

				if (diff == 0)
				{
					result = sum;
					return result;
				}
				
				if (diff < min)
				{
					min = diff;
					result = sum;
				}

				if (sum > target)
				{
					end--;
					continue;
				} else
				{
					start++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		_3SumClosest solution = new _3SumClosest();

		int[] nums = new int[] { 0,1,2 };

		int target = 3;

		System.out.println(solution.threeSumClosest(nums, target));
	}
}
