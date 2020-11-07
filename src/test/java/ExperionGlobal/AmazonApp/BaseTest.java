package ExperionGlobal.AmazonApp;

import static Utils.SetProperties.appConfig;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;
import ObjectRepository.Amazon_OR;
import Utils.SetProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import static Utils.SetProperties.appConfig;




public class BaseTest  {
	
	public static AppiumDriver<WebElement> driver;

	static com.relevantcodes.extentreports.ExtentTest test;
	static com.relevantcodes.extentreports.ExtentReports report;


	
	@BeforeClass
    public static void startTest() throws MalformedURLException
	{
    	SetProperties setProperty = new SetProperties();

		//Extent Reporting Setup
		System.out.println("Extent Reporting");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        report = new com.relevantcodes.extentreports.ExtentReports(System.getProperty("user.dir")+"/target/Reports/"+timeStamp.replace(":","_").replace(":","_")+".html");
		test = report.startTest("Amazon App Product Search");
		report.loadConfig(new File(System.getProperty("user.dir") + "/target/extent-config.xml"));
		
		// Desired Capabilities SetUp
		final File appDir = new File(appConfig.getValue("AppLocation"));
		final File app = new File(appDir, appConfig.getValue("App"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("deviceName", appConfig.getValue("deviceName"));
		capabilities.setCapability("udid", appConfig.getValue("udid"));
		capabilities.setCapability("platformVersion", appConfig.getValue("androidVersion"));
		capabilities.setCapability("automationName", appConfig.getValue("automationName"));
        capabilities.setCapability("fullReset", true);
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		PageFactory.initElements(driver, Amazon_OR.class);
	}
	
	 @AfterMethod
	    public void getResult(ITestResult result){
	        if(result.getStatus()==ITestResult.FAILURE){
	        	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	        	System.out.println("Fail Flow");
				try {
					//This takes a screenshot from the driver at save it to the specified location
					//File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
					
					TakesScreenshot scrShot =((TakesScreenshot)driver);
	                 File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);
	                 
					//Building up the destination path for the screenshot to save
					//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
					File destinationPath = new File(System.getProperty("user.dir") + "/target/Screenshots/" + "screenshotName"+ timeStamp.replace(":","_").replace(":","_") + ".png");
					
					//Copy taken screenshot from source location to destination location
					Files.copy(sourcePath, destinationPath);   

					//This attach the specified screenshot to the test
					test.addScreenCapture(destinationPath.toString());
			        test.log(LogStatus.FAIL, result.getThrowable());

					
				} catch (IOException e) {
				} 
	        }
	        else
	        {	
	            System.out.println("Pass Flow");
	        	test.log(LogStatus.PASS, "Test Case Passed For Searching A Product In Amazon App");

	        }
	        report.endTest(test);
	    }
	 
	    @AfterClass
		public static void endTest()
	    {

			report.endTest(test);
			report.flush();
	        System.out.println("ending");
			driver.closeApp();
	        driver.quit();

		}
 
}
