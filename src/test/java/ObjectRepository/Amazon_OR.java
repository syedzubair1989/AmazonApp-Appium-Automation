package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amazon_OR {
	
	@FindBy(id = "skip_sign_in_button")
	public static WebElement SkipSignIn;
	
	
	@FindBy(id="rs_search_src_text")
	public static WebElement SearchBar;
	
	@FindBy(xpath="//*/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]")
	public static WebElement SixtyFiveinchtv;
	
	
	@FindBy(xpath="//*[contains(@text,'MX Ultra Slim')]")
	public static WebElement TvText;
	
	
	@FindBy(id="loc_ux_gps_auto_detect")
	public static WebElement UseCurrentLocation;
	
	
   @FindBy(id="com.android.packageinstaller:id/permission_allow_button")
   public static WebElement AllowButton;
	
	

}
