package com.hypo.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *	单链表结点. 
 */
class node
{
	int key;
	int val;
	node next;
	
	public node(int key , int value)
	{
		this.key = key;
		this.val = value;
		next = null;
	}
}

/**
 *	使用单链表 + HashMap超时
 */
public class LRUCache2_T146
{
	Map<Integer,node> cache; 
	int capacity;
	node dummy;
	
    public LRUCache2_T146(int capacity)
    {
    	//node中存储上一个结点的引用,不是存储当前结点的引用.
    	//一个链表记顺序
    	//一个HashMap判断是否存在与位置.
    	cache = new HashMap<Integer,node>(capacity<<1);
    	dummy = new node(-1,Integer.MIN_VALUE);
    	this.capacity = capacity;
    }
    
    public int get(int key)
    {
    	//访问了也要调整位置
    	if(cache.containsKey(key))
    	{
          	node prev = (node)cache.get(key);//前一个结点
          	
        	node now = prev.next;
        	
        	System.out.println(key + " " + now.val);
        	
        	if(prev == dummy)//当前结点已在最前面.
        	{
        		return now.val;
        	}
        	
        	cache.put(key, dummy);//当前结点前缀调整
        	
        	prev.next = now.next;
        	
        	if(now.next != null)
        	{
        		cache.put(now.next.key, prev);//后一结点的前缀调整
        	}
        	
        	now.next = dummy.next;
        	dummy.next = now;
        	
        	if(now.next == prev)
        	{
        		cache.put(prev.key, now);//前一结点的前缀调整
        	}
        	
        	return now.val;
    	}
        return -1;
    }
    
    public void set(int key, int value)
    {
        if(get(key) > 0)//已在cache中,调整位置
        {
        	node prevnode = cache.get(key);
        	
        	if(value != prevnode.next.val)
        	{
        		prevnode.next.val = value;
        	}
        }
        else//不在cache中.
        {
			if(cache.size() == capacity)//已满
			{
				int countnode = capacity;
				node lastprevnode = dummy;
				
				//这个地方找最后一个结点比较耗时间(寻找最久未访问页面)
				while(--countnode > 0)
				{
					lastprevnode = lastprevnode.next;
				}
				
				int lastkey = lastprevnode.next.key;
				
				lastprevnode.next = null;
				
				cache.remove(lastkey);
				
				node newnode = new node(key,value);
				
				newnode.next = dummy.next;
				
				dummy.next = newnode;
				
				if(newnode.next != null)
				{
					cache.put(newnode.next.key, newnode);
				}
				
				cache.put(newnode.key, dummy);
			}
			else//未满
			{
				
				node newnode = new node(key,value);
				
				newnode.next = dummy.next;
				
				dummy.next = newnode;
				
				if(newnode.next != null)
				{
					cache.put(newnode.next.key, newnode);
				}
				
				cache.put(newnode.key, dummy);
			}
        }
    }
    
    public static void main(String[] args)
	{
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	String input = "3, [set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),"
    			+ "get(2),get(3),get(4),get(5)]";
    	
    	int capacity = Integer.parseInt(input.substring(0 , input.indexOf(",")));
    	
    	System.out.println(capacity);
    	
    	LRUCache2_T146 test  = new LRUCache2_T146(capacity);
    	
    	String operation = input.substring(input.indexOf("["), input.lastIndexOf("]")+1);
    	
    	String[] oper = input.split("(\\[)|(\\)\\,)|(\\])");
    	
    	for(int j = 1; j < oper.length; j++)
    	{
    		
    		String i = oper[j];
    		String step = i.substring(0 , 3);
    		
    		if(step.equals("set"))
    		{
    			String[] num = i.substring(i.indexOf("(")+1).split("\\,");
    			
    			int start = Integer.parseInt(num[0]) ;
    			int end = Integer.parseInt(num[1]);
    			
    			System.out.println("set["+start+","+end+"]");
    			test.set(start , end );
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
    		
    		node cursor = test.dummy.next;
    		
    		//打印当前链表内结点
    		while(cursor != null)
    		{
    			System.out.print("["+cursor.key+","+cursor.val+"]"+" ");
    			cursor = cursor.next;
    		}
    		System.out.println();
    		
    		Iterator itor = test.cache.entrySet().iterator();
    		
    		//打印HashMap中内容.
    		while(itor.hasNext())
    		{
    			Map.Entry< Integer, node> entry = (Map.Entry< Integer, node> )itor.next();
    			
    			Object key = entry.getKey();
    			Object value = entry.getValue();
    			
    			System.out.print(key + " ");
    			System.out.println(((node)value).key);
    		}
    		
    		System.out.println("------------------------------------------");
    	}
    	
    	for(int s : result)
    	{
    		System.out.print(s + " ");
    	}
	}
}
