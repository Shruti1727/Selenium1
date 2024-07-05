package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    
    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginSpan;
    
    @FindBy(xpath = "//a[text()='New to Flipkart? Create an account']")
    WebElement createAccountLink;
    
    @FindBy(xpath = "//input[@maxlength='10']")
    WebElement inputElement;

    @FindBy(xpath = "//button[contains(@class, 'QqFHMw')]")
    WebElement continueButton;


    

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickLogin() {
        loginSpan.click();
    }
    

    public void clickCreateAccountLink() {
        createAccountLink.click();
    }

    
    public void setInputValue(String value) {
        inputElement.clear();
        inputElement.sendKeys(value);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isContinueButtonClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
