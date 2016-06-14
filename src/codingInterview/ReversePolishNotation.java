package codingInterview;

import java.util.Stack;

public class ReversePolishNotation
{
    public static int evalRPN(String[] tokens)
    {
    	int result = 0;
    	
    	String operator = "+-*/";
    	
    	Stack<String> stack = new Stack<String>();
    	
    	for(String t:tokens)
    	{
    		if(!operator.contains(t))
    		{
    			stack.push(t);
    		}
    		else
    		{
    			int second = Integer.valueOf(stack.pop());
    			int first = Integer.valueOf(stack.pop());
    			
    			switch(t)
    			{
    				case "+": 
    					stack.push(String.valueOf(first + second));
    					break;
    				case "-":
    					stack.push(String.valueOf(first - second));
    					break;
    				case "*":
    					stack.push(String.valueOf(first * second));
    					break;
    				case "/":
    					stack.push(String.valueOf(first / second));
    					break;
    				default: System.out.println("invalid operator!");
    					break;
    			}
    		}
    	}
    	
    	result = Integer.valueOf(stack.pop());
    	
    	return result;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] input = new String[]{"2", "1", "+", "3", "*"};
		
		System.out.println(ReversePolishNotation.evalRPN(input));
	}

}
