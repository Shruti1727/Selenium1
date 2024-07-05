package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.TestBase;
import Pages.viewCartPage;
import Utils.configReader;

public class ViewCartTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(ViewCartTest.class);
    viewCartPage viewCart;

    @Test(priority = 20, enabled = true)
    public void testViewCartPage() {
        test = extent.createTest("View Cart Page");

        // Get URL from config.properties
        String url = configReader.getProperty("url");

        // Open the URL
        driver.get(url);
        logger.info("Navigated to URL: " + url);
        test.log(Status.INFO, "Navigated to URL: " + url);

        // Initialize viewCartPage
        viewCartPage viewCart = new viewCartPage(driver);

        try {
            // Check if the cart icon is displayed
            Assert.assertTrue(viewCart.isCartIconDisplayed(), "Cart icon is not displayed");

            // Click on the cart icon to view the cart page
            viewCart.viewCartPage();
            logger.info("Clicked on view cart icon");
            test.log(Status.INFO, "Clicked on view cart icon successfully");

            
            
            
        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test
            test.fail("Element not found: " + e.getMessage());
            
            
        }

        
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
