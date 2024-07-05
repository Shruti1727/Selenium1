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

public class GroceryPage {

    WebDriver driver;

    @FindBy(css = "img._2puWtW._3a3qyb")
    private WebElement groceryImage;

    
    @FindBy(className = "QqFHMw")
    private WebElement currentLocationButton;
   
    
    @FindBy(xpath = "//img[@class=\"xTaogf _3iTqAS\" and @src=\"https://rukminim2.flixcart.com/flap/50/50/image/ed04b09381eec3f9.jpg?q=50\"]")
    private WebElement staplesImage;
    @FindBy(css = "button.QqFHMw.PxrzFS")
    private WebElement addItemButton;
    
    @FindBy(css = "a._9Wy27C")
    private WebElement cartLink;

    public GroceryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickGrocery() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        groceryImage.click();
    }
    public void clickCurrentLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        currentLocationButton.click();
    }
    
    public void clickStaples() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        staplesImage.click();
    }
    public void addItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        addItemButton.click();
    }
    public void viewCartItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        cartLink.click();
    }

	public boolean isItemAdded() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(cartLink));
	        return true; // If the element is visible, return true
	    } catch (TimeoutException e) {
	        return false; // If the element is not visible within the timeout period, return false
	    }	
	}
    

    
}
