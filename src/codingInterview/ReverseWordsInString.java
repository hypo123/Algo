package codingInterview;

public class ReverseWordsInString
{
    public String reverseWords(String s) 
    {
    	StringBuffer sb = new StringBuffer();
    	String strim = s.trim();
    	
//    	for(int k = 0 ; k < strim.length();k++)
//    	{
//    		System.out.print(strim.charAt(k));
//    	}
    	int wordlen = 0;
    	boolean flag = false;
    	for(int i = 0 ; i < strim.length() ; i++)
    	{
    		if(!Character.isWhitespace(strim.charAt(i)))
    		{
    			if(flag)
    			{
    				sb.append(' ');
    				flag = false;
    			}
    			wordlen++;
    		}
    		else
    		{
    			if(i != 0 && wordlen > 0)
    			{
    				for(int j = i-1 ; j >= (i-wordlen); j--)
    				{
    					sb.append(strim.charAt(j));
    				}
    				flag = true;
    			}
    			wordlen = 0;
    		}
    	}
    	System.out.println("len="+wordlen);
    	if(wordlen > 0)
    	{
    		for(int k = strim.length()-1; k >= strim.length()-wordlen; k--)
    		{
    			System.out.println("charAt="+strim.charAt(k));
    			sb.append(strim.charAt(k));
    		}
    	}
    	
        return sb.reverse().toString();
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseWordsInString rwis = new ReverseWordsInString();
		
		String s = "the sky is blue";
		String s2 = "     1!";
		
		System.out.println(rwis.reverseWords(s2));
	}

}
