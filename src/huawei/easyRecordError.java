package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class easyRecordError
{
	private static HashMap<String , Integer> result = new HashMap<String , Integer>();
	
	private static void solve(String str , int line)
	{
		if(result.containsKey(str))
		{
				result.put(str, result.get(str)+1);
		}
		else
		{
			result.put(str, 1);
		}
	}
	
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext())
		{
			String input = scan.next();
			int line = scan.nextInt();
			
			int index = input.lastIndexOf("\\");
			
			String filename = null; 
			
			if(index < 0)
			{
				filename = input;
			}
			else
			{
				filename = input.substring(index + 1, input.length());
			}
			
			easyRecordError.solve(filename+" "+Integer.toString(line) , line);
		}
		//Map.Entry<K,V>是接口，其方法有getKey(),getValue()等.
		List<Map.Entry<String,Integer>> infoId = new ArrayList<Map.Entry<String,Integer>>(result.entrySet());
		
		//排序
		//通过把HashMap中的所有Entry存入一个List,然后调用collection的sort进行排序操作.
		Collections.sort(infoId, new Comparator<Map.Entry<String,Integer>>()
		{
			@Override
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2)
			{
				// TODO Auto-generated method stub
//				return (o1.getKey()).toString().compareTo(o2.getKey());
				return (o2.getValue() - o1.getValue());
			}
		});
		
		int count = 8;
		
//		Iterator iter = result.entrySet().iterator();
//		while(iter.hasNext())
//		{
//			//Map.Entry<K,V>是接口，其方法有getKey(),getValue()等.
//			Map.Entry< String, Integer> entry = (Map.Entry<String, Integer>) iter.next();
//			
//			String key = (String)entry.getKey();
//			Integer val = (Integer)entry.getValue();
//			
//			int index = key.lastIndexOf(" ");
//			String filename = key.substring(0 , index);
//			int line = Integer.parseInt(key.substring(index + 1, key.length()));
//			
//			if(filename.length() > 16)
//			{
//				filename = filename.substring(filename.length()-16, filename.length());
//			}
//			
//			System.out.println(filename + " " + line + " " + val);
//			
//			if(--count <= 0)
//			{
//				break;
//			}
//		}
		
		for(int i = 0 ; i < infoId.size() && i < 8; i++)
		{
			Map.Entry< String, Integer> entry  = infoId.get(i);
			String key = (String)entry.getKey();
			Integer val = (Integer)entry.getValue();
			
			int index = key.lastIndexOf(" ");
			String filename = key.substring(0 , index);
			int line = Integer.parseInt(key.substring(index + 1, key.length()));
			
			if(filename.length() > 16)
			{
				filename = filename.substring(filename.length()-16, filename.length());
			}
			
			System.out.println(filename + " " + line + " " + val);
		}
		
		scan.close();
	}
}
