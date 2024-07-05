package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.mobilesPage;
import Pages.TestBase;
import Utils.configReader;

public class MobilePageTest extends TestBase {
    mobilesPage getMobilePage;
    private static final Logger logger = LogManager.getLogger(MobilePageTest.class);

    @Test(priority = 5, enabled = true)
    public void testMobilePage() {
        test = extent.createTest("Mobile Page Test");

        // Get URL from config.properties
        String url = configReader.getProperty("url");

        driver.get(url);
        logger.info("Navigated to URL: " + url);
        test.log(Status.INFO, "Navigated to URL: " + url);

        getMobilePage = new mobilesPage(driver);
        try {
            
            
            Assert.assertTrue(getMobilePage.isMobilesImageClickable(), "Mobiles image is not clickable");
            
            
            getMobilePage.getMobilesImage();
            logger.info("Clicked on Mobiles Image");
            test.log(Status.INFO, "Clicked on Mobiles Image");
            
            
        } catch (Exception e) {
            logger.error("Error occurred while performing Mobile Page test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred while performing Mobile Page test: " + e.getMessage());
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
