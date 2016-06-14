package com.hypo.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class T17_LetterCombinationsPhoneNumber
{
//--------------------------------------------------------------------------------	
    public List<String> letterCombinations(String digits)
    {
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer path = new StringBuffer();
        if(digits.length() >= 1)
        {
            String[] keyboard = {" ", "" , "abc" , "def" , "ghi" , "jkl" ,
        		"mno" , "pqrs" , "tuv" , "wxyz"};// '0','1','2',...
            dfs(result , path , digits , keyboard , 0);
        }
        return (List)result;
    }
    
    private void dfs( ArrayList<String> result , StringBuffer path , String digits , String[] keyboard , int index)
    {
    	if(index == digits.length())//终止条件
    	{
    		result.add(new StringBuffer(path).toString());
    		return;
    	}
    	
    	int a = Integer.parseInt(digits.substring(index, index+1));
    		
		String key = keyboard[a];

		for (int j = 0; j < key.length(); j++)
		{
			path.append(key.charAt(j));
			dfs(result, path, digits, keyboard, index + 1);
			path.deleteCharAt(path.length() - 1);
		}
    }
// ------------------------------------------------------------------------------------   
    public static void main(String[] args)
	{
    	T17_LetterCombinationsPhoneNumber t17 = new T17_LetterCombinationsPhoneNumber();
    	
    	String digits = "232";
    	
    	ArrayList<String> res = (ArrayList) t17.letterCombinations(digits);
    	
    	for(String n : res)
    	{
    		System.out.print(n + " ");
    	}
	}
}
