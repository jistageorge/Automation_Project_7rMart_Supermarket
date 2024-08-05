package testscripts;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageNewsPage;
import retry.Retry;
import utilities.XlUtility;

public class ManageNewsTest extends Base {

	@Test(description="This is for verifying header of news table",dataProvider="LoginProvider",retryAnalyzer=Retry.class,groups= {"Regression"})
	public void verifyHeaderOfManageNewsTable(String userNameExpected,String passwordExpected) {		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameExpected).enterPasswordOnUserNameField(passwordExpected).clickonSigninButton();		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickNewsMoreInfoLink();			
		List<String> expectedHeaderList =managenewspage.addValuesToHeader();			 		
		List<String> actualHeaderList =managenewspage.verifyHeaderNews();		
		assertEquals(actualHeaderList,expectedHeaderList,"The header of manage news table is not as expected");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { XlUtility.getString(1, 0, "LoginPage"), XlUtility.getString(1, 1, "LoginPage") },
		};
	}
	
}
