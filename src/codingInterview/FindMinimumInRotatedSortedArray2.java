package codingInterview;

public class FindMinimumInRotatedSortedArray2
{
	public int findMin(int[] nums)
	{
		int start = 0;
		int end = nums.length - 1;

		while (start < end)
		{
			if (nums[start] == nums[start + 1])
			{
				start++;
			}

			if (nums[end] >= nums[end - 1])
			{
				end--;
			}
			else
			{
				if (nums[end - 1] >= nums[nums.length - 1])
				{
					return Math.min(nums[0], nums[end]);
				} else
				{
					end--;
				}
			}
		}
		return nums[start];
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		FindMinimumInRotatedSortedArray2 fmirsa = new FindMinimumInRotatedSortedArray2();

		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(fmirsa.findMin(nums));
	}

}
