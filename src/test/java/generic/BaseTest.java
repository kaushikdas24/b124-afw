	package generic;

import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"browser","usegrid","gridURL","appURL"})
	@BeforeMethod
	public void preCondition(
			@Optional("chrome")String browser,
			@Optional("no")String usegrid,
			@Optional("")String gridURL, 
			@Optional("https://pos.aksharatraining.in/pos/public/")String appURL)
			throws Exception
	{
		if(usegrid.equals("yes"))
		{
			if(browser.equals("chrome"))
			{
				Reporter.log("Open Chrome Browser in Remote System",true);
				URL remoteURL=new URL(gridURL);
				ChromeOptions options=new ChromeOptions();
				driver=new RemoteWebDriver(remoteURL,options);
			}
			else
			{
				Reporter.log("Open Edge Browser in Remote System",true);
				URL remoteURL=new URL(gridURL);
				EdgeOptions options=new EdgeOptions();
				driver=new RemoteWebDriver(remoteURL,options);
			}
		}
		else
		{
				if(browser.equals("chrome"))
				{
					Reporter.log("Open Chrome Browser in Local System",true);
					driver=new ChromeDriver();
				}
				else
				{
					Reporter.log("Open Edge Browser in Local System",true);
					driver=new EdgeDriver();
				}
		}
		
		Reporter.log("Enter the URL:"+appURL,true);
		driver.get(appURL);
		
		Reporter.log("Maximize the Browser",true);
		driver.manage().window().maximize();
		
		Reporter.log("Set ITO",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		Reporter.log("Set ETO",true);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void postCondition()
	{
		Reporter.log("Close the Browser",true);
		driver.quit();
	}
}
