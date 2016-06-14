package worksApplication;

import java.util.ArrayList;
import java.util.Scanner;

//两个正整数M和N，M <= N，令0 < a < M，M <= b <= N，分别输出以a为分子b为分母的可约和不可约分数        b/a

public class fraction
{
	private static ArrayList<String> canReduce = new ArrayList<String>();
	private static ArrayList<String> cannotReduce = new ArrayList<String>();
	
	private static void solve(int m  , int n)
	{
		for(int i = 1 ; i < m ; i++)
		{
			for(int j = m ; j <= n ; j++)
			{
				if(gcd(i , j) == 1)
				{
					cannotReduce.add(Integer.toString(i) + "/" + Integer.toString(j));
				}
				else
				{
					canReduce.add(Integer.toString(i) + "/" + Integer.toString(j));
				}
			}
		}
	}
	
	//最大公约数
	private static int gcd(int a , int b)
	{
		if(a % b == 0)
		{
			return b;
		}
		else
		{
			return gcd(b , a % b);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		
		fraction.solve(m, n);
		
		
		for(String i : canReduce)
		{
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for(String s : cannotReduce)
		{
			System.out.print(s + " ");
		}
	}
}
