package tests;
 
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.FlipkartSearchPage;
import Pages.TestBase;
import Utils.ReadXLSdata;
import Utils.configReader;
import com.aventstack.extentreports.Status;
 
public class SearchProduct extends TestBase {
    private static final Logger logger = LogManager.getLogger(SearchProduct.class);
    FlipkartSearchPage searchPage;

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 6, enabled = true)
    public void testSearch(String searchData) {
        test = extent.createTest("Search Product Test");

        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");

            // Open Flipkart website
            driver.get(url);
            logger.info("Launching browser");
            test.log(Status.INFO, "Launching browser");

            // Initialize FlipkartSearchPage
            searchPage = new FlipkartSearchPage(driver);

            // Perform search
            searchPage.flipkartSearchBox(searchData);
            logger.info("Performed search for: " + searchData);
            test.log(Status.INFO, "Performed search for: " + searchData);

            assertTrue(searchPage.isSubmitbtnDisplayed(), "Search button is not displayed");
            searchPage.searchButton();
            logger.info("Click on the search button");
            test.log(Status.INFO, "Click on the search button");


            logger.info("Search product successful");
            test.log(Status.PASS, "Search product successful");
        } catch (Exception e) {
            logger.error("Error occurred during search: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during search: " + e.getMessage());
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
