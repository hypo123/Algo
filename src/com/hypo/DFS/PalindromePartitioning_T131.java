package com.hypo.DFS;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_T131
{
    private List<List<String>> partition(String s) 
    {
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	
    	ArrayList<String> path = new ArrayList<String>();//一个分割方案.
    	
    	if(s == null || s.length() == 0) return (List)res;
    	
    	dfs(s , path ,0 ,  res);
    	
        return (List)res;
    }
    
    private void dfs(String st , ArrayList<String> path ,int pos , 
    		ArrayList<ArrayList<String>> res)
    {
    	if(pos == st.length())//终止条件
    	{
    		////ArrayList(Collection<? extends E> c)构造一个含有path的所有元素的新ArrayList
    		res.add(new ArrayList<String>(path));
    		return;
    	}
    	
    	for(int i = pos + 1 ; i <= st.length(); ++i)
    	{
    		//取字符串的前一部分
    		String prefix = st.substring(pos , i);//子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符
    		if(!isPalindrome(prefix))
    		{
    			continue;
    		} 
    		path.add(prefix);
    		dfs(st , path ,i ,  res );//继续往下砍
    		path.remove(path.size()-1);//撤销上一行,每返回一次dfs就撤销一次，最后path就为空了。可以用作下一次分割.
    	}
    }
    
//  判断是否是回文数
    private boolean isPalindrome(String str )
    { 
    	int start = 0;
    	int end = str.length() - 1;
    	while(start < end && str.charAt(start) == str.charAt(end))
    	{
    		start++;
    		end--;
    	}
    	return start >= end;//跳出while循环后，若end>start，则说明不是回文字符串
    }
    
	public static void main(String[] args)
	{
		PalindromePartitioning_T131 pp = new PalindromePartitioning_T131();
		
		String s = "aab";
		
		ArrayList<ArrayList<String>> print = (ArrayList)pp.partition(s);
		
		
		for(int i = 0 ; i < print.size() ; ++i)
		{
			ArrayList<String> mid = print.get(i);
			
			for(int j = 0 ; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j) + " ");
			}
			
			System.out.println();
		}
	}
}
