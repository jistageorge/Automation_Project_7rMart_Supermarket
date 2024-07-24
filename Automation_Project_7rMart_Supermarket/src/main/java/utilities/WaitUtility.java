package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
  public static final long EXPLICITWAIT=10;  
  public static final long IMPLICITWAIT=10;   
  public static final long FLUENTWAITTIMEOUT=30;   
  public static final long FLUENTWAITPOLLINGTIME=5;   
  
  public void clickableWait(WebDriver driver,WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));         
	  wait.until(ExpectedConditions.elementToBeClickable(element));		
  }
  public void waitByVisibilityOfElementLocated(WebDriver driver,WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));         
	  wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));		
  }
  public void waitByTextToBePresentInElement(WebDriver driver,WebElement element, String textInElement) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));         
	  wait.until(ExpectedConditions.textToBePresentInElement(element, textInElement));		
  }
  public void waitByTextToBePresentInElement(WebDriver driver, String titleText) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));         
	  wait.until(ExpectedConditions.titleContains(titleText)); 		
  }
  public void waitByTextToBePresentInElement(WebDriver driver,WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));         
	  wait.until(ExpectedConditions.visibilityOf(element)); 		
  }
  
  public void implicitWait(WebDriver driver) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT));
  }
  
  public void fluentWaitByVisibilityOfElement(WebDriver driver,WebElement element) {
	  Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)   
			  .withTimeout(Duration.ofSeconds(FLUENTWAITTIMEOUT))
			  .pollingEvery(Duration.ofSeconds(FLUENTWAITPOLLINGTIME))
			  .ignoring(NoSuchElementException.class);
	  fluentWait.until(ExpectedConditions.visibilityOf(element));
  }
  public void fluentWaitByContainedAttribute(WebDriver driver,WebElement element,String attribute,String value) {
	  Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)   
			  .withTimeout(Duration.ofSeconds(FLUENTWAITTIMEOUT))
			  .pollingEvery(Duration.ofSeconds(FLUENTWAITPOLLINGTIME))
			  .ignoring(NoSuchElementException.class);
	  fluentWait.until(ExpectedConditions.attributeContains(element, attribute, value));
  }
  public void fluentWaitByNonEmptyAttribute(WebDriver driver,WebElement element,String attribute) {
	  Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)   
			  .withTimeout(Duration.ofSeconds(FLUENTWAITTIMEOUT))
			  .pollingEvery(Duration.ofSeconds(FLUENTWAITPOLLINGTIME))
			  .ignoring(NoSuchElementException.class);
	  fluentWait.until(ExpectedConditions.attributeToBeNotEmpty(element, "id"));
  }
  public void fluentWaitByContainedTitle(WebDriver driver,String title) {
	  Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)   
		        .withTimeout(Duration.ofSeconds(FLUENTWAITTIMEOUT))
		        .pollingEvery(Duration.ofSeconds(FLUENTWAITPOLLINGTIME))
		        .ignoring(NoSuchElementException.class);
	  fluentWait.until(ExpectedConditions.titleContains(title));
  }

}
