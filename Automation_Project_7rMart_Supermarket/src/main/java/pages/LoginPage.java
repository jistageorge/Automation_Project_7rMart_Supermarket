package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']") private WebElement userNameInput;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordInput;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") private WebElement signinButton;
	@FindBy(linkText="Dashboard") private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement invalidCredentialsAlert;
	
	public LoginPage enterUserNameOnUserNameField(String username) {
		userNameInput.sendKeys(username);
		return this;
	}
	public LoginPage enterPasswordOnUserNameField(String password) {
		passwordInput.sendKeys(password);
		return this;
	}
	public LoginPage clickonSigninButton() {
		signinButton.click();
		return this;
	}
	public boolean verifyHomePageNavigated() {
		boolean isHomePageNavigated=dashboard.isDisplayed();
		return isHomePageNavigated;		
	}
	public boolean verifyHomePageNotNavigated() {
		boolean isAlertDisplayed=invalidCredentialsAlert.isDisplayed();
		return isAlertDisplayed;		
	}	
}
