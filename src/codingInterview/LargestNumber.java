package codingInterview;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber
{
    public String largestNumber(int[] nums) 
    {
    	String[] str = new String[nums.length];
    	
    	for(int i = 0 ; i < nums.length; i++)
    	{
    		str[i] = String.valueOf(nums[i]);
    	}
    	
    	Arrays.sort(str, new Comparator<String>()
		{
    		@Override
    		public int compare(String o1, String o2)
    		{
    			// TODO Auto-generated method stub
    			String o1o2 = o1.concat(o2);
    			String o2o1 = o2.concat(o1);
    			return o2o1.compareTo(o1o2);//按字典序比较字符串
    		}
		});
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for(int j = 0 ; j < str.length; j++)
    	{
    		sb.append(str[j]);
    	}
    	
    	//这儿要先转为BigInteger,再由BigInteger转为字符串,
    	//防止"00"这样的直接返回了。而转为BigInteger则变为了0,再返回就是"0".
    	BigInteger bi = new BigInteger(sb.toString());
    	
        return bi.toString();
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LargestNumber ln = new LargestNumber();
		
		int[] nums = new int[]{3, 30, 34, 5, 9};
		
		System.out.println(ln.largestNumber(nums));
	}

}
