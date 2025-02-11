package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.Page1;

public class Test4 extends BaseTest
{
	@Test
	public void testB()
	{
		String v = Excel.getData("./data/input.xlsx","Sheet1", 0, 0);
		Reporter.log(driver.getTitle(),true);
		Page1 p=new Page1(driver);
		p.setElement(v);
		int a =10;
	}
}
