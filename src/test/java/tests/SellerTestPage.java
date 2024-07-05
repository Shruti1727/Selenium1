package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.TestBase;
import Pages.sellerPage;
import Utils.configReader;

public class SellerTestPage extends TestBase {
    sellerPage getSellerPage;
    private static final Logger logger = LogManager.getLogger(SellerTestPage.class);

    @Test(priority = 7, enabled = true)
    public void testSellerPage() {
        test = extent.createTest("Seller Page Test");

        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            getSellerPage = new sellerPage(driver);
            getSellerPage.clickSeller();
            logger.info("Clicked on Seller");
            test.log(Status.INFO, "Clicked on Seller");

            getSellerPage.startSelling();
            logger.info("Clicked on Start Selling");
            test.log(Status.INFO, "Clicked on Start Selling");

            // Verify username field
            WebElement usernameField = getSellerPage.getUsernameField();
            try {
                Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
                logger.info("Username field is displayed");
                test.log(Status.PASS, "Username field is displayed");
            } catch (AssertionError e) {
                logger.error("Username field is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "Username field is not displayed: " + e.getMessage());
                throw e;
            }

            // Verify email field
            WebElement emailField = getSellerPage.getEmailField();
            try {
                Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed");
                logger.info("Email field is displayed");
                test.log(Status.PASS, "Email field is displayed");
            } catch (AssertionError e) {
                logger.error("Email field is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "Email field is not displayed: " + e.getMessage());
                throw e;
            }

        } catch (Exception e) {
            logger.error("Error occurred during Seller Page Test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during Seller Page Test: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
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
