package codingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval2
{
	int start;
	int end;
	Interval2() { start = 0; end = 0; }
	Interval2(int s, int e) { start = s; end = e; }
}

class Interval2Comparator implements Comparator<Interval2>
{
	@Override
	public int compare(Interval2 o1, Interval2 o2)
	{
		// TODO Auto-generated method stub
		return o1.start - o2.start;
	}
}

public class InsertInterval
{
    public List<Interval2> insert(List<Interval2> Interval2s, Interval2 newInterval2)
    {
    	Interval2s.add(newInterval2);
    	
    	if(Interval2s.size() <= 1)
		{
			return Interval2s;
		}
		
		Collections.sort(Interval2s, new Interval2Comparator());
		
		ArrayList<Interval2> result = new ArrayList<Interval2>();
		
		Interval2 prev = Interval2s.get(0);
		
		for(int i = 1 ; i < Interval2s.size(); i++)
		{
			Interval2 curr = Interval2s.get(i);
			
			if(prev.end >= curr.start)
			{
				Interval2 merge = new Interval2(prev.start, Math.max(prev.end, curr.end));
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
		List<Interval2> list = new ArrayList<Interval2>();
		
		list.add(new Interval2(1,2));
		list.add(new Interval2(3,5));
		list.add(new Interval2(6,7));
		list.add(new Interval2(8,10));
		list.add(new Interval2(12,16));
		
		Interval2 newOne = new Interval2(4,9);
		
		for(int k = 0 ; k < list.size(); k++)
		{
			System.out.print("["+list.get(k).start+","+list.get(k).end+"]"+"  ");
		}
		
		System.out.println();
		
		InsertInterval solution = new InsertInterval();
		
		List<Interval2> res = solution.insert(list , newOne);
		
		System.out.println("size="+res.size());
		
		for(int j = 0 ; j < res.size(); j++)
		{
			System.out.print("["+res.get(j).start+","+res.get(j).end+"]");
			System.out.println();
		}
			
	}

}
