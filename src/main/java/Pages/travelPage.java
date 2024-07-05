package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class travelPage {

    WebDriver driver;

    @FindBy(xpath = "//img[@alt=\"Travel\"]")
    private WebElement travelImage;

    @FindBy(xpath = "//input[@name='0-departcity']")
    private WebElement fromInputField;

    @FindBy(xpath = "//input[@name='0-arrivalcity']")
    private WebElement toInputField;

    @FindBy(xpath = "//button[@class='QqFHMw sgUmTV M5XAsp']")
    private WebElement searchButton;

    public travelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTravelPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        travelImage.click();
    }

    public boolean isFromInputFieldDisplayed() {
        try {
            return fromInputField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isToInputFieldDisplayed() {
        try {
            return toInputField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSearchButtonDisplayed() {
        try {
            return searchButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
