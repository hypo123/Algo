package codingInterview;

//使用有限自动机DFA
public class ValidNumber2
{
	private enum Type
	{
        INVALID,    // 0
        SPACE,      // 1
        SIGN,       // 2
        DIGIT,      // 3
        DOT,        // 4
        EXPONENT,   // 5
	}
	
    public boolean isNumber(String s) 
    {
    	int[][] stateTable = 
    		{
    			//INVALID SPACE SIGN DIGIT DOT EXPONMENT
    		   //所在列   0    1      2    3    4     5
    				{-1,   0,     1,   2,   3,   -1}, //state 0
    				{-1,  -1,    -1,   2,   3,   -1}, //state 1
    				{-1,   8,    -1,   2,   4,    5}, //state 2
    				{-1,  -1,    -1,   4,  -1,   -1}, //state 3
    				{-1,   8,    -1,   4,  -1,    5}, //state 4
    				{-1,  -1,     6,   7,  -1,   -1}, //state 5
    				{-1,  -1, 	 -1,   7,  -1,   -1}, //state 6
    				{-1,   8, 	 -1,   7,  -1,   -1}, //state 7
    				{-1,   8, 	 -1,  -1,  -1,   -1}, //state 8
    		};
    		
    		int state = 0;//其实状态state0
    		
    		
    		for(int i = 0 ; i < s.length(); i++)
    		{
    			Type type = Type.INVALID;
    			char tmp = s.charAt(i);
    			
    			if(tmp == ' ')
    			{
    				type = Type.SPACE;
    			}
    			else if(tmp == '+' || tmp == '-')
    			{
    				type = Type.SIGN;
    			}
    			else if(Character.isDigit(tmp))
    			{
    				type = Type.DIGIT;
    			}
    			else if(tmp == '.')
    			{
    				type = Type.DOT;
    			}
    			else if(tmp == 'e')
    			{
    				type = Type.EXPONENT;
    			}
    			else
    			{
    				type = Type.INVALID;//不合法字符
    			}
    			
    			//ordinal()返回此枚举常量的序数
    			state = stateTable[state][type.ordinal()];//转移到下一个状态
    			
    			if(state == -1)
    			{
    				return false;
    			}
    		}
    		
    	//结束状态为state2 state4 state7 state8为合法的.	
        return state == 2 || state == 4 || state == 7 || state == 8;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ValidNumber2 vn2 = new ValidNumber2();
		
		String s = "2e10";
		
		System.out.println(vn2.isNumber(s));
	}

}
