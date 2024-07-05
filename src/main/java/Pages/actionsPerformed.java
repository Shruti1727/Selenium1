package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class actionsPerformed {

    WebDriver driver;
    //Locators to view cleartrip page
    @FindBy(xpath = "//a[@class=\"HlWMPX\" and text()=\"Cleartrip\"]")
    private WebElement clearTrip;
    
    
    //Locators for gift cards page
    @FindBy(xpath = "//span[text()='Gift Cards']")
    WebElement giftCards;
    
    @FindBy(xpath = "//img[@class='xTaogf _3iTqAS' and @alt='dm']")
    WebElement imageElement;

    //Locator for cancellation policy
    @FindBy(xpath = "//a[@href=\"/pages/returnpolicy?otracker=${otracker}_navlinks\"]")
    WebElement cancelPolicy;
    


    public actionsPerformed(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void viewClearTripPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	clearTrip.click();
    }
    
    public void viewGiftCardsPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	giftCards.click();
    }
    
    public void viewAddToWalletPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	imageElement.click();
    }
    
    public void viewCancelPolicy() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	cancelPolicy.click();
    }
    
    public boolean isClearTripLinkDisplayed() {
        try {
            return clearTrip.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean isGiftCardsElementDisplayed() {
        try {
            return giftCards.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isImageElementDisplayed() {
        try {
            return imageElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isCancelPolicyDisplayed() {
        try {
            return cancelPolicy.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}