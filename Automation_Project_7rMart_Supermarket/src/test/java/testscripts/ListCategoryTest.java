package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ListCategoryPage;
import pages.LoginPage;
import retry.Retry;
import utilities.XlUtility;

public class ListCategoryTest extends Base {
	@Test(description="This is for verifying a specific category exist inside the table",dataProvider="LoginProvider",retryAnalyzer=Retry.class)
	public void verifyCategoryExistsInTable(String userNameExpected,String passwordExpected) {			
		String categoryExpected=XlUtility.getString(1, 0, "ListCategoryPage");			
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		ListCategoryPage listcategorypage=new ListCategoryPage(driver);
		listcategorypage.categoryMoreInfo();			
		boolean isActualCatgeoryTitle=listcategorypage.verifyCategoryExistsInsideTable(categoryExpected);	
		assertTrue(isActualCatgeoryTitle,"User is not able to find the expected category from the category table");
	}
	@Test(description="This is for verifying category status in category table",dataProvider="LoginProvider",groups= {"Regression"})
	public void verifyCategoryStatusIsActiveInTable(String userNameExpected,String passwordExpected) {
		String categoryStatusExpected=XlUtility.getString(1, 1, "ListCategoryPage");					
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		ListCategoryPage listcategorypage=new ListCategoryPage(driver);
		listcategorypage.categoryMoreInfo();		
		String actualCategoryStatus=listcategorypage.categoryStatusCheck();
		assertEquals(actualCategoryStatus,categoryStatusExpected,"The category is not active inside the category table");		
	}	
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { XlUtility.getString(1, 0, "LoginPage"), XlUtility.getString(1, 1, "LoginPage") },
		};
	}
}
