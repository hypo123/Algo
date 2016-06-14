package ZTE;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LRUTest
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
	public void testMissTimes()
	{
		int cachesize1 = 2;
		int[] pages1 = {1, 2, 2, 3, 1, 2, 3};
		int expt1 = 6;
		org.junit.Assert.assertEquals("Wrong1", expt1, LRU.missTimes(cachesize1, pages1));

		int cachesize2 = 1;
		int[] pages2 = {1, 2, 3, 4, 5, 6, 7};
		int expt2 = 7;
		org.junit.Assert.assertEquals("Wrong2", expt2, LRU.missTimes(cachesize2, pages2));
	}

}
