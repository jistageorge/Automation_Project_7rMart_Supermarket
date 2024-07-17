package MyProject_TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class VerifyLoginPage extends Base{
	@Test                    
	public void verifyUserLoginWithCorrectUsernameAndPassword() {
		String userNameExpected="admin";
		WebElement userNameInput=driver.findElement(By.xpath("//input[@name='username']"));
		userNameInput.sendKeys(userNameExpected);
			
		
		String passwordExpected="admin";
		WebElement passwordInput=driver.findElement(By.xpath("//input[@name='password']"));	
		passwordInput.sendKeys(passwordExpected);
		
		WebElement signinButton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signinButton.click();
		
		WebElement dashboard=driver.findElement(By.linkText("Dashboard"));
		boolean loggedinPageText=dashboard.isDisplayed();
		assertTrue(loggedinPageText,"Login Unsuccessfull");
		
	}
	@Test       
	public void verifyUserLoginWithCorrectUsernameAndWrongPassword() {
		String userNameExpected="admin";
		WebElement userNameInput=driver.findElement(By.xpath("//input[@name='username']"));
		userNameInput.sendKeys(userNameExpected);
		
		String passwordExpected="adm";
		WebElement passwordInput=driver.findElement(By.xpath("//input[@name='password']"));	
		passwordInput.sendKeys(passwordExpected);
		
		WebElement signinButton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signinButton.click();
		
		WebElement invalidPasswordAlert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean alertDisplayed=invalidPasswordAlert.isDisplayed();
		assertTrue(alertDisplayed,"Alert not displayed");
	}
	@Test        
	public void verifyUserLoginWithWrongUsernameAndCorrectPassword() {
		String userNameExpected="user";
		WebElement userNameInput=driver.findElement(By.xpath("//input[@name='username']"));
		userNameInput.sendKeys(userNameExpected);
		
		String passwordExpected="admin";
		WebElement passwordInput=driver.findElement(By.xpath("//input[@name='password']"));	
		passwordInput.sendKeys(passwordExpected);
		
		WebElement signinButton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signinButton.click();
		
		WebElement invalidUsernameAlert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean alertDisplayed=invalidUsernameAlert.isDisplayed();
		assertTrue(alertDisplayed,"Alert not displayed");
	}
	@Test       
	public void verifyUserLoginWithWrongUsernameAndPassword() {
		String userNameExpected="user";
		WebElement userNameInput=driver.findElement(By.xpath("//input[@name='username']"));
		userNameInput.sendKeys(userNameExpected);
		
		String passwordExpected="adm";
		WebElement passwordInput=driver.findElement(By.xpath("//input[@name='password']"));	
		passwordInput.sendKeys(passwordExpected);
		
		WebElement signinButton=driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signinButton.click();
		
		WebElement invalidUsernamePasswordAlert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean alertDisplayed=invalidUsernamePasswordAlert.isDisplayed();
		assertTrue(alertDisplayed,"Alert not displayed");
	}
}
