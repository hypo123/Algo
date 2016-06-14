package codingInterview;

public class AddBinary
{
    public String addBinary(String a, String b) 
    {
    	StringBuffer result = new StringBuffer();
        int lena = a.length();
        int lenb = b.length();
        
        if(lena == 0 && lenb != 0) 
        {
        	return b;
        }
        else if(lena != 0 && lenb == 0)
        {
        	return a;
        }
        else
        {
        	int leanMax = Math.max(lena, lenb);
        	int diff = lena - lenb;
        	int carry  = 0;//进位    
        	for(int i = 0 ; i < leanMax ; i++)// 0 48 1 49
        	{
        		int tmpa;
        		int tmpb;
        		int mid = 0;
        		if(i < lena)
        		{
        			tmpa = a.charAt(lena-1-i)-48;//字符到数字 '1'到1
        		}
        		else
        		{
        			tmpa = 0;
        		}
        		
        		if(i < lenb)
        		{
        			tmpb = b.charAt(lenb-1-i) - 48;
        		}
        		else
        		{
        			tmpb = 0;
        		}
        		
        		mid = tmpa + tmpb + carry;
        		if(mid >= 2) 
        		{
        			carry = 1;
        		}
        		else
        		{
        			carry = 0;
        		}
        		result.insert(0, (mid%2));
        	}
        	
        	if(carry == 1) result.insert(0, 1);
        }
        return result.toString();
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String b = "1010";
		String a = "1011";
		
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary(a, b));
	}

}
