package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.GroceryPage;
import Pages.TestBase;
import Utils.configReader;

public class GroceryTestPage extends TestBase {
	private static Logger logger = LogManager.getLogger(GroceryTestPage.class);
    GroceryPage groceryPage;

    @Test(priority = 3, enabled = true)
    public void testGroceryPage() {
        test = extent.createTest("Grocery Page Test");

        String url = configReader.getProperty("url");
        driver.get(url);
        log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL: " + url);
        

        groceryPage = new GroceryPage(driver);
        groceryPage.clickGrocery();
        log(Status.INFO, "Clicked on Grocery");
        logger.info("Clicked on Grocery");

        groceryPage.clickCurrentLocation();
        log(Status.INFO, "Clicked on Current Location");
        logger.info("Clicked on Current Location ");

        groceryPage.clickStaples();
        log(Status.INFO, "Clicked on Staples");
        logger.info("Clicked on Staples");

        groceryPage.addItem();
        log(Status.INFO, "Added Item to Cart");
        logger.info("Added Item to Cart");

        groceryPage.viewCartItem();
        log(Status.INFO, "Viewed Cart Item");
        logger.info("Viewed Cart Item");
        
        Assert.assertTrue(groceryPage.isItemAdded(), "Item was not added to the cart.");
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath("./Screenshots/" + result.getName() + ".png");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped: " + result.getName());
        }
    }

	
}
