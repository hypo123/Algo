package com.hypo.String;

//给定一个字符串，可在该字符串前添加字符，使之成为最短的回文字符串
public class ShortestPalindrome_T214
{
//	=======================KMP=============================
    public String shortestPalindrome(String s) 
    {
    	StringBuffer t = new StringBuffer(s);
    	t.append("#");
    	t.append(new StringBuffer(s).reverse());
    	System.out.println(t);
    	return null;
    }
    
//  求KMP模式串前缀数组
    private int[] getNext(String t)
    {
    	int[] next = new int[t.length()];//模式串前缀数组
    	next[0] = 0;
    	int k  = 0;
    	for(int q= 1 ; q < t.length() ; q++)
    	{
    		while(k > 0 && t.charAt(k+1) != t.charAt(q)) k = next[k];
    		
    		if(t.charAt(k+1) == t.charAt(q)) k++;
    			
    		next[q] = k;
    	}
    	return next;
    }
	
	
//    =====================================================
 /*   输入字符串为s,翻转后字符串为t,检查 s == t是否成立，如果成立，则返回输入串s;
   	  否则，将字符串每次向前移动一个字符，检查串s和串t重合部分是否相等，如相等，则
   	 merge串s和串t, 并返回组合后的字符串.
   	 否则再次将串t想左移动一个字符再判断...
   	 
   	串s   aacecaaa
   	串t   aaacecaa   //step1 比较串s和串t
    ----------------------------------        
            串s   aaacecaa
            串t  aaacecaa    //step2 串t向左移动一个字符，在比较s和t重合部分是否相等
  合并后           aaacecaaa
    经检测串s和串t重合部分相等，则合并串s和串t，并返回        
    -------------------------------        
*/
	public String shortestPalindrome2(String s) 
	{
		if(s.length() <= 1) return s;
		StringBuffer pattern = new StringBuffer(s).reverse(); 
		String mirror = new String(pattern);
		int i = 0;
		for(;i < s.length() ; i++)
		{
			if(mirror.substring(i).equals(s.substring(0, s.length()-i))) break;
		}
		return mirror.substring(0, i)+s;
	}
//	-----------------------------------------------
    public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ShortestPalindrome_T214 t214 = new ShortestPalindrome_T214();
		
		String s1 = "aacecaaa";
		String s2 = "abcd";
		String s3 = "";
		System.out.println("["+t214.shortestPalindrome2(s1)+"]");
		System.out.println("["+t214.shortestPalindrome2(s2)+"]");
		System.out.println("["+t214.shortestPalindrome2(s3)+"]");
	}

}
