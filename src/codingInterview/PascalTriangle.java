package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle
{
	public List<List<Integer>> generate(int numRows)
	{
		List<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		if (numRows < 1) return (List)triangle;
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(1);
		triangle.add(first);

		for (int i = 1; i < numRows; i++)
		{
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++)
			{
				int up1 = 0;
				int up2 = 0;
				if (j - 1 > -1 && j < i )
				{
					up1 = triangle.get(i - 1).get(j - 1);
					up2 = triangle.get(i - 1).get(j);
				} else if (j - 1 > -1 && j == i )
				{
					up1 = triangle.get(i - 1).get(j - 1);
				} else if (j - 1 == -1 && j < i )
				{
					up2 = triangle.get(i - 1).get(j);
				}
				al.add(up1 + up2);
			}

			triangle.add(al);
		}
		return (List) triangle;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PascalTriangle pt = new PascalTriangle();

		int num = 10;

		List<ArrayList<Integer>> result = (List) pt.generate(num);

		for (int i = 0; i < result.size(); i++)
		{
			for (int j = 0; j < result.get(i).size(); j++)
			{
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
