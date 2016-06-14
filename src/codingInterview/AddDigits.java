package codingInterview;

/**
 * 数学找规律
 *    --- 任何一个整数模9同余于它的各数位上数字之和 
 *
 *
 *　具体证明过程如下：

　　设自然数N=a[n]a[n-1]…a[0]，其中a[0]，a[1]、…、a[n]分别是个位、十位、…上的数字

　　再设M=a[0]+a[1]+…+a[n]

　　求证：N≡M(mod 9).


  　证明：
 　　  ∵ N=a[n]a[n-1]…a[0]=a[n]*10^n+a[n-1]*10^(n-1)+…+a[1]*10+a[0].
 　　 又∵ 1≡1(mod 9),
     　　 10≡1(mod 9),
   　　   10^2≡1(mod 9),
  　　      … 
 　　     10^n≡1(mod 9).
 　　 上面这些同余式两边分别同乘以a[0]、a[1]、a[2]、…、a[n]，再相加得：
 　　　　 a[0]+a[1]*10+…+a[n]*10^n≡(a[0]+a[1]+…+a[n])(mod 9)，
  　　　　　　　　　　　　　　　　  即 N≡M(mod 9)，得证。
 */
public class AddDigits
{
    public int addDigits(int num) 
    {
        if(num == 0)
        {
            return 0;
        }
    	else if(num % 9 == 0)
    	{
    		return 9;
    	}
    	else
    	{
    		return num % 9;
    	}
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AddDigits ad = new AddDigits();
		
		int num = 18;
		System.out.println(ad.addDigits(num));
				
	}

}
