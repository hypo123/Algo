package codingInterview;

public class LongestPalindromicSubstring
{
    public String longestPalindrome(String s) 
    {
    	int longindex = 0;
    	int longlen = 0;
    	
    	for(int current = 0 ; current < s.length() ; current++)
    	{
    		if(isPalindrome(s, current - longlen, current))
    		{
    			longindex = current;
    			longlen++;
    		}
    		else if(current-longlen-1 > -1 && isPalindrome(s, current-longlen-1, current))
    		{
    			longindex = current;
    			longlen += 2;
    		}
    	}
    	longindex++;
        return s.substring(longindex - longlen, longindex);
    }
    
    public boolean isPalindrome(String s , int begin , int end)
    {
    	for(int i = begin , j = end ; i <= j; i++ , j--)
    	{
    		if(s.charAt(i) != s.charAt(j))
    		{
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		
		String s = "xxABCDCBAio";
		
		String result = lps.longestPalindrome(s);
		
		for(int k = 0 ; k < result.length() ; k++)
		{
			System.out.print(result.charAt(k));
		}
	}

}
