package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
public WebDriver driver;    
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(); 	
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver(); 	
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver(); 	
		}
		else {
			throw new Exception("Browser is not connected");
		}
	
	driver.get("https://groceryapp.uniqassosiates.com/admin/login"); 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize(); 
	System.out.println();
	}	
	@AfterMethod(alwaysRun=true)	
	public void driverQuit()   
	{
	driver.quit();	
	}
}
