package com.hypo.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII_T126
{
//	程序运行结果正确，但超时.--------------------------------------------------
    private List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) 
    {
    	ArrayList<ArrayList<String>> last = new ArrayList<ArrayList<String>>();
    	
    	ArrayList<ArrayList<String>>  res = new ArrayList<ArrayList<String>> ();
    	
    	
    	ArrayList<String> path = new ArrayList<String>();
    	
    	wordList.add(endWord);
    	
    	int[] minStep = new int[1];//变换最小长度.
    	minStep[0] = Integer.MAX_VALUE;
    	
    	generateLadder(beginWord , endWord , wordList , path , res ,minStep);
    	
    	for(int i = 0 ; i < res.size() ; ++i)
    	{
    		if(res.get(i).size() == minStep[0])
    		{
    			last.add(res.get(i));
    		}
    	}
        return (List)last;
    }
    
    private void generateLadder(String start ,String end , Set<String> wordList , ArrayList<String> path ,
    		ArrayList<ArrayList<String>> res ,int[] minStep)
    {
    	path.add(start);
    	
    	if(path.size() > minStep[0])//如果当前path比最小长度path大,return
    	{
    		return;
    	}
    	
		if (start.equals(end))// 终止条件.
		{
			minStep[0] = Math.min(minStep[0], path.size());
			res.add(new ArrayList<String>(path));
			return;
		}

		for(int i = 0 ; i < start.length(); ++i)
		{
			char[] curWordArr = start.toCharArray();
			
			for(char c = 'a' ; c <= 'z' ; ++c)
			{
				 curWordArr[i] = c ;
//				 String newWord = Arrays.toString(curWordArr);//BUG
				 String newWord = new String(curWordArr);
				 
				 if(newWord.equals(start)) continue;
				 
				 if(path.contains(newWord)) continue;
				 
				 if(wordList.contains(newWord))
				 {
					 generateLadder(newWord , end , wordList ,path , res , minStep);
					 
					 path.remove(path.size()-1);
				 }
			}
		}
    }
//-------------------------------------------------------------------   
    
// 方案二   ---------------------------------------------------------------
	public List<List<String>> findLadders2(String start, String end,
			Set<String> dict)
	{
		List<List<String>> ladders = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();

		dict.add(start);
		dict.add(end);

		bfs(map, distance, start, end, dict);

		List<String> path = new ArrayList<String>();

		dfs(ladders, path, end, start, distance, map);

		return ladders;
	}

	void dfs(List<List<String>> ladders, List<String> path, String crt,
			String start, Map<String, Integer> distance,
			Map<String, List<String>> map)
	{
		path.add(crt);
		if (crt.equals(start))
		{
			Collections.reverse(path);
			ladders.add(new ArrayList<String>(path));
			Collections.reverse(path);
		}
		else
		{
			for (String next : map.get(crt))
			{
				if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1)
				{
					dfs(ladders, path, next, start, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
			String start, String end, Set<String> dict)
	{
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		distance.put(start, 0);
		for (String s : dict)
		{
			map.put(s, new ArrayList<String>());
		}

		while (!q.isEmpty())
		{
			String crt = q.poll();

			List<String> nextList = expand(crt, dict);
			for (String next : nextList)
			{
				map.get(next).add(crt);
				if (!distance.containsKey(next))
				{
					distance.put(next, distance.get(crt) + 1);
					q.offer(next);
				}
			}
		}
	}

	List<String> expand(String crt, Set<String> dict)//扩展.
	{
		List<String> expansion = new ArrayList<String>();

		for (int i = 0; i < crt.length(); i++)
		{
			for (char ch = 'a'; ch <= 'z'; ch++)
			{
				if (ch != crt.charAt(i))
				{
					String expanded = crt.substring(0, i) + ch
							+ crt.substring(i + 1);
					if (dict.contains(expanded))
					{
						expansion.add(expanded);
					}
				}
			}
		}

		return expansion;
	}
//---------------------------------------------------------------------
	
//	方案三-------------------------------------------------------------------
	public List<List<String>> findLadders3(String start, String end,
			Set<String> dict)
	{
		Set<String> current = new HashSet<String>();//当前层
		Set<String> next = new HashSet<String>();//下一层
		Map<String , ArrayList<String>> father = new HashMap<String, ArrayList<String>>();//树
		
		boolean found = false;
		
		return null;
	}
//	--------------------------------------------------------------------
    public static void main(String[] args)
	{
    	WordLadderII_T126 wd126 = new WordLadderII_T126();
    	
		
		String start = "hit";
		String end = "cog";
		
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		
		ArrayList<ArrayList<String>> print = (ArrayList)wd126.findLadders2(start, end, wordDict);

		for (int i = 0; i < print.size(); ++i)
		{
			ArrayList<String> mid = print.get(i);

			for (int j = 0; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j) + " ");
			}

			System.out.println();
		}
	}
}
