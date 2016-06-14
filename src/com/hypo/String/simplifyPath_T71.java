package com.hypo.String;

import java.util.ArrayList;

public class simplifyPath_T71
{
	public String simplifyPath2(String path)
	{
		String result = "/";
		String[] stubs = path.split("/+");
		ArrayList<String> paths = new ArrayList<String>();
		for(String s : stubs)
		{
			if(s.equals(".."))
			{
				if(paths.size() > 0)
				{
					paths.remove(paths.size() - 1);//".."不是上级目录，要向上级目录回退
				}
			}
			else if(!s.equals(".") && !s.equals(""))// "."为当前目录不用管，""为空不用管
			{
				paths.add(s);
			}
		}
		
		for(String i : paths)
		{
			result += i + "/" ;
		}
		
		if(result.length() > 1)//去掉最后一个多加的"/"
		{
			result = result.substring(0, result.length() - 1);
		}
		return result.toString();
	}

//	test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		simplifyPath_T71 sp = new simplifyPath_T71();
		
		String path = "/home/";
		String path2 = "/a/./b/../../c/";
		String path3 = "/../";
		String path4 = "/home//foo/";
		
		System.out.println(sp.simplifyPath2(path));
		System.out.println(sp.simplifyPath2(path2));
		System.out.println(sp.simplifyPath2(path3));
		System.out.println(sp.simplifyPath2(path4));
	}
}
