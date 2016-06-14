package codingInterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//BFS
public class WordLadder
{
	public int ladderLength(String start, String end, Set<String> dict)
	{
		int step = Integer.MAX_VALUE;
		if(dict.size() == 0)
		{
			return step = 0;
		}
		
		dict.add(end);
		
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> stepQueue = new LinkedList<Integer>();

		wordQueue.add(start);
		System.out.println(start);
		stepQueue.add(1);
		
		while(!wordQueue.isEmpty())
		{
			String currWord = wordQueue.pop();
			Integer currStep = stepQueue.pop();
			
			if(currWord.equals(end))
			{
				step = Math.min(currStep, step);
			}
			
			for(int i = 0 ; i < currWord.length(); i++)
			{
				System.out.println();//
				
				char[] currCharArr = currWord.toCharArray();
				
				for(char c = 'a' ; c <= 'z'; c++)
				{
					currCharArr[i] = c;
					
					String newWord = new String(currCharArr);
					
					if(dict.contains(newWord))
					{
						wordQueue.add(newWord);
						stepQueue.add(currStep + 1);
						System.out.print(newWord+"+"+(currStep+1)+" ");//test
						dict.remove(newWord);
					}
				}
			}//for
			
		}//while
		
		if(step < Integer.MAX_VALUE)
		{
			return step;
		}
		else
		{
			return 0;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");	
		
		int step = -1;
		step = wl.ladderLength(start, end, dict);
		
		System.out.println(step);
	}

}
