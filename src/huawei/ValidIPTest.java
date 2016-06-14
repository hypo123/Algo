package huawei;

import org.junit.Test;

import junit.framework.TestCase;

public class ValidIPTest extends TestCase
{

	@Test
	public void test()
	{
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("0092.12.1.1", buffer);
		assertEquals("NO", buffer.toString());
	}
	
	@Test
	public void test1()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192.168.0.0", buffer);
		assertEquals("YES", buffer.toString());
	}
	
	@Test
	public void test2()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("10.138.15.1", buffer);
		assertEquals("YES", buffer.toString());
	}
	
	@Test
	public void test3()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("01.1.1.1", buffer);
		assertEquals("NO", buffer.toString());
	}
	
	@Test
	public void test4()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192.168.1 3.0", buffer);
		assertEquals("NO", buffer.toString());
	}
	
	@Test
	public void test5()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192.168.13.0", buffer);
		assertEquals("YES", buffer.toString());
	}
	
	@Test
	public void test6()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192.168..0", buffer);
		assertEquals("NO", buffer.toString());
	}
	
	@Test
	public void test7()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("0.0.0.0", buffer);
		assertEquals("NO", buffer.toString());
	}
	
	@Test
	public void test8()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192.-168..0", buffer);
		assertEquals("NO", buffer.toString());
	}
	@Test
	public void test9()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192.168.0.00", buffer);
		assertEquals("NO", buffer.toString());
	}
	@Test
	public void test10()
	{
		// TODO Auto-generated method stub
		ValidIP demo = new ValidIP();
		StringBuffer buffer = new StringBuffer();
		demo.checkIP("192   .168.1.2", buffer);
		assertEquals("NO", buffer.toString());
	}

}
