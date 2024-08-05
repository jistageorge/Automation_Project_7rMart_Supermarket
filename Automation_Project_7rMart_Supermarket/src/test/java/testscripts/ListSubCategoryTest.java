package testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ListSubCategoryPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ConstantsFile;
import utilities.XlUtility;

public class ListSubCategoryTest extends Base {
	
	@Test(description="This is for verifying user is able to edit and upload a file in subcategory page using send keys",dataProvider="LoginProvider")                    
	public void verifyUserAbleToEditAndUploadFileInSubCategoryPageUsingSendKeys(String userNameExpected,String passwordExpected) throws AWTException {						
		String imgFilePath=ConstantsFile.IMGFILEPATH;	
		String scrollData=XlUtility.getString(1, 1, "ListSubCategoryPage");				
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  		
		ListSubCategoryPage listsubcategorypage=new ListSubCategoryPage(driver);		
		listsubcategorypage.fluentWaitWithContainedAttribute().clickSubCategoryMoreInfoLink().clickEditButtonSubCategoryPage().chooseFileOfEditSubCategorySendKeysMethod(imgFilePath).clickableWaitElement().clickUpdateButton();					    
		listsubcategorypage.scrollDownSubCategoryPage(scrollData).scrollUpSubCategoryPage().doubleClickOnPaginationSecondPage();
		boolean isFileUploaded= listsubcategorypage.isFileUploaded();
		assertTrue(isFileUploaded,"User is not able to edit and upload file in sub category page");	
	}
	
	@Test(description="This is for verifying user is able to delete a subcategory",dataProvider="LoginProvider",groups= {"Regression"}) 
	public void verifyUserIsAbleToDeleteSubCategory(String userNameExpected,String passwordExpected) {						
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  		
		ListSubCategoryPage listsubcategorypage=new ListSubCategoryPage(driver);
		listsubcategorypage.clickSubCategoryMoreInfoLink().clickDeleteButtonSubCategoryPage().acceptAlertDeleteSubCategory();
		boolean alertDeletedSubCategory=listsubcategorypage.deleteSubCategorySuccessAlertDisplayed();
		assertTrue(alertDeletedSubCategory,"User is not able to delete subcategory");
	}
	
	@Test(description="This is for verifying user is able to upload file using robot class",dataProvider="LoginProvider",retryAnalyzer=Retry.class)                    
	public void verifyUserAbleToEditAndUploadFileInSubCategoryPageUsingRobotClass(String userNameExpected,String passwordExpected) throws AWTException {			
		String imgPathLink=ConstantsFile.IMGPATHLINK;			
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  		
		ListSubCategoryPage listsubcategorypage=new ListSubCategoryPage(driver);
		listsubcategorypage.clickSubCategoryMoreInfoLink().clickEditButtonSubCategoryPage().chooseFileOfEditSubCategoryRobotClassMethod(imgPathLink).clickUpdateButton();				
		boolean isImageDisplayed= listsubcategorypage.isFileUploaded();
		assertTrue(isImageDisplayed,"User is not able to edit and upload file in sub category page");		
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { XlUtility.getString(1, 0, "LoginPage"), XlUtility.getString(1, 1, "LoginPage") },
		};
	}
}
