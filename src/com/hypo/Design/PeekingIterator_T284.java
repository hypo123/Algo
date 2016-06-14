package com.hypo.Design;

import java.util.Iterator;

public class PeekingIterator_T284 implements Iterator<Integer>
{
	private final Iterator<Integer> iterator;
	private boolean hasPeeked;//是否已经查看下一个元素
	private Integer peekedElement;//查看的下一个元素
	
	/**
	 *	构造方法 
	 */
	public PeekingIterator_T284(Iterator<Integer> iterator2) 
	{
		iterator = iterator2;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() 
	{
       if(!hasPeeked)
       {
    	   peekedElement = iterator.next();
    	   hasPeeked = true;
       }
       return peekedElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public boolean hasNext()
	{
		// TODO Auto-generated method stub
		return hasPeeked || iterator.hasNext();
	}
	
	@Override
	public Integer next()
	{
		// TODO Auto-generated method stub
		if(!hasPeeked)
		{
			return iterator.next();
		}
		
		Integer result = peekedElement;
		hasPeeked = false;
		peekedElement = null;
		return result;
	}
	
	@Override
	public void remove()
	{
		// TODO Auto-generated method stub
//		iterator.remove();
	}
}

