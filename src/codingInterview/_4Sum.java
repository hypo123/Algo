package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum
{
	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (nums.length < 4) return (List) result;

		Arrays.sort(nums);

		int len = nums.length;

		for (int i = 0; i < len - 3; i++)
		{
			// 避免重复
			if (i == 0 || nums[i] > nums[i - 1])
			{
				int left3 = target - nums[i];

				for (int j = i + 1; j < len - 2; j++)
				{
					// 避免重复
					if(j == 1 + i || nums[j] > nums[j-1])
					{
						int left4 = left3 - nums[j];
						int start = j + 1;

						int end = len - 1;

						while (start < end)
						{
							if ((nums[start] + nums[end]) == left4)
							{
								ArrayList<Integer> each = new ArrayList<Integer>();
								each.add(nums[i]);
								each.add(nums[j]);
								each.add(nums[start]);
								each.add(nums[end]);

								result.add(each);
								start++;
								end--;

								// 避免重复
								while (start < end && nums[end] == nums[end + 1])
								{
									end--;
								}
								while (start < end
										&& nums[start] == nums[start - 1])
								{
									start++;
								}
								continue;
							} else if (nums[start] + nums[end] > left4)
							{
								end--;
								continue;
							} else
							{
								start++;
							}
						}
					}
				}
			}
		}
		return (List) result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		_4Sum solution = new _4Sum();

		int[] nums = new int[] { -3,-2,-1,0,0,1,2,3 };
		int target = 0;

		ArrayList<ArrayList<Integer>> res = (ArrayList) solution.fourSum(nums,
				target);

		// System.out.println(res.size());

		for (int i = 0; i < res.size(); i++)
		{
			ArrayList<Integer> mid = res.get(i);

			for (int j = 0; j < mid.size(); j++)
			{
				System.out.print(mid.get(j) + " ");
			}

			mid.clear();

			System.out.println();
		}

	}

}
