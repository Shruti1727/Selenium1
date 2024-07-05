
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

public class navigateMyntraPage {

    WebDriver driver;
    
    @FindBy(xpath = "//a[@class=\"HlWMPX\" and text()=\"Myntra\"]")
    private WebElement clickMyntra;
    
    
    public navigateMyntraPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickMyntraPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	clickMyntra.click();
    }

	public boolean isMyntraPageLinkVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(clickMyntra));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }	}
	}
     


