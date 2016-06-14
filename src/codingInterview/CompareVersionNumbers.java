package codingInterview;

public class CompareVersionNumbers
{
    public int compareVersion(String version1, String version2) 
    {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int i = 0;
        
        while( i < ver1.length || i < ver2.length)
        {
        	if(i < ver1.length && i < ver2.length)
        	{
        		if(Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i]))
        		{
        			return 1;
        		}
        		else if(Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i]))
        		{
        			return -1;
        		}
        	}
        	else if(i < ver1.length)
        	{
        		if(Integer.parseInt(ver1[i]) != 0)
        		{
        			return 1;
        		}
        	}
        	else
        	{
        		if(Integer.parseInt(ver2[i]) != 0)
        		{
        			return -1;
        		}
        	}
        		
        	i++;
        }
        return 0;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		
		String v1 = "12.25.00";
		String v2 = "12.25";
		
		System.out.println(cvn.compareVersion(v1, v2));
	}

}
