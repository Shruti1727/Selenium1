
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

public class appliancesPage {

    WebDriver driver;
    
    //Locators to test appliances page
    @FindBy(xpath = "//img[@alt=\"Appliances\"]")
    private WebElement Appliances;
    
    @FindBy(xpath = "//img[@class=\"xTaogf _3iTqAS\" and @alt=\"SDF\"]")
    private WebElement OpenProduct;
    
    @FindBy(css = "div.KzDlHZ")
    private WebElement samsungTVElement;

    @FindBy(xpath= "//span[text()=\"Share\"]")
    private WebElement clickShare;
    
    //Locators for testcase Offerzone
    @FindBy(xpath= "//a[@class=\"TSD49J\" and text()=\"Offer Zone\"]")
    private WebElement clickOfferZone;
    
    @FindBy(xpath = "//img[@alt='Apple iPads (Shop Now!)']")
    WebElement ipadImage;

    
    
    
    public appliancesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickAppliances() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	Appliances.click();
    }
    public void clickProducts() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	OpenProduct.click();
    }
    public void clickTv() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	samsungTVElement.click();
    }
    
    public void clickShare() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	clickShare.click();
    }
    
    public void offerZonePage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	clickOfferZone.click();
    }
    
    public void offerProductPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	ipadImage.click();
    }

	public boolean isAppliancesLinkVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(Appliances));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }
	}

	public boolean isOfferZonePageLinkVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(clickOfferZone));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }
	}

	public boolean isOfferProductPageLinkVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(ipadImage));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }
	}
    

    

}