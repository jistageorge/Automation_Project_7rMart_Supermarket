package testscripts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.XlUtility;

public class ManageNewsTest extends Base {

	@Test
	public void verifyHeaderOfManageNewsTable() {
		String userNameExpected=XlUtility.getString(1, 0, "LoginPage");  	
		String passwordExpected=XlUtility.getString(1, 1, "LoginPage");	
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickNewsMoreInfoLink();
		
		List<String> expectedHeaderList = new ArrayList<String>();
		expectedHeaderList.add("News");  
		expectedHeaderList.add("Action"); 
		
		List<String> actualHeaderList =managenewspage.verifyHeaderNews();	
		assertEquals(actualHeaderList,expectedHeaderList,"The header of manage news table is not as expected");
	}
	
}
