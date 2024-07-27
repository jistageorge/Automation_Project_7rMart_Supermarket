package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.XlUtility;

public class LoginTest extends Base{
	@Test                    
	public void verifyUserLoginWithCorrectUsernameAndPassword() {			
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  
		boolean homePageNavigated=loginpage.verifyHomePageNavigated();
		assertTrue(homePageNavigated,"Not navigated to home page even if user enters correct username and password");		
	}
	@Test                    
	public void verifyUserLoginWithCorrectUsernameAndWrongPassword() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");
		String passwordExpected=XlUtility.getString(1, 3, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton(); 
		boolean isHomePageDisplayed=loginpage.verifyHomePageNotNavigated();
		assertTrue(isHomePageDisplayed,"Navigated to home page even if user enters correct username and wrong password");		
	}
	@Test                    
	public void verifyUserLoginWithWrongUsernameAndCorrectPassword() {
		String userNameExpected=XlUtility.getString(1, 2, "LoginPage");
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton(); 
		boolean isHomePageDisplayed=loginpage.verifyHomePageNotNavigated();
		assertTrue(isHomePageDisplayed,"Navigated to home page even if user enters wrong username and correct password");		
	}
	@Test                    
	public void verifyUserLoginWithWrongUsernameAndPassword() {
		String userNameExpected=XlUtility.getString(1, 2, "LoginPage");
		String passwordExpected=XlUtility.getString(1, 3, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton(); 
		boolean isHomePageDisplayed=loginpage.verifyHomePageNotNavigated();
		assertTrue(isHomePageDisplayed,"Navigated to home page even if user enters wrong username and password");		
	}
}
