
package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FlipkartSearchPage {

    WebDriver driver;

    @FindBy(name = "q")
    WebElement searchbox;
    
    @FindBy(css = "button._2iLD__")
    private WebElement searchButton;
    
    
    //Locators for compare button
    @FindBy(xpath = "//span[text()='Add to Compare']")
    WebElement addToCompare;
    
    @FindBy(xpath = "//span[text()='COMPARE']")
    WebElement compareButton;
    



    public FlipkartSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void flipkartSearchBox(String searchInput) {
        searchbox.sendKeys(searchInput);
    }

    public void searchButton() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        searchButton.sendKeys(Keys.RETURN);
        
    }
    public void actionsPerformed() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        addToCompare.click();
        
    }
    
    public void compareBtn() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        compareButton.click();
        
    }
    
    public boolean isSubmitbtnDisplayed() {
    	try {
            return searchButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    
    }

public boolean isAddToCompareButtonDisplayed() {
    try {
        return addToCompare.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}

public boolean isCompareButtonDisplayed() {
    try {
        return compareButton.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}




}

