package ExperionGlobal.AmazonApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonFunctions.AppiumActions;
import ObjectRepository.Amazon_OR;
 

/**
 * @author syedzubairmehdi
 * 
 * Sample Automation test for Amazon App.
 */
public class AppTest extends BaseTest
{
	
	@Test
    public void AmazonApp() throws MalformedURLException, InterruptedException
    {

    	//SetProperties setProperty = new SetProperties();
    	AppiumActions action = new AppiumActions();

		//Test Script Execution
		test.log(LogStatus.INFO, "Navigate to Amazon Home page");
        action.ExplicitWait(Amazon_OR.SkipSignIn);
		action.ClickElement(Amazon_OR.SkipSignIn);
		test.log(LogStatus.INFO, "Clicked On  Search Bar");
        action.ExplicitWait(Amazon_OR.SearchBar);
        action.ClickElement(Amazon_OR.SearchBar);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Searching for 65 inch TV");
        action.SendText(Amazon_OR.SearchBar, "65 inch");
        action.ClickElement(Amazon_OR.SixtyFiveinchtv);
		test.log(LogStatus.INFO, "Scroll To Text Mx Ultra Slim");
        action.scrollToText("MX Ultra Slim", driver);
		test.log(LogStatus.INFO, "Click On MX TV Set");
		action.ClickElement(Amazon_OR.TvText);
		test.log(LogStatus.INFO, "Allow Current Location Access");
        action.ExplicitWait(Amazon_OR.UseCurrentLocation);
		action.ClickElement(Amazon_OR.UseCurrentLocation);
		action.ClickElement(Amazon_OR.AllowButton);
		action.ExplicitWait(Amazon_OR.TvText);
		test.log(LogStatus.INFO, "Validating Product Description Page Opening");
        action.AssertElementDisplay(Amazon_OR.TvText);
        
   }
    
}
