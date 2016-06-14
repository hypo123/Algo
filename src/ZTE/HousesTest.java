package ZTE;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HousesTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testhouseNumber()
	{
		int[][] grid1 = {
							 {1 , 0 , 0},
							 {0 , 1 , 0},
							 {0 , 0 , 1}
						 };
		int expt1 = 3;
		org.junit.Assert.assertEquals("Wrong1", expt1, Houses.houseNumber(grid1));
	
		int[][] grid2 = {
							{1 , 0 , 1},
							{1 , 1 , 1},
							{0 , 1 , 1}
						};
		int expt2 = 1;
		org.junit.Assert.assertEquals("Wrong2", expt2, Houses.houseNumber(grid2));
	
		int[][] grid3 = {
							{1 , 0 , 1},
							{0 , 0 , 1},
							{0 , 1 , 1}
						};
		int expt3 = 2;
		org.junit.Assert.assertEquals("Wrong3", expt3, Houses.houseNumber(grid3));
	}

}
