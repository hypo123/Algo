package codingInterview;

public class ValidPalindrome
{
    public boolean isPalindrome(String s1) 
    {
        if(s1.length() == 0) return true;
        int start = 0;
        int end = s1.length()-1;
        
        String s = s1.toLowerCase();
        for(int k = 0 ; k < s.length(); k++)
        {
        	System.out.print(s.charAt(k));
        }
        System.out.println();
 
        while(start < end)
        {
            boolean finds = false;
            boolean finde = false;
            
        	char st = s.charAt(start);
        	while(!(finds = Character.isLetterOrDigit(st)) )//从左边找字母数字
        	{
        		if(++start < end)
        		{
        			st = s.charAt(start);
        		}
        		else
        		{
        			break;
        		}
        	}
        	
        	System.out.print(st+" ");
        	
         	char en = s.charAt(end);
        	while( !(finde =Character.isLetterOrDigit(en)) )//从右边找字母数字
        	{
        		if(--end > start)
        		{
        			en = s.charAt(end);
        			System.out.println("st="+en);
        		}
        		else
        		{
        			break;
        		}
        	}
        	System.out.print(en+" ");
        	System.out.println(finds+" "+finde);
        	
        	if(finds && finde)
        	{
        		if(! (st == en))
            	{
            		return false;
            	}
        		else
        		{
        			start++;
        			end--;
        			System.out.println(start+" "+end);
        			
        		}
        	}
        	else
        	{
        		return true;
        	}
        	System.out.println();
        }
        
        return true;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String s = "race a car";
		
		ValidPalindrome vp = new ValidPalindrome();
		
		System.out.println(vp.isPalindrome(s));
	}

}
