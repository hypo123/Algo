package huawei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @param inputStr
 *            输入字符串
 * @param outputStr
 *            输出判断结果
 * 
 * @description： 输入的inputStr是合法的IP，返回YES，否则返回NO 示例 输入：10.138.15.1 返回：YES
 * 
 * 测试用例没有全部通过
 * 
 */
public class ValidIP
{
	public void checkIP(String inputStr, StringBuffer outputStr) 
	{		
		if(inputStr == null) 
		{
			outputStr.append("NO");
			return;
		}
		String[] stubs = inputStr.split("\\.");
		
		if(stubs.length != 4 )
		{
			outputStr.append("NO");
			return;
		}
		boolean flag = false;
		
		for(String s : stubs)
		{
			s = s.trim();
			
			if(s.length() > 3 || s.length() < 1)
			{
				outputStr.append("NO");
				return;
			}
			
			for(int i = 0 ; i < s.length(); i++)
			{
				if(!Character.isDigit(s.charAt(i)))
				{
					outputStr.append("NO");
					return;
				}
			}
			
			Pattern pattern = Pattern.compile("^0.*");
			Matcher matcher = pattern.matcher(s);
			
			if(matcher.matches())
			{
				if(!flag || s.length() > 1)
				{
					outputStr.append("NO");
					return;
				}
			}
			else
			{
				if(Integer.parseInt(s) > 255)
				{
					outputStr.append("NO");
					return;
				}
				
				flag = true;
			}
		}
		outputStr.append("YES");
		return;
	}
	
}