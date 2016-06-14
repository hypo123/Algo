package com.hypo.LinkedList;

/**
 * 判断两个链表是否有交点，如果有返回第一个交点.
 *
 */
class Node 
{
     int val;
     Node next;
     Node(int x) 
     {
         val = x;
         next = null;
     }
 }
public class IntersectionofTwoLinkedLists
{
    public Node getIntersectionNode(Node headA, Node headB) 
    {
    	if(headA == null && headB == null) return null;
    	Node currA = headA;
    	Node currB = headB;
    	
    	int countA = 0;
    	int countB = 0;
    	while(currA != null	)
    	{
    		countA++;
    		currA = currA.next;
    	}
    	while(currB != null	)
    	{
    		countB++;
    		currB = currB.next;
    	}
    	
    	//将两个链表处理为一样长
    	if(countA == countB)
    	{
    		return  findcomonNode(headA , headB);
    	}
    	else if(countA > countB)
    	{
    		int diff = countA - countB;
    		while(--diff >= 0)
    		{
    			headA = headA.next;
    		}
    		return findcomonNode(headA , headB);
    	}
    	else
    	{
    		int diff = countB - countA;
    		while(--diff >= 0)
    		{
    			headB = headB.next;
    		}
    		return findcomonNode(headA , headB);	
    	}
    }
    
//   将两个一样长度链表的第一个共同交点.
    private Node findcomonNode(Node A , Node B)
    {
    	while(A != null)
    	{
    		if(A == B)
    		{
    			return A;
    		}
    		else
    		{
    			A = A.next;
    			B = B.next;
    		}
    	}
    	return null;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
