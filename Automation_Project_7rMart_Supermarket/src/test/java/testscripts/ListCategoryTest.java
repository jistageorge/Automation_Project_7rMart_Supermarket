package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ListCategoryPage;
import pages.LoginPage;
import utilities.XlUtility;

public class ListCategoryTest extends Base {
	@Test
	public void verifyCategoryExistsInTable() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		String categoryExpected=XlUtility.getString(1, 0, "ListCategoryPage");	
				
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();
		
		ListCategoryPage listcategorypage=new ListCategoryPage(driver);
		listcategorypage.categoryMoreInfo();			
		boolean isActualCatgeoryTitle=listcategorypage.verifyCategoryExistsInsideTable(categoryExpected);	
		assertTrue(isActualCatgeoryTitle,"User is not able to find the expected category from the category table");
	}
}
