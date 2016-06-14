package com.hypo.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *	双向链表+HashMap 
 */
public class LRUCache_T146
{
	DoubleLinkedNode dummy;
	Map<Integer,DoubleLinkedNode> cache;
	
	int capacity;
	
	public LRUCache_T146(int capacity)
	{
		dummy = new DoubleLinkedNode(Integer.MIN_VALUE,Integer.MIN_VALUE);
		dummy.next = null;
		dummy.prev = null;
		
		cache = new HashMap<Integer,DoubleLinkedNode>();
		
		this.capacity = capacity;
	}

	public int get(int key)
    {
		if(cache.containsKey(key))
		{
			toHead(cache.get(key));
			
			return cache.get(key).val;
		}
		
    	return -1;
    }
    public void set(int key, int value)
    {
    	if(get(key) > 0)//已在cache中
    	{
    		DoubleLinkedNode node = cache.get(key);
    		
    		if(node.val !=  value)
    		{
    			node.val = value;
    		}
    	}
    	else//不在cache中
    	{
    		DoubleLinkedNode newnode = new DoubleLinkedNode(key, value);
    		
    		if(cache.size() == capacity)//已满
    		{
    			DoubleLinkedNode tail = dummy.prev;
    			
    			if(tail.prev != dummy)
    			{
    				dummy.prev = tail.prev;
    			}
    			else
    			{
    				dummy.prev = null;
    			}
    			
    			cache.remove(tail.key);
    			
    			deleteNode(tail);
    			
    			tail = null;
    		}
    		
			addNode(newnode);
    			
			toHead(newnode);
			
    		cache.put(key, newnode);
    	}
    }
    
	class DoubleLinkedNode
	{
		int key;
		int val;
		
		DoubleLinkedNode prev;
		DoubleLinkedNode next;
		
		public DoubleLinkedNode(int key , int value)
		{
			this.key = key;
			this.val = value;
			this.prev = null;
			this.next = null;
		}
	}
	
	//结点都插在最前面.
	private void addNode(DoubleLinkedNode node)
	{
		if(dummy.next == null)
		{
			dummy.prev = node;
			node.next = dummy;
		}
		else
		{
			node.next = dummy.next;
		}
		
		DoubleLinkedNode temp = dummy.next;
		
		dummy.next = node;
		node.prev = dummy;
			
			
		if(temp  != null)
		{
			node.next.prev = node;
		}
	}
	
	private void deleteNode(DoubleLinkedNode node)
	{
		node.prev.next = node.next;
		
		if(node.next != null)
		{
			node.next.prev = node.prev;
		}
		
		if(node == dummy.prev)
		{
			dummy.prev = node.prev;
		}
	}
	
	private void toHead(DoubleLinkedNode node)
	{
		if(dummy.prev == node)
		{
			dummy.prev = node.prev;
		}
		
		deleteNode(node);
		addNode(node);
	}
	
	
    public static void main(String[] args)
	{
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	String input = "3, [set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),"
    			+ "get(2),get(3),get(4),get(5)]";
    	
//    	String input = "1,[set(2,1),get(2),set(3,2),get(2),get(3)]";
    	
    	int capacity = Integer.parseInt(input.substring(0 , input.indexOf(",")));
    	
    	System.out.println(capacity);
    	
    	LRUCache_T146 test  = new LRUCache_T146(capacity);
    	
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
    		
    		DoubleLinkedNode cursor = test.dummy.next;
    		
    		//打印当前链表内结点
    		while(cursor != test.dummy && cursor != null)
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
    			System.out.println(((DoubleLinkedNode)value).prev.key);
    			
    		}
    		
    		if(test.dummy.prev != null)
    		{
    			System.out.println("tail = " + test.dummy.prev.key);
    		}
    		
    		
    		System.out.println("------------------------------------------");
    	}
    	
    	for(int s : result)
    	{
    		System.out.print(s + " ");
    	}
	}
}
