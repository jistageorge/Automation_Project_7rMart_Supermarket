package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import retry.Retry;
import utilities.XlUtility;

public class AdminUsersTest extends Base {

	@Test(description="This is for verifying searched username is displayed in the results table",retryAnalyzer=Retry.class,dataProvider="LoginProvider")                    
	public void verifySearchedAdminUserNameDisplayedOnSearchResultsTable(String userNameExpected,String passwordExpected) {								
		String userNameOnSearchInput=XlUtility.getString(1, 0, "AdminUsersPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickSearchButton().userNameOnSearchInput(userNameOnSearchInput).clickSearchButtonInsideSearchAdminUsers();
		adminuserspage.checkSearchedUserNameIsDisplayed();		
		String searchResultUsername=adminuserspage.checkSearchedUserNameIsDisplayed();
		assertEquals(searchResultUsername,userNameOnSearchInput,"Searched username is not found in the search result table");
	}
		
	@Test(description="This is for verifying a new user is added to the admin user table",dataProvider="LoginProvider")     
	public void addNewUserToAdminUserTable(String userNameExpected,String passwordExpected) {				 
		String passwordExpectedAddUser=XlUtility.getString(1, 2, "AdminUsersPage");
		String dropdownValue=XlUtility.getString(1, 3, "AdminUsersPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		String userNameExpectedFake=adminuserspage.addNewUserUsingFakerUtility();	
		adminuserspage.clickMoreInfoButton().clickAddNewUserButton().enterUserNameOnUserNameFieldAddUser(userNameExpectedFake).enterPasswordOnUserNameFieldAddUser(passwordExpectedAddUser).selectDropdownElement(dropdownValue).clickonSaveButton();	
		String addedUsernameDisplayed=adminuserspage.checkAddedUserNameIsDisplayed();
		assertEquals(addedUsernameDisplayed,userNameExpectedFake,"User is not added to the admin user table");
	}
	
	@Test(description="This is for verifying reset function of searched admin user",groups= {"Regression"},dataProvider="LoginProvider")         
	public void verifyResetFunctionOfSearchedAdminUser(String userNameExpected,String passwordExpected) {			
		String userNameOnSearchInput=XlUtility.getString(1, 0, "AdminUsersPage");				
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickSearchButton().userNameOnSearchInput(userNameOnSearchInput).clickResetButtonInsideSearchAdminUsers();			
		boolean resetOfSearchEnabled=adminuserspage.verifyResetButtonInsideSearchAdminUsersEnabled();	
		assertTrue(resetOfSearchEnabled,"Reset action fails");		
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { XlUtility.getString(1, 0, "LoginPage"), XlUtility.getString(1, 1, "LoginPage") },
		};
	}
}