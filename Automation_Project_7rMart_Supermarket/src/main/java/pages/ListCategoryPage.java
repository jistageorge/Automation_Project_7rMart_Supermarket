package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ListCategoryPage {
	public WebDriver driver;
	public ListCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement categoryMoreInfoLink;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]") private List<WebElement> categoryColumnList;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]//a") private WebElement categoryStatus;
		
	public void categoryMoreInfo() {
		categoryMoreInfoLink.click();
	}
	
	public boolean verifyCategoryExistsInsideTable(String categoryExpected) {
		boolean flag=false;
		 for (WebElement columnTitle : categoryColumnList) {   			 	        			        	
	        	PageUtility pageutility=new PageUtility();
	        	String actualCategoryValue=pageutility.getText(columnTitle);
				
				if (actualCategoryValue.equals(categoryExpected)) 
			    {				
					flag=true;
			    }	            
	        }
		 return flag;
	}
	
	public String categoryStatusCheck() {
		PageUtility pageutility=new PageUtility();
    	String categoryStatusText=pageutility.getText(categoryStatus);    	
		return categoryStatusText;
	}
}
