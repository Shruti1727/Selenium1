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

public class termsAndConditionsPage {

    WebDriver driver;
    
    
    @FindBy(xpath = "//a[@class=\"HlWMPX\" and text()=\"Terms Of Use\"]")
    WebElement termsConditions;
    
    
    public termsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickTermsCondn() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	termsConditions.click();
    }

	public boolean isTermsConditionsLinkVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(termsConditions));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }	}
    
    
    
   
    
}

