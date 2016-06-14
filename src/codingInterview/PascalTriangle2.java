package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2
{
    public List<Integer> getRow(int rowIndex)
    {
    	List<Integer> row = new ArrayList<Integer>();
    	if(rowIndex < 0) return row;
    	
    	row.add(1);
    	
    	int mid = 0;
    	
    	for(int i = 1 ; i <= rowIndex; i++)
    	{
    		for (int j = 0; j <= i; j++)
			{
    			
				if (j - 1 > -1 && j < i )
				{
					int tmp = row.get(j);
					row.remove(j);
					
					if(j == i - 1)
					{
						row.add( tmp + mid);
					}
					else
					{
						row.add(j , tmp + mid);
					}
					mid = tmp;
					continue;
				} 
				else if (j - 1 > -1 && j == i )//右边界
				{
					row.add(mid);
					break;
					
				} 
				else if (j - 1 == -1 && j < i )//左边界
				{
					mid = row.get(j);
					continue;
				}
			}
    	}
        return (List)row;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PascalTriangle2 pt2 = new PascalTriangle2();

		int num = 5 ;

		List<Integer> result = (List) pt2.getRow(num);

		for (int i = 0; i < result.size(); i++)
		{
				System.out.print(result.get(i) + " ");
		}
	}

}
