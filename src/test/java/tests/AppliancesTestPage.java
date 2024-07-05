package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.TestBase;
import Pages.appliancesPage;
import Utils.configReader;

public class AppliancesTestPage extends TestBase {
    private static final Logger logger = LogManager.getLogger(AppliancesTestPage.class);
    appliancesPage getAppliancesPage;

    @Test(priority = 2, enabled = true)
    public void testAppliancesPage() {
        test = extent.createTest("Appliances Page Test");

        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            getAppliancesPage = new appliancesPage(driver);

            // Check if Appliances link is visible
            try {
                Assert.assertTrue(getAppliancesPage.isAppliancesLinkVisible(), "Appliances link is not visible");
                logger.info("Appliances link is visible");
                test.log(Status.PASS, "Appliances link is visible");
            } catch (AssertionError e) {
                logger.error("Appliances link is not visible: " + e.getMessage());
                test.log(Status.FAIL, "Appliances link is not visible: " + e.getMessage());
                throw e;
            }

            // Click Appliances
            getAppliancesPage.clickAppliances();
            logger.info("Clicked on Appliances");
            test.log(Status.INFO, "Clicked on Appliances");

        } catch (Exception e) {
            logger.error("Error occurred during Appliances Page Test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during Appliances Page Test: " + e.getMessage());
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
