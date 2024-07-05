package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginSpan;

    @FindBy(css = "input[type='text'][class='r4vIwl BV+Dqf'][autocomplete='off']")
    WebElement usernameInput;
    
    @FindBy(css = "button.QqFHMw")
    WebElement requestOTPButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginSpan.click();
    }

    public void enterUsername(String value) {
        usernameInput.sendKeys(value);
    }
    
    public void clickSubmit() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	requestOTPButton.click();
    }

    
}
