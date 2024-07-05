package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class shopsyPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='_1krdK5 _3jeYYh' and @title='Become a Seller']")
    WebElement seller;
    
    @FindBy(xpath = "//input[@name='fullName']")
    WebElement userNameField;
 
    @FindBy(xpath = "//input[@data-testid='test-input' and @type='text' and @placeholder='Enter Mobile Number / Email ID' and @label='Enter Mobile Number / Email ID' and @name='contactInformation']")
    WebElement userMobileEmailField;
    
    @FindBy(xpath ="//input[@data-testid='test-input' and @type='text' and @placeholder='Type Your Messsage' and @label='Type Your Messsage' and @name='message']")
    WebElement messageField;
    
    @FindBy(xpath="//button[@data-testid='button' and text()='Send Query']")
    WebElement submitButton;
   

    public shopsyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSeller() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(seller)).click();
    }
    
    public void enterUsername(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(seller)).sendKeys(name);
    }
    public void enterMobileNum(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(seller)).sendKeys(value);
    }
    public void enterMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(seller)).sendKeys(message);
    }
    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(seller)).click();
    }

    
    
}
