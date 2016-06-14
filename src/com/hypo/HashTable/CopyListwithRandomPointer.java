package com.hypo.HashTable;

/**
 * Copy List with Random Pointer 
 * 
 * 结点含有随机指针的链表的深拷贝.
 * 
 * 遍历一遍旧链表，通过next向后遍历，当前结点为curr.
 * 如果，HashSet的不含该结点，则对应的新链表中也要新建一个结点,
 * 如果，HashSet中含有该结点，说明链表前面有结点的random域指向了该结点。则新链表中也不需要新建该结点了。
 * 然后判断curr的random域,
 * 如果HashSet中含有curr的random指向的结点说明当前结点的random域指向了前面的结点，
 * 则新链表中也不需要新建旧链表中random域所指的结点对应位置的结点，但新链表中需要找到对应位置上的该结点，
 * 然后将其当前结点的random指向找到的结点；如果HashSet中没有curr的random所指的结点，则新链表中药新建该结点
 * 
 */
import java.util.HashSet;
import java.util.Set;

 class RandomListNode 
 {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }
 
public class CopyListwithRandomPointer
{
    public RandomListNode copyRandomList(RandomListNode head) 
    {
    	Set<RandomListNode> hs = new HashSet<RandomListNode>();//装旧链表的结点.
    	
    	if(head == null) return head;
    	RandomListNode curr = head;//旧链表游标
    	
    	RandomListNode dummy = new RandomListNode(-1);//新链表哨兵
    	dummy.next = null;
    	dummy.random = null;
    	RandomListNode prev = dummy;
    	int count = 0; //新建结点数,不含random所指新建的结点.
    	
    	RandomListNode randhead = dummy;//新链表游标.用于找结点
    	
    	while(curr != null)
    	{
    		if(hs.contains(curr))//判断旧链表中的结点.当前结点已在链表中，说明前面有结点的random指向该结点
    		{					 //则新链表中需要找到是那个结点的random指向了当前结点.
    			int step = 1;
    			RandomListNode cusor = head;
    			while(cusor.random != curr)//找到旧链表中那个结点的random域指向了当前结点.要next几下
    			{
    				step++;
    				randhead = randhead.next;
    			}
    			
    			RandomListNode randcurr = dummy;
    			while(--step >= 0)   //在新链表中找到random域指向当前结点的结点
    			{
    				randcurr = randcurr.next;
    			}
    			
    			prev.next = randcurr.random ;
    			prev = prev.next;
    			count++;
    			curr = curr.next;
    		}
    		else//当前结点不在链表中.需新建,还要判断当前结点的random域，如果不为空，且HashSe中不包含，则
      		{   //同时也要新建当前结点random域所指的结点.如果HashSe中包含了，则需在新链表中找到random域所指的结点
     			RandomListNode mid = curr;
    			curr = curr.next;
    			RandomListNode node = new RandomListNode(mid.label);
    			node.next = null;
    			prev.next = node;
    			prev = node;
    			count++;
    			if(mid.random == null)//当前结点random域指向null
    			{
    				prev.random = null;
    				continue;
    			}
    			
    			if(hs.contains(mid.random))//mid的random指向链表的前面结点.要找到新链表对应位置的前面结点.
    			{
    				int step = 0;//从旧链表中当前结点的random所指的结点到当前结点有多少步
    				RandomListNode subnode = mid.random;
    				
    				while(subnode != curr)
    				{
    					step++;
    					subnode = subnode.next;
    				}
    				
    				//拿到新链表中当前结点random所指的结点引用.
    				while(count > step)
    				{
    					step++;
    					randhead = randhead.next;
    				}
    				
    				node.random = randhead;
    				randhead = dummy;
    			}
    			else//指向后面还没有新建的结点.  则新建.
    			{
    				RandomListNode rand = new RandomListNode(mid.random.label);
    				rand.next = null;
    				rand.random = null;
    				prev.random = rand;
    			}
    		}
    	}
    	return dummy.next;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CopyListwithRandomPointer clrp = new CopyListwithRandomPointer();
		
		/** 建如下链表. 
		 * ---------|
		 * | 1 | -->| 2 | -->| 3 | -->| 4 | 
		 *   |-----------------
		 */
		RandomListNode head = new RandomListNode(0);
		
		RandomListNode node1 = new RandomListNode(1);
		head.next = node1;
		
		RandomListNode node2 = new RandomListNode(2);
		node1.next = node2;
		head.random = node2;
		node2.random = null;
		
		RandomListNode node3 = new RandomListNode(3);
		node2.next = node3;
		node3.random = node1;
		
		RandomListNode node4 = new RandomListNode(4);
		node3.next = node4;
		node4.next = null;
		node4.random = null;
		
		RandomListNode result = clrp.copyRandomList(head);
		
		while(result != null)
		{
			System.out.print(result.label+"");
			if(result.random != null)
			{
				System.out.print("+"+result.random.label+ " ");
			}
			result = result.next;
		}
	}

}
