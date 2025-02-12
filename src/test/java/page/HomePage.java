package page;

import org.checkerframework.common.util.count.report.qual.ReportCall;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(logout));
			Reporter.log("Home Page is Displayed",true);
			return true;//pass
		}
		catch (Exception e) 
		{
			Reporter.log("Home Page is NOT Displayed",true);
			return false;//fail
		}
	}
	
}
