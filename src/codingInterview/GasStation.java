package codingInterview;

public class GasStation
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
    	int total = 0;
    	int num = 0;
    	int j = -1;
    	
    	for(int i = 0 ; i < gas.length; ++i)
    	{
    		num += gas[i] - cost[i];
    		total += gas[i] - cost[i];
    		
    		if(num < 0)
    		{
    			j = i;
    			num = 0;
    		}
    		
    	}
        return total >= 0 ? j + 1 : -1;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GasStation gs = new GasStation();
		
		int[] gas = {1,10,10,15,5};
		int[] cost = {5,15 , 1 ,2,9};
		
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}

}
