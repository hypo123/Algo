package ZTE;

import java.util.HashMap;
import java.util.Map;

/**
 *	中兴蓝剑计划第一题  
 *	题目描述:LRU访问缺页次数统计
 *	解题思路一:HashMap+双向链表
 *	解题思路二:LinkedHashMap
 *  2016.6.13
 */

//双向链表
class DoubleLinkedListNode
{
	DoubleLinkedListNode prev;
	DoubleLinkedListNode next;
	int val;
	
	public DoubleLinkedListNode(int val)
	{
		this.val = val;
		this.prev = null;
		this.next = null;
	}
}

public class LRU
{
	//LRU算法缺页次数
    public static int missTimes(int cachesize , int[] pages)
    {
    	
		Map<Integer, DoubleLinkedListNode> cache = new HashMap<Integer, DoubleLinkedListNode>();
		DoubleLinkedListNode dummy = new DoubleLinkedListNode(-1);
        
		int misstimes = 0;
		
		for(Integer i : pages)
		{
			//命中,将访问页设为最新访问页
			if(cache.containsKey(i))
			{
				DoubleLinkedListNode node = cache.get(i);
				
				moveToHead(node , dummy);
			}
			else//未命中
			{
				misstimes++;
				
				DoubleLinkedListNode newnode = new DoubleLinkedListNode(i);
				
				//cache已满,要先删除最久未访问的页面，再将新页面设置为最新访问页面
				if(cache.size() == cachesize)
				{
					DoubleLinkedListNode lastnode = dummy.prev;
					
					cache.remove(lastnode.val);
					
					lastnode.prev.next = newnode;
					newnode.prev = lastnode.prev;
					
					dummy.prev = newnode;
					newnode.next = dummy;
					
					moveToHead(newnode, dummy);
					
					cache.put(i, newnode);
				}
				else//cache未满,将新页面设置为最新访问页面
				{
					DoubleLinkedListNode lastnode = dummy.prev;
					
					if(lastnode != null)
					{
						lastnode.next = newnode;
						newnode.prev = lastnode;
						
						newnode.next = dummy;
						dummy.prev = newnode;
					}
					else
					{
						dummy.prev = newnode;
						newnode.next = dummy;
						dummy.next = newnode;
						newnode.prev = dummy;
					}

						
					moveToHead(newnode, dummy);
					cache.put(i, newnode);
				}
			}
		}
    	return misstimes;
    }
    
    //将给定结点移动为哨兵结点后的第一个结点
    private static void moveToHead(DoubleLinkedListNode node , DoubleLinkedListNode dummy)
    {
    	//node为双链表最后一个结点
    	if(node == dummy.prev)
    	{
    		if(node.prev != dummy)//要调整结点不是哨兵后第一个结点，如果是则不用调整.
    		{
    			dummy.prev = node.prev;
    			node.prev.next = dummy;
    		
    			DoubleLinkedListNode first = dummy.next;
    			dummy.next = node;
    			node.next = first;
    			first.prev = node; 
    			node.prev = dummy;
    		}
    	}
    	else
    	{
    		node.prev.next = node.next;
    		node.next.prev = node.prev;
    		
    		DoubleLinkedListNode first = dummy.next;
    		dummy.next = node;
    		node.next = first;
    		first.prev = node;
    		node.prev = dummy;
    	}
    }
}
