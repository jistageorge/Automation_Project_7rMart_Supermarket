package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	 public void selectValueUsingSelectByValue(WebElement dropdown,String value) {
		Select select=new Select(dropdown);
		select.selectByValue(value);
	 }	
	 public void selectValueUsingSelectByIndex(WebElement dropdown,int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	 }
	 public void selectValueUsingSelectByVisibleText(WebElement dropdown,String visibleText) {
		Select select=new Select(dropdown);
		select.selectByVisibleText(visibleText);
	 }
	 public void scrollDownPage(JavascriptExecutor driver, String scrollData) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scrollData);  
	 }	
	 public void scrollUpPage(WebDriver driver) {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-350)", "");
	 }		
	 public String getAlertText(WebDriver driver,WebElement alertElement) {
		String alertText=driver.switchTo().alert().getText();  
		return alertText;
	 }
	 public void acceptAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
	 }
	 public void dismissAlert(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
	 }	 
	 public void enterValueToAlert(WebDriver driver,WebElement alertElement, String valueEntered) {
		 driver.switchTo().alert().sendKeys(valueEntered); 
	 }	 
	 public void dragActionToHoverElementUsingMouse(WebDriver driver, WebElement element) {
		 Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	 }	 
	 public void dragActionToDoubleClickElement(WebDriver driver, WebElement element) {
		 Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	 }	 
	 public void dragActionToRightClickElement(WebDriver driver, WebElement element) {
		 Actions actions=new Actions(driver);
		 actions.contextClick(element).build().perform();
	 }
	 public void dragAndDropAction(WebDriver driver, WebElement sourceElement, WebElement DestinationElement2) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(sourceElement, DestinationElement2).build().perform();
	 } 
	 public String getTagName(WebElement element) {
		 String tagName=element.getTagName();
		 return tagName;
	 }
	 public String getAttribute(WebElement element,String attributeValue) {
		 String attribute=element.getAttribute(attributeValue);
		 return attribute;
	 }
	 public String getCssValue(WebElement element,String cssElement) {
		 String cssValue=element.getCssValue(cssElement);
		 return cssValue;
	 }	 
	 public String getText(WebElement element) {
		 String getText=element.getText();
		 return getText;
	 }
	 public void switchToIframe(WebDriver driver, WebElement iframeElement,WebElement elementInsideIframe) {
		 driver.switchTo().frame(iframeElement);
		 elementInsideIframe.click();
	 }	 
	 
}
