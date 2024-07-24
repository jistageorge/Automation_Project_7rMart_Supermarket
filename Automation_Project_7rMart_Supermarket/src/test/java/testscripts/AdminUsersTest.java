package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	

	@Test                    
	public void verifySearchedAdminUserNameDisplayedOnSearchResultsTable() {
		
				
		String userNameOnSearchInput="AnusreeJudson";
		String userNameExpected="admin";
		String passwordExpected="admin";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected);
		loginpage.enterPasswordOnUserNameField(passwordExpected);
		loginpage.clickonSigninButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickSearchButton().userNameOnSearchInput(userNameOnSearchInput).clickSearchButtonInsideSearchAdminUsers();
		adminuserspage.checkSearchedUserNameIsDisplayed();
		
		String searchResultUsername=adminuserspage.checkSearchedUserNameIsDisplayed();
		assertEquals(searchResultUsername,userNameOnSearchInput,"Searched username is not found in the search result table");
	}
		
	@Test    
	public void addNewUserToAdminUserTable() {
		String userNameExpected="admin";
		String passwordExpected="admin";
		String userNameExpectedAddUser="jis";
		String passwordExpectedAddUser="jis";
		String dropdownValue="staff";
		
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
		String userNameExpected="admin";
		String passwordExpected="admin";		
		String userNameOnSearchInput="AnusreeJudson";
				
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoButton().clickSearchButton().userNameOnSearchInput(userNameOnSearchInput);
		adminuserspage.clickResetButtonInsideSearchAdminUsers();	
		
		boolean resetOfSearchEnabled=adminuserspage.verifyResetButtonInsideSearchAdminUsersEnabled();	
		assertTrue(resetOfSearchEnabled,"Reset action fails");		
	}
	
	
}