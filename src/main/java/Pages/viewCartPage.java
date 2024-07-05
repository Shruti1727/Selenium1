package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class viewCartPage {

    WebDriver driver;
    //Locators to view cArt page
    @FindBy(xpath = "//a[@title='Cart' and @class='_3RX0a-']")
    private WebElement cartIcon;
    
    //Locator for going back to homepage
    @FindBy(xpath = "//img[@class=\"W5mR4e\"]")
    private WebElement backToHomePage;

    public viewCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void viewCartPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        cartIcon.click();
    }
    
    public void homepage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	backToHomePage.click();
    }
    
    public boolean isCartIconDisplayed() {
        try {
            return cartIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isBackToHomePageIconDisplayed() {
        try {
            return backToHomePage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}