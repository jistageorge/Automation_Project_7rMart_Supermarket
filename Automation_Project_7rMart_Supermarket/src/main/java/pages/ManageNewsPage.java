package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement newsMoreInfoLink;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//thead//th") List<WebElement> newsTableHeaderListElement;
	 
	public void clickNewsMoreInfoLink() {
		newsMoreInfoLink.click();
	}
	
	public List<String> verifyHeaderNews() {
    List<String> header = new ArrayList();	
		
	    for (WebElement headerElement : newsTableHeaderListElement) {	    	
           String headerValues= headerElement.getText();         
           header.add(headerValues);            
	    }
		return header;	    	   
	}
	
}
