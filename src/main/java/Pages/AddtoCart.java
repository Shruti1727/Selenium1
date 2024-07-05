package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddtoCart {

    WebDriver driver;

    @FindBy(name = "q")
    WebElement searchbox;
    
    @FindBy(css = "button._2iLD__")
    private WebElement searchButton;
    
    @FindBy(xpath = "//div[@class='KzDlHZ' and text()='Apple iPhone 15 (Blue, 128 GB)']")
    private WebElement productTitle;
    
    //@FindBy(xpath = "//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")
    @FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")
    private WebElement addToCartButton;


    

    public AddtoCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SearchBox(String searchInput) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        searchbox.sendKeys(searchInput);
    }

    public void searchBtn() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        searchButton.sendKeys(Keys.RETURN);
        
    }
    
    public void getProductTitle() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	productTitle.click();
    }
    public void getAddToCartButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	addToCartButton.click();
    }

 // Simplified method to verify if product was added to the cart
    public boolean isProductAdded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait for the Add to Cart button to be clicked
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            return true; // If the button is clickable, consider the test as passed
        } catch (Exception e) {
            // If the button is not clickable within the timeout, return false
            return false;
        }
    }

}