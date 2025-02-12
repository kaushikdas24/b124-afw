package script;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.HomePage;
import page.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority = 1)
	public void testValidLogin()
	{
		String un=Excel.getData("./data/input.xlsx","ValidLogin",1,0);
		String pw=Excel.getData("./data/input.xlsx","ValidLogin",1,1);
		
//		1. enter valid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
//		2. enter valid password
		loginPage.setPassword(pw);
		
//		3. click on go button
		loginPage.clickGoButton();
		
//		4. verify that home page is displayed
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.verifyHomePageIsDisplayed(wait);
//		Assert.assertEquals(result, true);
		Assert.assertTrue(result);
	}
}
