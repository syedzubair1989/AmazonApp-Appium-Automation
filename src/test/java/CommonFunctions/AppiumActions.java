package CommonFunctions;

import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ExperionGlobal.AmazonApp.AppTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;


public class AppiumActions extends AppTest  {
  
	 public void SendText(WebElement element,String Text)
	 {
		 element.sendKeys(Text);
	 }
	 
	 public void ClickElement(WebElement element)
	 {
		 element.click();
	 }
	 
	 public void AssertElementDisplay(WebElement element)
	 {
		 Assert.assertTrue(element.isDisplayed(), element+ " is not displayed");
	 }
	 
	 public void ExplicitWait(WebElement element)
	  {
	    	WebDriverWait wait = new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.elementToBeClickable(element));
		 
		
	  }
	 
	 public String getText(WebElement elementText)
	 {
		 return elementText.getText();
	 }
	 
	 public void VisibilityOfElement(WebElement element)
	 {
	    	WebDriverWait wait = new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 
	 public void ClearText(WebElement element)
	 {
		 element.clear();
	 }
	 
	
	public void scrollToText(String text, AppiumDriver<WebElement> driver)
				throws MalformedURLException, InterruptedException {
		    	 MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver)
						    .findElementByAndroidUIAutomator("new UiScrollable("
						        + "new UiSelector().scrollable(true)).scrollIntoView("                      
						        + "new UiSelector().textContains(\""+text+"\"));");
		}
}
