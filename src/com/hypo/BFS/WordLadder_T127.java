package com.hypo.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//BFS
public class WordLadder_T127
{
//	返回从start变化为end的所有过程单词的最小长度.
    public int ladderLength(String start, String end, Set<String> dict)
    {
        int step = Integer.MAX_VALUE;
		if(dict.size() == 0)//没有这种变换,返回0
		{
			return step = 0;
		}
		
		dict.add(end);
		
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> stepQueue = new LinkedList<Integer>();

		wordQueue.add(start);
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
				char[] currCharArr = currWord.toCharArray();
				
				for(char c = 'a' ; c <= 'z'; c++)
				{
					currCharArr[i] = c;
					
					String newWord = new String(currCharArr);
					
					if(dict.contains(newWord))
					{
						wordQueue.add(newWord);
						stepQueue.add(currStep + 1);
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
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WordLadder_T127 wd127 = new WordLadder_T127();
		
		String start = "hit";
		String end = "cog";
		
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		
		System.out.println(wd127.ladderLength(start, end, wordDict));
	}

}
