package com.hypo.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//所给字符串长度可能不同，都是小写
public class GroupAnagrams_T49
{
//	-----------------------------超时--------------------------------
    private List<List<String>> groupAnagrams(String[] strs) 
    {
    	ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
    	//int stringlen = strs[0].length();
    	HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
    	LinkedList<String> path = new LinkedList<String>();
    	
    	for(int i = 0 ; i < strs.length ; i++)//遍历字符串数组
    	{
    		boolean flag = false;
    		
    		for(int k = 0 ; k < result.size() ; k++)//遍历result
    		{
    			LinkedList<String> ll = result.get(k);
    			
    			hm.clear();
    			
    			String first = ll.get(0);//取该链表第一个字符串
    			
    			if(first.length() == strs[i].length())
    			{
    				for(int j = 0 ; j < first.length() ; j++)
    				{
    					char c = first.charAt(j);
    					
    					if(hm.containsKey(c))
    					{
    						hm.put(c, hm.get(c)+1);
    					}
    					else
    					{
    						hm.put(c, 1);
    					}
    				}
    				
    				if(check(strs[i] , hm) == true)	//find
    				{
    					flag = true;
    					boolean f = false;
    					for(int j = ll.size()-1 ; j >= 0  ; j--)
    					{
    						if(strs[i].compareTo(ll.get(j)) >= 0)
    						{
    							ll.add(j+1, strs[i]);
    							result.set(k, ll);
    							f = true;
    							break;
    						}
    					}
    					
    					if(f == false)
    					{
    						ll.addFirst(strs[i]);
    						
    						result.set(k, ll);
    					}
    					break;
    				}
    			}
    		}
    		
    		if(flag == false)//result中没找到
    		{
    			path.add(strs[i]);
    			result.add(new LinkedList<String>(path));
    			path.clear();
    			flag = false;
    		}
    		else
    		{
    			hm.clear();
    		}

    	}
    	
    	return (List)result;
    }
    
    private boolean check(String s , HashMap<Character,Integer> hm)
    {
    	for(int i = 0 ; i < s.length() ; i++)
    	{
    		char c = s.charAt(i);
    		if(hm.containsKey(c))
    		{
    			if(hm.get(c)-1 == 0)
    			{
    				hm.remove(c);
    			}
    			else
    			{
    				hm.put(c, hm.get(c)-1);
    			}
    		}
    		else
    		{
    			return false;
    		}
    	}
    	return hm.size() == 0 ;
    }
//    --------------------------------------------------------------
    
//    ----------------------------AC----------------------------------
    private List<List<String>> groupAnagrams2(String[] strs)
    {
    	HashMap<String , LinkedList<String>> anagrams = new HashMap<String ,LinkedList<String>>();
    	
    	for(String s : strs)
    	{
    		String single = newString(s);
    		
    		if(anagrams.containsKey(single))
    		{
    			LinkedList<String> ll = anagrams.get(single);
    			
    			boolean find = false;
    			
				for(int j = ll.size()-1 ; j >= 0  ; j--)
				{
					if(s.compareTo(ll.get(j)) >= 0)
					{
						find = true;
						ll.add(j+1, s);
						anagrams.put(single, ll);
						break;
					}
				}
				
				if(find == false)
				{
					ll.addFirst(s);
					anagrams.put(single, ll);
				}
    		}
    		else
    		{
    			LinkedList<String> newGroup = new LinkedList<String>();
    			newGroup.add(s);
    			anagrams.put(single, newGroup);
    		}
    	}
    	
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	
    	for(Map.Entry<String, LinkedList<String>> group: anagrams.entrySet())
    	{
    		ArrayList<String> path = new ArrayList<String>();
    		path.addAll(group.getValue());
    		result.add(path);
    	}
    	
    	return (List)result;
    }
    
    private String newString(String s)//返回字符串s各字符按字典序排序形成的新字符串
    {
    	char[] charString = s.toCharArray();
    	Arrays.sort(charString);
    	return new String(charString);
    }
    
//    ---------------------------------------------------------------
	public static void main(String[] args)
	{
		GroupAnagrams_T49 t49 = new GroupAnagrams_T49();
		
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat","tea"};
		String[] str2 = {"tea","","eat","","tea",""};
		
		ArrayList<ArrayList<String>> print = (ArrayList)t49.groupAnagrams2(strs);
		
		for(int i = 0 ; i < print.size() ; ++i)
		{
			ArrayList<String> mid = print.get(i);
			
			System.out.print("[ ");
			for(int j = 0 ; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j) + "|");
			}
			System.out.println("]");
			
		}
	
		
	}
}
