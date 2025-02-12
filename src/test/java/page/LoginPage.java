package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id="input-username")
	private WebElement usernameTB;
	
	@FindBy(id="input-password")
	private WebElement passwordTB;
	
	@FindBy(name="login-button")
	private WebElement goBTN;
	
	
	@FindBy(css = "div.error")
	private WebElement errMsg;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUserName(String un)
	{
		usernameTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	
	public void clickGoButton()
	{
		goBTN.click();
	}
	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Error Msg is Displayed",true);
			return true;//pass
		}
		catch (Exception e) 
		{
			Reporter.log("Error Msg is NOT Displayed",true);
			return false;//fail
		}
	}
}
