package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class sellerPage {

    WebDriver driver;
    
    @FindBy(xpath = "//a[@class=\"_1krdK5 _3jeYYh\" and @title=\"Become a Seller\"]")
    WebElement seller;
    
    @FindBy(xpath = "//button[@data-testid=\"button\" and text()=\"Start Selling\"]")
    WebElement startSelling;
    @FindBy(xpath = "//input[@data-testid='test-input' and @name='mobileNumber']")
    WebElement enterMobileNumber;
    
    @FindBy(xpath = "//input[@data-testid='test-input' and @name=\"email\"]")
    WebElement enterEmail;
    
    public sellerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickSeller() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        seller.click();
    }
    public void startSelling() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	startSelling.click();
    }
    public WebElement getUsernameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return enterMobileNumber;
    }
    
    public WebElement getEmailField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return enterEmail;
    }
   
    
}

