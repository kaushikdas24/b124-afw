package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class Test1 extends BaseTest
{
	@Test
	public void testA()
	{
		Reporter.log(driver.getTitle(),true);
	}
}
