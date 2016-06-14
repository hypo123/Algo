package codingInterview;

import java.util.LinkedList;

public class CountAndSay
{
    public String countAndSay(int n)
    {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	list.add(1);
    	list.add(Integer.MIN_VALUE);
    	
    	int beforelen = 2;
    	
    	int afterlen = 2;
    	
    	for(int i = 0 ; i < n - 1 ; i++)
    	{
    		beforelen = afterlen;
    		afterlen = 0;
    		int curr = -1;
    		int count = 0;
    		int before = list.peek();
    		
    		while(--beforelen >= 0)
    		{
    			curr = list.poll();
    			if(curr == before)
    			{
    				count++;
    			}
    			else
    			{
    				list.add(count);
    				list.add(before);
    				before = curr;
    				afterlen += 2;
    				count = 1;
    			}
    		}
    		
    		list.add(Integer.MIN_VALUE);
    		afterlen++;
    	}
    	
    	list.removeLast();
    	
    	StringBuffer sb = new StringBuffer();
    	
    	while(!list.isEmpty())
    	{
    		sb.append(list.poll());
    	}
    		
        return sb.toString();
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CountAndSay cas = new CountAndSay();
		
		int n  = 1;
		
		String result = cas.countAndSay(n);
		for(int i = 0 ;i < result.length(); i++ )
		{
			System.out.print(result.charAt(i));
		}
	}

}
