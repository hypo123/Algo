package codingInterview;

//用有限自动机解题DFA
public class ValidNumber
{
    public boolean isNumber(String s) 
    {
        return state1(s , 0);//进入起始状态state 1
    }
    
    boolean state1(String s1 , int index1)
    {
    	//处理空格
    	while(index1 < s1.length() && s1.charAt(index1) == ' ')
    	{
    		index1++;
    	}
    	
    	//在state1结束 即全部为空格
    	if(index1 == s1.length())
    	{
    		return false;
    	}
    	
    	//转到state 2
    	if(s1.charAt(index1) == '+' || s1.charAt(index1) == '-')
    	{
    		return state2(s1,index1);
    	}
    	//转到state 3
    	else if(Character.isDigit(s1.charAt(index1)))
    	{
    		return state3(s1, index1);
    	}
    	//转到state 4
    	else if(s1.charAt(index1) == '.')
    	{
    		return state4(s1, index1);
    	}
    	//不合法字符
    	else
    	{
    		return false;
    	}
    	
    }
    
    boolean state2(String s2 , int index2)//+或-符号转到state2
    {
    	//在state2结束 不合法
    	if(++index2 == s2.length())
    	{
    		return false;
    	}
    	
    	//遇数字转到state 3
    	if(Character.isDigit(s2.charAt(index2)))
    	{
    		return state3(s2, index2);
    	}
    	//遇小数点转到state 4
    	else if(s2.charAt(index2) == '.')
    	{
    		return state4(s2 , index2);
    	}
    	//不合法字符
    	else
    	{
    		return false;
    	}
    }
    boolean state3(String s3 , int index3)//数字转到state3
    {
    	index3++;
    	while(index3 < s3.length() && Character.isDigit(s3.charAt(index3)))
    	{
    		index3++;
    	}
    	
    	//在state3结束合法
    	if(index3 == s3.length())
    	{
    		return true;
    	}
    	
    	//遇小数点转到state 5
    	if(s3.charAt(index3) == '.')
    	{
    		return state5(s3, index3);
    	}
    	//遇科学计数法e转到state 6
    	else if(s3.charAt(index3) == 'e')
    	{
    		return state6(s3 , index3);
    	}
    	//遇空格转到state 9
    	else if(s3.charAt(index3) == ' ')
    	{
    		return state9(s3 , index3);
    	}
    	//不合法字符
    	else
    	{
    		return false;
    	}
    	
    }
    boolean state4(String s4 , int index4)//"."转到state4
    {
    	////在state4结束不合法
    	if(++index4 == s4.length())
    	{
    		return false;
    	}
    	
    	//遇数字转到state 5
    	if(Character.isDigit(s4.charAt(index4)))
    	{
    		return state5(s4 , index4);
    	}
    	//不合法字符
    	else
    	{
    		return false;
    	}
    }
    boolean state5(String s5 , int index5)//数字转达state 5
    {
    	index5++;
    	while(index5 < s5.length() && Character.isDigit(s5.charAt(index5)))
    	{
    		index5++;
    	}
    	
    	//在state5结束合法
    	if(index5 == s5.length())
    	{
    		return true;
    	}
    	
    	//遇科学计数法e转到state 6
    	if(s5.charAt(index5) == 'e')
    	{
    		return state6(s5 , index5);
    	}
    	//遇空格转到state 9
    	else if(s5.charAt(index5) == ' ')
    	{
    		return state9(s5 , index5);
    	}
    	//不合法字符
    	else
    	{
    		return false;
    	}
    }
    
    boolean state6(String s6 , int index6)//遇科学计数法e转到state 6
    {
    	//在state6结束不合法
    	if(++index6 == s6.length())
    	{
    		return false;
    	}
    	
    	if(s6.charAt(index6) == '+' || s6.charAt(index6) == '-')
    	{
    		return state7(s6 , index6);
    	}
    	else if(Character.isDigit(s6.charAt(index6)))
    	{
    		return state8(s6 , index6);
    	}
    	else
    	{
    		return false;
    	}
    }
    boolean state7(String s7 , int index7)//遇+/-转到state 7
    {
    	if(++index7 == s7.length())//在state7结束 false
    	{
    		return false;
    	}
    	
    	if(Character.isDigit(s7.charAt(index7)))
    	{
    		return state8( s7 , index7);
    	}
    	else
    	{
    		return false;
    	}
    }
    boolean state8(String s8 , int index8)//遇数字转到state 8
    {
    	index8++;
    	while(index8 < s8.length() && Character.isDigit(s8.charAt(index8)))
    	{
    		index8++;
    	}
    	
    	if(index8 == s8.length())//在state8结束 true;
    	{
    		return true;
    	}
    	if(s8.charAt(index8) == ' ')
    	{
    		return state9(s8 , index8);
    	}
    	else
    	{
    		return false;
    	}
    }
    boolean state9(String s9 , int index9)//遇空格转到state 9
    {
    	index9++;
    	while(index9 < s9.length() && s9.charAt(index9) == ' ')
    	{
    		index9++;
    	}
    	
    	if(index9 == s9.length())//在state9结束 true;
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		
		String s = "-.0003";
		
		System.out.println(vn.isNumber(s));
	}

}
