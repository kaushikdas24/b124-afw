package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1
{
	@FindBy(name="q")
	private WebElement element;
	
	public Page1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setElement(String s)
	{
		element.sendKeys(s);
	}
}
