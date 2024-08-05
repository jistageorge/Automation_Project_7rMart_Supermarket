package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.XlUtility;
import retry.Retry;
public class LoginTest extends Base{
	@Test(description="This is for verifying loginpage with valid credentials ",groups= {"Smoke"},retryAnalyzer=Retry.class)                   
	public void verifyUserLoginWithCorrectUsernameAndPassword() {			
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  
		boolean homePageNavigated=loginpage.verifyHomePageNavigated();
		assertTrue(homePageNavigated,"Not navigated to home page even if user enters correct username and password");		
	}
	
	@Test(description="This is for verifying loginpage with valid username and invalid password",groups= {"Regression"})                   
	public void verifyUserLoginWithCorrectUsernameAndWrongPassword() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");
		String passwordExpected=XlUtility.getString(1, 3, "LoginPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton(); 
		boolean isHomePageDisplayed=loginpage.verifyHomePageNotNavigated();
		assertTrue(isHomePageDisplayed,"Navigated to home page even if user enters correct username and wrong password");		
	}
	
	@Test(description="This is for verifying loginpage with invalid username and valid password",dataProvider="LoginProvider")                 
	public void verifyUserLoginWithWrongUsernameAndCorrectPassword(String userNameExpected,String passwordExpected) 	{			
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton(); 
		boolean isHomePageDisplayed=loginpage.verifyHomePageNotNavigated();
		assertTrue(isHomePageDisplayed,"Navigated to home page even if user enters wrong username and correct password");		
	}
	
	@Test(description="This is for verifying loginpage with invalid username and password")                    
	public void verifyUserLoginWithWrongUsernameAndPassword() {
		String userNameExpected=XlUtility.getString(1, 2, "LoginPage");
		String passwordExpected=XlUtility.getString(1, 3, "LoginPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton(); 
		boolean isHomePageDisplayed=loginpage.verifyHomePageNotNavigated();
		assertTrue(isHomePageDisplayed,"Navigated to home page even if user enters wrong username and password");		
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { XlUtility.getString(1, 2, "LoginPage"), XlUtility.getString(1, 1, "LoginPage") },
		};
	
}}
