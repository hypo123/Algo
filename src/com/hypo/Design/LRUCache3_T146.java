package com.hypo.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *	LinkedHashMap
 */
public class LRUCache3_T146
{
	LinkedHashMap<Integer, Integer> cache;
	
	public LRUCache3_T146(final int capacity)
	{
		cache = new LinkedHashMap<Integer,Integer>()
			{
				@Override
				//重写removeEldestEntry方法返回true值指定插入元素时移除最老的元素
				//最老元素指最先插入的元素.
				protected boolean removeEldestEntry(
						java.util.Map.Entry<Integer, Integer> eldest)
				{
					if(cache.size() > capacity)
					{
						return true;
					}
					return false;
				}
			};
	}
	
	private void moveToHead(int key)
	{
		int val = cache.get(key);
		cache.remove(key);
		//删除后重新插入使其在链表末尾.(最新)
		cache.put(key, val);
	}
	
	public int get(int key)
	{
		
		if(cache.containsKey(key))
		{
			int val = cache.get(key);
			
			//把新查出来的元素放在末位
			moveToHead(key);
			
			return val;
			
		}
		return -1;
	}
	
    public void set(int key, int value)
    {
		cache.put(key, value);
		moveToHead(key);
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	String input = "3, [set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),"
    			+ "get(2),get(3),get(4),get(5)]";
    	
//    	String input = "1,[set(2,1),get(2),set(3,2),get(2),get(3)]";
    	
    	int capacity = Integer.parseInt(input.substring(0 , input.indexOf(",")));
    	
    	System.out.println(capacity);
    	
    	LRUCache3_T146 test  = new LRUCache3_T146(capacity);
    	
    	String operation = input.substring(input.indexOf("["), input.lastIndexOf("]")+1);
    	
    	String[] oper = input.split("(\\[)|(\\)\\,)|(\\])");
    	
    	for(int j = 1; j < oper.length; j++)
    	{
    		
    		String i = oper[j];
    		String step = i.substring(0 , 3);
    		
    		if(step.equals("set"))
    		{
    			String[] num = i.substring(i.indexOf("(")+1).split("\\,");
    			
    			int key = Integer.parseInt(num[0]) ;
    			int value = Integer.parseInt(num[1]);
    			
    			System.out.println("set["+key+","+value+"]");
    			
    			test.set(key , value );
    		}
    		else//get
    		{
    			int key = -1;
    			int start = i.indexOf("(");
    			int end = i.indexOf(")");
    			
    			if(end < 0)
    			{
    				key = Integer.parseInt(i.substring(start+1));
    			}
    			else
    			{
    				key = Integer.parseInt(i.substring(start+1, end));
    			}
    			
    			System.out.print("get("+key+") ");
    			int res = test.get(key);
    			result.add(res);
    			System.out.println( + res);
    		}
    		System.out.println();
    		
    		Iterator itor = test.cache.entrySet().iterator();
    		
    		//打印HashMap中内容.
    		while(itor.hasNext())
    		{
    			Map.Entry< Integer, node> entry = (Map.Entry< Integer, node> )itor.next();
    			
    			Object key = entry.getKey();
    			Object value = entry.getValue();
    			
    			System.out.print("["+key + "," + value+"] ");
    			
    		}
    		
    		System.out.println();
    		for(int k : result)
    		{
    			System.out.print(k + " ");
    		}
    		System.out.println();
    		System.out.println("------------------------------------------");
    	}
	}
}
