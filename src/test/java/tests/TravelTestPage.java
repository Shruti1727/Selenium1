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
import Pages.travelPage;
import Utils.configReader;

public class TravelTestPage extends TestBase {
    travelPage getTravelPage;
    private static final Logger logger = LogManager.getLogger(TravelTestPage.class);

    @Test(priority = 19, enabled = true)
    public void testTravelPage() {
        test = extent.createTest("Travel Page Test");

        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            getTravelPage = new travelPage(driver);
            getTravelPage.getTravelPage();
            logger.info("Clicked on Travel Image");
            test.log(Status.INFO, "Clicked on Travel Image");

            // Verify if from input field is displayed
            try {
                Assert.assertTrue(getTravelPage.isFromInputFieldDisplayed(), "From input field is not displayed");
                logger.info("From input field is displayed");
                test.log(Status.PASS, "From input field is displayed");
            } catch (AssertionError e) {
                logger.error("From input field is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "From input field is not displayed: " + e.getMessage());
                throw e;
            }

            // Verify if to input field is displayed
            try {
                Assert.assertTrue(getTravelPage.isToInputFieldDisplayed(), "To input field is not displayed");
                logger.info("To input field is displayed");
                test.log(Status.PASS, "To input field is displayed");
            } catch (AssertionError e) {
                logger.error("To input field is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "To input field is not displayed: " + e.getMessage());
                throw e;
            }

            // Verify if search button is displayed
            try {
                Assert.assertTrue(getTravelPage.isSearchButtonDisplayed(), "Search button is not displayed");
                logger.info("Search button is displayed");
                test.log(Status.PASS, "Search button is displayed");
            } catch (AssertionError e) {
                logger.error("Search button is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "Search button is not displayed: " + e.getMessage());
                throw e;
            }

        } catch (Exception e) {
            logger.error("Error occurred during Travel Page Test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during Travel Page Test: " + e.getMessage());
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
