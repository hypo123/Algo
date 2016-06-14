package codingInterview;

public class FirstMissingPositive
{
	public int firstMissingPositive(int[] nums)
	{
		if(nums.length == 0) return 1;
		for (int i = 0; i < nums.length; i++)
		{
			while (nums[i] != i)
			{
				if (nums[i] < 0 || nums[i] >= nums.length)
				{
					break;
				} 
				else
				{
					if(nums[i] == nums[nums[i]])
					{
						break;
					}
					else
					{
						int temp = nums[i];
						nums[i] = nums[temp];
						nums[temp] = temp;
					}
				}
			}
		}

		for (int j = 1; j < nums.length; j++)
		{
			if (nums[j] != j)
			{
				return j;
			}
		}

		return nums[0] == nums.length ? nums.length + 1 : nums.length;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		FirstMissingPositive fmp = new FirstMissingPositive();

		int[] nums = new int[] {0,1};
		System.out.println(fmp.firstMissingPositive(nums));

	}

}
