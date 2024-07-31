package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.XlUtility;

public class AdminUsersTest extends Base {
	

	@Test(description="This is for verifying searched username is displayed in the results table")                    
	public void verifySearchedAdminUserNameDisplayedOnSearchResultsTable() {
						
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");
		String userNameOnSearchInput=XlUtility.getString(1, 0, "AdminUsersPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickSearchButton().userNameOnSearchInput(userNameOnSearchInput).clickSearchButtonInsideSearchAdminUsers();
		adminuserspage.checkSearchedUserNameIsDisplayed();		
		String searchResultUsername=adminuserspage.checkSearchedUserNameIsDisplayed();
		assertEquals(searchResultUsername,userNameOnSearchInput,"Searched username is not found in the search result table");
	}
		
	@Test    
	public void addNewUserToAdminUserTable() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		String userNameExpectedAddUser=XlUtility.getString(1, 1, "AdminUsersPage");
		String passwordExpectedAddUser=XlUtility.getString(1, 2, "AdminUsersPage");
		String dropdownValue=XlUtility.getString(1, 3, "AdminUsersPage");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickAddNewUserButton().enterUserNameOnUserNameFieldAddUser(userNameExpectedAddUser).enterPasswordOnUserNameFieldAddUser(passwordExpectedAddUser);		
		adminuserspage.selectDropdownElement(dropdownValue);
		adminuserspage.clickonSaveButton();
		String addedUsernameDisplayed=adminuserspage.checkAddedUserNameIsDisplayed();
		assertEquals(addedUsernameDisplayed,userNameExpectedAddUser,"User is not added to the admin user table");
	}
	
	@Test    
	public void verifyResetFunctionOfSearchedAdminUser() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");			
		String userNameOnSearchInput=XlUtility.getString(1, 0, "AdminUsersPage");				
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickSearchButton().userNameOnSearchInput(userNameOnSearchInput);
		adminuserspage.clickResetButtonInsideSearchAdminUsers();			
		boolean resetOfSearchEnabled=adminuserspage.verifyResetButtonInsideSearchAdminUsersEnabled();	
		assertTrue(resetOfSearchEnabled,"Reset action fails");		
	}
	
}