
package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class notificationPage {

    WebDriver driver;
    
    @FindBy(xpath = "//img[@class='-dOa_b']")
    private WebElement moreHelpDropdown;
    
    @FindBy(xpath = "//li[@class=\"AT0fUR\" and text()=\"Notification Preferences\"]")
    private WebElement notificationPreferencesImage;


    
    public notificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickDropdown() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	moreHelpDropdown.click();
    }
    
    public void clickNotification() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	notificationPreferencesImage.click();
    }

	public boolean isDropdownDisplayed() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(moreHelpDropdown));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }
	}
    
   
    
}

