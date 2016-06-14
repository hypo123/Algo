package worksApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class permutation
{
	
	private static ArrayList<String> result = new ArrayList<String>();//存储结果
	
	private static void solve(String input)
	{
		StringBuffer path = new StringBuffer();
		
		char[] in = input.toCharArray();
		
		Arrays.sort(in);
		
		HashSet<Integer> hs = new HashSet<Integer>();//路径判重

		dfs(in , 0 , path , hs);
	}
	
	
	private static void dfs(char[] input ,  int step , StringBuffer path , HashSet<Integer> hs)
	{
		int len = input.length;
		
		if(step == len)
		{
			String in = new StringBuffer(path).toString();
			
			if(!result.contains(in))
			{
				result.add(in);
				return;
			}
			
			return;
		}
		
		for(int i = 0 ; i < len ; i++)
		{
			if(hs.contains(i))
			{
				continue;
			}
			
			path.append(input[i]);
		
			hs.add(i);
			
			dfs(input , step + 1 , path , hs);

			hs.remove(i);
			
			path.deleteCharAt(path.length() - 1);
		}
	}
	
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String input = scan.next();
		
		
		permutation.solve(input);
		
		for(String s : result)
		{
			System.out.print(s + " ");
		}
		
	}
}
