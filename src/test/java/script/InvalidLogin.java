package script;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest
{
	@Test(priority = 2)
	public void testInvalidLogin()
	{
		
		String un=Excel.getData("./data/input.xlsx","InvalidLogin",1,0);
		String pw=Excel.getData("./data/input.xlsx","InvalidLogin",1,1);
		
//		1. enter invalid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
//		2. enter invalid password
		loginPage.setPassword(pw);
		
//		3. click on go button
		loginPage.clickGoButton();
		
//		4. verify that error is displayed
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);

	}
}
