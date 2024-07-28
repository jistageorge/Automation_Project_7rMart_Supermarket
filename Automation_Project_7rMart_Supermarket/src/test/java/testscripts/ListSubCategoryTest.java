package testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import org.testng.annotations.Test;

import pages.ListSubCategoryPage;
import pages.LoginPage;
import utilities.XlUtility;

public class ListSubCategoryTest extends Base {
	
	@Test                    
	public void verifyUserAbleToEditAndUploadFileInSubCategoryPageUsingSendKeys() throws AWTException {
		
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		String imgFilePath=XlUtility.getString(1, 0, "ListSubCategoryPage");	
		String scrollData=XlUtility.getString(1, 1, "ListSubCategoryPage");	
				
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  
		
		ListSubCategoryPage listsubcategorypage=new ListSubCategoryPage(driver);		
		listsubcategorypage.fluentWaitWithContainedAttribute();		
		listsubcategorypage.clickSubCategoryMoreInfoLink().clickEditButtonSubCategoryPage();								
		listsubcategorypage.chooseFileOfEditSubCategorySendKeysMethod(imgFilePath);	
		listsubcategorypage.clickableWaitElement();	
		
		listsubcategorypage.clickUpdateButton();					    
		listsubcategorypage.scrollDownSubCategoryPage(scrollData);
		listsubcategorypage.scrollUpSubCategoryPage();
		listsubcategorypage.doubleClickOnPaginationSecondPage();
		boolean isFileUploaded= listsubcategorypage.isFileUploaded();
		assertTrue(isFileUploaded,"User is not able to edit and upload file in sub category page");	
	}
	
	@Test
	public void verifyUserIsAbleToDeleteSubCategory() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");							
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  		
		ListSubCategoryPage listsubcategorypage=new ListSubCategoryPage(driver);
		listsubcategorypage.clickSubCategoryMoreInfoLink().clickDeleteButtonSubCategoryPage();			
		listsubcategorypage.acceptAlertDeleteSubCategory();
		boolean alertDeletedSubCategory=listsubcategorypage.deleteSubCategorySuccessAlertDisplayed();
		assertTrue(alertDeletedSubCategory,"User is not able to delete subcategory");
	}
	
	@Test                    
	public void verifyUserAbleToEditAndUploadFileInSubCategoryPageUsingRobotClass() throws AWTException {
		
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		String imgPathLink=XlUtility.getString(1, 3, "ListSubCategoryPage");
			
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();  
		
		ListSubCategoryPage listsubcategorypage=new ListSubCategoryPage(driver);
		listsubcategorypage.clickSubCategoryMoreInfoLink().clickEditButtonSubCategoryPage();		
		listsubcategorypage.chooseFileOfEditSubCategoryRobotClassMethod(imgPathLink);		
		listsubcategorypage.clickUpdateButton();
				
		boolean isImageDisplayed= listsubcategorypage.isFileUploaded();
		assertTrue(isImageDisplayed,"User is not able to edit and upload file in sub category page");
		
	}
		
}
