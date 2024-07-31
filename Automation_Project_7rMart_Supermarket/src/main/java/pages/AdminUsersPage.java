package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement moreInfoButton;
	@FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement searchButton;
	@FindBy(xpath="//input[@name='un']") private WebElement userNameInputField;
	@FindBy(xpath="//button[@value='sr']") private WebElement searchButtonInsideSearchAdminUsers;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//td[1]") private WebElement userNameColumnValue;
	@FindBy(xpath="//div[@class='card-body']//a[text()='Reset']") private WebElement resetButtonInsideSearchUser;
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement addNewUserButton;
	@FindBy(xpath="//input[@name='username']") private WebElement userNameAddUser;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordAddUser;
	@FindBy(xpath="//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath="//select[@id='user_type']") private WebElement selectDropdown;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertSuccess;

	
	public AdminUsersPage clickMoreInfoButton() {
		moreInfoButton.click();
		return this;
	}
	public AdminUsersPage clickSearchButton() {
		searchButton.click();
		return this;
	}
	public AdminUsersPage userNameOnSearchInput(String userNameSearchInput) {
		userNameInputField.sendKeys(userNameSearchInput);
		return this;
	}
	public AdminUsersPage clickSearchButtonInsideSearchAdminUsers() {
		searchButtonInsideSearchAdminUsers.click();
		return this;
	}
	public String checkSearchedUserNameIsDisplayed() {
		String tableValue=userNameColumnValue.getText();
		return tableValue;		
	}
	public AdminUsersPage clickResetButtonInsideSearchAdminUsers() {
		resetButtonInsideSearchUser.click();
		return this;
	}
	public boolean verifyResetButtonInsideSearchAdminUsersEnabled() {
		boolean resetEnabled=resetButtonInsideSearchUser.isEnabled();
		return resetEnabled;
	}
	public AdminUsersPage clickAddNewUserButton() {
		addNewUserButton.click();
		return this;
	}
	public AdminUsersPage enterUserNameOnUserNameFieldAddUser(String usernametoadduser) {
		userNameAddUser.sendKeys(usernametoadduser);
		return this;
	}
	public AdminUsersPage enterPasswordOnUserNameFieldAddUser(String passwordtoaddusser) {
		passwordAddUser.sendKeys(passwordtoaddusser);
		return this;
	}
	public void selectDropdownElement(String value) {
		PageUtility pageutility=new PageUtility();
		pageutility.selectValueUsingSelectByValue(selectDropdown,value);		
	}	
	public AdminUsersPage clickonSaveButton() {
		saveButton.click();
		return this;
	}
	public String checkAddedUserNameIsDisplayed() {
		String usernameTableValue=userNameColumnValue.getText();
		return usernameTableValue;		
	}
}
