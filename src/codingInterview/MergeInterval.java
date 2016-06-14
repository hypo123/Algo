package codingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval
{
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<Interval>
{
	@Override
	public int compare(Interval o1, Interval o2)
	{
		// TODO Auto-generated method stub
		return o1.start - o2.start;
	}
}
public class MergeInterval
{
	public List<Interval> merge(List<Interval> intervals)
	{
		if(intervals == null || intervals.size() <= 1)
		{
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		Interval prev = intervals.get(0);
		
		for(int i = 1 ; i < intervals.size(); i++)
		{
			Interval curr = intervals.get(i);
			
			if(prev.end >= curr.start)
			{
				Interval merge = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merge;
			}
			else
			{
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		
		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Interval> list = new ArrayList<Interval>();
		
		list.add(new Interval(1,3));
		list.add(new Interval(2,6));
		list.add(new Interval(8,10));
		list.add(new Interval(15,18));
		
		for(int k = 0 ; k < list.size(); k++)
		{
			System.out.print("["+list.get(k).start+","+list.get(k).end+"]"+"  ");
		}
		
		System.out.println();
		
		MergeInterval solution = new MergeInterval();
		List<Interval> res = solution.merge(list);
		
		System.out.println("size="+res.size());
		for(int j = 0 ; j < res.size(); j++)
		{
			System.out.print("["+res.get(j).start+","+res.get(j).end+"]");
			System.out.println();
		}
				
	}

}
