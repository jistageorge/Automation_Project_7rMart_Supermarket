package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ListSubCategoryPage {
	
		public WebDriver driver;
		public ListSubCategoryPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']") private WebElement moreInfoSubCategoryLink;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=443&page_ad=1']") private WebElement editButtonSubCategoryPage;			
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/delete?del=444&page_ad=1']") private WebElement deleteButtonSubCategoryButton;			
		@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFileButton;			
		@FindBy(xpath="//button[text()='Update']") private WebElement updateButton;	
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr[2]//td[3]") private WebElement imgDisplayed;	
		@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement deletedSubCategoryAlert;	
		@FindBy(xpath="//ul[@class='pagination pagination-sm m-0 float-right']//li[2]") private WebElement pagination2Element;	
				
						
		public ListSubCategoryPage clickSubCategoryMoreInfoLink() {
			moreInfoSubCategoryLink.click();
			return this;
		}
		public ListSubCategoryPage clickEditButtonSubCategoryPage() {
			editButtonSubCategoryPage.click();
			return this;
		}
		
		public ListSubCategoryPage chooseFileOfEditSubCategorySendKeysMethod(String imgFilePath) throws AWTException {
			FileUploadUtility fileuploadutility=new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(chooseFileButton,imgFilePath);
			return this;
		}	
				
		public ListSubCategoryPage chooseFileOfEditSubCategoryRobotClassMethod(String imgPath) throws AWTException {			
			FileUploadUtility fileuploadutility=new FileUploadUtility();
			fileuploadutility.fileUploadUsingRobotClass(imgPath);	
			return this;
		}
		
		public ListSubCategoryPage scrollDownSubCategoryPage(String scrollData) {
			PageUtility pageutility=new PageUtility();
			pageutility.scrollDownPage((JavascriptExecutor) driver, scrollData);	
			return this;
		}
		
		public ListSubCategoryPage scrollUpSubCategoryPage() {
			PageUtility pageutility=new PageUtility();
			pageutility.scrollUpPage((WebDriver) driver);
			return this;
		}
		
		public boolean isFileUploaded() {
			boolean imageIsDisplayed=imgDisplayed.isDisplayed();
			return imageIsDisplayed;
		}
				
		public ListSubCategoryPage clickUpdateButton() {
			updateButton.click();
			return this;
		}
			
		public ListSubCategoryPage clickDeleteButtonSubCategoryPage() {
			deleteButtonSubCategoryButton.click();
			return this;
		}
		
		public ListSubCategoryPage acceptAlertDeleteSubCategory() {
			PageUtility pageutility=new PageUtility();
			pageutility.acceptAlert(driver);
			return this;
		}
		public boolean deleteSubCategorySuccessAlertDisplayed() {
			boolean isDeleteAlertDisplayed=deletedSubCategoryAlert.isDisplayed();
			return isDeleteAlertDisplayed;
		}
			
		public ListSubCategoryPage doubleClickOnPaginationSecondPage() {
			PageUtility pageutility=new PageUtility();
			pageutility.dragActionToDoubleClickElement(driver, pagination2Element);
			return this;
		}
		public ListSubCategoryPage clickableWaitElement() {
			WaitUtility waitutility=new WaitUtility();
			waitutility.clickableWait(driver, updateButton);
			return this;
		}
		public ListSubCategoryPage fluentWaitWithContainedAttribute() {
			WaitUtility waitutility=new WaitUtility();
			waitutility.fluentWaitByContainedAttribute(driver, moreInfoSubCategoryLink, "class", "small-box-footer" );
			return this;
		}
				
}

